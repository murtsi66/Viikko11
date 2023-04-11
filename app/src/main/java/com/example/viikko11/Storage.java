package com.example.viikko11;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Item> items = new ArrayList<>();
    private static Storage storage = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if(storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

}