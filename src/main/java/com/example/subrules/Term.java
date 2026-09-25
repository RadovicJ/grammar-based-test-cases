package com.example.subrules;

import com.example.client.EvalInterface;
import com.example.generators.IdGenerator;
import com.example.generators.IntegerGenerator;

import java.util.Random;

public class Term implements EvalInterface {

    static final Random RNG = new Random();

    @Override
    public String eval() {
        switch (RNG.nextInt(3)) {
            case 0: return new IdGenerator().eval();
            case 1: return new IntegerGenerator().eval();
            default: return new ParenExpr(RNG.nextInt(4)).eval();
        }
    }
}
