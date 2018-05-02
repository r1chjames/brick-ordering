package com.richjames.brickordering.dao.mappers;

import com.richjames.brickordering.entities.OrderHeader;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class OrderHeaderMapper implements RowMapper<OrderHeader> {
    @Override
    public OrderHeader map(ResultSet rs, StatementContext ctx) throws SQLException {
        return OrderHeader.builder()
                .orderId(UUID.fromString(rs.getString("id")))
                .customerId(UUID.fromString(rs.getString("customer_id")))
                .dateCreated(rs.getTimestamp("date_created").toLocalDateTime())
                .dateUpdated(rs.getTimestamp("date_updated").toLocalDateTime())
                .build();
    }
}
