package CONTROLLER;

import MODEL.Enemies.*;
import MODEL.Player;
import MODEL.Spells.Offensive.Druid.*;
import MODEL.Spells.Offensive.OffensiveSpells;
import MODEL.StartingClasses.*;
import VIEW.*;

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
    public static void promptEnterKey() {
        charGenText.pressContinueTextDisplay();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    /**
     * gets name
     *
     * @return playerName
     */
    public static String askForName() {
        charGenText.nameTextDisplay();
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().toUpperCase();
        playerName = scanner.nextLine().toUpperCase();
        return playerName;
    }

    /**
     * gets class
     *
     * @return playerClass
     */
    public static String askForClass() {
        charGenText.classTextDisplay();
        Scanner scanner = new Scanner(System.in);
        playerClass = scanner.nextLine().toUpperCase();
        while (!playerClass.equals("DRUID") && (!playerClass.equals("KNIGHT")) && (!playerClass.equals("MAGE")) && (!playerClass.equals("PALADIN")) &&
                (!playerClass.equals("RANGER")) && (!playerClass.equals("ROGUE"))) {
            charGenText.classAgainTextDisplay();
            playerClass = scanner.nextLine().toUpperCase();
        }
        return playerClass;
    }

    /**
     * picks a random enemy
     *
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
     * simulates a player turn
     *
     * @param p player
     * @param e enemy
     * @return 1 if successful flee
     */
    public static int playerTurn(Player p, Enemies e) {
        CombatText combatText = new CombatText();
        combatText.combatMoveTextDisplay();
        Scanner scanner = new Scanner(System.in);
        String move = scanner.nextLine().toUpperCase();
        while ((!move.equals("LIGHT")) && (!move.equals("HEAVY")) && (!move.equals("FLEE")) && (!move.equals("SPELLS"))) {
            combatText.moveInvalidTextDisplay();
            move = scanner.nextLine().toUpperCase();
        }

        // light attack
        if (move.equals("LIGHT")) {
            int value = p.lightAttack(e.getDodge());
            // miss
            if (value == 0) {
                CombatText damageText = new CombatText(0, e.getName());
                damageText.playerMissTextDisplay();
            }
            // hit
            else {
                CombatText damageText = new CombatText(e.takeDamage(value), e.getName());
                damageText.playerLightTextDisplay();
            }
        }

        // heavy attack
        else if (move.equals("HEAVY")) {
            int value = p.heavyAttack(e.getDodge());
            // miss
            if (value == 0) {
                CombatText damageText = new CombatText(0, e.getName());
                damageText.playerMissTextDisplay();
            }
            // hit
            else {
                CombatText damageText = new CombatText(e.takeDamage(value), e.getName());
                damageText.playerHeavyTextDisplay();
            }
        }

        else if (move.equals("SPELLS")) {
            OffensiveSpells[] spellList = p.spells();
            SpellsText startSpellText = new SpellsText();
            startSpellText.startTextDisplay();
            for (int i = 0; i < spellList.length; i++) {
                SpellsText spellText = new SpellsText(spellList[i].getName(), spellList[i].getLevel(), spellList[i].getRawDamage(), spellList[i].getManaCost(), spellList[i].getDesc());
                spellText.spellTextDisplay();
            }
            startSpellText.pickTextDisplay();
            Scanner scanner1 = new Scanner(System.in);
            String spellPicker = scanner1.nextLine().toUpperCase();
            if (spellPicker.equals("BACK")) {
                playerTurn(p, e);
            }
            int spellCount = 0;

            while (!spellPicker.equals(spellList[spellCount].getName())){
                boolean found = false;
                for (int i = 0; i < spellList.length; i++) {
                    if (spellPicker.equals(spellList[i].getName())) {
                        spellCount = i;
                        found = true;
                    }
                }
                if (!found) {
                    startSpellText.pickAgainTextDisplay();
                    spellPicker = scanner1.nextLine().toUpperCase();
                }
            }

            int damage = spellList[spellCount].runSpell();
            p.setMana(spellList[spellCount].getManaCost());
            if (damage == 0) {
                SpellsText spellsDmgText = new SpellsText(spellList[spellCount].getName(), damage, spellList[spellCount].getManaCost(), e.getName());
                spellsDmgText.missTextDisplay();
            }
            else {
                SpellsText spellsDmgText = new SpellsText(spellList[spellCount].getName(), damage, spellList[spellCount].getManaCost(), e.getName());
                spellsDmgText.damageTextDisplay();
                e.takeMagicDamage(damage);
            }

        }

        // flee
        else {
            int flee = p.flee();
            if (flee == 1) {
                return 1;
            }
            CombatText fleeText = new CombatText(0, e.getName());
            fleeText.fleeFailTextDisplay();
        }
        return 0;
    }

    public static void enemyTurn(Player p, Enemies e) {
        int attackType = (int) (Math.random() * 1);

        // heavy attack
        if (attackType == 1) {
            int value = e.heavyAttack(p.getTempDodge());
            // miss
            if (value == 0) {
                CombatText damageText = new CombatText(0, e.getName());
                damageText.enemyAttackTextDisplay();
                promptEnterKey();
                damageText.enemyMissTextDisplay();
            }
            // hit
            else {
                CombatText damageText = new CombatText(p.takeDamage(value), e.getName());
                damageText.enemyAttackTextDisplay();
                promptEnterKey();
                damageText.enemyHeavyTextDisplay();
            }
        }

        // light attack
        else {
            int value = e.lightAttack(p.getTempDodge());
            // miss
            if (value == 0) {
                CombatText damageText = new CombatText(0, e.getName());
                damageText.enemyAttackTextDisplay();
                damageText.enemyMissTextDisplay();
            }
            // hit
            else {
                CombatText damageText = new CombatText(p.takeDamage(value), e.getName());
                damageText.enemyAttackTextDisplay();
                damageText.enemyLightTextDisplay();
            }
        }
    }

    /**
     * checks if enemy health is gone
     *
     * @param e enemy
     * @return true if dead, false if alive
     */
    public static boolean enemyChecker(Enemies e) {
        if (e.getCurHealth() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * checks if player health is gone
     *
     * @param p player
     * @return true if dead, false if alive
     */
    public static boolean playerChecker(Player p) {
        if (p.getCurHealth() <= 0) {
            return true;
        }
        return false;
    }

    /**
     * simulates combat until either party dies
     *
     * @param p player
     * @param e enemy
     * @return 0 if enemy wins, 1 if player wins, 2 for flee
     */
    public static int combatSim(Player p, Enemies e) {
        EnemyCombatText combat = new EnemyCombatText(e.getName(), e.getCurHealth(), e.getMaxHealth(), e.getDefense(), e.getDodge(), e.getDamage());

        // shows enemy stats
        combat.enemyStatTextDisplay();

        // shows player stats
        PlayerCreateText playerGenText = new PlayerCreateText(p.getName(), p.getDamage(), p.getCurHealth(), p.getMaxHealth(), p.getCurMana(), p.getMaxMana(), p.getDefense(), p.getDodge());
        playerGenText.playercomStatTextDisplay();

        // combat variables
        int flee = 0;
        int con = -1;

        while (con == -1) {
            // player turn
            flee = playerTurn(p, e);

            // if flee is successful, end combat
            if (flee == 1) {
                con = 2;
                break;
            }

            // checks enemy health
            if (enemyChecker(e)) {
                con = 1;
                break;
            }

            promptEnterKey();

            // enemy turn
            enemyTurn(p, e);

            // checks player health
            if (playerChecker(p)) {
                con = 0;
                break;
            }

            // show stats
            combat = new EnemyCombatText(e.getName(), e.getCurHealth(), e.getMaxHealth(), e.getDefense(), e.getDodge(), e.getDamage());
            playerGenText = new PlayerCreateText(p.getName(), p.getTempDamage(), p.getCurHealth(), p.getMaxHealth(), p.getCurMana(), p.getMaxMana(), p.getTempDefense(), p.getTempDodge());
            combat.enemyStatTextDisplay();
            playerGenText.playercomStatTextDisplay();
        }
        return con;
    }

    /**
     * main method
     *
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
                WindSlash windSlash = new WindSlash();
                FalconSwoop falconSwoop = new FalconSwoop();
                RootSnap rootSnap = new RootSnap();
                RagingBoar ragingBoar = new RagingBoar();
                ThornExplosion thornExplosion = new ThornExplosion();
                OffensiveSpells[] spellArray = new OffensiveSpells[]{windSlash, falconSwoop, rootSnap, ragingBoar, thornExplosion};
                p = new Player(playerName, druid, druid.getHealth(), druid.getMana(), druid.getDefense(), druid.getDodge(), druid.getDamage(), spellArray);
                break;
            case "KNIGHT":
                windSlash = new WindSlash();
                falconSwoop = new FalconSwoop();
                rootSnap = new RootSnap();
                ragingBoar = new RagingBoar();
                thornExplosion = new ThornExplosion();
                spellArray = new OffensiveSpells[]{windSlash, falconSwoop, rootSnap, ragingBoar, thornExplosion};
                p = new Player(playerName, knight, knight.getHealth(), knight.getMana(), knight.getDefense(), knight.getDodge(), knight.getDamage(), spellArray);
                break;
            case "MAGE":
                windSlash = new WindSlash();
                falconSwoop = new FalconSwoop();
                rootSnap = new RootSnap();
                ragingBoar = new RagingBoar();
                thornExplosion = new ThornExplosion();
                spellArray = new OffensiveSpells[]{windSlash, falconSwoop, rootSnap, ragingBoar, thornExplosion};
                p = new Player(playerName, mage, mage.getHealth(), mage.getMana(), mage.getDefense(), mage.getDodge(), mage.getDamage(), spellArray);
                break;
            case "PALADIN":
                windSlash = new WindSlash();
                falconSwoop = new FalconSwoop();
                rootSnap = new RootSnap();
                ragingBoar = new RagingBoar();
                thornExplosion = new ThornExplosion();
                spellArray = new OffensiveSpells[]{windSlash, falconSwoop, rootSnap, ragingBoar, thornExplosion};
                p = new Player(playerName, paladin, paladin.getHealth(), paladin.getMana(), paladin.getDefense(), paladin.getDodge(), paladin.getDamage(), spellArray);
                break;
            case "RANGER":
                windSlash = new WindSlash();
                falconSwoop = new FalconSwoop();
                rootSnap = new RootSnap();
                ragingBoar = new RagingBoar();
                thornExplosion = new ThornExplosion();
                spellArray = new OffensiveSpells[]{windSlash, falconSwoop, rootSnap, ragingBoar, thornExplosion};
                p = new Player(playerName, ranger, ranger.getHealth(), ranger.getMana(), ranger.getDefense(), ranger.getDodge(), ranger.getDamage(), spellArray);
                break;
            default:
                windSlash = new WindSlash();
                falconSwoop = new FalconSwoop();
                rootSnap = new RootSnap();
                ragingBoar = new RagingBoar();
                thornExplosion = new ThornExplosion();
                spellArray = new OffensiveSpells[]{windSlash, falconSwoop, rootSnap, ragingBoar, thornExplosion};
                p = new Player(playerName, rogue, rogue.getHealth(), rogue.getMana(), rogue.getDefense(), rogue.getDodge(), rogue.getDamage(), spellArray);
        }

        // post player-gen text
        PlayerCreateText playerGenText = new PlayerCreateText(playerName, playerClass);
        playerGenText.playerConfirmTextDisplay();
        promptEnterKey();
        p.setExpReq(p.getLevel());
        playerGenText = new PlayerCreateText(p.getName(), p.getCurHealth(), p.getMaxHealth(), p.getCurMana(), p.getMaxMana(), p.getDefense(), p.getDodge(), p.getDamage(), p.getCurExp(), p.getExpReq(), p.getGold(), p.getLevel());
        playerGenText.playerStatTextDisplay();
        promptEnterKey();

        // test purposes
        while (true) {

            // pre-combat
            e = enemyPicker(p.getScale());
            EnemyCombatText enemyText = new EnemyCombatText(e.getName());
            enemyText.enemyStartTextDisplay();
            promptEnterKey();
            boolean isLevelUp = false;

            // combat
            int result = combatSim(p, e);
            if (result == 0) {
                enemyText.enemyLoseTextDisplay();
                promptEnterKey();
            } else if (result == 1) {
                EnemyCombatText winner = new EnemyCombatText(e.getName(), e.getExp(), e.getGold());
                isLevelUp = p.addExpGold(e.getExp(), e.getGold());
                winner.enemyWinTextDisplay();
                promptEnterKey();
            } else {
                CombatText fleeText = new CombatText(0, e.getName());
                fleeText.fleeSecTextDisplay();
                promptEnterKey();
            }

            // post combat
            // checks for level up
            if (isLevelUp) {
                PlayerCreateText playerLevelUp = new PlayerCreateText();
                playerLevelUp.playerLevelTextDisplay();
            }
            p.resetStat();
            playerGenText = new PlayerCreateText(p.getName(), p.getCurHealth(), p.getMaxHealth(), p.getCurMana(), p.getMaxMana(), p.getDefense(), p.getDodge(), p.getDamage(), p.getCurExp(), p.getExpReq(), p.getGold(), p.getLevel());
            playerGenText.playerStatTextDisplay();
            promptEnterKey();
        }

    }
}