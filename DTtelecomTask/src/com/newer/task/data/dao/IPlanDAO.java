package com.newer.task.data.dao;

import java.util.List;

import com.newer.task.data.eneity.TbPlan;
import com.newer.task.web.dto.PlanDto;
import com.newer.task.web.util.TaskPlan;

public interface IPlanDAO {
	// ��ѯ���мƻ�
	public List<TbPlan> selectAll(String sql, Object[] parms);

	// ���������Ų�ѯ�ƻ�
	public List<TbPlan> selectByTaskId(Integer taskId);

	// ���ݼƻ���Ų�ѯ�ƻ���Ϣ ***
	public TbPlan selectByPlanId(Integer planId);

	// �����ƻ�
	public abstract boolean insertplan(TbPlan tp);

	// ɾ���ƻ�
	public abstract boolean deleteplan(Integer id);

	// �޸ļƻ�
	public abstract boolean updateplan(Integer id, TbPlan tp);

	// ��ϲ�ѯ/�߼���ѯ�����ѯ����м�¼����
	public abstract int getTotalCountsByPlanAdvance(PlanDto dto,int id);

	// �߼���ѯ��ҳ
	public abstract List<TaskPlan> selectPageByPlanAdvance(int id,PlanDto dto,
			int pageNo, int pageSize);


}
