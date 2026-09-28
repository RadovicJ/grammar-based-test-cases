package com.example.client;

import java.util.ArrayList;

public class References {

    private ArrayList<Integer> expr_reference = null;
    private ArrayList<Integer> paren_expr_reference = null;

    public ArrayList<Integer> getExpr_reference() {
        return expr_reference;
    }

    public void setExpr_reference(ArrayList<Integer> expr_reference) {
        this.expr_reference = expr_reference;
    }

    public ArrayList<Integer> getParen_expr_reference() {
        return paren_expr_reference;
    }

    public void setParen_expr_reference(ArrayList<Integer> paren_expr_reference) {
        this.paren_expr_reference = paren_expr_reference;
    }
}
