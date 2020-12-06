package com.project.broker.repository;

import org.springframework.stereotype.Repository;
import com.project.broker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
	public User findByUserNameAndPassWord(String username,String password);

}
