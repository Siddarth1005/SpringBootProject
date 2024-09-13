package com.example.jpa.hibernateandjpa;

import com.example.jpa.hibernateandjpa.entities.Users;
import com.example.jpa.hibernateandjpa.service.impl.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaAndHibernateApplication {


	public static void main(String[] args) {
		SpringApplication.run(JpaAndHibernateApplication.class, args);
	}

//	Creating Users
	public void createUser( UserService userinterface){
		Users newUser = new Users();
		newUser.createUser("siddarth1099", "sid123", "Siddarth", "M", "sid@gmail.com");
		userinterface.saveUserRecord(newUser);
		System.out.println("The user " + newUser.getfirstName() + " has been successfully created");
	}

	public void createMultipleUSers(UserService userinterface){
		Users newUser1 = new Users();
		newUser1.createUser("preethi1099", "preethi123", "Preethi", "K", "preethi@gmail.com");
		userinterface.saveUserRecord(newUser1);

		Users newUser2 = new Users();
		newUser2.createUser("harun1099", "harun123", "Harun", "L", "harun@gmail.com");
		userinterface.saveUserRecord(newUser2);

		Users newUser3 = new Users();
		newUser3.createUser("akshat1099", "akshat123", "Akshat", "P", "akshat@gmail.com");
		userinterface.saveUserRecord(newUser3);
	}

//	Reading User Data
	public void findUserById(UserService userinterface, Integer id){
		Users userData = userinterface.fetchUserData(id);
		System.out.println(userData.getfirstName() + " " + userData.getlastName() + " " + userData.getEmail());
	}

	public void findAllUsers(UserService user){
		List<Users> allUserData = user.fetchAllUsersData();
		for(int i = 0; i < allUserData.size(); i++){
			System.out.println(allUserData.get(i).getfirstName());
		}
	}
//	Updating User Data
	public void updateUserPassword(UserService userServiceDAO, Users userdata){
		userServiceDAO.updateUserData(userdata);
	}
	public void updateUsername(UserService userServiceDAO, String newUsername, String currentUserName){
		userServiceDAO.updateUserName(newUsername, currentUserName);
	}

//	Deleting UserData

	public void deleteUser(UserService userServiceDAO, String userName){
		userServiceDAO.deleteUser(userName);
	}

}
