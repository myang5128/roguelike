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
    String getName();

    /**
     * getter method for mana cost
     *
     * @return mana cost
     */
    int getManaCost();

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    int getDamage();

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    int getRawDamage();

    /**
     * getter method for misfire chance
     *
     * @return misfire chance
     */
    int getMisfire();

    /**
     * getter method for spell level
     *
     * @return spell level
     */
    int getLevel();

    /**
     * getter method for spell target
     *
     * @return target
     */
    String getTarget();

    /**
     * getter method for spell desc
     *
     * @return desc
     */
    String getDesc();

    /**
     * getter method for spell type
     *
     * @return ATTACK for offensive spells, SUPPORT for support spells, WEAKEN for enemy debuff spells
     */
    String getSpellType();

    /**
     * getter method for stat change
     *
     * @return HEALTH for health changing, DEFENSE for defense changing, DODGE for dodge changing, DAMAGE for damage changing
     */
    String getStatChange();

    /**
     * getter method for stat change value
     *
     * @return stat change value
     */
    int getStatValue();

    /**
     * getter method for raw stat change value
     *
     * @return raw stat change value
     */
    int getRawStatValue();

    /**
     * run spell
     *
     * @return 0 if miss, >0 for damage
     */
    int runSpell();

    /**
     * updates spell level
     *
     * @param pLevel player level
     * @return t if updated, f if not
     */
    boolean updateLevel(int pLevel);
}
