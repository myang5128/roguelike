package MODEL.SpellsList.Knight;

import MODEL.SpellsList.Spells;

public class ShieldBulwark implements Spells {
    String name = "SHIELD BULWARK";
    int manaCost = 1;
    int defense = 1;
    int level = 0;
    String target = "SELF";
    String desc = "PREPARE YOURSELF AGAINST ENEMY ATTACKS BY HARDENING YOUR BODY!";
    String spellType = "SUPPORT";
    String statChange = "DEFENSE";

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
        int val = this.manaCost;
        switch (this.level) {
            case 1:
                val = 1;
                break;
            case 2:
                val = 2;
                break;
            case 3:
                val = 4;
                break;
            case 4:
                val = 6;
                break;
            case 5:
                val = 8;
                break;
            case 6:
                val = 12;
                break;
        }
        return val;
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
     * @return stat change value
     */
    @Override
    public int getStatValue() {
        return getRawStatValue();
    }

    /**
     * getter method for raw stat change value
     * @return raw stat change value
     */
    public int getRawStatValue() {
        int val = this.defense;
        switch (this.level) {
            case 1:
                val = 1;
                break;
            case 2:
                val = 2;
                break;
            case 3:
                val = 4;
                break;
            case 4:
                val = 6;
                break;
            case 5:
                val = 12;
                break;
            case 6:
                val = 20;
                break;
        }
        return val;
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
        if (pLevel == 2) {
            this.level = 1;
            return true;
        } else if (pLevel == 9) {
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
