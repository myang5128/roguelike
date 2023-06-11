package VIEW;

import java.util.HashMap;

public class EnemyCombatText {

    HashMap<String, String> dialText = new HashMap<>();
    public EnemyCombatText(String name) {
        dialText.put("ENEMYSTART", "A " + name + " HAS APPEARED IN YOUR WAY! ITS RICKETY BONES START WALKING TOWARDS YOU!\n");
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
}
