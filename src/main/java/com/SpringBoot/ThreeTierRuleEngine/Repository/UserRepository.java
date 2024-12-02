package com.SpringBoot.ThreeTierRuleEngine.Repository;


import com.SpringBoot.ThreeTierRuleEngine.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}