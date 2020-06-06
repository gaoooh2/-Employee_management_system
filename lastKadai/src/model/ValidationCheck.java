package model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class ValidationCheck {
	//nullチェックメソッド
	public boolean executeNull(String nullCheck) {
		if(nullCheck != null && !(nullCheck.isEmpty())){
			return true;
		}
		return false;
	}
	//文字数チェックメソッド
	public boolean executeLength(String lengthCheck,int num) {
		if(lengthCheck == null || lengthCheck.isEmpty() || lengthCheck.length() <= num ){
			return true;
		}
		return false;
	}
	//全角チェックメソッド
	public boolean executeParam(String param) {
		try {
			if (param == null || param.isEmpty() || param.getBytes("UTF-8").length == param.length() * 3) {
				return true;
			} else {
				return false;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
	// yyyy/MM/ddチェックメソッド
	public boolean executeDate(String date) {
		String day = "^(\\d{4})/(\\d{2})/(\\d{2})$";
	    if(date == null || date.isEmpty() || date.matches(day)) {
	    return true;
	    } else {
	    	return false;
	    }
	}
	//半角英数字記号チェックメソッド
	public boolean executeHarf(String harf) {
		String hCheck = "^[\\p{Alnum}|\\p{Punct}]*$";
		if(harf == null || harf.isEmpty() || harf.matches(hCheck)) {
			return true;
		} else {
			return false;
		}
	}
	//数字チェックメソッド
	public boolean executeNumber(String number) {
		String NCheck = "^[0-9]+$";
		if(number == null || number.isEmpty() || number.matches(NCheck)) {
			return true;
		} else {
			return false;
		}
	}

	//バリデーションチェック判定用メソッド
	public List<Integer> executeAll(String name,String name_hiragana,String birthday,String business_manager,String hire_date,String commissioning_status,String sex,String mail_address,String telephone_number,String retire_date) {
		boolean isNullName = this.executeNull(name);
		boolean isLenName = this.executeLength(name, 20);
		boolean isParName = this.executeParam(name);
		boolean isNullNameH = this.executeNull(name_hiragana);
		boolean isLenNameH = this.executeLength(name_hiragana, 20);
		boolean isParNameH = this.executeParam(name_hiragana);
		boolean isNullBirt = this.executeNull(birthday);
		boolean isLenBirt = this.executeLength(birthday, 10);
		boolean isDatBirt = this.executeDate(birthday);
		boolean isNullMail = this.executeNull(mail_address);
		boolean isLenMail = this.executeLength(mail_address, 50);
		boolean isHarfMail = this.executeHarf(mail_address);
		boolean isNullTele = this.executeNull(telephone_number);
		boolean isLenTele = this.executeLength(telephone_number, 11);
		boolean isNumTele = this.executeNumber(telephone_number);
		boolean isNullBusi = this.executeNull(business_manager);
		boolean isLenBusi = this.executeLength(business_manager, 20);
		boolean isParBusi = this.executeParam(business_manager);
		boolean isNullHire = this.executeNull(hire_date);
		boolean isLenHire = this.executeLength(hire_date, 10);
		boolean isDatHire = this.executeDate(hire_date);
		boolean isLenReti = this.executeLength(retire_date, 10);
		boolean isDatReti = this.executeDate(retire_date);

		//バリデーションチェックfalseならflagListに数字を入れる
		boolean[] flag = {isNullName,isLenName,isParName,isNullNameH,isLenNameH,isParNameH,isNullBirt,isLenBirt,isDatBirt,isNullMail,isLenMail,isHarfMail,isNullTele,isLenTele,isNumTele,isNullBusi,isLenBusi,isParBusi,isNullHire,isLenHire,isDatHire,isLenReti,isDatReti};
		List<Integer> flagList = new ArrayList<>();
		int i = 1;
		for(boolean e : flag) {
			if(!e) {
				flagList.add(i);
			}
			i++;
		}

		return flagList;
	}
}
