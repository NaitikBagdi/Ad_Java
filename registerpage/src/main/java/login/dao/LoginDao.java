package login.dao;

import registerpage.dto.UserRegistrationDTO;

public interface LoginDao {

	public boolean validate(UserRegistrationDTO urd);
}
