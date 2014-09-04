/*
 * 这是与好友聊天的界面
 * 因为客户端要处于读取的状态，因此把它做成一个线程
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
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jsp=new JScrollPane(jta);
		jp.add(jtf);
		jp.add(jb);
		
		this.setTitle(ownerId+"正在和"+friend+"聊天");
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setSize(400,300);
		this.setIconImage((new ImageIcon("image/头像.GIF").getImage()));
		this.setVisible(true);
		
	}
	//写一个方法，让它显示消息
	public void showMessage(Message m)
	{
		String info=m.getSender()+" 对 "+m.getGetter()+" 说： "+m.getSendTime()+"\n"+m.getConn()+"\r\n";
		this.jta.append(info);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb)
		{
			//如果用户点击了发送按钮
			Message m=new Message();
			m.setMessType(MessageType.message_comm_mes);
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setConn(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			//发送给服务器
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(ManageClientConServerThread.getClientConServerThread(ownerId).getS().getOutputStream());
				oos.writeObject(m);
			} catch (Exception b) {
				// TODO: handle exception
				b.printStackTrace();
			}
			String info1=m.getSender()+" 对 "+m.getGetter()+"  "+m.getSendTime()+"\n"+m.getConn()+"\r\n";
			this.jta.append(info1);
			this.jtf.setText("");
		}
	}
}
