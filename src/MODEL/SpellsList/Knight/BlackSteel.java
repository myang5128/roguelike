package MODEL.SpellsList.Knight;

import MODEL.SpellsList.Spells;

public class BlackSteel implements Spells {

    String name = "BLACK STEEL";
    int manaCost = 2;
    int attack = 2;
    int level = 0;
    String target = "SELF";
    String desc = "CALL UPON DELMAT, THE GOD OF SMITHING, TO ENHANCE YOUR STEEL FOR THIS ENGAGEMENT!";
    String spellType = "SUPPORT";
    String statChange = "ATTACK";

    /**
     * getter method for spell name
     *
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * getter method for mana cost
     *
     * @return mana cost
     */
    @Override
    public int getManaCost() {
        return this.manaCost + this.level;
    }

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    @Override
    public int getDamage() {
        return 0;
    }

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    @Override
    public int getRawDamage() {
        return 0;
    }

    /**
     * getter method for misfire chance
     *
     * @return misfire chance
     */
    @Override
    public int getMisfire() {
        return 0;
    }

    /**
     * getter method for spell level
     *
     * @return spell level
     */
    @Override
    public int getLevel() {
        return this.level;
    }

    /**
     * getter method for spell target
     *
     * @return target
     */
    @Override
    public String getTarget() {
        return this.target;
    }

    /**
     * getter method for spell desc
     *
     * @return desc
     */
    @Override
    public String getDesc() {
        return this.desc;
    }

    /**
     * getter method for spell type
     *
     * @return ATTACK for offensive spells, SUPPORT for support spells, WEAKEN for enemy debuff spells
     */
    @Override
    public String getSpellType() {
        return this.spellType;
    }

    /**
     * getter method for stat change
     *
     * @return HEALTH for health changing, DEFENSE for defense changing, DODGE for dodge changing, DAMAGE for damage changing
     */
    @Override
    public String getStatChange() {
        return this.statChange;
    }

    /**
     * getter method for stat change value
     * @return stat change value
     */
    @Override
    public int getStatValue() {
        return (int) ((Math.random() * 3) + getRawStatValue());
    }

    /**
     * getter method for raw stat change value
     * @return raw stat change value
     */
    public int getRawStatValue() {
        return this.attack + this.level;
    }

    /**
     * run spell
     *
     * @return value for stat change
     */
    @Override
    public int runSpell() {
        return getStatValue();
    }

    /**
     * updates spell level
     *
     * @param pLevel player level
     * @return t if updated, f if not
     */
    @Override
    public boolean updateLevel(int pLevel) {
        if (pLevel == 3) {
            this.level = 1;
            return true;
        } else if (pLevel == 5) {
            this.level = 2;
            return true;
        } else if (pLevel == 14) {
            this.level = 3;
            return true;
        } else if (pLevel == 17) {
            this.level = 4;
            return true;
        } else if (pLevel == 21) {
            this.level = 5;
            return true;
        } else if (pLevel == 28) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
