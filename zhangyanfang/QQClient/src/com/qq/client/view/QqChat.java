/*
 * �������������Ľ���
 * ��Ϊ�ͻ���Ҫ���ڶ�ȡ��״̬����˰�������һ���߳�
 */
package com.qq.client.view;

import com.qq.client.tools.*;
import com.qq.client.model.*;
import com.qq.common.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class QqChat extends JFrame implements ActionListener {

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	JScrollPane jsp;
	String ownerId;
	String friendId;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqChat qqChat=new QqChat("1","1");
	}
	public QqChat(String ownerId,String friend)
	{
		this.ownerId=ownerId;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(25);
		jb=new JButton("����");
		jb.addActionListener(this);
		jp=new JPanel();
		jsp=new JScrollPane(jta);
		jp.add(jtf);
		jp.add(jb);
		
		this.setTitle(ownerId+"���ں�"+friend+"����");
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setSize(400,300);
		this.setIconImage((new ImageIcon("image/ͷ��.GIF").getImage()));
		this.setVisible(true);
		
	}
	//дһ��������������ʾ��Ϣ
	public void showMessage(Message m)
	{
		String info=m.getSender()+" �� "+m.getGetter()+" ˵�� "+m.getSendTime()+"\n"+m.getConn()+"\r\n";
		this.jta.append(info);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			//����û�����˷��Ͱ�ť
			Message m=new Message();
			m.setMessType(MessageType.message_comm_mes);
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setConn(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			//���͸�������
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception b) {
				// TODO: handle exception
				b.printStackTrace();
			}
			String info1=m.getSender()+" �� "+m.getGetter()+"  "+m.getSendTime()+"\n"+m.getConn()+"\r\n";
			this.jta.append(info1);
			this.jtf.setText("");
		}
	}
}
