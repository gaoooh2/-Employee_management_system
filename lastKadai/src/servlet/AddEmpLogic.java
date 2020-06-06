package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AddEmp;
import model.AddjspValue;
import model.ChangeSql;
import model.Company;
import model.Dao;
import model.User;
import model.ValidationCheck;

/**
 * Servlet implementation class NewAddemp
 */
@WebServlet("/AddEmpLogic")
public class AddEmpLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");

		//ログインしているか確認
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		//employee.jspで受け取った値を変数に入れる
		String employee_id = request.getParameter("employee_id");
		String company_name = request.getParameter("companyName");
		String department = request.getParameter("department");
		String name = request.getParameter("name");
		String name_hiragana = request.getParameter("nameHiragana");
		String birthday = request.getParameter("birthday");
		String business_manager = request.getParameter("businessManager");
		String hire_date = request.getParameter("enterDate");
		String commissioning_status = request.getParameter("commissioningStatus");
		String sex = request.getParameter("sex");
		String mail_address = request.getParameter("mailAddress");
		String telephone_number = request.getParameter("telephoneNumber");
		String status = request.getParameter("status");
		String retire_date = request.getParameter("retireDate");
		String val = request.getParameter("val");


		//AddEmpのインスタンスを作成
		AddEmp ae = new AddEmp(company_name,department,name,name_hiragana,birthday,business_manager,hire_date,commissioning_status,sex,mail_address,telephone_number,retire_date);
		Dao dao = new Dao();
		List<Company> comlist = dao.findCompany();
		List<AddEmp> idlist = dao.findEmp();

		//バリデーションチェックにフラグを立てる
		ValidationCheck VCheck = new ValidationCheck();
		List<Integer> errFlag = VCheck.executeAll(ae.getName(), ae.getName_hiragana(), ae.getBirthday(), ae.getBusiness_manager(), ae.getHire_date(), ae.getCommissioning_status(), ae.getSex(), ae.getMail_address(), ae.getTelephone_number(), ae.getRetire_date());

		//変換用のメソッドChangeSqlを作成
		ChangeSql change = new ChangeSql();

		//ログインしていない場合はリダイレクト
		if(loginUser == null) {
			response.sendRedirect("/lastKadai/");
			/* ログイン成功時の処理 */
		} else {
			if(errFlag != null && errFlag.size() != 0) {
				//フラグによってエラーメッセージを追加
				String msg = "";
				if(errFlag.contains(1)) {
					msg +=  "氏名を入力してください。<br>";
				}
				if(errFlag.contains(2)) {
					msg +=  "氏名は20文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(3)) {
					msg +=  "氏名は全角で入力して下さい。<br>";
				}
				if(errFlag.contains(4)) {
					msg +=  "氏名(ひらがな)を入力して下さい。<br>";
				}
				if(errFlag.contains(5)) {
					msg +=  "氏名(ひらがな)は20文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(6)) {
					msg +=  "氏名(ひらがな)は全角ひらがなで入力して下さい。<br>";
				}
				if(errFlag.contains(7)) {
					msg +=  "生年月日を入力して下さい。<br>";
				}
				if(errFlag.contains(8)) {
					msg +=  "生年月日は10文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(9)) {
					msg +=  "生年月日はYYYY/MM/DDの書式で入力して下さい。<br>";
				}
				if(errFlag.contains(10)) {
					msg +=  "メールアドレスを入力して下さい。<br>";
				}
				if(errFlag.contains(11)) {
					msg +=  "メールアドレスは50文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(12)) {
					msg +=  "メールアドレスは半角英数字記号で入力して下さい。<br>";
				}
				if(errFlag.contains(13)) {
					msg +=  "電話番号を入力して下さい。<br>";
				}
				if(errFlag.contains(14)) {
					msg +=  "電話番号は11文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(15)) {
					msg +=  "電話番号は半角数字で入力して下さい。<br>";
				}
				if(errFlag.contains(16)) {
					msg +=  "担当管理営業を入力して下さい。<br>";
				}
				if(errFlag.contains(17)) {
					msg +=  "担当管理営業は20文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(18)) {
					msg +=  "担当管理営業は全角で入力して下さい。<br>";
				}
				if(errFlag.contains(19)) {
					msg +=  "入社日を入力して下さい。<br>";
				}
				if(errFlag.contains(20)) {
					msg +=  "入社日は10文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(21)) {
					msg +=  "入社日はYYYY/MM/DDの書式で入力して下さい。<br>";
				}
				if(errFlag.contains(22)) {
					msg +=  "退職日は10文字以内で入力して下さい。<br>";
				}
				if(errFlag.contains(23)) {
					msg +=  "退職日はYYYY/MM/DDの書式で入力して下さい。<br>";
				}
				//エラーメッセージをリクエストスコープに保存（最後の改行は消す）
				request.setAttribute("errFlagMsg", msg.substring(0,msg.length() - 4));

				//エラーの時も入力値を保持するようにリクエストスコープに保存
				request.setAttribute("errVal", ae);
				//エラー時に値の保持をする
				for(int i = 0 ; i  < comlist.size() ; i++ ) {
					if(company_name.equals(comlist.get(i).getAbbreviation())) {
						comlist.get(i).setSelected("selected");
						break;
					}
				}

				AddjspValue ajv = new AddjspValue(sex,department,commissioning_status,status);
				request.setAttribute("com", comlist);
				request.setAttribute("aeList", ajv);
				request.setAttribute("val", val);
				//employee画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/employee.jsp");
				dispatcher.forward(request, response);
			} else {
				/* エラーがない場合の処理 */
				//会社名からidに変える処理追加
				String company_info_id = request.getParameter("companyName");
				for(int i = 0; i < comlist.size(); i++) {
					if(company_info_id.equals(comlist.get(i).getAbbreviation())) {
						company_info_id = comlist.get(i).getCompany_id();
					}
				}
				//departmentを0〜4の数字に変換
				department = change.department(department);

				String is_deleted = "0";
				//登録日の処理
				Date date = new Date();
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy/MM/dd");
				String created_date = sdf.format(date);
				String modified_date = sdf.format(date);
				String created_id = "";
				String modified_id = loginUser.getName();

				//登録ボタンが押されたときの処理
				if(val.equals("登録")) {
					//社員番号（created_id)の付与
					int id = 0;
					for(int i = 0; i < idlist.size(); i++ ) {
						created_id = idlist.get(i).getCreated_id();
						id = Integer.parseInt(created_id);
					}
					id += 1;
					created_id = Integer.toString(id);

					//sqlの人数+1をemployee_idに付与
					int emp_id = 0;
					emp_id = idlist.size() + 1;
					AddEmp aeinsert = new AddEmp(emp_id,name,name_hiragana,birthday,sex,mail_address,telephone_number,company_info_id,business_manager,department,commissioning_status,hire_date,is_deleted,created_date,modified_date,created_id,modified_id,status,retire_date);
					aeinsert.setEnrollment_year(hire_date);
					aeinsert.setEnrollment_month(hire_date);
					aeinsert.setEnrollment_day(hire_date);

					//insert文を実行
					dao.insert(aeinsert);

				//詳細ボタンが押された時の処理
				} else {
					created_id = ae.getCreated_id();
					String sql = "UPDATE employee_info set name = " + name  + ", name_hiragana = " + name_hiragana  +", birthday = " + birthday +", sex = " + sex +", mail_address = " + mail_address +", telephone_number = " + telephone_number +", company_info_id = " + company_info_id +", business_manager = " + business_manager +", department = " + department +", commissioning_status = " + commissioning_status +", hire_date = " + hire_date +", retire_date = " + retire_date +", status = " + status + ", modified_date = " + modified_date + ", modified_id = " + modified_id + " where employee_id = " + employee_id;
					System.out.println(sql);
					//update文を実行
					//dao.update(ae,sql);
				}
				/* 最新のDaoを取得し、listの中身の事業部と年齢と稼働状況を編集してemployee.jspに渡す */
				Dao newDao = new Dao();
				List<AddEmp> list = newDao.findEmp();
				ChangeSql cs = new ChangeSql();
				list = cs.listChange(list);
				request.setAttribute("ademp", list);

				//employeeList画面にフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/employeeList.jsp");
				dispatcher.forward(request, response);
			}
		}
	}
}