package com.SpringBoot.ThreeTierRuleEngine.Repository;

import com.SpringBoot.ThreeTierRuleEngine.Model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}