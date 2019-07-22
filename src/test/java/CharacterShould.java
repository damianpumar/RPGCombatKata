import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterShould {

    @Test
    public void start_health_1000() {
        Character character = new Character();
        assertThat(character.health()).isEqualTo(1000);
    }

    @Test
    public void start_level_is_1() {
        Character character = new Character();
        assertThat(character.level()).isEqualTo(1);
    }

    @Test
    public void start_alive() {
        Character character = new Character();
        assertThat(character.isAlive()).isTrue();
    }

    @Test
    public void deal_damage_to_other_character() {
        Character otherCharacter = getCharacterWithDamageOf(400);
        assertThat(otherCharacter.health()).isEqualTo(600);
    }

    @Test
    public void not_deal_damage_to_itself(){
        Character character = new Character();
        character.dealDamage(character, 400);
        assertThat(character.health()).isEqualTo(1000);
    }

    @Test
    public void die_when_health_is_zero() {
        Character otherCharacter = getCharacterWithDamageOf(1001);
        assertThat(otherCharacter.isAlive()).isFalse();
    }

    @Test
    public void have_health_zero_when_damage_received_exceeds_current_health() {
        Character otherCharacter = getCharacterWithDamageOf(1001);
        assertThat(otherCharacter.health()).isEqualTo(0);
    }

    @Test
    public void heal_other_character() {
        Character character = new Character();

        Character otherCharacter = getCharacterWithDamageOf(100);

        character.heal(otherCharacter, 50);

        assertThat(otherCharacter.health()).isEqualTo(950);
    }

    @Test
    public void not_heal_character_when_is_dead() {
        Character character = new Character();

        Character otherCharacter = getCharacterWithDamageOf(1001);

        character.heal(otherCharacter, 50);

        assertThat(otherCharacter.health()).isEqualTo(0);
    }

    @Test
    public void not_heal_above_1000() {
        Character character = new Character();
        Character otherCharacter = new Character();

        character.heal(otherCharacter, 50);

        assertThat(otherCharacter.health()).isEqualTo(1000);
    }

    private Character getCharacterWithDamageOf(int damage) {
        Character newCharacter = new Character();
        Character damagingCharacter = new Character();

        damagingCharacter.dealDamage(newCharacter, damage);
        return newCharacter;
    }
}
