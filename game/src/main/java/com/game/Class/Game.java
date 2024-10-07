package com.game.Class;
import java.util.*;
public class Game {
    private Room currentRoom;
    private Player player;

    public Game() {
        player = new Player("Hero");
        createRooms();
    }
    private void createRooms(){

        Room entrance = new Room("Entrée");
        Room room1 = new Room("Dans la piece numero 1");
        Room room2 = new Room("Dans la piece numero 2");

        entrance.addExit("nord", room1);
        room1.addExit("sud", entrance);
        room1.addExit("east", room2);

        Weapon sword = new Weapon("epée", 15);
        room1.addTreasure(sword);

        Monster goblin = new Monster("Goblin", 50);

        room2.addMonster(goblin);

        currentRoom = entrance;

    }

    public void play(){
        Scanner scanner = new Scanner(System.in);
        boolean finished = false;

        printWelcome();

        System.out.print("Entrer votre nom: ");
        String playerName = scanner.nextLine();
        player = new Player(playerName); 

        while (!finished) {
            System.out.print("> ");
            String command = scanner.nextLine();
            finished = processCommand(command);
        }

        System.out.println(" Merci d'avoir jouer aurevoir :)");
       

    }

    private void printWelcome() {

        System.out.println("Bienvenu dans le monde de laventure! " );
        System.out.println("taper 'help' si tu as besoin d'aide.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        
    }

    private boolean processCommand(String commandLine){
        String[] commandWords = commandLine.split(" ");

        if (commandWords.length == 0) {
            System.out.println("Command inconnue.");
            return false;

        }

        String command = commandWords[0].toLowerCase();
        switch (command) {
            case "aller":
                if (commandWords.length > 1) {
                    goRoom(commandWords[1].toLowerCase()); // Direction en minuscule
                } else {
                    System.out.println("Direction manquante.");
                }
                break;
            case "obtenir":
                if (commandWords.length > 1) {
                    takeItem(commandWords[1].toLowerCase()); // Objet en minuscule
                } else {
                    System.out.println("Objet manquant.");
                }
                break;
            case "attaquer":
                if (commandWords.length > 1) {
                    attackMonster(commandWords[1].toLowerCase()); // Monstre en minuscule
                } else {
                    System.out.println("Monstre manquant.");
                }
                break;
            case "quitter":
                return true;
            case "help":
                printHelp();
                break;
            default:
                System.out.println("Command inconnue.");
        }
        return false;
    }

    private void goRoom(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if(nextRoom != null){
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        } else {
            System.out.println("Il n'y a pas de porte dans cette direction!");
        }

    }

    private void takeItem(String itemName) {
        for (Treasure treasure : currentRoom.getTreasures()) {
            if (treasure.getName().equals(itemName)) {
                player.takeTreasure(treasure);
                return;
            }
        }
        System.out.println("Il y'a pas de " + itemName + " ici.");
    }   


    private void attackMonster(String monsterName) {
        for (Monster monster : currentRoom.getMonsters()) {
            if (monster.getName().equals(monsterName)) {
                Weapon weapon = new Weapon("epée", 15); 
                player.setActionStrategy(new PlayerAttackStrategy(monster, weapon));
                player.performAction();
                return;
            }
        }
        System.out.println("Il y'a pas de " + monsterName + " ici.");
    }

    private void printHelp() {
        System.out.println("Command disponible:");
        System.out.println("  aller <direction> - aller a une autre piece");
        System.out.println("  obtenir <item> - obtenir un item");
        System.out.println("  attaquer <monster> - attaquer un monstre");
        System.out.println("  quitter - quitter le jeux");
    }

}