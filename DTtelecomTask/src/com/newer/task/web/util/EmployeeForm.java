package com.newer.task.web.util;

import com.newer.task.data.eneity.TbEmployee;
import com.newer.task.data.eneity.TbRole;

public class EmployeeForm {
	TbEmployee emp;// ��Ա��
	TbRole role;// ����ɫ

	public TbEmployee getEmp() {
		return emp;
	}

	public void setEmp(TbEmployee emp) {
		this.emp = emp;
	}

	public TbRole getRole() {
		return role;
	}

	public void setRole(TbRole role) {
		this.role = role;
	}

	public EmployeeForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeForm(TbEmployee emp, TbRole role) {
		super();
		this.emp = emp;
		this.role = role;
	}

	@Override
	public String toString() {
		return "LoginForm [emp=" + emp + ", role=" + role + "]";
	}
}
