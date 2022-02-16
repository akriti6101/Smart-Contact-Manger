package spring.album.all.access;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import spring.album.all.data.Contact;

public class MyRowMapperImpl  implements RowMapper<Contact>{

	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		         Contact c=new Contact();
		           c.setEmail(rs.getString(2));
		           c.setFilename(rs.getString(3));
		           c.setName(rs.getString(4));
		           c.setPhone(rs.getString(1));
		           c.setUserAccountName(rs.getString(5));
		           c.setWork(rs.getString(6));
		return c;
	}

}
