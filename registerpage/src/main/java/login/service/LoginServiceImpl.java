package login.service;

import login.dao.LoginDao;
import login.dao.LoginDaoImpl;
import registerpage.dto.UserRegistrationDTO;

public class LoginServiceImpl implements LoginService {

	LoginDao ld = new LoginDaoImpl();

	@Override
	public boolean validate(UserRegistrationDTO urd) {
		boolean validate = ld.validate(urd);
		return validate;
	}

}
