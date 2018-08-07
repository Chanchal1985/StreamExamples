package com.steams;

public class Dish {

    private String dishName ;

    private Integer colories ;

    private DishType dishType ;


    public Dish(String dishName, int colories, DishType dishType) {
        this.dishName = dishName;
        this.colories = colories;
        this.dishType = dishType;
    }


    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Integer getColories() {
        return colories;
    }

    public void setColories(Integer colories) {
        this.colories = colories;
    }


    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishName='" + dishName + '\'' +
                ", colories=" + colories +
                '}';
    }

}
