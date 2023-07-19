package VIEW;

import java.util.HashMap;

public class SpellsText {

    HashMap<String, String> dialText = new HashMap<>();

    public SpellsText() {
        dialText.put("START", "AVAILABLE SPELL(S): \n");
        dialText.put("PICK", "WHAT SPELL DO YOU WISH TO CAST OR DO YOU WISH TO PICK A DIFFERENT ACTION *BACK*?\n");
        dialText.put("PICKAGAIN", "THAT MAY NOT BE A SPELL YOU KNOW, THIS IS NOT THE TIME TO BE PLAYING AROUND. CAST A SPELL WARRIOR!\n");
    }
    public SpellsText(String spellName, int level, int dmg, int manaCost, String desc) {
        dialText.put("SPELL", spellName + " -   TIER: " + level + "  RAW DMG: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n");
    }
    public SpellsText(String spellName, int dmg, int manaCost, String enemyName) {
        dialText.put("DAMAGE", spellName + " HIT THE " + enemyName + " FOR " + dmg + " DAMAGE AT THE COST OF " + manaCost + " MANA!\n\n");
        dialText.put("MISS", spellName + " MISSED THE " + enemyName + "!\n\n");
    }

    /**
     * return spell info
     * @return spell info
     */
    public String spellText() {
        return dialText.get("SPELL");
    }
    public void spellTextDisplay() {
        System.out.print(dialText.get("SPELL"));
    }

    /**
     * return start
     * @return start
     */
    public String startText() {
        return dialText.get("START");
    }
    public void startTextDisplay() {
        System.out.print(dialText.get("START"));
    }

    /**
     * return pick
     * @return pick
     */
    public String pickText() {
        return dialText.get("PICK");
    }
    public void pickTextDisplay() {
        System.out.print(dialText.get("PICK"));
    }

    /**
     * return pick again
     * @return pick again
     */
    public String pickAgainText() {
        return dialText.get("PICKAGAIN");
    }
    public void pickAgainTextDisplay() {
        System.out.print(dialText.get("PICKAGAIN"));
    }

    /**
     * return damage
     * @return damage
     */
    public String damageText() {
        return dialText.get("DAMAGE");
    }
    public void damageTextDisplay() {
        System.out.print(dialText.get("DAMAGE"));
    }

    /**
     * return miss
     * @return miss
     */
    public String missText() {
        return dialText.get("MISS");
    }
    public void missTextDisplay() {
        System.out.print(dialText.get("MISS"));
    }

}
