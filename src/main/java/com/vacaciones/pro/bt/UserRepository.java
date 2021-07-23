package com.vacaciones.pro.bt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.pro.dl.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByUserNameAndUserPass(String userName, String password);

}
