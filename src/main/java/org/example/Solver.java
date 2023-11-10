package org.example;

public class Solver {
    int a;
    int b;
    int c;

    public Solver(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int solveQuadraticEquation () {
        int discriminant = b * b - 4 * a * c;
        if (discriminant < 0) {
            return 0;
        } else if (discriminant == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
