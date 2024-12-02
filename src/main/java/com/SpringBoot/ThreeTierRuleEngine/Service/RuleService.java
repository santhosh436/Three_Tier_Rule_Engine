package com.SpringBoot.ThreeTierRuleEngine.Service;

import com.SpringBoot.ThreeTierRuleEngine.Model.Node;
import com.SpringBoot.ThreeTierRuleEngine.Model.Rule;
import com.SpringBoot.ThreeTierRuleEngine.Parser.RuleParser;
import com.SpringBoot.ThreeTierRuleEngine.Repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {
    @Autowired
    RuleRepository ruleRepository;

    private final RuleParser ruleParser = new RuleParser();

    public Node createRule(String ruleString) {
        Node ruleAst = ruleParser.parse(ruleString);

        Rule rule = new Rule();
        rule.setRuleString(ruleString);
        ruleRepository.save(rule);

        // Return the AST
        return ruleAst;
    }


    public Node combineRules(List<String> ruleStrings) {
        Node combined = null;
        for (String rule : ruleStrings) {
            Node ruleAst = ruleParser.parse(rule); // Assuming ruleParser has a parse method
            if (combined == null) {
                combined = ruleAst;
            } else {
                combined = new Node("operator", "AND", combined, ruleAst);
            }
        }
        return combined;
    }

}