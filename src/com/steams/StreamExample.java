package com.steams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args){
        System.out.println("Welcome to Stream Example");

        List<Dish> dishes = Arrays.asList(new Dish("dish1",50, DishType.NONVEG),new Dish("dish1",150,DishType.VEG ),
                new Dish("dish3",75, DishType.NONVEG),new Dish("dish4",125, DishType.VEG),
                new Dish("dish4",50, DishType.VEG));


        filterAndSortConventional(dishes);
        filterAndSortStreams(dishes);
    }

    private static void filterAndSortStreams(List<Dish> dishes) {
        System.out.println("--- Filtering via streams");
        List<String> lowCaloryDishes = dishes.stream()
                .filter(dish -> dish.getColories() < 100)
                //.sorted((dish1, dish2) -> dish1.getColories().compareTo(dish2.getColories())) // using normal comparator
                //.sorted(Comparator.comparing(dish -> dish.getColories())) // sorting using collection.comparingMethod
                .sorted(Comparator.comparing(Dish::getColories))
                .map(Dish::getDishName)
                .collect(Collectors.toList());

        /*
        Map<DishType,Dish> dishesByDishTypes = dishes.stream()
                .filter(dish -> dish.getColories() < 100)
                .sorted(Comparator.comparing(Dish::getColories))
                .collect(Collectors.groupingBy(Dish::getDishType));
                //.groupingBy(Dish::getDishType)));
        System.out.println(lowCaloryDishes);
        */
    }

    private static void filterAndSortConventional(List<Dish> dishes) {
        System.out.println("--- Filtering via conventional");
        dishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getColories().compareTo(o2.getColories());
            }
        });

        List<String> lowCaloryDishes = new ArrayList<>();

        // conventional way
        for (Dish dish: dishes) {
            if (dish.getColories() < 100)
                lowCaloryDishes.add(dish.getDishName());
        }

        System.out.println(lowCaloryDishes);
    }
}
