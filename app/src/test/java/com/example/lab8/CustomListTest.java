package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity(){
        list = MockCityList();
        City city = new City("Calgary", "Alberta");
        Assertions.assertFalse(list.hasCity(city));
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
    }
    @Test
    public void testDelete(){
        list = MockCityList();
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        Assertions.assertTrue(list.hasCity(city));
        list.delete(city);
        Assertions.assertFalse(list.hasCity(city));
    }

    @Test
    public void testCountCities(){
        list = MockCityList();
        assertEquals(0, list.countCities());
        City city = new City("Calgary", "Alberta");
        City city2 = new City("Victoria", "British Columbia");
        list.addCity(city);
        list.addCity(city2);
        assertEquals(2, list.countCities());
        list.delete(city);
        assertEquals(1, list.countCities());
    }


}
