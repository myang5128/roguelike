package MODEL.SpellsList.Knight;

import MODEL.SpellsList.Spells;

public class BladeSlash implements Spells {
    String name = "BLADE SLASH";
    int manaCost = 3;
    int damage = 3;
    int misfire = 8;
    int level = 0;
    String target = "ENEMY";
    String desc = "UNLEASH A TORRENT OF PRECISE BLADE STRIKES AGAINST YOUR ENEMY!";
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
                this.manaCost = 3;
                break;
            case 2:
                this.manaCost = 5;
                break;
            case 3:
                this.manaCost = 7;
                break;
            case 4:
                this.manaCost = 10;
                break;
            case 5:
                this.manaCost = 12;
                break;
            case 6:
                this.manaCost = 15;
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
        return (int) ((Math.random() * getRawDamage() + 1) * 1.5);
    }

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    @Override
    public int getRawDamage() {
        switch (this.level) {
            case 1:
                this.damage = 3;
                break;
            case 2:
                this.damage = 6;
                break;
            case 3:
                this.damage = 10;
                break;
            case 4:
                this.damage = 16;
                break;
            case 5:
                this.damage = 21;
                break;
            case 6:
                this.damage = 27;
                break;
        }
        return this.damage;
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
        if (pLevel == 5) {
            this.level = 1;
            return true;
        } else if (pLevel == 8) {
            this.level = 2;
            return true;
        } else if (pLevel == 11) {
            this.level = 3;
            return true;
        } else if (pLevel == 15) {
            this.level = 4;
            return true;
        } else if (pLevel == 22) {
            this.level = 5;
            return true;
        } else if (pLevel == 30) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
