package com.richjames.brickordering.dao;

import com.richjames.brickordering.dao.mappers.OrderLineMapper;
import com.richjames.brickordering.entities.OrderHeader;
import com.richjames.brickordering.entities.OrderLine;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;
import java.util.UUID;

public interface OrderLineDao {

    String selectFields = "id, order_id, item_number, quantity ";
    String insertFields = "order_id, item_number, quantity ";
    String insertValues = ":line.orderId::UUID, :line.itemNumber, :line.quantity ";
    String tableName = "order_lines ";

    @UseRowMapper(OrderLineMapper.class)
    @SqlQuery(
            "SELECT " +
                    selectFields +
                    " FROM "
                    + tableName +
                    "WHERE " +
                    "order_id = :orderId::UUID")
    List<OrderLine> getOrderLinesForId(@Bind("orderId") UUID orderId);

    @UseRowMapper(OrderLineMapper.class)
    @SqlQuery(
            "INSERT INTO " +
                    tableName +
                    "(" + insertFields + ")" +
                    "VALUES (" +
                    insertValues +
                    ") RETURNING *")
    OrderLine createOrderLine(@BindBean("line") OrderLine orderLine);

}
