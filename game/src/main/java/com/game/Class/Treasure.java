package com.game.Class;

public class Treasure {
    private String name;

    Treasure(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return getName();
    }
}
