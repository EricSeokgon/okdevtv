package com.mybatis.demo.user.bo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.demo.ConnectionFactory;
import com.mybatis.demo.user.dao.UserDAO;
import com.mybatis.demo.user.vo.UserVO;

public class UserBO { 

	public List<UserVO> getUsers() throws Exception{
		SqlSession session = ConnectionFactory.getSession().openSession();
			UserDAO dao =session.getMapper(UserDAO.class);
			List<UserVO> users= dao.getAllUsers();
		session.close();
		return users;
	}
	public UserVO getUserById(long id) throws Exception{
		SqlSession session = ConnectionFactory.getSession().openSession();
			UserDAO dao =session.getMapper(UserDAO.class);
			UserVO user =dao.getUserById(id);
		session.close();
		return user;
	}
	public UserVO createUser(UserVO vo) throws Exception{
		SqlSession session = ConnectionFactory.getSession().openSession();
			UserDAO dao =session.getMapper(UserDAO.class);
			dao.doCreateUser(vo);
		session.commit();
		session.close();
		return vo;
	}
	public UserVO updateUser(UserVO vo) throws Exception{
		SqlSession session = ConnectionFactory.getSession().openSession();
			UserDAO dao =session.getMapper(UserDAO.class);
			dao.doUpdateUser(vo);
		session.commit();
		session.close();
		return vo;
	}
	public int deleteUser(UserVO vo) throws Exception{
		SqlSession session = ConnectionFactory.getSession().openSession();
			UserDAO dao =session.getMapper(UserDAO.class);
			int cnt= dao.doDeleteUser(vo);
		session.commit();
		session.close();
		return cnt;
	}

	public static void main(String a[])throws Exception{

		UserBO bo = new UserBO();
		UserVO vo= new UserVO();

		vo.setAddress("Test");
		vo.setEmail("test@gmail.com");
		vo.setFullName("Full Name");
		vo.setMobile("12411515");

		System.out.println(bo.createUser(vo));
	 	System.out.println(bo.getUsers());

		vo= bo.getUserById(1);
		vo.setAddress("Test Updated11 Address");
		vo.setEmail("testupdated@gmail.com");
		vo.setFullName("Full Name Test");
		vo.setMobile("1241151511");
		bo.updateUser(vo);

		vo=bo.getUserById(1);

		System.out.println(vo);

		bo.deleteUser(vo);

	}
}
