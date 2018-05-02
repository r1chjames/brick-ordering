package com.richjames.brickordering.dao.mappers;

import com.richjames.brickordering.entities.OrderLine;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class OrderLineMapper implements RowMapper<OrderLine> {
    @Override
    public OrderLine map(ResultSet rs, StatementContext ctx) throws SQLException {
        return OrderLine.builder()
                .id(UUID.fromString(rs.getString("id")))
                .orderId(UUID.fromString(rs.getString("order_id")))
                .itemNumber(rs.getInt("item_number"))
                .quantity(rs.getInt("quantity"))
                .build();
    }
}
