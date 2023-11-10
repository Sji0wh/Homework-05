package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolverTest {

    //Discriminant is lesser than zero
    @Test
    public void lesserThanZero () {
        Solver lesserThanZero = new Solver(1,4,5);
        int equationResult = lesserThanZero.solveQuadraticEquation();
        Assertions.assertEquals(0, equationResult);
    }

    //Discriminant is equals zero
    @Test
    public void equalsZero () {
        Solver lesserThanZero = new Solver(1,-4,4);
        int equationResult = lesserThanZero.solveQuadraticEquation();
        Assertions.assertEquals(1, equationResult);
    }

    //Discriminant is larger than zero
    @Test
    public void largerThanZero () {
        Solver largerThanZero = new Solver(1,-5,6);
        int equationResult = largerThanZero.solveQuadraticEquation();
        Assertions.assertEquals(2, equationResult);
}
}

