class ObitoUchiha extends Character {
    public ObitoUchiha() {
        super("Obito Uchiha", 100, 15, 25);
    }

    @Override
    public void useAbility(Character target) {
        System.out.println(name + " uses Kamui on " + target.getName());
        System.out.println(target.getName() + " cannot attack Obito this turn.");
    }
}