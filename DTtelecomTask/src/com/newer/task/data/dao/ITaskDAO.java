package com.newer.task.data.dao;

import java.util.List;

import com.newer.task.data.eneity.TbTask;
import com.newer.task.web.util.TaskPlan;

//����dao
public interface ITaskDAO {
	// ��ѯ����
	public abstract List<TaskPlan> selectAllTask(String sql, Object[] prams);

	// ��������
	public abstract int insertTask(TbTask task);

	// �޸�����
	public abstract int updateTask(TbTask task);

	// �޸�����״̬
	public abstract int updateTaskInfo(Integer id);

	// ɾ��δʵʩ������Ϣ
	public abstract int deleteTask(Integer id);

	// ������Ӳ�ѯ
	public abstract List<TaskPlan> selectallTaskandPlan(int id);

	public abstract TbTask selectTask(int id);
	
	public abstract boolean updatetask(TbTask tk);

	public abstract int selectallcountTaskandPlan(Integer id);

	public abstract List<TaskPlan> selectallTaskandPlan(Integer id,
			Integer pageNo, Integer pageSize);

}
