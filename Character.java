public abstract class Character {
    protected String name;
    protected int health;
    protected int armor;
    protected int attackPower;
    
    public Character(String name, int health, int armor, int attackPower) {
        this.name = name;
        this.health = health;
        this.armor = armor;
        this.attackPower = attackPower;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        int damageReduction = armor / 2; // Armor blocks only 50% of its value
        int damageTaken = Math.max(damage - damageReduction, 1); // Ensure minimum 1 damage
        health -= damageTaken;
        if (health < 0) health = 0;
        System.out.println(name + " took " + damageTaken + " damage. Health: " + health);
    }
    

    public void heal(int healAmount) {
        health += healAmount;
        System.out.println(name + " healed for " + healAmount + ". Health: " + health);
    }

    public abstract void useAbility(Character target);

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName());
        target.takeDamage(attackPower);
    }

    public boolean isAlive() {
        return health > 0;
    }
}