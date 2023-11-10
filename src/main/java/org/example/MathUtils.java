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

    public MathUtils() {

    }

    //Addition method for integers "a" and "b"
    public int add(int a, int b) {
        return a + b;
    }

    //Compare method that integer "a" is larger that integer "b"
    public boolean bigger() {
        return a > b;
    }

    //Floating point division method
    public float divide() {
        return c/d;
    }

    //Method of multiplying floating point numbers
    public float multiplying(float c, float d) {
        return c*d;
    }

    //Method for squaring a number
    public int squaring(){
        return a*a;
    }
}
