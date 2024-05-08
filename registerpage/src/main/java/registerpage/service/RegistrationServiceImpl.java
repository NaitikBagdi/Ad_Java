package registerpage.service;

import java.util.List;

import registerpage.dao.RegistrationDAO;
import registerpage.dao.RegistrationDaoImpl;
import registerpage.dto.UserRegistrationDTO;

public class RegistrationServiceImpl implements RegistrationService {

	private RegistrationDAO rd = new RegistrationDaoImpl();

	@Override
	public int saveRegistration(UserRegistrationDTO urt) {
		int recordinserted = rd.saveRegistration(urt);
		return recordinserted;
	}

	@Override
	public int editRegistration(long rid) {
		int recordedit = rd.editRegistration(rid);
		return recordedit;
	}

	@Override
	public int deleteRegistration(long rid) {
		int recordDelete = rd.deleteRegistration(rid);

		return recordDelete;
	}

	@Override
	public List<UserRegistrationDTO> getAllRegistration() {

		return rd.getAllRegistration();
	}

	@Override
	public UserRegistrationDTO getRegistration(long rid) {
		UserRegistrationDTO urd = rd.getRegistration(rid);
		return urd;
	}

}
