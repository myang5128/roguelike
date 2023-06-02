package VIEW;

import java.util.HashMap;

public class PlayerCreateText {

    HashMap<String, String> dialText = new HashMap<>();
    public PlayerCreateText(String name, String playerClass) {
        dialText.put("PLAYERCONFIRM", "AH, " + name + " THE " + playerClass + ". NICE TO MEET YOU. ALAS, WE MUST PART WAYS. MY MASTER, THE WONDERFUL BEAST O' GRIM, " +
                "MAY HIS NAME INSPIRE FEAR AND SUBSERVIENCE ACROSS GENERATIONS, HAS PLANS FOR YOU. \nI CANNOT BETRAY MY MASTER. " +
                "I HOPE YOU THE BEST IN YOUR ENDEAVORS.\n");
    }

    /**
     * return player confirm
     * @return player confirm
     */
    public String playerConfirmText() {
        return dialText.get("PLAYERCONFIRM");
    }
    public void playerConfirmeTextDisplay() {
        System.out.print(dialText.get("PLAYERCONFIRM"));
    }
}
