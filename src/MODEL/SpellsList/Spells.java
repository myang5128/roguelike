package MODEL.SpellsList;

public interface Spells {

    String name = null;
    int manaCost = 0;
    int damage = 0;
    int heal = 0;
    int defense = 0;
    int dodge = 0;
    int attack = 0;
    int misfire = 0;
    int level = 0;
    String target = null;
    String desc = null;
    String spellType = null;
    String statChange = null;

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
     * getter method for spell type
     * @return ATTACK for offensive spells, SUPPORT for support spells, WEAKEN for enemy debuff spells
     */
    public String getSpellType();

    /**
     * getter method for stat change
     * @return HEALTH for health changing, DEFENSE for defense changing, DODGE for dodge changing, DAMAGE for damage changing
     */
    public String getStatChange();

    /**
     * getter method for stat change value
     * @return stat change value
     */
    public int getStatValue();

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
