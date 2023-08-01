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
     *
     * @param damage damage value
     * @return -1 if miss, >0 for damage done
     */
    int takeDamage(int damage);

    /**
     * enemy takes magic damage
     *
     * @param damage raw magic damage value
     * @return damage value
     */
    int takeMagicDamage(int damage);

    /**
     * enemy gets a debuff
     *
     * @param stat   stat getting debuffed
     * @param damage debuff strength
     */
    void debuff(String stat, int damage);

    /**
     * enemy gets a buff
     *
     * @param stat   stat getting buffed
     * @param damage buff strength
     */
    void buff(String stat, int damage);

    /**
     * getter method for enemy name
     *
     * @return name
     */
    String getName();

    /**
     * getter method for enemy max health
     *
     * @return max health
     */
    int getMaxHealth();

    /**
     * getter method for enemy cur health
     *
     * @return cur health
     */
    int getCurHealth();

    /**
     * getter method for enemy defense
     *
     * @return defense
     */
    int getDefense();

    /**
     * getter method for enemy dodge
     *
     * @return dodge
     */
    int getDodge();

    /**
     * getter method for enemy damage
     *
     * @return damage
     */
    int getDamage();

    /**
     * enemy light attack
     *
     * @param pDodge player dodge chance
     * @return 0 for miss, >0 for raw damage value
     */
    int lightAttack(int pDodge);

    /**
     * enemy heavy attack
     *
     * @param pDodge player dodge chance
     * @return 0 for miss, >0 for raw damage value
     */
    int heavyAttack(int pDodge);

    /**
     * getter method for enemy gold
     *
     * @return gold
     */
    int getGold();

    /**
     * getter method for enemy exp
     *
     * @return exp
     */
    int getExp();
}
