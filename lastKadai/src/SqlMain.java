import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.AddEmp;
import model.Dao;

public class SqlMain {

	public static void main(String[] args) {
		//Employee_Infoテーブルの全レコードを取得
		Dao dao = new Dao();
		List<AddEmp> addemps = dao.find();

		//年齢計算処理
		String birth = null;
		Date now = new Date();
		try {
			for(AddEmp emp : addemps) {
				//誕生日の取得してDate型に変換
				birth = emp.getBirthday();
				DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date formatBirth = sdf.parse(birth);
				//今日から誕生日を計算してデータベースにセット
				int resultDate = calcAge(formatBirth,now);
				String age = String.valueOf(resultDate);
				emp.setBirthday(age);

			}
		} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	public static int calcAge(Date birthday, Date now) {
		//年齢の計算　今日から誕生日を引く
	    DateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	    return (Integer.parseInt(sdf.format(now)) - Integer.parseInt(sdf.format(birthday))) / 10000;
	}
}


