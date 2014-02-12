package info.solidsoft.kata.mockito;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@Test
public class ConsecutiveCallsStubbingTest {

    public void shouldStubConsecutiveCalls() {
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        given(tacticalStationMock.getNumberOfEnemyShipsInRange()).willReturn(0, 1, 2);

        assertThat(tacticalStationMock.getNumberOfEnemyShipsInRange()).isEqualTo(0);
        assertThat(tacticalStationMock.getNumberOfEnemyShipsInRange()).isEqualTo(1);
        assertThat(tacticalStationMock.getNumberOfEnemyShipsInRange()).isEqualTo(2);
    }

    public void shouldReturnLastDefinedValueConsistently() {
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        given(tacticalStationMock.getNumberOfEnemyShipsInRange()).willReturn(2, 3);

        assertThat(tacticalStationMock.getNumberOfEnemyShipsInRange()).isEqualTo(2);
        assertThat(tacticalStationMock.getNumberOfEnemyShipsInRange()).isEqualTo(3);
        assertThat(tacticalStationMock.getNumberOfEnemyShipsInRange()).isEqualTo(3);
    }
}
