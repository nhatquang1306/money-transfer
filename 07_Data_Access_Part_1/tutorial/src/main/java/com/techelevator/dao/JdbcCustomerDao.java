package com.techelevator.dao;

import com.techelevator.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCustomerDao implements CustomerDao {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public JdbcCustomerDao(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    // Step Four: Add a new DAO method
//    @Override
//    public Customer getCustomerById(int customerId) {
//        Customer customer = null;
//        String sql = "SELECT customer_id, first_name, last_name, street_address, city, phone_number, " +
//                "email_address, email_offers " +
//                "FROM customer " +
//                "WHERE customer_id = ?;";
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, customerId);
//        if (results.next()) {
//            customer = mapRowToCustomer(results);
//        }
//        return customer;
//    }
//
//    @Override
//    public List<Customer> getCustomersByName(String search, boolean useWildCard) {
//        List<Customer> customers = new ArrayList<>();
//        String sql = "SELECT customer_id, first_name, last_name, street_address, city, phone_number, " +
//                "email_address, email_offers " +
//                "FROM customer " +
//                "WHERE first_name LIKE ? OR last_name LIKE ?;";
//        if (useWildCard) {
//            search = "%" + search + "%";
//        }
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, search, search);
//        while (results.next()) {
//            customers.add(mapRowToCustomer(results));
//        }
//        return customers;
//    }
//
//    private Customer mapRowToCustomer(SqlRowSet rowSet) {
//        Customer customer = new Customer();
//        customer.setCustomerId(rowSet.getInt("customer_id"));
//        customer.setFirstName(rowSet.getString("first_name"));
//        customer.setLastName(rowSet.getString("last_name"));
//        customer.setStreetAddress(rowSet.getString("street_address"));
//        customer.setCity(rowSet.getString("city"));
//        customer.setPhoneNumber(rowSet.getString("phone_number"));
//        customer.setEmailAddress(rowSet.getString("email_address"));
//        customer.setEmailOffers(rowSet.getBoolean("email_offers"));
//        return customer;
//    }
//
//    Exercise 11: MakeMiddle
//    Create an integer array method called MakeMiddle that takes in an integer array “nums”. Given an array of ints of even length,
//    return a new array length 2 containing the middle two elements from the original array. The original array will be length 2 or more.
//    makeMiddle([1, 2, 3, 4]) → [2, 3]
//    makeMiddle([7, 1, 2, 3, 4, 9]) → [2, 3]
//    makeMiddle([1, 2]) → [1, 2]
    public static int [] MakeMiddle(int [] nums) {
        int [] length2 = new int[2];
        int middle = nums.length/2;
        length2[0] = nums[middle-1];
        length2[1] = nums[middle];
            return length2;
        }

    }



