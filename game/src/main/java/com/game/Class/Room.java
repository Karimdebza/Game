package com.game.Class;
import java.util.*;
public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private List<Treasure> treasures;
    private List<Monster> monsters;
    private Monster monster;


    Room(String description){
        this.description = description;
        this.exits = new HashMap<>();
        this.treasures = new ArrayList<>();
        this.monsters = new ArrayList<>();
    }

    public void addExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public String getLongDescription() {
        return "Tu es " + description + ".\n" + getExitString() 
        
        + " " + "les Monstres disponibles dans la piece: " + getMonsters() +   " " + "Les tresors disponibles dans la piece" +  getTreasures();
    }

    public String getExitString() {
        return "Sortie: " + String.join(", ", exits.keySet());
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public boolean hasMonster() {
        return monster != null;
    }
    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public Monster getMonster() {
        return monster;
    }
}
