package ex0503.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex0503.dto.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	 public String idCheck(String id) {
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  Connection con = null;
	  String result="사용가능합니다.";
	  try {
	   con=DbUtil.getConnection();
	   ps = con.prepareStatement("select id from customer where id=?");
	   ps.setString(1, id);
	   rs = ps.executeQuery();
	   if(rs.next()){
	    result="중복입니다.";
	   }
	  } catch (SQLException e) {
	   e.printStackTrace();
	  }finally {
	   DbUtil.dbClose(con, ps, rs);
	  }
	  return result;
	 }

	 @Override
	 public int insert(CustomerDTO dto) {
	  PreparedStatement ps = null;
	  Connection con = null;
	  int result=0;
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("insert into customer(id,name,age,tel,addr) values(?,?,?,?,?)");
	   ps.setString(1, dto.getId());
	   ps.setString(2, dto.getName());
	   ps.setInt(3, dto.getAge());
	   ps.setString(4, dto.getPhone());
	   ps.setString(5, dto.getAddr());
	   result = ps.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose(con, ps);
	  }
	  return result;
	 }

	 @Override
	 public List<CustomerDTO> selectAll() {
	  Connection con = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List<CustomerDTO> list = new ArrayList<CustomerDTO>();
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("select * from customer order by id");
	   rs  = ps.executeQuery();
	   while(rs.next()){
	    list.add(new CustomerDTO(rs.getString(1), rs.getString(2), rs.getInt(3), 
	      rs.getString(4), rs.getString(5)));
	   }

	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose(con, ps, rs);
	  }
	  return list;
	 }

	 @Override
	 public int delete(String id) {
	  PreparedStatement ps = null;
	  Connection con =null;
	  int result=0;
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("delete from customer where id=?");
	   ps.setString(1, id);
	   result = ps.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose(con, ps);
	  }
	  return result;
	 }

	 @Override
	 public int update(CustomerDTO customerDTO) {
	  PreparedStatement ps = null;
	  Connection con =null;
	  int result=0;
	  try {
	   con = DbUtil.getConnection();
	   ps = con.prepareStatement("update customer set name=?,age=?,tel=?,addr=? where id=?");
	   
	   ps.setString(1, customerDTO.getName());
	   ps.setInt(2, customerDTO.getAge());
	   ps.setString(3, customerDTO.getPhone());
	   ps.setString(4, customerDTO.getAddr());
	   ps.setString(5, customerDTO.getId());
	   
	   result = ps.executeUpdate();
	  } catch (SQLException e) {
	   e.printStackTrace();
	  } finally {
	   DbUtil.dbClose(con, ps);
	  }
	  return result;
	 }



}
