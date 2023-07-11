package VIEW;

import java.util.HashMap;

public class PlayerCreateText {

    HashMap<String, String> dialText = new HashMap<>();
    public PlayerCreateText(String name, String playerClass) {
        dialText.put("PLAYERCONFIRM", "AH, " + name + " THE " + playerClass + ". NICE TO MEET YOU. ALAS, WE MUST PART WAYS. MY MASTER, THE WONDERFUL BEAST O' GRIM, " +
                "MAY HIS NAME INSPIRE FEAR AND SUBSERVIENCE ACROSS GENERATIONS, HAS PLANS FOR YOU. \nI CANNOT BETRAY MY MASTER. " +
                "I HOPE YOU THE BEST IN YOUR ENDEAVORS.\n");
    }
    public PlayerCreateText(String name, int curHealth, int maxHealth, int curMana, int maxMana, int defense, int dodge, int damage, int curExp, int reqExp, int gold, int level) {
        dialText.put("PLAYERSTAT", "NAME: " + name + "     LEVEL: " + level + "\n" +
                "HP: " + curHealth + "/" + maxHealth + "     MANA: " + curMana + "/" + maxMana + "\n"+
                "DEFENSE: " + defense + "     DODGE: " + dodge + "\n" +
                "DAMAGE: " + damage + "     GOLD: " + gold + "\n" +
                "EXP: " + curExp + "/" + reqExp + "\n\n"
        );
    }

    public PlayerCreateText(String name, int damage, int curHealth, int maxHealth, int curMana, int maxMana, int defense, int dodge) {
        dialText.put("COMBATSTAT", "NAME: " + name + "     DAMAGE: " + damage + "\n" +
                "HP: " + curHealth + "/" + maxHealth + "     MANA: " + curMana + "/" + maxMana + "\n"+
                "DEFENSE: " + defense + "     DODGE: " + dodge + "\n\n"
        );
    }

    public PlayerCreateText() {
        dialText.put("LEVELUP", "YOU ABSORBED ENOUGH MONSTER ESSENCE! YOU FEEL A BIT STRONGER NOW, YET YOU CRAVE MORE...\n");
    }

    /**
     * return player confirm
     * @return player confirm
     */
    public String playerConfirmText() {
        return dialText.get("PLAYERCONFIRM");
    }
    public void playerConfirmTextDisplay() {
        System.out.print(dialText.get("PLAYERCONFIRM"));
    }

    /**
     * return player stats
     * @return player stats
     */
    public String playerStatText() {
        return dialText.get("PLAYERSTAT");
    }
    public void playerStatTextDisplay() {
        System.out.print(dialText.get("PLAYERSTAT"));
    }

    /**
     * return player combat stats
     * @return player combat stats
     */
    public String playercomStatText() {
        return dialText.get("COMBATSTAT");
    }
    public void playercomStatTextDisplay() {
        System.out.print(dialText.get("COMBATSTAT"));
    }

    /**
     * return player level up
     * @return player level up
     */
    public String playerLevelText() {
        return dialText.get("LEVELUP");
    }
    public void playerLevelTextDisplay() {
        System.out.print(dialText.get("LEVELUP"));
    }
}
