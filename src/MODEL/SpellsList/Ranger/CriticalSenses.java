package MODEL.SpellsList.Ranger;

import MODEL.SpellsList.Spells;

public class CriticalSenses implements Spells {
    String name = "Critical SENSES";
    int manaCost = 1;
    int attack = 2;
    int level = 0;
    String target = "SELF";
    String desc = "USE YOUR EMPOWERED SENSES TO AIM AT FATAL SPOTS!";
    String spellType = "SUPPORT";
    String statChange = "DAMAGE";

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
                this.manaCost = 3;
                break;
            case 4:
                this.manaCost = 4;
                break;
            case 5:
                this.manaCost = 5;
                break;
            case 6:
                this.manaCost = 6;
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
        return getRawDamage();
    }

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    @Override
    public int getRawDamage() {
        return this.damage + this.level;
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
        return getRawStatValue() + (int) (Math.random() * this.level);
    }

    /**
     * getter method for raw stat change value
     *
     * @return raw stat change value
     */
    public int getRawStatValue() {
        switch (this.level) {
            case 1:
                this.attack = 2;
                break;
            case 2:
                this.attack = 3;
                break;
            case 3:
                this.attack = 5;
                break;
            case 4:
                this.attack = 7;
                break;
            case 5:
                this.attack = 10;
                break;
            case 6:
                this.attack = 14;
                break;
        }
        return this.attack;
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
        if (pLevel == 2) {
            this.level = 1;
            return true;
        } else if (pLevel == 7) {
            this.level = 2;
            return true;
        } else if (pLevel == 11) {
            this.level = 3;
            return true;
        } else if (pLevel == 16) {
            this.level = 4;
            return true;
        } else if (pLevel == 21) {
            this.level = 5;
            return true;
        } else if (pLevel == 27) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
