package com.game.Class;

public class Weapon extends Treasure {
    
    private int power ;

    public Weapon(String name,int power){
        super(name);
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
