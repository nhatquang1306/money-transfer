package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao {
    @Lazy
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public double getBalance(String username) {
        double balance = 0;
        String sql = "SELECT balance FROM account WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);";
        try {
            balance = jdbcTemplate.queryForObject(sql, double.class, username);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return balance;
    }

    @Override
    public Transfer sendMoney(double amount, String username, String receivingUsername) {
        if (receivingUsername.equals(username) || getBalance(username) < amount) {
            return null;
        }
        int transferId = 0;
        String sql = "UPDATE account SET balance = balance - ? WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);" +
                "UPDATE account SET balance = balance + ? WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);";
        String sql2 = "INSERT INTO transfer (username_from, username_to, amount, status, request) " +
                "VALUES (?, ?, ?, 'Approved', false) RETURNING transfer_id;";
        try {
            jdbcTemplate.update(sql, amount, username, amount, receivingUsername);
            transferId = jdbcTemplate.queryForObject(sql2, int.class, username, receivingUsername, amount);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return findTransferByTransferId(username, transferId);
    }


    @Override
    public List<Transfer> seeTransfer(String username) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM transfer WHERE username_from = ? OR username_to = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, username);
            while (results.next()) {
                transfers.add(mapRowToTransfer(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return transfers;
    }

    @Override
    public Transfer findTransferByTransferId(String username, int id) {
        Transfer transfer = null;
        String sql = "SELECT * FROM transfer WHERE transfer_id = ? AND (username_from = ? OR username_to = ?);";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id, username, username);
            if (results.next()) {
                transfer = mapRowToTransfer(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return transfer;
    }

    @Override
    public Transfer requestMoney(double amount, String sendingUsername, String username) {
        int newId = 0;
        String sql = "INSERT INTO transfer (username_from, username_to, amount, status, request) VALUES (?, ?, ?, 'Pending', true) RETURNING transfer_id;";
        try {
            newId = jdbcTemplate.queryForObject(sql, int.class, sendingUsername, username, amount);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return findTransferByTransferId(username, newId);
    }

    @Override
    public List<Transfer> seePending(String username) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT * FROM transfer WHERE status = 'Pending' AND (username_from = ? OR username_to = ?);";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, username);
            while (results.next()) {
                transfers.add(mapRowToTransfer(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return transfers;
    }

    @Override
    public Transfer approveRequest(String username, int id, String status) {
        if (!status.equals("Approved") && !status.equals("Rejected")){
            return null;
        }
        Transfer transfer = findTransferByTransferId(username, id);
        if (transfer== null) {
            return null;
        }
        double amount = transfer.getAmount();
        if (getBalance(username) < amount || !transfer.getUsernameFrom().equals(username)) {
            return null;
        }
        String usernameTo = transfer.getUsernameTo();
        String sql = "UPDATE account SET balance = balance - ? WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);" +
                "UPDATE account SET balance = balance + ? WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);";
        String sql2 = "UPDATE transfer SET status = ? WHERE transfer_id = ? AND username_from = ?;";
        try {
            jdbcTemplate.update(sql2, status, id, username);
            if (status.equals("Approved")) {

                jdbcTemplate.update(sql, amount, username, amount, usernameTo);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return findTransferByTransferId(username, id);
    }


    public Transfer mapRowToTransfer(SqlRowSet results) {
        Transfer newTransfer = new Transfer();
        newTransfer.setTransferId(results.getInt("transfer_id"));
        newTransfer.setUsernameFrom(results.getString("username_from"));
        newTransfer.setUsernameTo(results.getString("username_to"));
        newTransfer.setAmount(results.getDouble("amount"));
        newTransfer.setStatus(results.getString("status"));
        newTransfer.setRequest(results.getBoolean("request"));
        return newTransfer;
    }
}
