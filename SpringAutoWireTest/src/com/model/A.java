package com.model;

public class A {
    B b;

    // Constructor must be public
    public A() {
        System.out.println("A is created");
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    // Make print() public so it can be accessed across packages/Spring proxies
    public void print() {
        System.out.println("Hello a");
    }

    public void display() {
        print();
        b.print();
    }
}
