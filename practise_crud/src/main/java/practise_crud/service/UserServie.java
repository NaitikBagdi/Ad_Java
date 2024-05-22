package practise_crud.service;

import java.util.List;

import practise_crud.model.User;

public interface UserServie {

	public void saveUser(User user);

	public List<User> getList();

}