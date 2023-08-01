package MODEL.SpellsList.Druid;

import MODEL.SpellsList.Spells;

public class HealingFruit implements Spells {

    String name = "HEALING FRUIT";
    int manaCost = 2;
    int misfire = 12;
    int level = 0;
    int heal = 4;
    String target = "SELF";
    String desc = "CONSUME A DELICIOUS HEALING FRUIT TO SOOTH YOUR PAIN!";
    String spellType = "SUPPORT";
    String statChange = "HEALTH";

    /**
     * constructor
     */
    public HealingFruit() {
    }

    /**
     * getter method for spell name
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * getter method for mana cost
     *
     * @return mana cost
     */
    @Override
    public int getManaCost() {
        switch (this.level) {
            case 1 -> this.manaCost = 2;
            case 2 -> this.manaCost = 3;
            case 3 -> this.manaCost = 6;
            case 4 -> this.manaCost = 9;
            case 5 -> this.manaCost = 13;
            case 6 -> this.manaCost = 16;
        }
        return this.manaCost;
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
        return this.misfire;
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
     *
     * @return stat change value
     */
    @Override
    public int getStatValue() {
        return (int) ((Math.random() * this.level) + getRawStatValue());
    }

    /**
     * getter method for raw stat change value
     *
     * @return raw stat change value
     */
    public int getRawStatValue() {
        switch (this.level) {
            case 1 -> this.heal = 4;
            case 2 -> this.heal = 6;
            case 3 -> this.heal = 10;
            case 4 -> this.heal = 16;
            case 5 -> this.heal = 24;
            case 6 -> this.heal = 32;
        }
        return this.heal;
    }

    /**
     * run spell
     *
     * @return 0 if miss, >0 for damage
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
        } else if (pLevel == 7) {
            this.level = 2;
            return true;
        } else if (pLevel == 12) {
            this.level = 3;
            return true;
        } else if (pLevel == 18) {
            this.level = 4;
            return true;
        } else if (pLevel == 23) {
            this.level = 5;
            return true;
        } else if (pLevel == 29) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
