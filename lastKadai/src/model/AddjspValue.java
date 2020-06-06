package model;

import java.io.Serializable;

public class AddjspValue implements Serializable  {
	//employee.jspのラジオボタンとセレクトボックスに値を保持するリスト
	private String man = "";
	private String woman = "";
	private String development = "";
	private String network = "";
	private String verification = "";
	private String office = "";
	private String management = "";
	private String commissioningStatusK = "";
	private String commissioningStatusM = "";
	private String enrollment = "";
	private String retirement = "";
	private String joined_wait = "";
	private String joined_cancellation = "";


	public AddjspValue() {}
	public AddjspValue(String sex,String department,String commissioning_status,String status) {
		if("0".equals(sex)) {
			this.man = "checked";
		}else if("1".equals(sex)) {
			this.woman = "checked";
		}
		if(department.equals("DEVELOPMENT") || department.equals("0") ) {
			this.development = "selected";
		}else if(department.equals("NETWORK") || department.equals("1")) {
			this.network = "selected";
		}else if(department.equals("VERIFICATION") || department.equals("2")) {
			this.verification = "selected";
		}else if(department.equals("OFFICE") || department.equals("3")) {
			this.office = "selected";
		}else if(department.equals("MANAGEMENT") || department.equals("4")) {
			this.management = "selected";
		}
		if("0".equals(commissioning_status)) {
			this.commissioningStatusK = "checked";
		}else if("1".equals(commissioning_status)) {
			this.commissioningStatusM = "checked";
		}
		if(status.equals("ENROLLMENT") || status.equals("在籍")) {
			this.enrollment = "selected";
		}else if(status.equals("RETIREMENT") || status.equals("退職")) {
			this.retirement = "selected";
		}else if(status.equals("JOINED_WAIT") || status.equals("入社待")) {
			this.joined_wait = "selected";
		}else if(status.equals("JOINED_CANCELLATION") || status.equals("入社取り消し")) {
			this.joined_cancellation = "selected";
		}
	}

	public String getMan() {
		return man;
	}

	public String getWoman() {
		return woman;
	}

	public String getDevelopment() {
		return development;
	}

	public String getNetwork() {
		return network;
	}

	public String getVerification() {
		return verification;
	}

	public String getOffice() {
		return office;
	}

	public String getManagement() {
		return management;
	}

	public String getCommissioningStatusK() {
		return commissioningStatusK;
	}
	public String getCommissioningStatusM() {
		return commissioningStatusM;
	}
	public String getEnrollment() {
		return enrollment;
	}
	public String getRetirement() {
		return retirement;
	}
	public String getJoined_wait() {
		return joined_wait;
	}

	public String getJoined_cancellation() {
		return joined_cancellation;
	}

}
