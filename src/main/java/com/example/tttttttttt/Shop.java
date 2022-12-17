package com.example.tttttttttt;

import java.util.Comparator;

public class Shop {

    private String name;
    private String data;
    private int number;
    private Double prise;



    public Shop() {
    }

    public Shop(String name, String data, int number, double prise) {
        this.name = name;
        this.data = data;
        this.number = number;
        this.prise = prise;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public int getNumber() {
        return number;
    }

    public double getPrise() {
        return prise;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    @Override
    public String toString() {
        return
                "{name='" + name + '\'' +
                ", data='" + data + '\'' +
                ", number=" + number +
                ", prise=" + prise +"}";
    }

    static class ShopComparatorName implements Comparator<Shop> {

        public int compare(Shop b1, Shop b2) {

            return b1.name.compareTo(b2.name);
        }

    }
    static class ShopComparatorPrise implements Comparator<Shop> {

        public int compare(Shop s1, Shop s2) {

            return s1.prise.compareTo(s2.prise);
        }
    }
}