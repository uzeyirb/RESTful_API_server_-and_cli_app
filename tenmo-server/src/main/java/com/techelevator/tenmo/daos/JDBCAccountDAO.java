package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.models.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JDBCAccountDAO implements AccountDAO{
    private JdbcTemplate jdbcTemplate;

    public JDBCAccountDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> getAllAccount() {
        String sql = "SELECT account_id, user_id, balance FROM accounts";
        List<Account> accounts = new ArrayList<Account>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()){
           accounts.add(mapRowToAccount(rows));
        }
        return accounts;
    }

    @Override
    public List<Account> getAllAccountByUser(long userId) {
        String sql = " SELECT account_id, user_id, balance FROM accounts WHERE user_id =? ";
        List<Account> accounts = new ArrayList<Account>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);

        while (rows.next()){
            accounts.add(mapRowToAccount(rows));
        }
        return accounts;
    }

    @Override
    public Account getUserAccount(String username) {
        return null;
    }

    private Account mapRowToAccount(SqlRowSet rows){
        Account account = new Account();
        account.setAccountId(rows.getLong("account_id"));
        account.setUserId(rows.getLong("user_id"));
        account.setBalance(rows.getDouble("balance"));
        return account;
    }
}
