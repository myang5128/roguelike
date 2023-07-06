package VIEW;

import java.util.HashMap;

public class EnemyCombatText {

    HashMap<String, String> dialText = new HashMap<>();
    public EnemyCombatText(String name) {
        dialText.put("ENEMYSTART", "A " + name + " HAS APPEARED IN YOUR WAY! IT STARTS MOVING TOWARDS YOU!\n");
        dialText.put("ENEMYLOSE", "THE " + name + " HAS BESTED YOU! YOU FEEL THE GROUND SHAKE AS IT OPENS UP.\n" +
                "FIERY HANDS FROM THE PITS OF HELL REACHES UP AND TAKE HOLD OF YOU AND PULLS YOU DOWN, FOREVER LOSING SIGHT OF FREEDOM AND HEAVEN.\n");
    }

    public EnemyCombatText(String name, int expGain, int goldGain) {
        dialText.put("ENEMYWIN", "THE " + name + " HAS BEEN KILLED! YOUR BODY BEGINS TO ABSORB THE ENEMY'S ESSENSE, MAKING YOU STRONGER.\n" +
                "YOU GAIN " + expGain + " EXPERIENCE AND " + goldGain + " GOLD!\n");
    }

    public EnemyCombatText(String name, int curHealth, int maxHealth, int defense, int dodge, int damage) {
        dialText.put("ENEMYSTAT", "ENEMY: " + name + "\n" +
                "HP: " + curHealth + "/" + maxHealth + "     DODGE: " + dodge + "\n" +
                "DEFENSE: " + defense + "     DAMAGE: " + damage + "\n\n");
    }

    /**
     * return enemy start
     * @return enemy start
     */
    public String enemyStartText() {
        return dialText.get("ENEMYSTART");
    }
    public void enemyStartTextDisplay() {
        System.out.print(dialText.get("ENEMYSTART"));
    }

    /**
     * return enemy lose
     * @return enemy lose
     */
    public String enemyLoseText() {
        return dialText.get("ENEMYLOSE");
    }
    public void enemyLoseTextDisplay() {
        System.out.print(dialText.get("ENEMYLOSE"));
    }

    /**
     * return enemy win
     * @return enemy win
     */
    public String enemyWinText() {
        return dialText.get("ENEMYWIN");
    }
    public void enemyWinTextDisplay() {
        System.out.print(dialText.get("ENEMYWIN"));
    }

    /**
     * return enemy stat
     * @return enemy stat
     */
    public String enemyStatText() {
        return dialText.get("ENEMYSTAT");
    }
    public void enemyStatTextDisplay() {
        System.out.print(dialText.get("ENEMYSTAT"));
    }
}
