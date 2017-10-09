package domain.db;

import java.util.List;

import domain.model.User;
import java.util.Map;

public interface UserRepository {

	public User getUser(String userId);

	public Map<String,User> getAllUsers();

	public void addUser(User user);

	public void updateUser(User user);

	public void deleteUser(String userId);
        
        public void open();
        
        public void close();

}