package com.newer.task.service;

import java.util.List;

import com.newer.task.data.eneity.TbPlan;
import com.newer.task.data.eneity.TbTask;
import com.newer.task.web.util.TaskPlan;

public interface ITaskService {
	// �������ܱ�Ų�ѯ���������������
	public abstract List<TaskPlan> queryAllTaskById(int id);

	// ���������Ų�ѯ���еļƻ�
	public abstract List<TbPlan> queryAllPlanById(Integer id);

	// ���ݼƻ���Ų�ѯ�ƻ���ϸ��Ϣ
	public abstract TbPlan queryPlanById(Integer id);

	// ��������

	public abstract int addTask(TbTask task);

	// �������ܱ�Ų�ѯ����״̬Ϊδʵʩ������
	public abstract List<TaskPlan> queryUnimplementedTask(Integer taskId,int pageNo, int pageSize);

	// �޸�������Ϣ
	public abstract int updateTaskInfo(TbTask task);

	// �������ܱ�Ų�ѯ��������ʵʩ�е�����
	public abstract List<TaskPlan> queryAllimplementTask(Integer id,
			int pageNo, int pageSize);

	// ���ݱ���޸�������Ϣ
	public abstract int updateTaskInfos(Integer id);

	// ���ݱ��ɾ��δʵʩ������

	public abstract int deleteNoTask(Integer id);

	// �������ܱ�Ų�ѯ���������������(��ҳ)
	public abstract List<TaskPlan> queryPageAllTaskById(int id, int pageNo,
			int pageSize);

	// �������ܱ�Ų�ѯ�������������������(��ҳ)
	public abstract int queryPageCount(int id);
	
	// �������ܱ�Ų�ѯ����������Ĵ�ʵʩ��������(��ҳ)
		public abstract int querydPageCount(int id);

	// �������ܱ�Ų�ѯ����������ʵʩ�е���������(��ҳ)
	public abstract int queryPageImplCount(int id);

}
