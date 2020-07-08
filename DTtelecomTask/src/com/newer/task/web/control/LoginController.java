package com.newer.task.web.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.newer.task.data.dao.IRoleDAO;
import com.newer.task.data.eneity.TbEmployee;
import com.newer.task.data.eneity.TbRole;
import com.newer.task.service.IEmployeeService;
import com.newer.task.web.util.EmployeeForm;


@Controller
@SessionAttributes("form")
public class LoginController {
	public LoginController() {
		System.out.println("��¼������ʵ����LoginController");
	}

	@Resource(name = "employeeService")
	IEmployeeService employeeService;

	@Resource(name = "roleDao")
	IRoleDAO roleDAO;

	// װ��Ա����¼������
	@RequestMapping(value = "/emp_input.do")
	public String inputEmps(Model model) {
		System.out.println("װ�������inputEmps");
		TbEmployee emps = new TbEmployee();// ��Ա���հ׶���
		TbRole role = new TbRole();// ����ɫ�հ׶���

		EmployeeForm loginForm = new EmployeeForm();// ��¼���ύ���ݷ�װ������
		loginForm.setEmp(emps);
		loginForm.setRole(role);

		// ��ѯ���н�ɫ��
		List<TbRole> allRoles = this.roleDAO.findAllRoles();
		model.addAttribute("form", loginForm);// �հױ�����

		model.addAttribute("allroles", allRoles);// ����ɫ�����б�װ������

		return "login";// login.jsp->ת������¼ҳ��
	}

	// ����¼����
	@RequestMapping(value = "/emplogin", method = RequestMethod.POST)
	public String empLogin(@ModelAttribute("form") EmployeeForm form,
			ModelMap map, HttpSession session) {
		String nextAction = "";// ��ת·��

		// ʹ��ҵ�����֤��¼��
		TbEmployee employee = employeeService.checkLogin(form.getEmp()
				.getEmployeeName(), form.getEmp().getPassword());// ��ѯԱ�����û���/���룩-�������ʽ����RoleId
		System.out.println(employee);
		if (employee != null) {
			// ��֤�û��ɹ������ݿ����Ա����¼��
			if (employee.getRole().getRoleId()
					.equals(form.getRole().getRoleId())) {// EmployeeForm���ύ��RoleID
				System.out.println("��ɫ/�û���/����");
				// �û��������뼰���ɫ��һ�µĵ�¼�ɹ�Ա�������ڻỰ��Χ�ڣ�����
				session.setAttribute("employee", employee);
				String roleName = employee.getRole().getRoleName();
				if ("ϵͳ����Ա".equals(roleName)) {
					nextAction = "redirect:/admin_login_success.do";
				} else if ("����".equals(roleName)) {
					nextAction = "redirect:/manager_login_success.do";
				} else if ("Ա��".equals(roleName)) {
					System.out.println("��ͨԱ��");
					nextAction = "redirect:/employee_login_success.do";
				}
			} else {
				map.put("message", "���û��޴˽�ɫ");
				nextAction = "error";
			}

		} else {
			map.put("message", "��¼ʧ�ܣ��û��������벻һ��");
			nextAction = "error";
		}
		return nextAction;
	}
}
