package MODEL.Enemies;

public class GooSlime implements Enemies{

    String name;
    int curHealth;
    int maxHealth;
    int defense;
    int dodge;
    int damage;
    int exp;
    int gold;

    /**
     * constructor that creates a goo slime
     * @param scale how the goo slime should scale accordingly to the player's level
     */
    public GooSlime(int scale) {
        this.name = "GOO SLIME";
        this.maxHealth = (int) ((Math.random() * 10) + scale);
        this.curHealth = this.maxHealth;
        this.defense = scale;
        this.dodge = 65 + scale;
        this.damage = scale;
        this.exp = 7 * scale;
        this.gold = 2 * scale;
    }

    /**
     * enemy takes damage
     *
     * @param damage damage value
     */
    @Override
    public int takeDamage(int damage) {
        int value = 0;
        int hitChance = (int) ((Math.random() * 100) + 1);
        hitChance -= this.dodge;
        if (hitChance <= 0) {
            return -1;
        }
        else {
            damage -= this.defense;
            if (damage < 1) {
                damage = 1;
            }
            return damage;
        }
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
     * @return max health
     */
    public int getMaxHealth() {
        return maxHealth;
    };

    /**
     * getter method for enemy cur health
     * @return cur health
     */
    public int getCurHealth(){
        return curHealth;
    };

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
