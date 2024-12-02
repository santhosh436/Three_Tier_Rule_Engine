package com.SpringBoot.ThreeTierRuleEngine.DTO;

import java.util.List;

public class CombineRuleRequest {
    private List<String> ruleStrings;

    public List<String> getRuleStrings() {
        return ruleStrings;
    }

    public void setRuleStrings(List<String> ruleStrings) {
        this.ruleStrings = ruleStrings;
    }
}