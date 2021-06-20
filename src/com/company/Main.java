package com.company;

public class Main {
    static int i = 10;
    int j = 12;
    final int k;
    static final int l;

    static {
        l = 34;
    }

    public Main (int k)
    {
//        System.out.println(this.i);
//        System.out.println(this.j);
        this.k = k;
    }
    void consume(int a)
    {
        System.out.println(a+" consumed!!");
    }

    static int consume(int a, int j)
    {
        return a + j;
    }

    public static void main (String args[])
    {
        Main main = new Main(17);
        System.out.println(i);
        System.out.println(main.i);
//        System.out.println(j);
        System.out.println(main.j);
        System.out.println(main.k);
        System.out.println(main.l);
        System.out.println(l);
        System.out.println(consume(200,4));
    }
}
