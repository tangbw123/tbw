package com.newer.task.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.newer.task.data.dao.ITaskDAO;
import com.newer.task.data.eneity.TbTask;
import com.newer.task.data.util.DBUtil;
import com.newer.task.web.util.TaskPlan;

@SuppressWarnings("all")
@Component("taskDao")
public class TaskDAOImpl implements ITaskDAO {
	JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

	public List<TaskPlan> selectAllTask(String sql, Object[] prams) {
		System.out.println("���������������+selectAllTask");
		List<TaskPlan> list = new ArrayList<TaskPlan>();
		list = this.template.query(sql, prams, new RowMapper() {

			public Object mapRow(ResultSet rs, int row) throws SQLException {
				TaskPlan taskplan = new TaskPlan();
				TbTask task = new TbTask();
				task.setTaskId(rs.getInt("TASK_ID"));
				task.setTaskName(rs.getString("TASK_NAME"));
				task.setBeginDate(rs.getTimestamp("BEGIN_DATE"));
				task.setEndDate(rs.getTimestamp("END_DATE"));
				task.setRealBeginDate(rs.getTimestamp("REAL_BEGIN_DATE"));
				task.setRealEndDate(rs.getTimestamp("REAL_END_DATE"));
				task.setStatus(rs.getString("STATUS"));
				task.setTask(new EmployeeDaoImpl().selectById(rs
						.getInt("IMPLEMENTOR_ID")));
				task.setAssignerId(rs.getInt("ASSIGNER_ID"));
				task.setTaskDesc(rs.getString("TASK_DESC"));
				taskplan.setTask(task);
				taskplan.setPlans(new PlanDAOImpl().selectByTaskId(rs
						.getInt("TASK_ID")));
				return taskplan;
			}
		});
		return list;
	}

	public int insertTask(TbTask task) {
		String sql = "insert into T_TASK (task_id, task_name, begin_date, end_date, real_begin_date,"
				+ " real_end_date, status, implementor_id, assigner_id, task_desc)"
				+ "values(sq_task.nextval,?,?,?,?,?,'��ʵʩ',?,?,?)";
		return template.update(
				sql,
				new Object[] { task.getTaskName(), task.getBeginDate(),
						task.getEndDate(), task.getRealBeginDate(),
						task.getEndDate(), task.getTask().getEmployeeId(),
						task.getAssignerId(), task.getTaskDesc() });
	}

	public static void main(String[] args) {
		List<TaskPlan> list = new TaskDAOImpl().selectAllTask(
				"select * from t_task where ASSIGNER_ID=?", new Object[] { 8 });
		for (TaskPlan taskPlan : list) {
			System.out.println(taskPlan);
		}
	}

	public int updateTask(TbTask task) {
		// �޸�������Ϣ
		String sql = " update T_TASK set TASK_NAME=?,BEGIN_DATE=?,END_DATE=?,REAL_BEGIN_DATE=?,REAL_END_DATE=?,IMPLEMENTOR_ID=?,task_desc=? where task_id=?";

		return template.update(
				sql,
				new Object[] { task.getTaskName(), task.getBeginDate(),
						task.getEndDate(), task.getRealBeginDate(),
						task.getRealEndDate(), task.getTask().getEmployeeId(),
						task.getTaskDesc(), task.getTaskId() });
	}

	public int updateTaskInfo(Integer id) {
		String sql = "update T_TASK set STATUS='�����' where TASK_ID=?";
		return template.update(sql, new Object[] { id });
	}

	public int deleteTask(Integer id) {
		String sql = "delete t_task where TASK_ID=?";
		return template.update(sql, new Object[] { id });
	}

