package MODEL.Enemies;

public interface Enemies {
    String name = "NONE";
    int curHealth = 0;
    int maxHealth = 0;
    int defense = 0;
    int dodge = 0;
    int damage = 0;
    int exp = 0;
    int gold = 0;

    /**
     * enemy takes damage
     * @return -1 if miss, >0 for damage done
     * @param damage damage value
     */
    public int takeDamage(int damage);

    /**
     * enemy gets a debuff
     * @param stat stat getting debuffed
     * @param damage debuff strength
     */
    public void debuff(String stat, int damage);

    /**
     * enemy gets a buff
     * @param stat stat getting buffed
     * @param damage buff strength
     */
    public void buff(String stat, int damage);

    /**
     * getter method for enemy name
     * @return name
     */
    public String getName();

    /**
     * getter method for enemy max health
     * @return max health
     */
    public int getMaxHealth();

    /**
     * getter method for enemy cur health
     * @return cur health
     */
    public int getCurHealth();

    /**
     * getter method for enemy defense
     * @return defense
     */
    public int getDefense();

    /**
     * getter method for enemy dodge
     * @return dodge
     */
    public int getDodge();

    /**
     * getter method for enemy damage
     * @return damage
     */
    public int getDamage();

    /**
     * enemy attack
     * @return 0 for miss, >0 for raw damage value
     */
    public int attack(int pDodge);

    /**
     * getter method for enemy gold
     * @return gold
     */
    public int getGold();

    /**
     * getter method for enemy exp
     * @return
     */
    public int getExp();
}
