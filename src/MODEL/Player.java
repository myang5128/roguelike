package MODEL;

public class Player {
    /**
     * Player class
     */

    /**
     * values
     */
    String name;
    String playerClass;
    int curHealth;
    int maxHealth;
    int defense;
    int dodge;
    int damage;
    int curExp;
    int expReq;
    int gold;
    int level;

    /**
     * Constructor
     */
    public Player(String name, String playerClass, int maxHealth, int defense, int dodge, int damage) {
        this.name = name;
        this.playerClass = playerClass;
        this.curHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.defense = defense;
        this.dodge = dodge;
        this.damage = damage;
        this.curExp = 0;
        this.expReq = ExpReqChecker(this.level);
        this.gold = 0;
        this.level = 1;
    }

    /**
     * checks to see how much exp is needed for next level up
     * @param level current player level
     * @return exp needed
     */
    public int ExpReqChecker(int level) {
        if (level < 5) {
            return (level * 25);
        }
        else if (level < 15) {
            return (level * 50);
        }
        else {
            return (level * 75);
        }
    }

    /**
     * levels up player
     */
    public void PlayerLevelUp() {
        if (this.level < 10) {
            this.maxHealth += 1;
            this.curHealth += 1;
        }
        else if (this.level < 20) {
            this.maxHealth += 2;
            this.curHealth += 2;
        }
        else {
            this.maxHealth += 3;
            this.curHealth += 3;
        }
        this.dodge += 1;
        this.damage += 1;
        this.level += 1;
        this.expReq = ExpReqChecker(this.level);
    }

    /**
     * levels up player if exp is enough
     */
    public void ExpLevelEnough() {
        if (this.curExp >= this.expReq) {
            this.curExp -= this.expReq;
            PlayerLevelUp();
        }
    }

    /**
     * getter method for player name
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter method for player class
     * @return class
     */
    public String getPlayerClass() {
        return this.playerClass;
    }

    /**
     * getter method for current health
     * @return current health
     */
    public int getCurHealth() {
        return this.curHealth;
    }

    /**
     * getter method for max health
     * @return max health
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }

    /**
     * getter method for defense
     * @return defense
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * getter method for dodge
     * @return dodge
     */
    public int getDodge() {
        return this.dodge;
    }

    /**
     * getter method for damage
     * @return
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * getter method for current exp
     * @return current exp
     */
    public int getCurExp() {
        return this.curExp;
    }

    /**
     * getter method for exp required
     * @return exp required
     */
    public int getExpReq() {
        return this.expReq;
    }

    /**
     * getter method for gold
     * @return gold
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * getter method for level
     * @return level
     */
    public int getLevel() {
        return this.level;
    }
}
