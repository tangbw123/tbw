package com.newer.task.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newer.task.data.dao.IEmployeeDAO;
import com.newer.task.data.eneity.TbEmployee;
import com.newer.task.service.IEmployeeService;

@Service("employeeService")
public class EmployeeServiceImpl implements IEmployeeService {

	@Resource(name = "employeeDao")
	IEmployeeDAO employeeDAO;

	public TbEmployee checkLogin(String employeeName, String password) {
		TbEmployee employee = null;

		List<TbEmployee> employeeList = new ArrayList<TbEmployee>();

		String whereSql = "select * from t_employee where employee_name=? and password=?";
		Object[] params = new Object[] { employeeName, password };

		employeeList = this.employeeDAO.selectEmployees(whereSql, params);

		if (employeeList != null && employeeList.size() > 0) {
			employee = employeeList.get(0);
		}
		return employee;
	}

	public List<TbEmployee> queryByManagerId(Integer Id, int pageNo,
			int pageSize) {
		// 编写sql 根据主管编号查询 主管下属所有员工
		String sql = "select *from (select row_number() over(order by EMPLOYEE_ID) no,t.* from  t_employee t  where PARENT_ID=?) temp where temp.no between ? and ?";
		int start = (pageNo - 1) * pageSize + 1;
		int end = pageNo * pageSize;
		// 调用DAO方法查询出员工集合
		List<TbEmployee> employeeList = employeeDAO.selectEmployees(sql,
				new Object[] { Id, start, end });
		return employeeList;
	}

	public TbEmployee queryEmpInfoByEmpId(Integer Id) {
		TbEmployee employee = null;
		List<TbEmployee> employeeList = new ArrayList<TbEmployee>();

		String whereSql = "select * from t_employee where EMPLOYEE_ID=?";
		Object[] params = new Object[] { Id };

		employeeList = this.employeeDAO.selectEmployees(whereSql, params);

		if (employeeList != null && employeeList.size() > 0) {
			employee = employeeList.get(0);
		}
		return employee;
	}

	public List<TbEmployee> selectEmp() {
		// TODO Auto-generated method stub
		List<TbEmployee> all = employeeDAO.selectEmp();
		return all;
	}

	public int insert(TbEmployee employee) {
		// TODO Auto-generated method stub
		int count = employeeDAO.insert(employee);
		return count;
	}

	public int del(TbEmployee employee) {
		// TODO Auto-generated method stub
		int count = employeeDAO.delete(employee);
		return count;
	}

	public TbEmployee selectById(TbEmployee employee) {
		// TODO Auto-generated method stub
		TbEmployee tbemp = null;
		if (employeeDAO.selectById(employee).size() > 0) {
			tbemp = employeeDAO.selectById(employee).get(0);
		}
		return tbemp;
	}

	public int update(TbEmployee employee) {
		// TODO Auto-generated method stub
		int count = employeeDAO.update(employee);
		return count;
	}

	public int queryByManagerIdCount(Integer Id) {
		String sql = "select count(1) as num from t_employee where PARENT_ID=?";
		int count= this.employeeDAO.queryCount(sql, Id);
		return count;
	}
	
}
