package com.example.viikko11;

public class Item implements Comparable<Item>{
    private String itemName;
    private int id;

    public Item(String name, int id) {
        this.itemName = name;
        this.id = id;
    }

    public String getName() {
        return itemName;
    }

    public void setName(String name){
        this.itemName = name;
    }

    public int getId(){
        return id;
    }

    @Override
    public int compareTo(Item otherItem) {
        return this.itemName.compareTo(otherItem.getName());
    }
}
