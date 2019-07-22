public class Character {
    private final int MAX_HEALTH = 1000;
    private final int MIN_HEALTH = 0;

    private final int START_HEALTH = 1000;
    private final int START_LEVEL = 1;

    private int health;

    public Character() {
        this.health = START_HEALTH;
    }

    public int health() {
        return this.health;
    }

    public int level() {
        return START_LEVEL;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void dealDamage(Character character, int damage) {
        if(character.equals(this))
            return;

        character.health -= damage;

        if (character.health < MIN_HEALTH)
            character.health = MIN_HEALTH;
    }

    public void heal(int health) {
        if (!this.isAlive())
            return;

        this.health += health;

        if (this.health > MAX_HEALTH)
            this.health = MAX_HEALTH;
    }
}
