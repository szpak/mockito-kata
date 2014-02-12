package info.solidsoft.kata.mockito;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static info.solidsoft.kata.mockito.TacticalStation.TubeStatus;

@Test
public class ArgumentMatchingTest {

    public void shouldMatchSimpleArgument() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        given(tacticalStationMock.getTubeStatus(1)).willReturn(TubeStatus.LOADING);
        //when
        TubeStatus tube1Status = tacticalStationMock.getTubeStatus(1);
        TubeStatus tube2Status = tacticalStationMock.getTubeStatus(2);
        //then
        assertThat(tube1Status).isEqualTo(TubeStatus.LOADING);
        assertThat(tube2Status).isEqualTo(null);    //default value for enums
    }

    public void shouldMatchWithMatchers() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        given(tacticalStationMock.smellyFindNumberOfShipsInRangeByCriteria(anyInt(), contains("fiant"), eq(4))).willReturn(1);
//        //incorrect - would throw an exception
//        given(tacticalStationMock.smellyFindNumberOfShipsInRangeByCriteria(anyInt(), contains("fiant"), 4)).willReturn(1);

        //when
        int result = tacticalStationMock.smellyFindNumberOfShipsInRangeByCriteria(5, "Defiant", 4);

        //then
        assertThat(result).isEqualTo(1);
    }
}
