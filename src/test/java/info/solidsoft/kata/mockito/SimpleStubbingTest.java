package info.solidsoft.kata.mockito;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SimpleStubbingTest {

    private static final int TEST_NUMBER_OF_TORPEDO_TUBES = 2;

    @Test
    public void shouldReturnGivenValue() {
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        when(tacticalStationMock.getNumberOfTubes()).thenReturn(TEST_NUMBER_OF_TORPEDO_TUBES);

        int numberOfTubes = tacticalStationMock.getNumberOfTubes();

        assertThat(numberOfTubes).isEqualTo(TEST_NUMBER_OF_TORPEDO_TUBES);
    }

    @Test
    public void shouldReturnGivenValueUsingBDDNotation() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        given(tacticalStationMock.getNumberOfTubes()).willReturn(TEST_NUMBER_OF_TORPEDO_TUBES);
        //when
        int numberOfTubes = tacticalStationMock.getNumberOfTubes();
        //then
        assertThat(numberOfTubes).isEqualTo(TEST_NUMBER_OF_TORPEDO_TUBES);
    }
}
