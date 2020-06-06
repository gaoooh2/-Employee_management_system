package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig;

public class Dao {
	//csvのテーブル用の変数を用意
	//findメソッドで社員情報テーブルのカラム名を格納するための変数
	public String fieldData = "";
	//データベース接続用の変数を用意
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;

	//JDBCの変数を用意
	private final String JDBC ="jdbc:sqlite:/Users/gaoooh2/lastKadai.sqlite3";
	public List<AddEmp> find(){
	//リストを作成
	List<AddEmp> list = new ArrayList<>();
		try {
			/* データベースの接続 */
			Class.forName("org.sqlite.JDBC");
			// 外部キー制約を有効にする
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			// JDBC URLを指定
			con = DriverManager.getConnection(JDBC,config.toProperties());
			/* SQL送信処理 */

			/* 送信すべきSQL文の雛形を準備 */
			pstmt = con.prepareStatement("SELECT * FROM ((employee_info innner join company_info on company_info_id = company_info.company_id) employee_info inner join employee_state on employee_id = employee_state.employee_info_id) employee_info inner join login_info on employee_id = login_info.login_id;");
			//データベースから取得してrsにセット
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			rsmd.getColumnCount();

			/* 行が見つかればtrueが返る */
			while(rs.next()) {
				AddEmp one = new AddEmp();
				one.setEmployee_id(rs.getInt("employee_id"));
				one.setCompany_name(rs.getString("company_name"));
				one.setDepartment(rs.getString("department"));
				one.setName(rs.getString("name"));
				one.setName_hiragana(rs.getString("name_hiragana"));
				one.setBirthday(rs.getString("birthday"));
				one.setBusiness_manager(rs.getString("business_manager"));
				one.setHire_date(rs.getString("hire_date"));
				one.setCommissioning_status(rs.getString("commissioning_status"));
				one.setSex(rs.getString("sex"));
				one.setMail_address(rs.getString("mail_address"));
				one.setTelephone_number(rs.getString("telephone_number"));
				one.setStatus(rs.getString("status"));
				one.setCompany_info_id(rs.getString("company_info_id"));
				one.setIs_deleted(rs.getString("is_deleted"));
				one.setCreated_date(rs.getString("created_date"));
				one.setModified_date(rs.getString("modified_date"));
				one.setCreated_id(rs.getString("created_id"));
				one.setModified_id(rs.getString("modified_id"));
				one.setRetire_date(rs.getString("retire_date"));
				one.setLogin_id(rs.getString("login_id"));
				one.setPassword(rs.getString("password"));
				list.add(one);
			}

		} catch (ClassNotFoundException e) {
			//JDBCドライバが見つからない場合の処理
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			/* データベース接続の切断 */
			if(con != null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch(SQLException e) {
					//切断失敗時の処理
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public List<AddEmp> findEmp(){
	//リストを作成
	List<AddEmp> list = new ArrayList<>();
		try {
			/* データベースの接続 */
			Class.forName("org.sqlite.JDBC");
			// 外部キー制約を有効にする
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			// JDBC URLを指定
			con = DriverManager.getConnection(JDBC,config.toProperties());
			/* SQL送信処理 */

			/* 送信すべきSQL文の雛形を準備 */
			pstmt = con.prepareStatement("SELECT * FROM employee_info inner join employee_state on employee_info.created_id = employee_state.created_id");
			//データベースから取得してrsにセット
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			rsmd.getColumnCount();

			/* 行が見つかればtrueが返る */
			while(rs.next()) {
				AddEmp one = new AddEmp();
				one.setEmployee_id(rs.getInt("employee_id"));
				one.setName(rs.getString("name"));
				one.setName_hiragana(rs.getString("name_hiragana"));
				one.setBirthday(rs.getString("birthday"));
				one.setSex(rs.getString("sex"));
				one.setMail_address(rs.getString("mail_address"));
				one.setTelephone_number(rs.getString("telephone_number"));
				one.setCompany_info_id(rs.getString("company_info_id"));
				one.setBusiness_manager(rs.getString("business_manager"));
				one.setDepartment(rs.getString("department"));
				one.setCommissioning_status(rs.getString("commissioning_status"));
				one.setHire_date(rs.getString("hire_date"));
				one.setIs_deleted(rs.getString("is_deleted"));
				one.setCreated_date(rs.getString("created_date"));
				one.setModified_date(rs.getString("modified_date"));
				one.setCreated_id(rs.getString("created_id"));
				one.setModified_id(rs.getString("modified_id"));
				one.setStatus(rs.getString("status"));
				list.add(one);
			}

		} catch (ClassNotFoundException e) {
			//JDBCドライバが見つからない場合の処理
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			/* データベース接続の切断 */
			if(con != null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch(SQLException e) {
					//切断失敗時の処理
					e.printStackTrace();
				}
			}
		}
		return list;
	}


	public List<Company> findCompany(){
	//リストを作成
	List<Company> list = new ArrayList<>();
		try {
			/* データベースの接続 */
			Class.forName("org.sqlite.JDBC");
			// 外部キー制約を有効にする
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			// JDBC URLを指定
			con = DriverManager.getConnection(JDBC,config.toProperties());
			/* SQL送信処理 */

			/* 送信すべきSQL文の雛形を準備 */
			pstmt = con.prepareStatement("SELECT * FROM company_info;");
			//データベースから取得してrsにセット
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			rsmd.getColumnCount();

			/* 行が見つかればtrueが返る */
			while(rs.next()) {
				Company one = new Company();
				one.setCompany_id(rs.getString("company_id"));
				one.setCompany_name(rs.getString("company_name"));
				one.setAbbreviation(rs.getString("abbreviation"));
				one.setIs_deleted(rs.getString("is_deleted"));
				one.setCreated_date(rs.getString("created_date"));
				one.setModified_date(rs.getString("modified_date"));
				one.setCreated_id(rs.getString("created_id"));
				one.setModified_id(rs.getString("modified_id"));
				list.add(one);
			}

		} catch (ClassNotFoundException e) {
			//JDBCドライバが見つからない場合の処理
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			/* データベース接続の切断 */
			if(con != null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch(SQLException e) {
					//切断失敗時の処理
					e.printStackTrace();
				}
			}
		}
		return list;
	}


	public boolean insert(AddEmp ademp) {
		/* データベースの接続 */
		// 外部キー制約を有効にする
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		//JDBC URLを指定
		try(Connection con = DriverManager.getConnection(JDBC,config.toProperties())) {
			/* SQL送信処理 */
			/* 送信すべきSQL文の雛形を準備 */
			//employee_infoテーブル
			String employee_info = "INSERT INTO employee_info(employee_id,name,name_hiragana,birthday,sex,mail_address,telephone_number,company_info_id,business_manager,department,commissioning_status,hire_date,enrollment_year,enrollment_month,enrollment_day,is_deleted,created_date,modified_date,created_id,modified_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(employee_info);
			//INSERT文中の「?」に使用する値を設定しSQLを完成
			pstmt.setInt(1, ademp.getEmployee_id());
			pstmt.setString(2,ademp.getName());
			pstmt.setString(3,ademp.getName_hiragana());
			pstmt.setString(4,ademp.getBirthday());
			pstmt.setString(5,ademp.getSex());
			pstmt.setString(6,ademp.getMail_address());
			pstmt.setString(7,ademp.getTelephone_number());
			pstmt.setString(8,ademp.getCompany_info_id());
			pstmt.setString(9,ademp.getBusiness_manager());
			pstmt.setString(10,ademp.getDepartment());
			pstmt.setString(11,ademp.getCommissioning_status());
			pstmt.setString(12,ademp.getHire_date());
			pstmt.setString(13,ademp.getEnrollment_year());
			pstmt.setString(14,ademp.getEnrollment_month());
			pstmt.setString(15,ademp.getEnrollment_day());
			pstmt.setString(16,ademp.getIs_deleted());
			pstmt.setString(17,ademp.getCreated_date());
			pstmt.setString(18,ademp.getModified_date());
			pstmt.setString(19,ademp.getCreated_id());
			pstmt.setString(20,ademp.getModified_id());

			//employee_stateテーブル
			String employee_state = "INSERT INTO employee_state(employee_info_id,retire_date,status,is_deleted,created_date,modified_date,created_id,modified_id) values(?,?,?,?,?,?,?,?)";
			pstmt2 =con.prepareStatement(employee_state);
			//employee_idをStringに変換、statusをsql用に0〜4に変換
			String empId = Integer.toString(ademp.getEmployee_id());
			ChangeSql cs = new ChangeSql();
			String status = cs.status(ademp.getStatus());

			//INSERT文中の「?」に使用する値を設定しSQLを完成
			pstmt2.setString(1,empId);
			pstmt2.setString(2,ademp.getRetire_date());
			pstmt2.setString(3,status);
			pstmt2.setString(4,ademp.getIs_deleted());
			pstmt2.setString(5,ademp.getCreated_date());
			pstmt2.setString(6,ademp.getModified_date());
			pstmt2.setString(7,ademp.getCreated_id());
			pstmt2.setString(8,ademp.getModified_id());

			//INSERT文を実行
			pstmt.executeUpdate();
			pstmt2.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			/* データベース接続の切断 */
			if(con != null) {
				try {
					rs.close();
					pstmt.close();
					pstmt2.close();
					con.close();
				} catch(SQLException e) {
					//切断失敗時の処理
					e.printStackTrace();
				}
			}
		}
		return  true;
	}

	public boolean update(AddEmp ademp,String sql) {
		/* データベースの接続 */
		// 外部キー制約を有効にする
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		//JDBC URLを指定
		try(Connection con = DriverManager.getConnection(JDBC,config.toProperties())) {
			/* SQL送信処理 */
			/* 送信すべきSQL文の雛形を準備 */
			pstmt = con.prepareStatement(sql);
			//UPDATE文を実行
			pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			/* データベース接続の切断 */
			if(con != null) {
				try {
					rs.close();
					pstmt.close();
					con.close();
				} catch(SQLException e) {
					//切断失敗時の処理
					e.printStackTrace();
				}
			}
		}
		return  true;
	}

}

