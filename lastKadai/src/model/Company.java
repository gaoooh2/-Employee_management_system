package model;

import java.io.Serializable;

public class Company implements Serializable {
	//comoany_info用
	private String company_id;
	private String company_name;
	private String abbreviation;
	private String is_deleted;
	private String created_date;
	private String modified_date;
	private String created_id;
	private String modified_id;
	private String selected = "";

	public Company() {}
	public Company(String company_id,String company_name,String abbreviation,String is_deleted,String created_date,String modified_date,String created_id,String modified_id) {
		this.company_id = company_id;
		this.company_name = company_name;
		this.abbreviation = abbreviation;
		this.is_deleted = is_deleted;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_id = created_id;
		this.modified_id = modified_id;
	}

	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getIs_deleted() {
		return is_deleted;
	}
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getModified_date() {
		return modified_date;
	}
	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}
	public String getCreated_id() {
		return created_id;
	}
	public void setCreated_id(String created_id) {
		this.created_id = created_id;
	}
	public String getModified_id() {
		return modified_id;
	}
	public void setModified_id(String modified_id) {
		this.modified_id = modified_id;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
}
