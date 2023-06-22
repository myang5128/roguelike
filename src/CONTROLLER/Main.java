package CONTROLLER;

import MODEL.Enemies.*;
import MODEL.Player;
import MODEL.StartingClasses.*;
import VIEW.CharCreateText;
import VIEW.CombatText;
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
        BatSwarm batty = new BatSwarm(scale);
        FallenKnight fKnight = new FallenKnight(scale);
        FallenMage fMage = new FallenMage(scale);
        GiantFrog froggy = new GiantFrog(scale);
        Goblin gobby = new Goblin(scale);
        GooSlime gooey = new GooSlime(scale);
        Orc orc = new Orc(scale);
        Skeleton skelly = new Skeleton(scale);
        Zombie zombie = new Zombie(scale);
        Enemies[] enemyArray = {skelly, batty, fKnight, fMage, froggy, gobby, gooey, orc, zombie};

        return (enemyArray[(int) (Math.random() * enemyArray.length)]);
    }

    /**
     * simulates combat until either party dies
     * @param p player
     * @param e enemy
     * @return 0 if enemy wins, 1 if player wins, 2 for flee
     */
    public static int combat(Player p, Enemies e) {
        EnemyCombatText combat = new EnemyCombatText(e.getName(), e.getCurHealth(), e.getMaxHealth(), e.getDefense(), e.getDodge(), e.getDamage());

        // shows enemy stats
        combat.enemyStatTextDisplay();
        promptEnterKey();

        // shows player stats
        PlayerCreateText playerGenText = new PlayerCreateText(p.getName(), p.getCurHealth(), p.getMaxHealth(), p.getCurMana(), p.getMaxMana(), p.getDefense(), p.getDodge(), p.getDamage(), p.getCurExp(), p.getExpReq(), p.getGold(), p.getLevel());
        playerGenText.playerStatTextDisplay();
        promptEnterKey();

        CombatText combatText = new CombatText();

        // starts player turn
        combatText.combatMoveTextDisplay();
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine().toUpperCase();
        while ( (!move.equals("LIGHT")) && (!move.equals("HEAVY")) && (!move.equals("FLEE")) ) {
            combatText.moveInvalidTextDisplay();
            move = scanner.nextLine().toUpperCase();
        }

        // light attack
        if (move.equals("LIGHT")) {
            int value = p.lightAttack(e.getDodge());
            // miss
            if (value == 0) {

            }
            // hit
            else {

            }
        }

        // heavy attack
        else if (move.equals("HEAVY")) {
            int value = p.heavyAttack(e.getDodge());
            // miss
            if (value == 0) {

            }
            // hit
            else {

            }
        }

        // flee
        else {
            int flee = p.flee();
            if (flee == 1) {
                return 2;
            }
        }

        return -1;
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

        // combat
        int result = combat(p, e);
        if (result == 0) {
            enemyText.enemyLoseTextDisplay();
        }
        else if (result == 1) {
            EnemyCombatText winner = new EnemyCombatText(e.getName(), e.getExp(), e.getGold());
            winner.enemyWinTextDisplay();
        }

    }
}