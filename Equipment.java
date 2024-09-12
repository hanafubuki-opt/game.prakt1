class Equipment {
    private String name;
    private int healthBonus;
    private int armorBonus;
    private int attackBonus;

    public Equipment(String name, int healthBonus, int armorBonus, int attackBonus) {
        this.name = name;
        this.healthBonus = healthBonus;
        this.armorBonus = armorBonus;
        this.attackBonus = attackBonus;
    }

    public void equip(Character character) {
        System.out.println(character.getName() + " equips " + name);
        character.health += healthBonus;
        character.armor += armorBonus;
        character.attackPower += attackBonus;
    }
}