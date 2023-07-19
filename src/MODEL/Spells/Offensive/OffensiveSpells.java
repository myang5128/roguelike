package MODEL.Spells.Offensive;

public interface OffensiveSpells {

    String name = null;
    int manaCost = 0;
    int damage = 0;
    int misfire = 0;
    int level = 0;
    String target = null;
    String desc = null;

    /**
     * getter method for spell name
     *
     * @return name
     */
    public String getName();

    /**
     * getter method for mana cost
     *
     * @return mana cost
     */
    public int getManaCost();

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    public int getDamage();

    /**
     * getter method for raw spell damage
     * @return raw spell damage
     */
    public int getRawDamage();

    /**
     * getter method for misfire chance
     *
     * @return misfire chance
     */
    public int getMisfire();

    /**
     * getter method for spell level
     *
     * @return spell level
     */
    public int getLevel();

    /**
     * getter method for spell target
     *
     * @return target
     */
    public String getTarget();

    /**
     * getter method for spell desc
     *
     * @return desc
     */
    public String getDesc();

    /**
     * run spell
     *
     * @return 0 if miss, >0 for damage
     */
    public int runSpell();

    /**
     * updates spell level
     *
     * @param pLevel player level
     * @return t if updated, f if not
     */
    public boolean updateLevel(int pLevel);
}
