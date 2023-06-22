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

    /**
     * Creates hashmap for character creation dialogue
     */
    {
        {

        }
    };

    /**
     * return combat move
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
     * @return move invalid
     */
    public String moveInvalidText() {
        return dialText.get("MOVEINVALID");
    }
    public void moveInvalidTextDisplay() {
        System.out.print(dialText.get("MOVEINVALID"));
    }
}
