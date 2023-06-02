package CONTROLLER;

import MODEL.Player;
import MODEL.StartingClasses.*;
import VIEW.CharCreateText;
import VIEW.PlayerCreateText;

import java.util.Scanner;

public class Main {
    static CharCreateText charGenText = new CharCreateText();
    static Player p;
    static String playerName;
    static String playerClass;
    static DruidClass druid = new DruidClass();
    static KnightClass knight = new KnightClass();
    static MageClass mage = new MageClass();
    static PaladinClass paladin = new PaladinClass();
    static RangerClass ranger = new RangerClass();
    static RogueClass rogue = new RogueClass();

    /**
     * function that asks user to click ENTER before continuing
     */
    public static void promptEnterKey(){
        charGenText.pressContinueTextDisplay();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static String askForName() {
        charGenText.nameTextDisplay();
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine().toUpperCase();
        return playerName;
    }

    public static String askForClass() {
        charGenText.classTextDisplay();
        Scanner scanner = new Scanner(System.in);
        playerClass = scanner.nextLine().toUpperCase();
        while (!playerClass.equals("DRUID") && (!playerClass.equals("KNIGHT")) && (!playerClass.equals("MAGE")) && (!playerClass.equals("PALADIN")) &&
                (!playerClass.equals("RANGER")) && (!playerClass.equals("ROGUE")) ) {
            charGenText.classAgainTextDisplay();
            playerClass = scanner.nextLine().toUpperCase();
        }
        return playerClass;
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        // intro text
        charGenText.welcomeTextDisplay();
        promptEnterKey();
        askForName();
        askForClass();

        // generate player based on response
        switch (playerClass) {
            case "DRUID":
                p = new Player(playerName, playerClass, druid.getHealth(), druid.getDefense(), druid.getDodge(), druid.getDamage());
            case "KNIGHT":
                p = new Player(playerName, playerClass, knight.getHealth(), knight.getDefense(), knight.getDodge(), knight.getDamage());
            case "MAGE":
                p = new Player(playerName, playerClass, mage.getHealth(), mage.getDefense(), mage.getDodge(), mage.getDamage());
            case "PALADIN":
                p = new Player(playerName, playerClass, paladin.getHealth(), paladin.getDefense(), paladin.getDodge(), paladin.getDamage());
            case "RANGER":
                p = new Player(playerName, playerClass, ranger.getHealth(), ranger.getDefense(), ranger.getDodge(), ranger.getDamage());
            default:
                p = new Player(playerName, playerClass, rogue.getHealth(), rogue.getDefense(), rogue.getDodge(), rogue.getDamage());
        }
        PlayerCreateText playerGenText = new PlayerCreateText(playerName, playerClass);
        playerGenText.playerConfirmeTextDisplay();
        promptEnterKey();
    }
}