package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.models.Account;
import com.techelevator.tenmo.models.Transfer;
import org.springframework.dao.DataAccessException;
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
    public List<Account> list() {
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

    @Override
    public Account get(long id) {
        List<Account> account = new ArrayList<>();
        for(Account acc: account){
            if(acc.getAccountId() == id){
                return acc;
            }

        }
        return null;
    }


    public Account getByUserId(long id) {
        String sql = "SELECT account_id, user_id, balance FROM accounts WHERE user_id = ?";
        List<Account> accounts = new ArrayList<Account>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);

       if(rows.next()){
            accounts.add(mapRowToAccount(rows));
        }
        return accounts.get(0);
    }

    @Override
    public Account transfer(Transfer transfer) {
        System.out.println("transfer started " + transfer);

        Account toAccount =updateBalance(transfer.getToUser(), transfer.getAmount() );
        Account fromAccount = updateBalance(transfer.getFromUser(), transfer.getAmount() * (-1));
        createTransferHistory(fromAccount, toAccount, transfer.getAmount());
        return get(transfer.getFromUser());

    }

    public void createTransferHistory(Account fromAccount , Account toAccount, Double amount){
        //INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?, ?);
        //String sql = "INSERT INTO transfers (transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (?, ?, ?, ?, ?) RETURNING transferId";
        String sql = "INSERT INTO transfers (transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount) VALUES (DEFAULT, ?, ?, ?, ?, ?)";

        System.out.println("seokfnonf" +fromAccount + " " + toAccount+ " " + amount);
        Integer transferId;
        try {
            transferId = jdbcTemplate.queryForObject(sql, Integer.class, "2", "1", "",  fromAccount.getAccountId(), toAccount.getAccountId(), amount );
        } catch (DataAccessException e) {

        }


    }

    @Override
    public Account updateBalance(long userId, Double amount) {
        String sql = "UPDATE accounts SET  balance = balance + ? WHERE user_id = ?";
        jdbcTemplate.update(sql, amount, userId );
        return getByUserId(userId);
    }

    @Override
    public List<Account> getAllAccountExceptSender(long userId) {
        List<Account> accounts = new ArrayList<Account>();
        String sql = "SELECT user_id, username, password_hash FROM users WHERE user_id != ?";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, userId);
        while (rows.next()){
            accounts.add(mapRowToAccount(rows));
        }
        return accounts;
    }

    private Account mapRowToAccount(SqlRowSet rows){
        Account account = new Account();
        account.setAccountId(rows.getLong("account_id"));
        account.setUserId(rows.getLong("user_id"));
        account.setBalance(rows.getDouble("balance"));
        return account;
    }

    private void logTransfer(Transfer transfer ){
        String sql = "";
    }
}
