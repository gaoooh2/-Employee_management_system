package model;

import java.util.List;

public class LoginLogic {
	public boolean execute(User user) {
		Dao dao = new Dao();
		List<AddEmp> list = dao.find();
		for(int i = 0;i < list.size();i++) {
			if(user.getName().equals(list.get(i).getCreated_id()) && user.getPass().equals(list.get(i).getPassword())) {
				return true;
			}
		}
		return false;
	}
}
