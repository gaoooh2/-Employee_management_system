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
import model.ChangeSql;
import model.Dao;
import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class LoginProcessing
 */
@WebServlet("/LoginProcessing")
public class LoginProcessing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("loginId");
		String pass = request.getParameter("password");

		//Userインスタンスの生成
		User user = new User(name,pass);

		//ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);

		/* ログイン成功時の処理 */
		if(isLogin) {
			//ユーザー情報をセッションスコープに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

			/* Daoのlistの中身の事業部と年齢と稼働状況を編集してemployee.jspに渡す */
			Dao dao = new Dao();
			List<AddEmp> list = dao.findEmp();
			/* employeeList.jsp表示のための変換処理 */
			ChangeSql cs = new ChangeSql();
			list = cs.listChange(list);

			//employeeList.jspにリストを渡す
			session.setAttribute("ademp", list);

			//ログイン結果画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/employeeList.jsp");
			dispatcher.forward(request, response);

		} else {
			/* ログイン失敗時の処理 */
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errMsg", "IDまたはパスワードが異なります。");

			//ログイン結果画面にフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);

		}
	}
}