package com.SpringBoot.ThreeTierRuleEngine.Controller;

import com.SpringBoot.ThreeTierRuleEngine.DTO.CombineRuleRequest;
import com.SpringBoot.ThreeTierRuleEngine.DTO.RuleRequest;
import com.SpringBoot.ThreeTierRuleEngine.Model.Node;
import com.SpringBoot.ThreeTierRuleEngine.Model.Rule;
import com.SpringBoot.ThreeTierRuleEngine.Service.EvaluationService;
import com.SpringBoot.ThreeTierRuleEngine.Service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    @Autowired
    private EvaluationService evaluationService;

    // API to create a rule from a string
    @PostMapping("/create")
    public ResponseEntity<Node> createRule(@RequestBody RuleRequest ruleRequest) {
        if (ruleRequest == null || ruleRequest.getRuleString() == null || ruleRequest.getRuleString().trim().isEmpty()) {
            return ResponseEntity.badRequest().body(null); // Return 400 Bad Request if ruleString is missing
        }

        Node ruleAst = ruleService.createRule(ruleRequest.getRuleString());
        return ResponseEntity.ok(ruleAst);
    }


    // API to combine multiple rules
    @PostMapping("/combine")
    public ResponseEntity<Node> combineRules(@RequestBody CombineRuleRequest request) {
        Node combined = ruleService.combineRules(request.getRuleStrings());
        return ResponseEntity.ok(combined);
    }

    // API to evaluate a rule against user data
    @PostMapping("/evaluate")
    public boolean evaluateRule(@RequestBody Map<String, Object> userData) {
        return evaluationService.evaluate(userData);
    }
}