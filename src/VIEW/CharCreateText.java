package VIEW;

import java.util.HashMap;

public class CharCreateText {

    HashMap<String, String> dialText = new HashMap<String, String>();

    public CharCreateText() {
        // format for adding to hashmap: text.put(KEY, VALUE);
        /**
         * Hashmap values
         */
        dialText.put("PRESSCONTINUE", "*press ENTER to continue*\n");
        dialText.put("WELCOME", "WELCOME, O' BROKEN SOUL. ANOTHER SOUL HAS BEEN SNATCHED BY THE GREAT BEAST O' GRIM!\n");
        dialText.put("GETNAME", "MIGHT I ASK WHAT YOUR NAME IS, DEAD ADVENTURER? I WISH NOT TO SEND YOU INTO THE ABYSS WITHOUT AT LEAST KNOWING YOUR NAME.\n");
        dialText.put("GETCLASS", "NOW, REMEMBER AS MUCH AS YOU CAN FROM YOUR PAST LIFE. WHAT WAS YOUR PROFESSION? YOU DON'T HAVE THE BODY OR THE EYES OF A PEASANT, SOME BOLD SOLDIER PERHAPS, " +
                "OR A STEALTHY ASSASSIN, OR, OH MY, EVEN A CRAFTY MAGE, PERHAPS?\n" + "*available classes: DRUID, KNIGHT, MAGE, PALADIN, RANGER, ROGUE*\n");
        dialText.put("GETCLASSAGAIN", "I'M SORRY, MY HEARING MIGHT HAVE GOTTEN WORSE THROUGHOUT THE YEARS, BUT I COULDN'T MAKE OUT WHAT YOU SAID. WHAT PROFESSION WERE YOU AGAIN?\n"
                +"*available classes: DRUID, KNIGHT, MAGE, PALADIN, RANGER, ROGUE*\n");
    }

    /**
     * Creates hashmap for character creation dialogue
     */
     {
        {

        }
    };

    /**
     * return press continue
     * @return press continue
     */
    public String pressContinueText() {
        return dialText.get("PRESSCONTINUE");
    }
    public void pressContinueTextDisplay() {
        System.out.print(dialText.get("PRESSCONTINUE"));
    }

    /**
     * returns welcome text
     * @return welcome text
     */
    public String welcomeText() {
        return dialText.get("WELCOME");
    }
    public void welcomeTextDisplay() {
        System.out.print(dialText.get("WELCOME"));
    }

    /**
     * returns name text
     * @return name text
     */
    public String nameText() {
        return dialText.get("GETNAME");
    }
    public void nameTextDisplay() {
        System.out.print(dialText.get("GETNAME"));
    }

    /**
     * returns class text
     * @return class text
     */
    public String classText() {
        return dialText.get("GETCLASS");
    }
    public void classTextDisplay() {
        System.out.print(dialText.get("GETCLASS"));
    }
    public String classAgainText() {
        return dialText.get("GETCLASSAGAIN");
    }
    public void classAgainTextDisplay() {
        System.out.print(dialText.get("GETCLASSAGAIN"));
    }
}
