package VIEW;

import java.util.HashMap;

public class SpellsText {

    HashMap<String, String> dialText = new HashMap<>();

    public SpellsText() {
        dialText.put("START", "AVAILABLE SPELL(S): \n");
    }
    public SpellsText(String spellName, int level, int dmg, int manaCost, String desc) {
        dialText.put("SPELL", spellName + " -   TIER: " + level + "  RAW DMG: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n\n");
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

}
