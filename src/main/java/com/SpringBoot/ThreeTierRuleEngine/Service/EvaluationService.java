package com.SpringBoot.ThreeTierRuleEngine.Service;

import com.SpringBoot.ThreeTierRuleEngine.Model.Node;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EvaluationService {

    // Method to evaluate an AST rule based on the user data
    public boolean evaluate(Map<String, Object> userData) {
        // Assuming rootNode is the root of your AST, typically provided as a parameter or retrieved
        Node rootNode = getRootNode();  // Placeholder
        return evaluateNode(rootNode, userData);
    }

    private boolean evaluateNode(Node node, Map<String, Object> userData) {
        if (node == null) {
            return false;
        }

        switch (node.getType()) {
            case "operator":
                boolean left = evaluateNode(node.getLeft(), userData);
                boolean right = evaluateNode(node.getRight(), userData);
                if ("AND".equals(node.getValue())) {
                    return left && right;
                } else if ("OR".equals(node.getValue())) {
                    return left || right;
                }
                break;
            case "operand":
                return evaluateCondition(node, userData);
        }
        return false;
    }

    private boolean evaluateCondition(Node node, Map<String, Object> userData) {
        String condition = node.getValue();
        // Implement the logic to evaluate each condition based on userData
        // Example: "age > 30" can be parsed and evaluated
        return true; // placeholder
    }

    private Node getRootNode() {
        // Get root node from database or previous steps
        return new Node("AND", null, null, null); // placeholder
    }
}
