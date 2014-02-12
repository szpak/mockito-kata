package info.solidsoft.kata.mockito;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JustToPassTest {

    @Test
    public void shouldPass() {
        assertThat(true).isTrue();
    }
}
