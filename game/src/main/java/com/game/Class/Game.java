package com.game.Class;
import java.util.*;
public class Game {
    private Room currentRoom;
    private Player player;
    private Monster monster;

    public Game() {
        player = new Player("Hero");
        monster = new Monster("dragon", 100);
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

        Monster goblin = new Monster("goblin", 50);
        Monster dragon = new Monster("dragon", 100);

        room1.addMonster(dragon);
        room2.addMonster(goblin);
        room2.addTreasure(sword);

      

   


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
    
            startfight(player, monster);

            
        }

        System.out.println(" Merci d'avoir jouer aurevoir :)" + playerName);
       

    }

    private void printWelcome() {

        System.out.println("Bienvenu dans le monde de laventure! " );
        System.out.println("taper 'help' si tu as besoin d'aide.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println(currentRoom.getMonsters());
        System.out.println(currentRoom.getTreasures());
        
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
                    goRoom(commandWords[1].toLowerCase()); 
                } else {
                    System.out.println("Direction manquante.");
                }
                break;
            case "obtenir":
                if (commandWords.length > 1) {
                    takeItem(commandWords[1].toLowerCase());
                } else {
                    System.out.println("Objet manquant.");
                }
                break;
            case "attaquer":
                if (commandWords.length > 1) {
                    // attackMonster(commandWords[1].toLowerCase()); 
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

    public void startfight(Player player, Monster monster){

        if(monster.isAlive()  ){
        System.out.println("Le combat commence !" );
        while (player.isAlive() && monster.isAlive()) {
            int randomNumP = (int)(Math.random() * 100);
            Weapon sword = new Weapon("epée", randomNumP);
            PlayerAttackStrategy playerAttack = new PlayerAttackStrategy(monster, sword);
            
            playerAttack.execute();

            int randomNumM = (int)(Math.random() * 100);
            MonstreAttaqueStrategy monsterAttack = new MonstreAttaqueStrategy(player,randomNumM);
            
            monsterAttack.execute();
                
       
        }
        System.out.println("Fin du combat.");
    }else {
        System.out.println("il n'ya pas de monstre ici");
    }
}


    // private void attackMonster(String monsterName) {
    //     for (Monster monster : currentRoom.getMonsters()) {
    //         if (monster.getName().equals(monsterName)) {
    //             Weapon weapon = new Weapon("epée", 15); 
    //             player.setActionStrategy(new PlayerAttackStrategy(monster, weapon));
    //             player.performAction();
                
    //             return;
    //         }
    //     }
    //     System.out.println("Il y'a pas de " + monsterName + " ici.");
    // }

    private void printHelp() {
        System.out.println("Command disponible:");
        System.out.println("  aller <direction> - aller a une autre piece");
        System.out.println("  obtenir <item> - obtenir un item");
        System.out.println("  attaquer <monster> - attaquer un monstre");
        System.out.println("  quitter - quitter le jeux");
    }

}