class KakashiHatake extends Character {
    public KakashiHatake() {
        super("Kakashi Hatake", 90, 9, 30);
    }

    @Override
    public void useAbility(Character target) {
        System.out.println(name + " uses Chidori on " + target.getName());
        int chidoriDamage = 50;
        target.takeDamage(chidoriDamage);
    }
}