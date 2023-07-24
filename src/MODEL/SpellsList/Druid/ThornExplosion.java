package MODEL.SpellsList.Druid;

import MODEL.SpellsList.Spells;

public class ThornExplosion implements Spells {

    String name = "THORN EXPLOSION";
    int manaCost = 6;
    int damage = 7;
    int misfire = 20;
    int level = 0;
    String target = "ENEMY";
    String desc = "CREATE A HAPHAZARD ASSORTMENT OF EXPLODER FLOWERS FOR YOUR UNGRATEFUL VISITORS!";
    String spellType = "OFFENSIVE";
    String statChange = null;

    /**
     * constructor
     */
    public ThornExplosion() {
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
        int val = this.manaCost;
        switch (this.level) {
            case 1:
                val = 6;
                break;
            case 2:
                val = 8;
                break;
            case 3:
                val = 12;
                break;
            case 4:
                val = 15;
                break;
            case 5:
                val = 19;
                break;
            case 6:
                val = 25;
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
        return (int) ((Math.random() * getRawDamage()) + 1 * 2.3);
    }

    /**
     * getter method for raw spell damage
     * @return raw spell damage
     */
    public int getRawDamage() {
        int val = this.damage;
        switch (this.level) {
            case 1:
                val = 7;
                break;
            case 2:
                val = 15;
                break;
            case 3:
                val = 24;
                break;
            case 4:
                val = 36;
                break;
            case 5:
                val = 45;
                break;
            case 6:
                val = 54;
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
     * @return raw stat change value
     */
    public int getRawStatValue() {
        return 0;
    }

    /**
     * run spell
     *
     * @return 0 if miss, >0 for damage
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
            this.level =1;
            return true;
        } else if (pLevel == 11) {
            this.level =2;
            return true;
        } else if (pLevel == 17) {
            this.level =3;
            return true;
        } else if (pLevel == 22) {
            this.level =4;
            return true;
        } else if (pLevel == 26) {
            this.level =5;
            return true;
        } else if (pLevel == 30) {
            this.level =6;
            return true;
        }
        return false;
    }
}
