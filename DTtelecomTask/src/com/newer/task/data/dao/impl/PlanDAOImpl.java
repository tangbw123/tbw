package com.newer.task.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.newer.task.data.dao.IPlanDAO;
import com.newer.task.data.eneity.TbPlan;
import com.newer.task.data.eneity.TbTask;
import com.newer.task.data.util.DBUtil;
import com.newer.task.data.util.StringUtil;
import com.newer.task.web.dto.PlanDto;
import com.newer.task.web.util.TaskPlan;

@SuppressWarnings("all")
@Component("planDao")
// �ƻ�daoʵ����
public class PlanDAOImpl implements IPlanDAO {
	JdbcTemplate template = new JdbcTemplate(DBUtil.getDataSource());

	public List<TbPlan> selectAll(String sql, Object[] parms) {

		return template.query(sql, parms, new BeanPropertyRowMapper(
				TbPlan.class));
	}

	public List<TbPlan> selectByTaskId(Integer taskId) {

		return template.query("select * from t_plan where TASK_ID=?",
				new Object[] { taskId }, new RowMapper() {
					public Object mapRow(ResultSet rs, int row)
							throws SQLException {
						TbPlan tp = new TbPlan();
						tp.setPlanId(rs.getInt("PLAN_ID"));
						tp.setPlanName(rs.getString("PLAN_NAME"));
						tp.setStatus(rs.getString("STATUS"));
						tp.setIsFeedBack(rs.getString("IS_FEEDBACK"));
						tp.setBeginDate(rs.getTimestamp("BEGIN_DATE"));
						tp.setEndDate(rs.getTimestamp("END_DATE"));
						tp.setTaskId(rs.getInt("TASK_ID"));
						tp.setFeedBackInfo(rs.getString("FEEDBACK_INFO"));
						tp.setPlanDesc(rs.getString("PLAN_DESC"));
						return tp;
					}
				});
	}

	public TbPlan selectByPlanId(Integer planId) {
		String sql = "select * from t_plan where PLAN_ID=?";
		return template.queryForObject(sql, new Object[] { planId },
				new BeanPropertyRowMapper(TbPlan.class));
	}

	// ��ϲ�ѯ/�߼���ѯ�����ѯ����м�¼����
	public int getTotalCountsByPlanAdvance(PlanDto dto,int id) {

		String sql = "select count(*) from T_TASK inner join T_PLAN on T_TASK.TASK_ID=T_PLAN.TASK_ID  where 1=1 and IMPLEMENTOR_ID=?";
		List args = new ArrayList();
		args.add(id);
		if (dto != null) {
			if (!StringUtil.isBlank(dto.getSearch_planName())) {
				sql += " and PLAN_NAME like ?";

				args.add("%" + dto.getSearch_planName() + "%");

			}

			if (dto.getSearch_taskName() > 0) {
				sql += " and T_PLAN.TASK_ID=?";
				args.add(dto.getSearch_taskName());

			}

			if (dto.getSearch_begin_date1() != null
					&& dto.getSearch_begin_date2() != null
					&& dto.getSearch_begin_date1().before(
							dto.getSearch_begin_date2())) {
				sql += " and T_PLAN.BEGIN_DATE between ? and ? ";
				args.add(dto.getSearch_begin_date1());
				args.add(dto.getSearch_begin_date2());
			}

			if (dto.getSearch_end_date1() != null
					&& dto.getSearch_end_date2() != null
					&& dto.getSearch_end_date1().before(
							dto.getSearch_end_date2())) {
				sql += " and T_PLAN.END_DATE between ? and ? ";
				args.add(dto.getSearch_end_date1());
				args.add(dto.getSearch_end_date2());
			}

			if (!StringUtil.isBlank(dto.getFeedback_info())) {
				sql += " and FEEDBACK_INFO like ?";

				args.add("%" + dto.getFeedback_info() + "%");

			}

		}
		System.out.println(sql);
		return this.template.queryForInt(sql, args.toArray());

	}

