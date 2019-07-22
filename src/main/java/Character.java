public class Character {
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
        character.health -= damage;

        if(character.health < 0)
            character.health = 0;
    }

    public void heal(Character character, int health) {
        character.health+=health;
    }
}
