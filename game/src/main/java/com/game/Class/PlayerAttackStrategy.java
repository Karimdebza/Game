package com.game.Class;

import com.game.ActionStrategy;

public class PlayerAttackStrategy implements ActionStrategy {
    
    private Monster target;
    private Weapon weapon;

    public PlayerAttackStrategy(Monster target, Weapon weapon) {
        this.target = target;
        this.weapon = weapon;
    }

    @Override
    public void execute() {
        target.takeDamage(weapon.getPower());
        System.out.println("Tu lance une attaque a " + target.getName() + " avec " + weapon.getName() + ".");
    }

}
