package com.SpringBoot.ThreeTierRuleEngine.Model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {
    private String type;
    private String value;
    private Node left;
    private Node right;      // Right child for operators (null for operands)
         // "operator" or "operand"

    // Constructor with left Node, value String, right Node, and type String
    public Node(String type,String value ,Node left,Node right) {
        this.type = type;
        this.value = value;
        this.left = left;
        this.right = right;

    }

    // Constructor for operands (conditions)
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
        this.left = null; // No left/right for operands
        this.right = null;
    }

    // Getters and Setters
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
