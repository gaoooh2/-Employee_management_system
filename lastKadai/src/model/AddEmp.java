package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddEmp implements Serializable {
	//employee.jspで入力する値を設定
	private int employee_id;
	private String name = null;
	private String name_hiragana = null;
	private String birthday = null;
	private String sex = null;
	private String mail_address = null;
	private String telephone_number = null;
	private String company_info_id = null;
	private String business_manager = null;
	private String department = null;
	private String commissioning_status = null;
	private String hire_date = null;
	private String enrollment_year = null;
	private String enrollment_month = null;
	private String enrollment_day = null;
	private String is_deleted = null;
	private String created_date = null;
	private String modified_date = null;
	private String created_id = null;
	private String modified_id = null;
	private String company_name = null;
	private String retire_date = null;
	private String status = null;
	private String login_id = null;
	private String password = null;

	public AddEmp() {}
	public AddEmp(String company_name,String department,String name,String name_hiragana,String birthday,String business_manager,String hire_date,String commissioning_status,String sex,String mail_address,String telephone_number,String retire_date) {
		this.company_name = company_name;
		this.department = department;
		this.name = name;
		this.name_hiragana = name_hiragana;
		this.birthday = birthday;
		this.business_manager = business_manager;
		this.hire_date = hire_date;
		this.commissioning_status = commissioning_status;
		this.sex = sex;
		this.mail_address = mail_address;
		this.telephone_number = telephone_number;
		this.retire_date = retire_date;
	}

	public AddEmp(int employee_id,String company_name, String department,String name,String name_hiragana,String birthday,String business_manager,String hire_date,String commissioning_status,String sex,String mail_address,String telephone_number,String retire_date) {
		this.employee_id = employee_id;
		this.company_name = company_name;
		this.department = department;
		this.name = name;
		this.name_hiragana = name_hiragana;
		this.birthday = birthday;
		this.business_manager = business_manager;
		this.hire_date = hire_date;
		this.commissioning_status = commissioning_status;
		this.sex = sex;
		this.mail_address = mail_address;
		this.telephone_number = telephone_number;
		this.retire_date = retire_date;
	}

	//insertとselect文用
	public AddEmp(int employee_id,String name, String name_hiragana, String birthday, String sex, String mail_address,String telephone_number,String company_info_id, String business_manager, String department, String commissioning_status, String hire_date,  String is_deleted, String created_date, String modified_date, String created_id, String modified_id,String status,String retire_date) {
		this.employee_id = employee_id;
		this.name = name;
		this.name_hiragana = name_hiragana;
		this.birthday = birthday;
		this.sex = sex;
		this.mail_address = mail_address;
		this.telephone_number = telephone_number;
		this.company_info_id = company_info_id;
		this.business_manager = business_manager;
		this.department = department;
		this.commissioning_status = commissioning_status;
		this.hire_date = hire_date;
		this.is_deleted = is_deleted;
		this.created_date = created_date;
		this.modified_date = modified_date;
		this.created_id = created_id;
		this.modified_id = modified_id;
		this.status = status;
		this.retire_date = retire_date;
	}


	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_hiragana() {
		return name_hiragana;
	}

	public void setName_hiragana(String name_hiragana) {
		this.name_hiragana = name_hiragana;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBusiness_manager() {
		return business_manager;
	}

	public void setBusiness_manager(String business_manager) {
		this.business_manager = business_manager;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getCommissioning_status() {
		return commissioning_status;
	}

	public void setCommissioning_status(String commissioning_status) {
		this.commissioning_status = commissioning_status;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMail_address() {
		return mail_address;
	}

	public void setMail_address(String mail_address) {
		this.mail_address = mail_address;
	}

	public String getTelephone_number() {
		return telephone_number;
	}

	public void setTelephone_number(String telephone_number) {
		this.telephone_number = telephone_number;
	}

	public String getRetire_date() {
		return retire_date;
	}

	public void setRetire_date(String retire_date) {
		this.retire_date = retire_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompany_info_id() {
		return company_info_id;
	}

	public void setCompany_info_id(String company_info_id) {
		this.company_info_id = company_info_id;
	}

	public String getEnrollment_year() {
		return enrollment_year;
	}

	//入社年・月・日に使うカレンダー調整を作成
	SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
	public void setEnrollment_year(String hire_date) {
		try {
			//入社日取り出しと今日の日付取り出し
			Date nyushabi = sd.parse(hire_date);
			Date today = new Date();

		    //入社日をセット
		    Calendar calNyushabi = Calendar.getInstance();
		    calNyushabi.setTime(nyushabi);
		    calNyushabi.set(Calendar.DATE, 1);

		    //今日の日付をセット
		    Calendar calToday = Calendar.getInstance();
		    calToday.setTime(today);
		    calToday.set(Calendar.DATE, 1);

		    /**
		     *@param yearCount 差分年数（◯年と表記）
		     */
		    //差分月数を計算
		    int monthCount = 0;
		    while (calNyushabi.before(calToday)) {
		        calNyushabi.add(Calendar.MONTH, 1);
		        monthCount++;
		    }
		    //差分年月を計算
		    int yearCount = monthCount / 12;
		    int yearCountMonth = monthCount % 12;

		    //0か月なら年だけセットし、1か月以上なら月もセットする
		    if(yearCountMonth == 0) {
		    	this.enrollment_year = yearCount + "年";
		    }else{
		    	this.enrollment_year = yearCount + "年" + yearCountMonth + "か月";
		    }
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getEnrollment_month() {
		return enrollment_month;
	}

	public void setEnrollment_month(String hire_date) {
		try {
			//入社日取り出しと今日の日付取り出し
			Date nyushabi = sd.parse(hire_date);
			Date today = new Date();

		    //入社日をセット
		    Calendar calNyushabi = Calendar.getInstance();
		    calNyushabi.setTime(nyushabi);
		    calNyushabi.set(Calendar.DATE, 1);
		    //今日の日付をセット
		    Calendar calToday = Calendar.getInstance();
		    calToday.setTime(today);
		    calToday.set(Calendar.DATE, 1);

		    /**
		     *@param monthCount 差分月数（◯か月と表記）
		     */
		    //差分月数を計算
		    int monthCount = 0;
		    while (calNyushabi.before(calToday)) {
		        calNyushabi.add(Calendar.MONTH, 1);
		        monthCount++;
		    }
		    this.enrollment_month = monthCount + "か月";

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public String getEnrollment_day() {
		return enrollment_day;
	}

	public void setEnrollment_day(String hire_date) {
		try {
			//入社日取り出し
			Date nyushabi = sd.parse(hire_date);
			//今日の日付取り出し
			Date today = new Date();
		    // 日付をlong値に変換
		    long nyushabil = nyushabi.getTime();
		    long todayl = today.getTime();
		    //入社日をセット
		    Calendar calNyushabi = Calendar.getInstance();
		    calNyushabi.setTime(nyushabi);
		    calNyushabi.set(Calendar.DATE, 1);
		    //今日の日付をセット
		    Calendar calToday = Calendar.getInstance();
		    calToday.setTime(today);
		    calToday.set(Calendar.DATE, 1);

		    /**
		     *@param dayCount 差分日数（◯日と表記）
		     */

			// 差分の日数
		    long dayCount = ( todayl - nyushabil  ) / (1000 * 60 * 60 * 24 );
		    this.enrollment_day = dayCount + "日";

		} catch (ParseException e) {
			e.printStackTrace();
		}
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

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}