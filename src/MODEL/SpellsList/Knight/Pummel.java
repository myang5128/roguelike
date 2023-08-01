package MODEL.SpellsList.Knight;

import MODEL.SpellsList.Spells;

public class Pummel implements Spells {
    String name = "PUMMEL";
    int manaCost = 1;
    int dmgDebuff = 1;
    int misfire = 5;
    int level = 0;
    String target = "ENEMY";
    String desc = "PUMMEL YOUR ENEMY WITH YOUR POMMEL, MAKING THEM LESS COHERENT AND LESS DANGEROUS!";
    String spellType = "WEAKEN";
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
        switch (this.level) {
            case 1 -> this.manaCost = 1;
            case 2 -> this.manaCost = 2;
            case 3 -> this.manaCost = 4;
            case 4 -> this.manaCost = 5;
            case 5 -> this.manaCost = 7;
            case 6 -> this.manaCost = 10;
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
        return (int) (getRawStatValue() + (Math.random() * this.level));
    }

    /**
     * getter method for raw stat change value
     *
     * @return raw stat change value
     */
    public int getRawStatValue() {
        switch (this.level) {
            case 1 -> dmgDebuff = 1;
            case 2 -> dmgDebuff = 2;
            case 3 -> dmgDebuff = 4;
            case 4 -> dmgDebuff = 6;
            case 5 -> dmgDebuff = 8;
            case 6 -> dmgDebuff = 12;
        }
        return dmgDebuff;
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
        if (pLevel == 1) {
            this.level = 1;
            return true;
        } else if (pLevel == 6) {
            this.level = 2;
            return true;
        } else if (pLevel == 13) {
            this.level = 3;
            return true;
        } else if (pLevel == 19) {
            this.level = 4;
            return true;
        } else if (pLevel == 24) {
            this.level = 5;
            return true;
        } else if (pLevel == 26) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
