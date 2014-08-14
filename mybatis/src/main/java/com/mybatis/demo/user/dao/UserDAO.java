package com.mybatis.demo.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis.demo.user.vo.UserVO;

public interface UserDAO {

	String MQL_GET_ALL_USERS  = "select * from users";
	String MQL_GET_USER_BY_ID = "select * from users where id = #{id}";
	String MQL_CREATE_USER    = "insert into users (fullName, email, address, mobile) values (#{fullName},#{email},#{address},#{mobile})";
	String MQL_UPDATE_USER    = "update users set fullName=#{fullName}, email=#{email}, address=#{address}, mobile=#{mobile} where id=#{id}";
	String MQL_DELETE_USER    = "delete from users where id=#{id}";

	@Select(MQL_GET_ALL_USERS)
	public List<UserVO> getAllUsers() throws Exception;

	@Select(MQL_GET_USER_BY_ID)
	public UserVO getUserById(long id) throws Exception;

	@Insert(MQL_CREATE_USER)
	public int doCreateUser(UserVO vo) throws Exception;

	@Update(MQL_UPDATE_USER)
	public int doUpdateUser(UserVO vo) throws Exception; 

	@Delete(MQL_DELETE_USER)
	public int doDeleteUser(UserVO vo) throws Exception;  

}
