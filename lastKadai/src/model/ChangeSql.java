package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChangeSql implements Serializable {

	//employeeList.jsp表示用の事業部、年齢、稼働状況変換メソッド
	public List<AddEmp> listChange(List<AddEmp> list) {
		/* 事業部変換 */
		String depart;
		for(int i = 0; i < list.size(); i++) {
			depart = list.get(i).getDepartment();
			switch(depart) {
			case "0":
				depart = "開発";
				break;
			case "1":
				depart = "NW";
				break;
			case "2":
				depart = "検証";
				break;
			case "3":
				depart = "オフィス";
				break;
			case "4":
				depart = "管理";
				break;
			default:
				depart = null;
			}
			list.get(i).setDepartment(depart);
		}
		/* 年齢計算 */
		String age = null;
		Integer agei = 0;
		Date date = new Date();
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		for(int i = 0; i < list.size(); i++ ) {
			age = list.get(i).getBirthday();
			age = age.replace("/", "");
			try {
				date = sdf.parse(age);
				agei = (Integer.parseInt(sdf.format(today)) - Integer.parseInt(sdf.format(date))) / 10000;
				age = agei.toString();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		list.get(i).setBirthday(age);
		}
		/* 稼働状況置換処理 */
		String comission;
		for(int i = 0;i < list.size(); i++) {
			comission = list.get(i).getCommissioning_status();
			if(comission.equals("0")) {
				comission = "未稼働";
			}else if(comission.equals("1")){
				comission = "稼働";
			}
			list.get(i).setCommissioning_status(comission);
		}

		/* 会社情報置換 */
		Dao dao = new Dao();
		List<Company> comlist = dao.findCompany();
		String company_info_id = "";
		String company_id = "";
		//会社名の入れ物は性別(sex)に置き換え
		for(int i = 0; i < list.size() ; i++) {
			company_info_id = list.get(i).getCompany_info_id();
			for(int j = 0; j < comlist.size(); j ++) {
				company_id = comlist.get(j).getCompany_id();
				if(company_info_id.equals(company_id)) {
					list.get(i).setSex(comlist.get(j).getCompany_name());
				}
			}
		}


		return list;
	}

	//新規登録画面からSQLに追加するときに変換
	public String department(String department) {
		if(department.equals("DEVELOPMENT")) {
			return "0";
		} else if(department.equals("NETWORK")) {
			return "1";
		} else if(department.equals("VERIFICATION")) {
			return "2";
		} else if(department.equals("OFFICE")) {
			return "3";
		} else if(department.equals("MANAGEMENT")) {
			return "4";
		} else {
			return null;
		}
	}
	//新規登録画面からSQLに追加するときの変換
	public String status(String status) {
		if(status.equals("ENROLLMENT")) {
			return "在籍";
		} else if(status.equals("RETIREMENT")) {
			return "退職";
		} else if(status.equals("JOINED_WAIT")) {
			return "入社待";
		} else if(status.equals("JOINED_CANCELLATION")) {
			return "入社取り消し";
		} else {
			return null;
		}
	}
}
