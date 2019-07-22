import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterShould {
    private Character character ;

    @Before
    public void setup() {
      this.character = new Character();
    }

    @Test
    public void start_health_1000() {
        assertThat(character.health()).isEqualTo(1000);
    }

    @Test
    public void start_level_is_1() {
        assertThat(character.level()).isEqualTo(1);
    }

    @Test
    public void start_alive() {
        assertThat(character.isAlive()).isTrue();
    }
    
    @Test 
    public void deal_damage_to_other_character() {
        Character otherCharacter = new Character();

        character.dealDamage(otherCharacter, 400);

        assertThat(otherCharacter.health()).isEqualTo(600);
    }
    
    @Test 
    public void die_when_health_is_zero() {
        Character otherCharacter = new Character();

        character.dealDamage(otherCharacter, 1001);

        assertThat(otherCharacter.isAlive()).isFalse();
    }
}
