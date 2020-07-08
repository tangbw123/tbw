package com.newer.task.service;

import java.util.List;

import com.newer.task.data.eneity.TbPlan;
import com.newer.task.data.eneity.TbTask;
import com.newer.task.web.dto.PlanDto;
import com.newer.task.web.util.TaskPlan;

public interface IStaffService {

	public abstract List<TaskPlan> queryAllSTaffTaskPlanById(int id);

	// ��ϲ�ѯ/�߼���ѯ�����ѯ����м�¼����
	public abstract int getTotalCountsByPlanAdvance(PlanDto dto,int id);

	// �߼���ѯ��ҳ
	public abstract List<TaskPlan> selectPageByPlanAdvance(int id,PlanDto dto,
			int pageNo, int pageSize);

	public abstract TbTask selectTask(int id);

	// ���������Ų�ѯ�ƻ�
	public List<TbPlan> selectByTaskId(Integer taskId);

	// �����ƻ�
	public abstract boolean insertplan(TbPlan tp);

	// ɾ���ƻ�
	public abstract boolean deleteplan(Integer id);

	// �޸ļƻ�
	public abstract boolean updateplan(Integer id, TbPlan tp);

	// ���ݼƻ���Ų�ѯ�ƻ���Ϣ
	public abstract TbPlan selectByPlanId(Integer planId);

	// ��������id�޸�����״̬
	public abstract boolean updateTask(TbTask tk);

	public abstract int selectallcountTaskandPlan(Integer employeeId);

	public abstract List<TaskPlan> selectAllTask(Integer employeeId);

	public abstract List<TaskPlan> selectallTaskPlan(Integer employeeId,
			int pageNo, int pageSize);

}
