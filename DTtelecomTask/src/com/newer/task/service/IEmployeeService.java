package com.newer.task.service;

import java.util.List;

import com.newer.task.data.eneity.TbEmployee;

public interface IEmployeeService {
	// ��֤�û���¼�ķ���
	public abstract TbEmployee checkLogin(String employeeName, String password);

	// �������ܱ�Ų�ѯ�����ķ���
	public List<TbEmployee> queryByManagerId(Integer Id,int pageNo, int pageSize);

	// ���ݱ�Ų�ѯԱ����Ϣ
	public TbEmployee queryEmpInfoByEmpId(Integer Id);

	public List<TbEmployee> selectEmp();

	public int insert(TbEmployee employee);

	public int del(TbEmployee employee);

	public TbEmployee selectById(TbEmployee employee);

	public int update(TbEmployee employee);
	
	//���ݱ�Ų�ѯԱ������
	public int queryByManagerIdCount(Integer Id);

}