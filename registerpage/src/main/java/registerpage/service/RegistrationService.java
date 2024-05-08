package registerpage.service;

import java.util.List;

import registerpage.dto.UserRegistrationDTO;

public interface RegistrationService {
	
	
	public int saveRegistration (UserRegistrationDTO urt);
	public int editRegistration (long rid);
	public int deleteRegistration(long rid);
	
	public List<UserRegistrationDTO> getAllRegistration();
	public UserRegistrationDTO getRegistration(long rid);
}
