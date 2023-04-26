package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class JdbcTransferDao implements TransferDao {
    @Lazy
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public double getBalance(String username) {
        String sql = "SELECT balance FROM account WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);";
        return jdbcTemplate.queryForObject(sql, double.class, username);
    }

    @Override
    public int sendMoney(double amount, String username, String sendingUserName) {
        if(sendingUserName.equals(username) || getBalance(sendingUserName)<amount){
            return 0;
        }
        String sql = "UPDATE account SET balance = balance - ? WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);" +
                "UPDATE account SET balance = balance + ? WHERE user_id = (SELECT user_id FROM tenmo_user WHERE username = ?);";
        String sql2 = "INSERT INTO transfer (username_from, username_to, amount, status, request) " +
                "VALUES (?, ?, ?, 'Approved', false) RETURNING transfer_id;";
        jdbcTemplate.update(sql, amount, sendingUserName, amount, username);
        return jdbcTemplate.queryForObject(sql2, int.class, sendingUserName, username, amount);
    }


    @Override
    public List<Transfer> seeTransfer(String username) {
        String sql = "SELECT * FROM transfer WHERE username_from = ? OR username_to = ? AND status = 'Approved'";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, username, username);

        return results;
    }

    @Override
    public Transfer findTransferByTransferId(int id) {
        return null;
    }

    @Override
    public boolean requestMoney(double amount, String username) {
        return false;
    }

    @Override
    public Transfer findTransferByTransferId() {
        return null;
    }

    @Override
    public boolean requestMoney() {
        String sql = "INSERT INTO transfer (account_id, username, amount, status, request) VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, )
        return false;
    }

    @Override
    public List<Transfer> seePending() {
        return null;
    }

    @Override
    public boolean approveRequest() {
        return false;
    }

    public void mapRowToTransfer(SqlRowSet results) {
        Transfer newTransfer = new Transfer();
        newTransfer.setUsernameFrom(results.getString());
        newTransfer.setUsernameTo(results);
    }
}
