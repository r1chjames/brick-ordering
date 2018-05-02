package com.richjames.brickordering.dao;

import com.richjames.brickordering.dao.mappers.OrderHeaderMapper;
import com.richjames.brickordering.entities.OrderHeader;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.util.List;
import java.util.UUID;

public interface OrderHeaderDao {

    String selectFields = "id, customer_id, created, last_updated ";
    String insertFields = "customer_id ";
    String insertValues = ":order.customerId ";
    String tableName = "order_headers ";

    @UseRowMapper(OrderHeaderMapper.class)
    @SqlQuery(
            "SELECT " +
                    selectFields +
                    " FROM "
                    + tableName)
    List<OrderHeader> getAllOrderHeaders();

    @UseRowMapper(OrderHeaderMapper.class)
    @SqlQuery(
            "SELECT " +
                    selectFields +
                    " FROM "
                    + tableName +
                    "WHERE " +
                    "id = :id")
    OrderHeader getOrderLinesById(@Bind("id") UUID id);

    @UseRowMapper(OrderHeaderMapper.class)
    @SqlQuery(
            "INSERT INTO " +
                    tableName +
                    "(" + insertFields + ")" +
                    "VALUES (" +
                    insertValues +
                    ") RETURNING *")
    OrderHeader createOrder(@BindBean("order") OrderHeader orderHeader);
}
