package com.game.Class;

import java.util.ArrayList;
import java.util.List;

import com.game.ActionStrategy;;


public class Player  {
        private String name;
    private List<Treasure> bag;
    private int health;
    private ActionStrategy actionStrategy;

    public Player(String name) {
        this.name = name;
        this.bag = new ArrayList<>();
        this.health = 100; 
    }

    

    public void setActionStrategy(ActionStrategy actionStrategy) {
        this.actionStrategy = actionStrategy;
    }
    

    public boolean isAlive(){
        return health > 0;
    }

    public void performAction() {
        if (actionStrategy != null) {
            actionStrategy.execute();
        } else {
            System.out.println("Pas d'action asigné.");
        }
    }

    public void takeTreasure(Treasure treasure){
        bag.add(treasure);
        if(treasure != null){
            System.out.println("You have taken the " + treasure.getName() + ".");
        }
    }

    public void showItems(){
        System.out.println(" Vous avez les articles suivants dans votre sac :");
        for(Treasure item : bag){
            System.out.println(item.getName());
        }
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            System.out.println(name + "  été vaincu!");
        } else {
            System.out.println(name + " à " + health + " de point de vie restant.");
        }
    }

    public String getName() {
        return name;
    }


    public void lunchAttack(Monster target){

        
    }

}
