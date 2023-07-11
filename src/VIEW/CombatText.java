package VIEW;

import java.util.HashMap;

public class CombatText {

    HashMap<String, String> dialText = new HashMap<String, String>();

    public CombatText() {
        // format for adding to hashmap: text.put(KEY, VALUE);
        /**
         * Hashmap values
         */
        dialText.put("COMBATMOVE", "PICK A MOVE, ADVENTURER." + " *LIGHT, HEAVY, FLEE*\n");
        dialText.put("MOVEINVALID", "PLEASE FIGHT PROPERLY..." + " *LIGHT, HEAVY, FLEE*\n");
    }

    public CombatText(int value, String name) {
        dialText.put("PLAYERMISS", "THE " + name + " DODGES OUT OF YOUR ATTACK!\n");
        dialText.put("PLAYERLIGHTHIT", "YOU STRUCK THE " + name + " WITH A LIGHT ATTACK FOR " + value + " DAMAGE!\n");
        dialText.put("PLAYERHEAVYHIT", "YOU CHARGE A POWERFUL ATTACK AND DAMAGED THE " + name + " FOR " + value + " DAMAGE!\n");
        dialText.put("ENEMYATTACK", "THE " + name + " PREPARES TO ATTACK YOU!");
        dialText.put("ENEMYLIGHTHIT", "THE " + name + " ATTACKS YOU WITH A LIGHT ATTACK FOR " + value + " DAMAGE!\n");
        dialText.put("ENEMYRHEAVYHIT", "YOU GET HIT BY A FORCEFUL ATTACK BY THE  " + name + "  FOR " + value + " DAMAGE!\n");
        dialText.put("ENEMYMISS", "YOU JUMP OUT OF THE " + name + "'S ATTACK!\n");
        dialText.put("FLEESUCCESS", "YOU QUICKLY RAN AWAY FROM THE " + name + " AND MANAGED TO HIDE FROM IT!\n");
        dialText.put("FLEEFAIL", "YOU TRY TO RUN AWAY FROM THE " + name + " BUT YOU TRIP AND ATE SHIT!\n");
    }

    /**
     * return combat move
     *
     * @return combat move
     */
    public String combatMoveText() {
        return dialText.get("COMBATMOVE");
    }

    public void combatMoveTextDisplay() {
        System.out.print(dialText.get("COMBATMOVE"));
    }

    /**
     * return move invalid
     *
     * @return move invalid
     */
    public String moveInvalidText() {
        return dialText.get("MOVEINVALID");
    }

    public void moveInvalidTextDisplay() {
        System.out.print(dialText.get("MOVEINVALID"));
    }

    /**
     * return player miss
     *
     * @return player miss
     */
    public String playerMissText() {
        return dialText.get("PLAYERMISS");
    }

    public void playerMissTextDisplay() {
        System.out.print(dialText.get("PLAYERMISS"));
    }

    /**
     * return player light
     *
     * @return player light
     */
    public String playerLightText() {
        return dialText.get("PLAYERLIGHTHIT");
    }

    public void playerLightTextDisplay() {
        System.out.print(dialText.get("PLAYERLIGHTHIT"));
    }

    /**
     * return player heavy
     *
     * @return player heavy
     */
    public String playerHeavyText() {
        return dialText.get("PLAYERHEAVYHIT");
    }

    public void playerHeavyTextDisplay() {
        System.out.print(dialText.get("PLAYERHEAVYHIT"));
    }

    /**
     * return enemy attack
     *
     * @return enemy attack
     */
    public String enemyAttackText() {
        return dialText.get("ENEMYATTACK");
    }

    public void enemyAttackTextDisplay() {
        System.out.print(dialText.get("ENEMYATTACK"));
    }

    /**
     * return enemy miss
     *
     * @return enemy miss
     */
    public String enemyMissText() {
        return dialText.get("ENEMYMISS");
    }

    public void enemyMissTextDisplay() {
        System.out.print(dialText.get("ENEMYMISS"));
    }

    /**
     * return enemy light
     *
     * @return enemy light
     */
    public String enemyLightText() {
        return dialText.get("ENEMYLIGHTHIT");
    }

    public void enemyLightTextDisplay() {
        System.out.print(dialText.get("ENEMYLIGHTHIT"));
    }

    /**
     * return enemy heavy
     *
     * @return enemy heavy
     */
    public String enemyHeavyText() {
        return dialText.get("ENEMYHEAVYHIT");
    }

    public void enemyHeavyTextDisplay() {
        System.out.print(dialText.get("ENEMYHEAVYHIT"));
    }

    /**
     * return flee success
     *
     * @return flee success
     */
    public String fleeSucText() {
        return dialText.get("FLEESUCCESS");
    }

    public void fleeSecTextDisplay() {
        System.out.print(dialText.get("FLEESUCCESS"));
    }

    /**
     * return flee fail
     *
     * @return flee fail
     */
    public String fleeFailText() {
        return dialText.get("FLEEFAIL");
    }

    public void fleeFailTextDisplay() {
        System.out.print(dialText.get("FLEEFAIL"));
    }
}

