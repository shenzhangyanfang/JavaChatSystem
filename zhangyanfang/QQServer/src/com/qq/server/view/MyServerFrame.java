/*
 * ���Ƿ������˵Ŀ��ƽ��棬��������������������رշ�����
 * ���Թ���ͼ���û�
 */
package com.qq.server.view;

import javax.swing.*;

import com.qq.server.model.MyQqServer;

import java.awt.*;
import java.awt.event.*;
public class MyServerFrame extends JFrame implements ActionListener{
	JPanel jp1;
	JButton jb1,jb2;
	
	public static void main(String[] args) {
		
		MyServerFrame mysf=new  MyServerFrame();
	}
	
	public MyServerFrame()
	{
		jp1=new JPanel();
		jb1=new JButton("����������");
		jb1.addActionListener(this);
		jb2=new JButton("�رշ�����");
		jb2.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500,400);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			MyQqServer myQqServer=new MyQqServer();
		}
	}
}
