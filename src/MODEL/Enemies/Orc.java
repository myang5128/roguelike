package MODEL.Enemies;

public class Orc implements Enemies{

    String name;
    int curHealth;
    int maxHealth;
    int defense;
    int dodge;
    int damage;
    int exp;
    int gold;

    /**
     * constructor that creates an orc
     * @param scale how the orc should scale accordingly to the player's level
     */
    public Orc(int scale) {
        this.name = "ORC";
        this.maxHealth = (int) ((Math.random() * 11) * scale + 3);
        this.curHealth = this.maxHealth;
        this.defense = (int) ((Math.random() * scale) + 3);
        this.dodge = (int) (20 + (scale * 4));
        this.damage = (int) ((Math.random() * scale) + 3);
        this.exp = 11 * scale;
        this.gold = 7 * scale;
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