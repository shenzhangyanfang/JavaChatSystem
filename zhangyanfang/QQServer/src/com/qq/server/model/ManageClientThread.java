package com.qq.server.model;

import java.util.*;
public class ManageClientThread {

	public static HashMap hm=new HashMap<String,SerConClientThread>();
	
	//��hm�����һ���ͻ���ͨ���߳�
	public static void addClientThread(String uid,SerConClientThread ct)
	{
		hm.put(uid,ct);
	}
	
	public static SerConClientThread getClientThread(String uid)
	{
		return (SerConClientThread)hm.get(uid);
	}
	//���ص�ǰ�����˵����
	public static String getAllOnLineUserid()
	{
		//ʹ�õ��������
		Iterator it=hm.keySet().iterator();
		String res="";
		while(it.hasNext())
		{
			res+=it.next().toString()+" ";
		}
		return res;
	}
}
