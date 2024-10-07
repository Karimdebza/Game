package com.game.Class;

import com.game.ActionStrategy;

public class Monster {

    private String name;
    private int health;
    private ActionStrategy actionStrategy;
  

    public Monster(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }

    public void performAction() {
        if (actionStrategy != null) {
            actionStrategy.execute();
        } else {
            System.out.println(name + " pas d'action asignée.");
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " a été vaincu!");
        } else {
            System.out.println(name + " a " + health + " point de vie restant.");
        }
    }

    public String getName() {
        return name;
    }


    public boolean isAlive(){
        return health > 0;
    }
}
