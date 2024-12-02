package com.SpringBoot.ThreeTierRuleEngine.Parser;

import com.SpringBoot.ThreeTierRuleEngine.Model.Node;

public class RuleParser {

    public Node parse(String ruleString) {
        ruleString = ruleString.trim();
        return parseExpression(ruleString);
    }

    private Node parseExpression(String expression) {
        expression = expression.trim();

        // Remove outer parentheses if they exist
        if (expression.startsWith("(") && expression.endsWith(")")) {
            expression = expression.substring(1, expression.length() - 1).trim();
        }

        // Handle "OR" last (lower precedence)
        int orIndex = findOperatorOutsideParentheses(expression, " OR ");
        if (orIndex != -1) {
            String[] parts = splitExpression(expression, orIndex, " OR ");
            return new Node("operator", "OR", parseExpression(parts[0]), parseExpression(parts[1]));
        }

        // Handle "AND" first (higher precedence)
        int andIndex = findOperatorOutsideParentheses(expression, " AND ");
        if (andIndex != -1) {
            String[] parts = splitExpression(expression, andIndex, " AND ");
            return new Node("operator", "AND", parseExpression(parts[0]), parseExpression(parts[1]));
        }

        // If no operator, return it as an operand
        return new Node("operand", expression.trim());
    }

    private String[] splitExpression(String expression, int index, String operator) {
        return new String[] {
                expression.substring(0, index).trim(),
                expression.substring(index + operator.length()).trim()
        };
    }

    private int findOperatorOutsideParentheses(String expression, String operator) {
        int parenthesesCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '(') {
                parenthesesCount++;
            } else if (currentChar == ')') {
                parenthesesCount--;
            }
            // Only return index if outside all parentheses
            if (parenthesesCount == 0 && expression.startsWith(operator, i)) {
                return i;
            }
        }
        return -1;
    }
}
