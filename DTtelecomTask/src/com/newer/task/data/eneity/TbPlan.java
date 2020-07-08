package com.newer.task.data.eneity;



import java.util.Date;

public class TbPlan {
	private Integer planId;// �ƻ����
	private String planName;// �ƻ�����
	private String status;// �ƻ�״̬
	private String isFeedBack;// �Ƿ���
	private Date beginDate;// ��ʼʱ��
	private Date endDate;// ����ʱ��
	private Integer taskId;// ��������
	private String feedBackInfo;// ������Ϣ
	private String planDesc;// �ƻ�����

	public TbPlan(Integer planId, String planName, String status,
			String isFeedBack, Date beginDate, Date endDate, Integer taskId,
			String feedBackInfo, String planDesc) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.status = status;
		this.isFeedBack = isFeedBack;
		this.beginDate = beginDate;
		this.endDate = endDate;
		this.taskId = taskId;
		this.feedBackInfo = feedBackInfo;
		this.planDesc = planDesc;
	}

	public TbPlan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsFeedBack() {
		return isFeedBack;
	}

	public void setIsFeedBack(String isFeedBack) {
		this.isFeedBack = isFeedBack;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getFeedBackInfo() {
		return feedBackInfo;
	}

	public void setFeedBackInfo(String feedBackInfo) {
		this.feedBackInfo = feedBackInfo;
	}

	public String getPlanDesc() {
		return planDesc;
	}

	public void setPlanDesc(String planDesc) {
		this.planDesc = planDesc;
	}

	@Override
	public String toString() {
		return "TbPlan [planId=" + planId + ", planName=" + planName
				+ ", status=" + status + ", isFeedBack=" + isFeedBack
				+ ", beginDate=" + beginDate + ", endDate=" + endDate
				+ ", taskId=" + taskId + ", feedBackInfo=" + feedBackInfo
				+ ", planDesc=" + planDesc + "]";
	}

}
