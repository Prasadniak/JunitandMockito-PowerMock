package useradmin.dao;

import useradmin.dto.User;
import useradmin.util.IdGenerator;

public class UserDAO {
	public int Create(User user) {
		int id = IdGenerator.IDgenerator();
		return id;
	}
}
