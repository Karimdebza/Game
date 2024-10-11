package com.game.Class;

import com.game.ActionStrategy;

public class PlayerAttackStrategy implements ActionStrategy {
    
    private Monster target;
    private Weapon weapon;
    private int damage;

    public PlayerAttackStrategy(Monster target, Weapon weapon, int damage) {
        this.target = target;
        this.weapon = weapon;
        this.damage = damage;
    }

    @Override
    public void execute() {
       
        System.out.println("Tu lance une attaque a " + target.getName() + " avec " + weapon.getName() + " et il lui fais subir " + damage + "de dégâts" );
        target.takeDamage(damage);
    }

}
