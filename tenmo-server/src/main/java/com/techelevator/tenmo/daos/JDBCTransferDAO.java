package com.techelevator.tenmo.daos;

import com.techelevator.tenmo.models.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCTransferDAO implements TransferDAO{

    private JdbcTemplate jdbcTemplate;

    public JDBCTransferDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Transfer> list() {
        String sql = " SELECT transfer_id, account_from, account_to, amount FROM transfers ";
        List<Transfer> transfers = new ArrayList<>();
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
        while (rows.next()){
            transfers.add(mapRowToTransfer(rows));
        }
        return transfers;
    }

    private Transfer mapRowToTransfer(SqlRowSet rows){
        Transfer transfer = new Transfer();
        transfer.setTransferId(rows.getLong("transfer_id"));
        transfer.setFromAccount(rows.getLong("account_from"));
        transfer.setToAccount(rows.getLong("account_to"));
        transfer.setAmount(rows.getDouble("amount"));
        return transfer;
    }
}
