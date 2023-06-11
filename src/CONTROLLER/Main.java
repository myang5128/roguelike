package CONTROLLER;

import MODEL.Enemies.Enemies;
import MODEL.Enemies.Skeleton;
import MODEL.Player;
import MODEL.StartingClasses.*;
import VIEW.CharCreateText;
import VIEW.EnemyCombatText;
import VIEW.PlayerCreateText;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    static CharCreateText charGenText = new CharCreateText();
    static String playerName;
    static String playerClass;
    static DruidClass druid = new DruidClass();
    static KnightClass knight = new KnightClass();
    static MageClass mage = new MageClass();
    static PaladinClass paladin = new PaladinClass();
    static RangerClass ranger = new RangerClass();
    static RogueClass rogue = new RogueClass();
    static Player p;

    /**
     * function that asks user to click ENTER before continuing
     */
    public static void promptEnterKey(){
        charGenText.pressContinueTextDisplay();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * gets name
     * @return playerName
     */
    public static String askForName() {
        charGenText.nameTextDisplay();
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine().toUpperCase();
        return playerName;
    }

    /**
     * gets class
     * @return playerClass
     */
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
     * picks a random enemy
     * @param scale how the enemy stats should be compared to the player's level
     * @return enemy
     */
    public static Enemies enemyPicker(int scale) {
        Skeleton skelly = new Skeleton(scale);
        Enemies[] enemyArray = {skelly};

        return (enemyArray[(int) (Math.random() * enemyArray.length)]);
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        Enemies e;

        // intro text
        charGenText.welcomeTextDisplay();
        promptEnterKey();
        askForName();
        askForClass();

        // generate player based on response
        switch (playerClass) {
            case "DRUID":
                p = new Player(playerName, playerClass, druid.getHealth(), druid.getMana(), druid.getDefense(), druid.getDodge(), druid.getDamage());
                break;
            case "KNIGHT":
                p = new Player(playerName, playerClass, knight.getHealth(), knight.getMana(), knight.getDefense(), knight.getDodge(), knight.getDamage());
                break;
            case "MAGE":
                p = new Player(playerName, playerClass, mage.getHealth(), mage.getMana(), mage.getDefense(), mage.getDodge(), mage.getDamage());
                break;
            case "PALADIN":
                p = new Player(playerName, playerClass, paladin.getHealth(), paladin.getMana(), paladin.getDefense(), paladin.getDodge(), paladin.getDamage());
                break;
            case "RANGER":
                p = new Player(playerName, playerClass, ranger.getHealth(), ranger.getMana(), ranger.getDefense(), ranger.getDodge(), ranger.getDamage());
                break;
            default:
                p = new Player(playerName, playerClass, rogue.getHealth(), rogue.getMana(), rogue.getDefense(), rogue.getDodge(), rogue.getDamage());
        }

        // post player-gen text
        PlayerCreateText playerGenText = new PlayerCreateText(playerName, playerClass);
        playerGenText.playerConfirmTextDisplay();
        promptEnterKey();
        p.setExpReq(p.getLevel());
        playerGenText = new PlayerCreateText(p.getName(), p.getCurHealth(), p.getMaxHealth(), p.getCurMana(), p.getMaxMana(), p.getDefense(), p.getDodge(), p.getDamage(), p.getCurExp(), p.getExpReq(), p.getGold(), p.getLevel());
        playerGenText.playerStatTextDisplay();
        promptEnterKey();

        // pre-combat
        e = enemyPicker(p.getScale());
        EnemyCombatText enemyText = new EnemyCombatText(e.getName());
        enemyText.enemyStartTextDisplay();
        promptEnterKey();

    }
}