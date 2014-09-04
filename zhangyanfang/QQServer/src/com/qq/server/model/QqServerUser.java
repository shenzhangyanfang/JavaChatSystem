package com.qq.server.model;

import com.qq.common.User;
import com.qq.server.db.SqlHelper;
import java.sql.*;
import javax.swing.*;
public class QqServerUser {
	public boolean SerInsertFriend(String []paras)//���Ӻ���
	{
		boolean b=true;
		SqlHelper mysql=new SqlHelper();
		String sql="insert into friend(myqno,friendqno) values(?,?)";
		if(!mysql.SqlUpdate(sql, paras))
		{
			//��ʾ
			b=false;
		}
		return b;
	}
	
	public boolean SerInsertpersonalinfo(String []paras)//ע���û�
	{
		boolean b=true;
		SqlHelper mysql=new SqlHelper();
		String sql="insert into personalinfo(qnum,petname,password,sex,status) values(?,?,?,?,'��')";
		if(!mysql.SqlUpdate(sql, paras))
		{
			//��ʾ
			b=false;
		}
		return b;
	}
	public String[] showFriend(String []paras)//��ѯĳ���˺ŵ����еĺ���
	{
		
		SqlHelper mysql=new SqlHelper();
		String sql="select friendqno from friend where myqno=?";
		return mysql.FriendQuery(sql, paras);
	}
	
	public boolean SerDelFriend(String []paras)//ɾ��ĳ���û��ĺ���
	{
		boolean b=true;
		SqlHelper mysql=new SqlHelper();
		String sql="delete from friend where myqno=? and friendqno=?";
		if(!mysql.SqlUpdate(sql, paras))
		{
			//��ʾ
			b=false;
		}
		return b;
	}
	public boolean CheckUser(User u)
	{
		boolean b=false;
		String sql="select * from personalinfo where qnum=? and password=?";
		String []paras=new String[2];
		paras[0]=u.getQum();
		paras[1]=u.getPassword();
		if(new SqlHelper().SqlQuery(sql,paras))
		{
			b=true;
		}
		return b;
	}
	
}
