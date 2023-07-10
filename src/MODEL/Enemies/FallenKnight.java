package MODEL.Enemies;

public class FallenKnight implements Enemies {

    String name;
    int curHealth;
    int maxHealth;
    int defense;
    int dodge;
    int damage;
    int exp;
    int gold;

    /**
     * constructor that creates a fallen knight
     *
     * @param scale how the fallen knight should scale accordingly to the player's level
     */
    public FallenKnight(int scale) {
        this.name = "FALLEN KNIGHT";
        this.maxHealth = (int) ((Math.random() * 15) * scale + 4);
        this.curHealth = this.maxHealth;
        this.defense = (int) ((Math.random() * 3) * scale + 2);
        this.dodge = (int) (25 + (scale * 3));
        this.damage = (int) ((Math.random() * scale) + 3);
        this.exp = 13 * scale;
        this.gold = 8 * scale;
    }

    /**
     * enemy takes damage
     *
     * @param damage damage value
     */
    @Override
    public int takeDamage(int damage) {
        damage -= this.defense;
        if (damage < 1) {
            damage = 1;
        }
        this.curHealth -= damage;
        return damage;
    }

    /**
     * enemy gets a debuff
     *
     * @param stat   stat getting debuffed
     * @param damage debuff strength
     */
    @Override
    public void debuff(String stat, int damage) {

    }

    /**
     * enemy gets a buff
     *
     * @param stat   stat getting buffed
     * @param damage buff strength
     */
    @Override
    public void buff(String stat, int damage) {

    }

    /**
     * getter method for enemy name
     *
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * getter method for enemy max health
     *
     * @return max health
     */
    public int getMaxHealth() {
        return maxHealth;
    }

    ;

    /**
     * getter method for enemy cur health
     *
     * @return cur health
     */
    public int getCurHealth() {
        return curHealth;
    }

    ;

    /**
     * getter method for enemy defense
     *
     * @return defense
     */
    @Override
    public int getDefense() {
        return this.defense;
    }

    /**
     * getter method for enemy dodge
     *
     * @return dodge
     */
    @Override
    public int getDodge() {
        if (this.dodge > 80) {
            this.dodge = 80;
            return this.dodge;
        }
        return this.dodge;
    }

    /**
     * getter method for enemy damage
     *
     * @return damage
     */
    @Override
    public int getDamage() {
        return this.damage;
    }

    /**
     * runs an attack for the enemy
     * @param pDodge player dodge chance
     * @return 0 if miss, >0 for raw damage value
     */
    public int attack(int pDodge) {
        int hitChance = ( (int)(Math.random() * 100)) + 20;
        if (hitChance >= pDodge) {
            return this.damage;
        }
        else {
            return 0;
        }
    }

    /**
     * getter method for enemy gold
     *
     * @return gold
     */
    @Override
    public int getGold() {
        return this.gold;
    }

    /**
     * getter method for enemy exp
     *
     * @return
     */
    @Override
    public int getExp() {
        return this.exp;
    }
}
