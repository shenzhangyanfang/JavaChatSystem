/*
 * ����qq�����������ڼ������ȴ�ĳ��qq�ͻ���������
 */
package com.qq.server.model;
import java.net.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.sql.*;
import java.util.*;
import com.qq.common.Message;
import com.qq.common.User;
import com.qq.server.view.MyServerFrame;

public class MyQqServer {

	public MyQqServer()
	{
			//��9999�˿ڼ���
			System.out.println("���Ƿ�����,��9999����");
			ServerSocket ss = null;
			try {
				ss=new ServerSocket(9999);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		try{
			//�������ȴ�����
			while(true)//ѭ������
			{
				Socket s=ss.accept();
				
				//���ܿͻ��˷�������Ϣ
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
	
				
		        if(u.getOperation().equals("1"))//���ݿ����֤��½
		        {
					if(new QqServerUser().CheckUser(u))
					{
						//����һ���ɹ���½����Ϣ��
						m.setMessType("1");
						oos.writeObject(m);
						//����͵���һ���̡߳��ø��߳���ÿͻ��˱���ͨѶ
						SerConClientThread scct=new SerConClientThread(s);
						ManageClientThread.addClientThread(u.getQum(),scct);
						//������ÿͻ���ͨ�ŵ��߳�
						scct.start();
						//��֪ͨ�����������û�
						scct.notifyOther(u.getQum());
					}else{
						m.setMessType("2");
						oos.writeObject(m);
						//�ر�����
					}
		        }else if(u.getOperation().equals("2")){//��Ӻ���
		        	String []pas={u.getQum(),u.getFriendId()};
		        	if(new QqServerUser().SerInsertFriend(pas))
		        	{
		        		m.setMessType("1");
		        		oos.writeObject(m);
		        	}
		        }else if(u.getOperation().equals("3")){//ע����Ϣ
		        	String []pas={u.getQum(),u.getPetname(),u.getPassword(),u.getSex()};
		        	if(new QqServerUser().SerInsertpersonalinfo(pas))
		        	{
		        		m.setMessType("1");
		        		oos.writeObject(m);
		        	}
		        }else if(u.getOperation().equals("4")){//ɾ������
		        	String []pas={u.getQum(),u.getFriendId()};
		        	if(new QqServerUser().SerDelFriend(pas))
		        	{
		        		m.setMessType("1");
		        		oos.writeObject(m);
		        	}
		        }else if(u.getOperation().equals("5")){//���б�����ʾ���еĺ���
		        	int count=0;
		        	String []pas={u.getQum()};
		        	m.setFriend(new QqServerUser().showFriend(pas));
		        	oos.writeObject(m);
		        	
		        }
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
