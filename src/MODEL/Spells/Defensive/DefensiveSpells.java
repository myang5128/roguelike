package MODEL.Spells.Defensive;

public interface DefensiveSpells {

    String name = null;
    int manaCost = 0;
    int heal = 0;
    int defense = 0;
    int dodge = 0;
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
     * getter method for spell heal
     *
     * @return spell heal
     */
    public int getHeal();

    /**
     * getter method for spell defense
     *
     * @return spell defense
     */
    public int getDefense();

    /**
     * getter method for spell dodge
     *
     * @return spell dodge
     */
    public int getDodge();

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
     */
    public void runSpell();
}
