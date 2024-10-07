package com.game.Class;

import com.game.ActionStrategy;

public class MonstreAttaqueStrategy implements ActionStrategy {
    
    private Player player;
    private int damage;

    public MonstreAttaqueStrategy(Player player, int damage) {
        this.player = player;
        this.damage = damage;
    }

    @Override
    public void execute() {
        player.takeDamage(damage);
        System.out.println("le monstre attaque " + player.getName() + " et lui fais perdre  " + damage + "de dommage ");
    }
    
}
