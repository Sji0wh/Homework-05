package org.example;

public class MathUtils {
    int a;
    int b;

    public MathUtils(int a, int b) {
        this.a = a;
        this.b = b;
    }

    //Addition method for integers "a" and "b"
    public int add() {
        return a + b;
    }

    //Compare method that integer "a" is larger that integer "b"
    public boolean bigger() {
        return a > b;
    }
}
