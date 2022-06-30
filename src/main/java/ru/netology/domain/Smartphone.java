package ru.netology.domain;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone (int smartphoneId,String smartphoneName, String smartphoneManufacturer){
        super.id= smartphoneId;
        super.name = smartphoneName;
        this.manufacturer = smartphoneManufacturer;
    }
}