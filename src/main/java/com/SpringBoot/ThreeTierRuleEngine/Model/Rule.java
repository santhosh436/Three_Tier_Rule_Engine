package com.SpringBoot.ThreeTierRuleEngine.Model;
import jakarta.persistence.*;


@Entity
@Table(name = "rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_string", nullable = false)
    private String ruleString;

    public Rule(String ruleString) {
        this.ruleString = ruleString;
    }

    public Rule() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }
}
