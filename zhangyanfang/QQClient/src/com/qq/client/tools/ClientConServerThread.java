/*
 * ���ǿͻ��˺ͷ������˱���ͨ�ŵ��߳�
 * ���ϵض�ȡ��������������Ϣ
 */
package com.qq.client.tools;

import com.qq.client.view.QqChat;
import com.qq.client.view.QqFriendList;
import com.qq.common.*;
import java.io.*;
import java.net.*;
public class ClientConServerThread extends Thread{

	private Socket s;
	
	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}

	//���캯��
	public ClientConServerThread(Socket s)
	{
		this.s=s;
	}
	
	public void run()
	{
		while(true)
		{
			ObjectInputStream ois=null;
			Message m=null;
			//��ͣ�ض�ȡ�ӷ������˷�������Ϣ
			try {
				ois=new ObjectInputStream(s.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try {
				m = (Message)ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(m.getMessType().equals(MessageType.message_comm_mes))//��������ݵ�
			{
					//�Ѵӷ�������õ���Ϣ��ʾ���������
					QqChat qqChat=ManageQqChat.getQqChat(m.getGetter()+" "+m.getSender());
					//��ʾ
					qqChat.showMessage(m);
			}else if(m.getMessType().equals(MessageType.message_ret_onLineFriend)){
					String conn=m.getConn();
					String friends[]=conn.split(" ");
					String getter=m.getGetter();
					//�޸���Ӧ�ĺ����б�
					QqFriendList qqFriendList=ManageQqFriendList.getQqFriendList(getter);
					//�������ߺ���
					if(qqFriendList!=null)
					{
						qqFriendList.updateFriend(m);
					}
			}
		}
	}
}
