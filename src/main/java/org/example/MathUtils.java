package org.example;

public class MathUtils {
    int a;
    int b;
    float c;
    float d;

    public MathUtils(int a, int b) {
        this.a = a;
        this.b = b;

    }
    public MathUtils (float c, float d) {
        this.c = c;
        this.d = d;
    }

    //Addition method for integers "a" and "b"
    public int add() {
        return a + b;
    }

    //Compare method that integer "a" is larger that integer "b"
    public boolean bigger() {
        return a > b;
    }

    //Floating point division method
    public float divide() {
        return (float) c/d;
    }

    //Method of multiplying floating point numbers
    public float multiplying() {
        return (float) c*d;
    }

    //Method for squaring a number
    public int squaring(){
        return a*a;
    }
}