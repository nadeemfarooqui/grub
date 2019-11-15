package com.company;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.

 The goal of this interview is to take some finite amount of USD currency and dispense it into regular USD physical currency units. Namely in the form of bills and coins. These are the coins and bills that you must support and their colloquial name:

Penny    → $   0.01
Nickel   → $   0.05
Dime     → $   0.10
Quarter  → $   0.25
Dollar   → $   1.00
Five     → $   5.00
Ten      → $  10.00
Twenty   → $  20.00
Hundred  → $ 100.00
1. Implement a solution!
You are responsible for defining a data structure for your return

 Input: 137.57

 Output:
 1 hundred
 1 twenty
 1 ten
 1 five
 2 dollar
 2 quarters
 1 nickle
 2 pennies

 */

import java.util.stream.Stream;

public class Main {

    static class Amount {
        int amount;

        public Amount(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    enum Denominations {
        HUNDRED("Hundred",100.00),
        FIFTY("Fifty",50.00),
        TWENTY("Twenty",20.00),
        TEN("Ten",10.00),
        FIVE("Five",5.00),
        DOLLAR("Dollar",1.00),
        QUARTER("Quarter",0.25),
        DIME("Dime",0.10),
        NICKEL("Nickel",0.05),
        PENNY("Penny",0.01);

        String name;
        double value;
        int multiplier;

        Denominations(String name, double value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public double getValue() {
            return value;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        calucluate(137.57);
    }

    public static void calucluate(double amount) {

        if (amount == 0) {
            System.out.println("No Change for zero amount");
        }
        amount *= 100;
        System.out.println(amount);
        Amount amountObject = new Amount((int) amount);
        System.out.println();
        Stream.of(Denominations.values()).forEach(e -> {
            int quantity = (int) (amountObject.getAmount() / (e.getValue()*100));
            if (quantity > 0) {
                int currentAmount = amountObject.getAmount();
                currentAmount -= (quantity * e.getValue()*100);
                amountObject.setAmount(currentAmount);
                System.out.println(e.getName() + " " + quantity);
            }
        });
    }
}
