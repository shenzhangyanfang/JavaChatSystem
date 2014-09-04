/*
 * ���ܣ�QQ�ͻ��˵�½����
 */
package com.qq.client.view;

import com.qq.common.*;
import com.qq.client.tools.*;

import java.io.*;
import java.net.*;
import javax.swing.*;
import com.qq.client.model.QqClientUser;
import com.qq.common.User;

import java.awt.*;
import java.awt.event.*;
public class QqClientLogin extends JFrame implements ActionListener{

	/** ���屾��������� */
	private Desktop desktop = Desktop.getDesktop();
	/** ����ͳһ��Դ��ʶ������ */
	private URI uri1,uri2,uri3;
	//���山����Ҫ�����
	JLabel jbl1;
	//�����в���Ҫ�����
	//�в�������JPanel����һ����ѡ����ڹ���
	JPanel jp2;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4,jp2_jbl5;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;


	//�����ϲ���Ҫ�����
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqClientLogin  qqClientLogin=new QqClientLogin();
	}
	
	public QqClientLogin()
	{
		//������
		jbl1=new JLabel(new ImageIcon("image/logo554.GIF"));
		//jp5.add(jbl1);
		//�����в�
		jp2=new JPanel(new GridLayout(3,3));

		jp2_jbl1=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl3=new JLabel("��������",JLabel.CENTER);
		jp2_jbl3.setForeground(Color.BLUE);
		jp2_jbl4=new JLabel("�������뱣��",JLabel.CENTER);
		jp2_jbl4.setForeground(Color.BLUE);
		jp2_jbl5=new JLabel("�����˺�",JLabel.CENTER);
		jp2_jbl5.setForeground(Color.BLUE);
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		jp2_jcb1=new JCheckBox("�����¼");
		jp2_jcb2=new JCheckBox("��ס����");


		//����JLabel�ĳ���������������¼�
		 //����QQ����
		jp2_jbl5.setCursor(new Cursor(Cursor.HAND_CURSOR));//����������

		//��������¼�����
		jp2_jbl5.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				jp2_jbl5.setText("<html><A   href='http://id.qq.com/'>�����˺�</A></html>");
			}
			public void mouseExited(MouseEvent e){
				jp2_jbl5.setText("�����˺�");
			}
            public void mouseClicked(MouseEvent e) {
            	
            	try {
                    // ������ַ������
                    uri1 = new URI("http://id.qq.com/");
                } catch (URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            	try {
                    // ���uri1��ַ����ҳ
                    desktop.browse(uri1);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    //e1.printStackTrace();
                }
            }
        });
		
		//�������뱣��
		jp2_jbl4.setCursor(new Cursor(Cursor.HAND_CURSOR));//����������

		//��������¼�����
		jp2_jbl4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				jp2_jbl4.setText("<html><A   href='http://aq.qq.com/cn/services/safe_service/my_prot'>�������뱣��</A></html>");
			}
			public void mouseExited(MouseEvent e){
				jp2_jbl4.setText("�������뱣��");
			}
            public void mouseClicked(MouseEvent e) {
            	
            	try {
                    // ������ַ������
                    uri2 = new URI("http://aq.qq.com/cn/services/safe_service/my_prot");
                } catch (URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            	try {
                    // ���uri2��ַ����ҳ
                    desktop.browse(uri2);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    //e1.printStackTrace();
                }
            }
        });
		
		//�������뱣��
		jp2_jbl3.setCursor(new Cursor(Cursor.HAND_CURSOR));//����������

		//��������¼�����
		jp2_jbl3.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e)
			{
				jp2_jbl3.setText("<html><A   href='http://aq.qq.com/cn/findpsw/findpsw_index?reLogin=true&ADUIN=0&ADSESSION=0&ADTAG=CLIENT.QQ.1881_LoginWindow.0'>��������</A></html>");
			}
			public void mouseExited(MouseEvent e){
				jp2_jbl3.setText("��������");
			}
            public void mouseClicked(MouseEvent e) {
            	
            	try {
                    // ������ַ������
                    uri3 = new URI("http://aq.qq.com/cn/findpsw/findpsw_index?reLogin=true&ADUIN=0&ADSESSION=0&ADTAG=CLIENT.QQ.1881_LoginWindow.0");
                } catch (URISyntaxException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            	try {
                    // ���uri3��ַ����ҳ
                    desktop.browse(uri3);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    //e1.printStackTrace();
                }
            }
        });
		//�ѿؼ�����˳��ӵ�jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jbl5);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);


		//�����ϲ�
		jp1=new JPanel(new FlowLayout());
		jp1_jb1=new JButton(new ImageIcon("image/��¼.gif"));
		//��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton(new ImageIcon("image/ע��.gif"));
		jp1_jb2.addActionListener(this);


		//��������ť�ŵ�jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);


		this.add(jbl1,"North");
		this.add(jp2,"Center");
		//��jp1��������
		this.add(jp1,"South");
		this.setSize(325,220);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //��ȡ��ǰ��Ļ��С
		Dimension frameSize = this.getPreferredSize();//��ȡ��ǰ���ڴ�С
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);//���ִ��ڵ���λ�þ���
		this.setIconImage((new ImageIcon("image/ͷ��.GIF").getImage()));
		this.setTitle("QQ�û���¼");
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jp1_jb1)
		{
			QqClientUser qqClientUser=new QqClientUser();
			User u=new User();
			u.setQum(jp2_jtf.getText().trim());
			u.setOperation("1");
			u.setPassword(new String(jp2_jpf.getPassword()));
			if(qqClientUser.checkUser(u))
			{
				try {
					//�Ѵ��������б�������ǰ
					QqFriendList qqList=new QqFriendList(u.getQum());
					ManageQqFriendList.addQqFriendList(u.getQum(), qqList);
					//����һ��Ҫ�󷵻����ߺ��ѵ�����İ�
					ObjectOutputStream oos=new ObjectOutputStream
					(ManageClientConServerThread.getClientConServerThread(u.getQum()).getS().getOutputStream());

					//��һ��Message
					Message m=new Message();
					m.setMessType(MessageType.message_get_onLineFriend);

					//ָ����Ҫ�������qq�ŵĺ������
					m.setSender(u.getQum());
					oos.writeObject(m);

				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				//ͬʱ�رյ���½����
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this, "�û������������","��������",JOptionPane.WARNING_MESSAGE);
			}
		}else if(e.getSource()==jp1_jb2){
			
			new Register();
		}
	}
}
