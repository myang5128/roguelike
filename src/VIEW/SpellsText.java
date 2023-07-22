package VIEW;

import java.util.HashMap;

public class SpellsText {

    HashMap<String, String> dialText = new HashMap<>();

    public SpellsText() {
        dialText.put("START", "AVAILABLE SPELL(S): \n");
        dialText.put("PICK", "WHAT SPELL DO YOU WISH TO CAST OR DO YOU WISH TO PICK A DIFFERENT ACTION *BACK*?\n");
        dialText.put("PICKAGAIN", "THAT MAY NOT BE A SPELL YOU KNOW, THIS IS NOT THE TIME TO BE PLAYING AROUND. CAST A SPELL WARRIOR!\n");
        dialText.put("MANAGONE", "YOU TRIED TO CAST A SPELL BUT YOU DON'T HAVE ENOUGH MANA!\n\n");
    }
    public SpellsText(String spellName, int level, int dmg, int manaCost, String desc) {
        dialText.put("SPELLATK", spellName + " -   TIER: " + level + "  RAW DMG: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n");
        dialText.put("SPELLDMG", spellName + " -   TIER: " + level + "  DAMAGE BOOST: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n");
        dialText.put("SPELLDEF", spellName + " -   TIER: " + level + "  DEFENSE BOOST: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n");
        dialText.put("SPELLHP", spellName + " -   TIER: " + level + "  HEAL: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n");
        dialText.put("SPELLDODGE", spellName + " -   TIER: " + level + "  DODGE BOOST: " + dmg + "  MANA COST: " + manaCost + "\n   DESCRIPTION: " + desc + "\n");
    }
    public SpellsText(String spellName, int dmg, int manaCost, String enemyName) {
        dialText.put("DAMAGE", spellName + " HIT THE " + enemyName + " FOR " + dmg + " DAMAGE AT THE COST OF " + manaCost + " MANA!\n\n");
        dialText.put("MISS", spellName + " MISSED THE " + enemyName + "!\n\n");
    }
    public SpellsText(String spellName, int value) {
        dialText.put("ATTACK", spellName + " HAS INCREASED YOUR DAMAGE BY " + value + "!\n\n");
        dialText.put("DEFENSE", spellName + " HAS INCREASED YOUR DEFENSE BY " + value + "!\n\n");
        dialText.put("HEALTH", spellName + " HAS HEALED YOU FOR " + value + "!\n\n");
    }

    /**
     * return spell ATK info
     * @return spell ATK info
     */
    public String spellATKText() {
        return dialText.get("SPELLATK");
    }
    public void spellATKTextDisplay() {
        System.out.print(dialText.get("SPELLATK"));
    }

    /**
     * return spell DMG info
     * @return spell DMG info
     */
    public String spellDMGText() {
        return dialText.get("SPELLDMG");
    }
    public void spellDMGTextDisplay() {
        System.out.print(dialText.get("SPELLDMG"));
    }

    /**
     * return spell DEF info
     * @return spell DEF info
     */
    public String spellDEFText() {
        return dialText.get("SPELLDEF");
    }
    public void spellDEFTextDisplay() {
        System.out.print(dialText.get("SPELLDEF"));
    }

    /**
     * return spell HP info
     * @return spell HP info
     */
    public String spellHPText() {
        return dialText.get("SPELLHP");
    }
    public void spellHPTextDisplay() {
        System.out.print(dialText.get("SPELLHP"));
    }

    /**
     * return spell DODGE info
     * @return spell DODGE info
     */
    public String spellDODGEText() {
        return dialText.get("SPELLDODGE");
    }
    public void spellDODGETextDisplay() {
        System.out.print(dialText.get("SPELLDODGE"));
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

    /**
     * return attack
     * @return attack
     */
    public String attackText() {
        return dialText.get("ATTACK");
    }
    public void attackTextDisplay() {
        System.out.print(dialText.get("ATTACK"));
    }

    /**
     * return defense
     * @return defense
     */
    public String defenseText() {
        return dialText.get("DEFENSE");
    }
    public void defenseTextDisplay() {
        System.out.print(dialText.get("DEFENSE"));
    }

    /**
     * return health
     * @return health
     */
    public String healthText() {
        return dialText.get("HEALTH");
    }
    public void healthTextDisplay() {
        System.out.print(dialText.get("HEALTH"));
    }

    /**
     * return mana gone
     * @return mana gone
     */
    public String manaGoneText() {
        return dialText.get("MANAGONE");
    }
    public void manaGoneTextDisplay() {
        System.out.print(dialText.get("MANAGONE"));
    }
}
