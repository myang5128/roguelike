package MODEL.SpellsList.Knight;

import MODEL.SpellsList.Spells;

public class Pummel implements Spells {
    String name = "PUMMEL";
    int manaCost = 1;
    int damage = 2;
    int misfire = 5;
    int level = 0;
    String target = "ENEMY";
    String desc = "ATTACK YOUR ENEMY WITH A BLUNT STRIKE OF YOUR WEAPON!";
    String spellType = "ATTACK";
    String statChange = null;

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
            case 1:
                this.manaCost = 1;
                break;
            case 2:
                this.manaCost = 2;
                break;
            case 3:
                this.manaCost = 4;
                break;
            case 4:
                this.manaCost = 5;
                break;
            case 5:
                this.manaCost = 7;
                break;
            case 6:
                this.manaCost = 10;
                break;
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
        return (int) (getRawDamage() + (Math.random() * level));
    }

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    @Override
    public int getRawDamage() {
        int val = this.damage;
        switch (this.level) {
            case 1:
                val = 2;
                break;
            case 2:
                val = 4;
                break;
            case 3:
                val = 7;
                break;
            case 4:
                val = 11;
                break;
            case 5:
                val = 16;
                break;
            case 6:
                val = 23;
                break;
        }
        return val;
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
        return 0;
    }

    /**
     * getter method for raw stat change value
     *
     * @return raw stat change value
     */
    public int getRawStatValue() {
        return 0;
    }

    /**
     * run spell
     *
     * @return value for stat change
     */
    @Override
    public int runSpell() {
        int chance = (int) (Math.random() * 100 + this.level);
        if (chance <= this.misfire) {
            return 0;
        } else {
            return getDamage();
        }
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