	public List<TaskPlan> selectallTaskandPlan(int id) {

		String sql = "select*from T_TASK left join T_PLAN on T_TASK.TASK_ID=T_PLAN.TASK_ID where IMPLEMENTOR_ID=?";

		return this.template.query(sql, new Object[] { id }, new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {

				TaskPlan tp = new TaskPlan();

				TbTask task = new TbTask();

				task.setTaskId(rs.getInt("TASK_ID"));
				task.setTaskName(rs.getString("TASK_NAME"));
				task.setBeginDate(rs.getTimestamp("BEGIN_DATE"));
				task.setEndDate(rs.getTimestamp("END_DATE"));
				task.setRealBeginDate(rs.getTimestamp("REAL_BEGIN_DATE"));
				task.setEndDate(rs.getTimestamp("REAL_END_DATE"));
				task.setStatus(rs.getString("STATUS"));
				task.setTask(new EmployeeDaoImpl().selectById(rs
						.getInt("IMPLEMENTOR_ID")));
				task.setAssignerId(rs.getInt("ASSIGNER_ID"));
				task.setTaskDesc(rs.getString("TASK_DESC"));
				tp.setTask(task);
				tp.setPlans(new PlanDAOImpl().selectByTaskId(rs
						.getInt("TASK_ID")));

				return tp;
			}
		});
	}

	public TbTask selectTask(int id) {

		String sql = "select * from t_task where task_id=?";

		return (TbTask) template.queryForObject(sql, new Object[] { id },
				new RowMapper() {

					public Object mapRow(ResultSet rs, int arg1)
							throws SQLException {
						TbTask task = new TbTask();
						task.setTaskId(rs.getInt("TASK_ID"));
						task.setTaskName(rs.getString("TASK_NAME"));
						task.setBeginDate(rs.getTimestamp("BEGIN_DATE"));
						task.setEndDate(rs.getTimestamp("END_DATE"));
						task.setRealBeginDate(rs
								.getTimestamp("REAL_BEGIN_DATE"));
						task.setEndDate(rs.getTimestamp("REAL_END_DATE"));
						task.setStatus(rs.getString("STATUS"));
						task.setTask(new EmployeeDaoImpl().selectById(rs
								.getInt("IMPLEMENTOR_ID")));
						task.setAssignerId(rs.getInt("ASSIGNER_ID"));
						task.setTaskDesc(rs.getString("TASK_DESC"));

						return task;
					}
				});
	}

	public boolean updatetask(TbTask tk) {
		boolean issucceed = false;
		String sql = "update T_TASK set STATUS=? where TASK_ID=?";

		int count = this.template.update(sql,
				new Object[] { tk.getStatus(), tk.getTaskId() });

		if (count > 0) {

			issucceed = true;
		}

		return issucceed;

	}

	public int selectallcountTaskandPlan(Integer id) {
		String sql = "select count(*) from T_TASK left join T_PLAN on T_TASK.TASK_ID=T_PLAN.TASK_ID where IMPLEMENTOR_ID=?";

		return this.template.queryForInt(sql, new Object[] { id });
	}

	public List<TaskPlan> selectallTaskandPlan(Integer id, Integer pageNo,
			Integer pageSize) {
		int start = (pageNo - 1) * pageSize + 1;
		int end = pageNo * pageSize;
		String sql = "select * from(select a.*,rownum row_num  from(select*from T_TASK left join T_PLAN on T_TASK.TASK_ID=T_PLAN.TASK_ID  where IMPLEMENTOR_ID=?) a) b where b.row_num between ? and ?";

		return this.template.query(sql, new Object[] { id, start, end },
				new RowMapper() {

					public Object mapRow(ResultSet rs, int arg1)
							throws SQLException {

						TaskPlan tp = new TaskPlan();

						TbTask task = new TbTask();

						task.setTaskId(rs.getInt("TASK_ID"));
						task.setTaskName(rs.getString("TASK_NAME"));
						task.setBeginDate(rs.getTimestamp("BEGIN_DATE"));
						task.setEndDate(rs.getTimestamp("END_DATE"));
						task.setRealBeginDate(rs
								.getTimestamp("REAL_BEGIN_DATE"));
						task.setEndDate(rs.getTimestamp("REAL_END_DATE"));
						task.setStatus(rs.getString("STATUS"));
						task.setTask(new EmployeeDaoImpl().selectById(rs
								.getInt("IMPLEMENTOR_ID")));
						task.setAssignerId(rs.getInt("ASSIGNER_ID"));
						task.setTaskDesc(rs.getString("TASK_DESC"));
						tp.setTask(task);
						tp.setPlans(new PlanDAOImpl().selectByTaskId(rs
								.getInt("TASK_ID")));

						return tp;
					}
				});
	}
}
