package com.Brodau;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */

public class QuadraticEquationTest
{
    @Test
    public void TwoRootsQuadraticEquation(){
        assertArrayEquals(new double[]{-5,-1}, QuadraticEquation.quadraticEquation(1,6,5), 0 );
    }
    @Test
    public void OneRealRootQuadraticEquation(){
        assertArrayEquals(new double[]{0}, QuadraticEquation.quadraticEquation(1,0,0), 0);

    }
    @Test (expected = ArithmeticException.class)
    public void NoSolutionQuadraticEquation() {
        assertArrayEquals(new double[]{}, QuadraticEquation.quadraticEquation(0,1,1), 0);
    }
}

