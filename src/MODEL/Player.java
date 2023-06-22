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
    int curMana;
    int maxMana;
    int defense;
    int tempDefense;
    int dodge;
    int tempDodge;
    int damage;
    int curExp;
    int expReq;
    int gold;
    int level;

    /**
     * Constructor
     */
    public Player(String name, String playerClass, int maxHealth, int maxMana, int defense, int dodge, int damage) {
        this.name = name;
        this.playerClass = playerClass;
        this.curHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.curMana = maxMana;
        this.maxMana = maxMana;
        this.defense = defense;
        this.dodge = dodge;
        this.damage = damage;
        this.curExp = 0;
        this.gold = 0;
        this.level = 1;
    }

    /**
     * checks to see how much exp is needed for next level up
     *
     * @return exp needed
     */
    public int setExpReq(int level) {
        if (this.level < 5) {
            this.expReq = (this.level * 25);
            return this.expReq;
        }
        else if (this.level < 15) {
            this.expReq = (this.level * 50);
            return this.expReq;
        }
        else {
            this.expReq = (this.level * 75);
            return this.expReq;
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
        this.expReq = setExpReq(this.level);
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
     * getter method for current mana
     * @return current health
     */
    public int getCurMana() {
        return this.curMana;
    }

    /**
     * getter method for max mana
     * @return max health
     */
    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * getter method for defense
     * @return defense
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * getter method for temp defense
     * @return temp defense
     */
    public int getTempDefense() {
        return this.tempDefense;
    }

    /**
     * getter method for dodge
     * @return dodge
     */
    public int getDodge() {
        return this.dodge;
    }

    /**
     * getter method for tempdodge
     * @return temp dodge
     */
    public int getTempDodge() {
        return this.tempDodge;
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

    /**
     * gets a scale factor according to the level
     * @return scale factor
     */
    public int getScale() {
        if (this.level < 5) {
            return 1;
        }
        else if (this.level < 10) {
            return 2;
        }
        else {
            int scale = (int) (this.level / 5);
            return scale;
        }
    }

    /**
     * light attack function
     * @param eDodge enemy dodge chance
     * @return 0 if doesn't hit, > 0 for raw damage
     */
    public int lightAttack(int eDodge) {
        int hitChance = ( (int) Math.random() * 100) + 30;
        if (hitChance >= eDodge) {
            return this.damage;
        }
        else {
            return 0;
        }
    }

    /**
     * heavy attack function
     * @param eDodge enemy dodge chance
     * @return 0 if doesn't hit, > 0 for raw damage
     */
    public int heavyAttack(int eDodge) {
        int hitChance = ( (int) Math.random() * 100) + 15;
        if (hitChance >= eDodge) {
            return (int) (this.damage * 1.7);
        }
        else {
            return 0;
        }
    }

    /**
     * calculate flee chance
     * @return 1 if successful, 0 if not
     */
    public int flee() {
        int flee = ( (int) Math.random() * 100) + 1;
        if (flee >= 70) {
            flee = 1;
        }
        else {
            flee = 0;
        }
        return flee;
    }

    /**
     * calculates dmg done to player and changes player health accordingly
     * @param dmg enemy raw dmg value
     */
    public void takeDamage(int dmg) {
        int dmgValue = dmg - this.defense;
        if (dmgValue <= 0) {
            this.curHealth--;
        }
        else {
            this.curHealth -= dmgValue;
        }
    }

}
