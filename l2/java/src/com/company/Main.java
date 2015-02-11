package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 2;
        Employee[] a = new Employee[n];

        a[0] = new Employee();
        a[0].name = "Bjarne";
        a[0].social_number = 1234;
        a[0].age = 64;
        a[0].department = "Computer Science";
        a[0].salary = 1000000;

        a[1] = new Employee();
        a[1].name = "Frederik";
        a[1].social_number = 1234;
        a[1].age = 24;
        a[1].department = "Engineering & Design";
        a[1].salary = 0;

        for (int i = 0; i < n; ++i)
        {
            System.out.println(a[i].name + ", " + a[i].age);
        }
    }
}
