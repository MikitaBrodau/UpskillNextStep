package com.Brodau;

public class QuadraticEquation {
    public static double[] quadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new ArithmeticException("value a, can't be equal to zero");
        }

        double discriminant = Math.pow(b, 2) - (4 * a * c);

        if (discriminant > 0) {
            double firstRoot = (-b - Math.sqrt(discriminant)) / (2*a);
            double secondRoot = (-b + Math.sqrt(discriminant)) / (2*a) ;
            return new double[]{firstRoot, secondRoot};
        }
        else if (discriminant == 0) {
            double oneRoot = -b / 2 ;
            return new double[]{oneRoot};
        }
        else return new double[0];
    }
}