	// �߼���ѯ��ҳ
	public List<TaskPlan> selectPageByPlanAdvance(int id, PlanDto dto,
			int pageNo, int pageSize) {
		int start = (pageNo - 1) * pageSize + 1;
		int end = pageNo * pageSize;

		//String sql = "select *from(select a.*,rownum row_num  from(select*from T_TASK inner join T_PLAN on T_TASK.TASK_ID=T_PLAN.TASK_ID  where 1=1 and IMPLEMENTOR_ID=? ";
		String sql ="select *from(select a.*,rownum row_num  from(select t.*,p.begin_date as begindate,p.end_date as endDate,p.plan_id,p.plan_name,p.status as zhuangtai,p.is_feedback,p.feedback_info,p.plan_desc  from T_TASK t inner join T_PLAN p on t.TASK_ID=p.TASK_ID  where 1=1 and IMPLEMENTOR_ID=?";
		List args = new ArrayList();
		args.add(id);
		if (dto != null) {
			if (!StringUtil.isBlank(dto.getSearch_planName())) {
				sql += " and PLAN_NAME like ?";

				args.add("%" + dto.getSearch_planName() + "%");

			}

			if (dto.getSearch_taskName() > 0) {
				sql += " and t.TASK_ID=?";
				args.add(dto.getSearch_taskName());

			}

			if (dto.getSearch_begin_date1() != null
					&& dto.getSearch_begin_date2() != null
					&& dto.getSearch_begin_date1().before(
							dto.getSearch_begin_date2())) {
				sql += " and p.BEGIN_DATE between ? and ? ";
				args.add(dto.getSearch_begin_date1());
				args.add(dto.getSearch_begin_date2());
			}

			if (dto.getSearch_end_date1() != null
					&& dto.getSearch_end_date2() != null
					&& dto.getSearch_end_date1().before(
							dto.getSearch_end_date2())) {
				sql += " and p.END_DATE between ? and ? ";
				args.add(dto.getSearch_end_date1());
				args.add(dto.getSearch_end_date2());
			}

			if (!StringUtil.isBlank(dto.getFeedback_info())) {
				sql += " and FEEDBACK_INFO like ?";

				args.add("%" + dto.getFeedback_info() + "%");

			}

		}
		sql += ") a) b where b.row_num between ? and ?";
		args.add(start);
		args.add(end);
		System.out.println(sql);

		return this.template.query(sql, args.toArray(), new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				TaskPlan taskplan = new TaskPlan();
				TbTask task = new TbTask();
				TbPlan tp = new TbPlan();
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
				tp.setPlanId(rs.getInt("PLAN_ID"));
				tp.setPlanName(rs.getString("PLAN_NAME"));
				tp.setStatus(rs.getString("zhuangtai"));
				tp.setIsFeedBack(rs.getString("IS_FEEDBACK"));
				tp.setBeginDate(rs.getTimestamp("begindate"));
				tp.setEndDate(rs.getTimestamp("enddate"));
				tp.setTaskId(rs.getInt("TASK_ID"));
				tp.setFeedBackInfo(rs.getString("FEEDBACK_INFO"));
				tp.setPlanDesc(rs.getString("PLAN_DESC"));
				List<TbPlan> all= new ArrayList<TbPlan>();
				all.add(tp);
				taskplan.setPlans(all);
				return taskplan;
			}
		});
	}

	public boolean insertplan(TbPlan tp) {
		boolean issucceed = false;
		String sql = "insert into T_PLAN (plan_name,status, is_feedback, begin_date, end_date, task_id, plan_desc)values(?,'��ʵʩ','��',?,?,?,?)";

		int count = this.template.update(
				sql,
				new Object[] { tp.getPlanName(), tp.getBeginDate(),
						tp.getEndDate(), tp.getTaskId(), tp.getPlanDesc() });

		if (count > 0) {

			issucceed = true;
		}

		return issucceed;
	}

	public boolean deleteplan(Integer id) {
		boolean issucceed = false;
		String sql = "delete from t_plan where PLAN_ID=?";

		int count = this.template.update(sql, new Object[] { id });

		if (count > 0) {

			issucceed = true;
		}

		return issucceed;
	}

	public boolean updateplan(Integer id, TbPlan tp) {
		boolean issucceed = false;

		String sql = "update T_plan set STATUS=?,IS_FEEDBACK=?,FEEDBACK_INFO=? where PLAN_ID=?";

		int count = this.template.update(
				sql,
				new Object[] { tp.getStatus(), tp.getIsFeedBack(),
						tp.getFeedBackInfo(), id });

		if (count > 0) {

			issucceed = true;
		}

		return issucceed;
	}

	
}
