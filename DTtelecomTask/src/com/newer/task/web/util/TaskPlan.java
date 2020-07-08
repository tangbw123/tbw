package com.newer.task.web.util;

import java.util.List;

import com.newer.task.data.eneity.TbPlan;
import com.newer.task.data.eneity.TbTask;

public class TaskPlan {
	private TbTask task;// ������Ϣ
	private List<TbPlan> plans;// �ƻ���Ϣ

	public TbTask getTask() {
		return task;
	}

	public void setTask(TbTask task) {
		this.task = task;
	}

	public List<TbPlan> getPlans() {
		return plans;
	}

	public void setPlans(List<TbPlan> plans) {
		this.plans = plans;
	}

	@Override
	public String toString() {
		return "TaskPlan [task=" + task + ", plans=" + plans + "]";
	}

	public TaskPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskPlan(TbTask task, List<TbPlan> plans) {
		super();
		this.task = task;
		this.plans = plans;
	}

}
