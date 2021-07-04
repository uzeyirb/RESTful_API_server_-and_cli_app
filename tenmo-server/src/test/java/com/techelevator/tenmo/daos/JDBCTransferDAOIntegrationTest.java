package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.models.Transfer;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.util.List;

public class JDBCTransferDAOIntegrationTest {

    private static SingleConnectionDataSource dataSource;
    private TransferDAO transferDAO;
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
        transferDAO = new JDBCTransferDAO(jdbcTemplate);
    }

    @Test

    public void get_all_transfers(){
        List<Transfer> originalTransfers = transferDAO.list();
        addTransfer(new Transfer(1, 2, 2002, 2004, 10.0));

        List<Transfer> newTransfer = transferDAO.list();
        Assert.assertEquals(originalTransfers.size() + 1, newTransfer.size());

    }

    private void addTransfer(Transfer transfer){
        String sql = "INSERT INTO transfers ( transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount ) " +
                "VALUES ( ?, ( SELECT transfer_type_id FROM transfer_types WHERE transfer_type_id = ? )," +
                "( SELECT transfer_status_id FROM transfer_statuses WHERE transfer_status_id = ? ), " +
                "( SELECT account_id FROM accounts WHERE account_id = ? ), " +
                "(SELECT account_id FROM accounts WHERE account_id = ?), ?) ";
        jdbcTemplate.update(sql, transfer.getTransferId(), transfer.getTransferTypeId(), transfer.getTransferStatusTypeId(), transfer.getFromAccount(), transfer.getToAccount(), transfer.getAmount() );

/*
        try {
            jdbcTemplate.update(sql, Integer.class, transfer.getTransferTypeId(), transfer.getTransferStatusTypeId(), transfer.getFromUser(), transfer.getToUser(), transfer.getAmount() );

        } catch (DataAccessException e) {
            System.out.println("DataAccessException" + e.getMessage());
        }*/


    }
}
