package servlet;

import java.io.IOException;
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
import model.Company;
import model.Dao;
import model.User;

/**
 * Servlet implementation class EmployeeConnect
 */
@WebServlet("/EmployeeConnect")
public class EmployeeConnect extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		//ログインしているか確認
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		//ログインしていない場合はリダイレクト
		if(loginUser == null) {
			response.sendRedirect("/lastKadai/");
		} else {
		//ログインしている場合
		//リストを取得して、リクエストスコープに保存
		Dao dao = new Dao();
		AddEmp ae = new AddEmp();
		int i = 0;
		List<AddEmp> ademp = dao.findEmp();
		List<Company> comlist = dao.findCompany();

		//詳細ボタンが押されたNoから情報をもらって表示する
		String id = request.getParameter("employee_id");
		for(i = 0; i < ademp.size(); i++) {
			ae = ademp.get(i);
			if(Integer.parseInt(id) == ademp.get(i).getEmployee_id()) {
				break;
			}
		}
		//値保持の処理
		for(int j = 0 ; j  < ademp.size() ; j++ ) {
			ae = ademp.get(i);
			for(int k = 0; k < comlist.size(); k++ ) {
				if(Integer.parseInt(id) == ademp.get(i).getEmployee_id() && ademp.get(i).getCompany_info_id().equals(comlist.get(k).getCompany_id())) {
					comlist.get(k).setSelected("selected");
					break;
				}
			}
		}


		//詳細ボタンが押されたとき更新の文字に変える
		String val = "更新";

		//チェックボックスやセレクトボックスの値を持たせる
		AddjspValue ajv = new AddjspValue(ae.getSex(),ae.getDepartment(),ae.getCommissioning_status(),ae.getStatus());
		request.setAttribute("errVal", ae);
		request.setAttribute("aeList", ajv);
		request.setAttribute("val", val);
		request.setAttribute("com", comlist);
		//詳細画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/employee.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		//ログインしているか確認
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		//ログインしていない場合はリダイレクト
		if(loginUser == null) {
			response.sendRedirect("/lastKadai/");
		} else {
			//ログインしている場合
			//nullのリストを作成して、リクエストスコープに保存
			String sex = "";
			String company_name = "";
			String department = "";
			String commissioning_status = "";
			String status = "";
			String name = "";
			String name_hiragana = "";
			String birthday = "";
			String business_manager = "";
			String hire_date = "";
			String mail_address = "";
			String telephone_number = "";
			String retire_date = "";

			AddjspValue ajv = new AddjspValue(sex,department,commissioning_status,status);
			AddEmp ae = new AddEmp(company_name,department,name,name_hiragana,birthday,business_manager,hire_date,commissioning_status,sex,mail_address,telephone_number,retire_date);
			Dao dao = new Dao();
			List<Company> comlist = dao.findCompany();

			//新規登録ボタンが押された時の登録ボタン
			String val = "登録";
			request.setAttribute("ajv", ajv);
			request.setAttribute("ademp", ae);
			request.setAttribute("val", val);
			request.setAttribute("com", comlist);

		//新規登録画面にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/employee.jsp");
		dispatcher.forward(request, response);
		}
	}
}
