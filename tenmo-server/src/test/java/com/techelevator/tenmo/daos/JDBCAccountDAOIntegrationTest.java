package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.auth.model.User;
import com.techelevator.tenmo.models.Account;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class JDBCAccountDAOIntegrationTest {

    private static SingleConnectionDataSource dataSource;
    private AccountDAO accountDAO;
    private JdbcTemplate jdbcTemplate;

    @BeforeClass

    public static void setDataSource(){
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/tenmo");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }
    @AfterClass
    public static void destroyConnection(){
        dataSource.destroy();
    }
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }
    @Before
    public void setup(){
        jdbcTemplate = new JdbcTemplate(dataSource);
        accountDAO = new JDBCAccountDAO(jdbcTemplate);
    }

    @Test

    public void get_all_accounts(){
        List<Account> originalAccounts = accountDAO.getAllAccount();
        addAccount(new Account(2005, 1001, 10.0 ));
        List<Account> newAccount = accountDAO.getAllAccount();
        Assert.assertEquals(originalAccounts.size() + 1, newAccount.size());

    }





    private void addAccount(Account account){
        //INSERT INTO accounts (account_id, user_id, balance) VALUES (1110, (SELECT user_id FROM users WHERE user_id = 1001), 0)
        String sql = "INSERT INTO accounts (account_id, user_id, balance) VALUES (?, (SELECT user_id FROM users WHERE user_id = ?), ?)";
        jdbcTemplate.update(sql, account.getAccountId(), account.getUserId(), account.getBalance());

    }


}
