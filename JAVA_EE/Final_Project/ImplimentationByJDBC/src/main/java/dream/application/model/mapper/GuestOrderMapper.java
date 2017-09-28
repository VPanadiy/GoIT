package dream.application.model.mapper;

import dream.application.model.impl.GuestOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * GuestOrder RowMapper
 * Created by Splayd on 17.06.2017.
 */
public class GuestOrderMapper implements RowMapper<GuestOrder> {

    @Override
    public GuestOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        GuestOrder guestOrder = new GuestOrder();
        guestOrder.setId(rs.getInt("ID"));
        guestOrder.setTableNumber(rs.getInt("TABLE_NUMBER"));
        guestOrder.setDateOrder(rs.getDate("DATE_ORDER").toLocalDate());
        guestOrder.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
        guestOrder.setClosed(rs.getBoolean("ISCLOSED"));
        return guestOrder;
    }
}
