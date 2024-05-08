package login.service;

import registerpage.dto.UserRegistrationDTO;

public interface LoginService {

	public boolean validate(UserRegistrationDTO urd);
}
