package com.game.Class;
import java.util.*;
public class Room {

    private String description;
    private HashMap<String, Room> exits;
    private List<Treasure> treasures;
    private List<Monster> monsters;


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
        return "Tu es " + description + ".\n" + getExitString();
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

    public List<Monster> getMonsters() {
        return monsters;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

}
