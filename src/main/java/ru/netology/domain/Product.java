package ru.netology.domain;

import lombok.Data;

@Data

public class Product {
    protected int id;
    protected String name;

    private int price;
}