import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CharacterShould {
    @Test
    public void start_health_1000() {
        Character character = new Character();

        assertThat(character.health()).isEqualTo(1000);
    }
}
