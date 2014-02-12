package info.solidsoft.kata.mockito;

import org.mockito.Mockito;
import org.mockito.exceptions.verification.SmartNullPointerException;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

//WARNING. These examples break Demeter Law. Usually in a good refactored code it is not necessary to use deep stubs
public class DefaultValuesTest {

    private static final int EXPECTED_NUMBER_OF_TUBES = 5;

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldNotAllowForDeepStubbingByDefault() {
        //given
        SpaceShip spaceShipMock = mock(SpaceShip.class);
        given(spaceShipMock.getTacticalStation().getNumberOfTubes()).willReturn(EXPECTED_NUMBER_OF_TUBES);
        //when
        spaceShipMock.getTacticalStation().getNumberOfTubes();
        //then
        //exception expected
    }

    @Test
    public void shouldAllowForDeepStubbingWhenEnabled() {
        //given
        SpaceShip spaceShipMock = mock(SpaceShip.class, Mockito.RETURNS_DEEP_STUBS);
        given(spaceShipMock.getTacticalStation().getNumberOfTubes()).willReturn(5);
        //when
        int readNumberOfTubes = spaceShipMock.getTacticalStation().getNumberOfTubes();
        //then
        assertThat(readNumberOfTubes).isEqualTo(EXPECTED_NUMBER_OF_TUBES);
    }

    @Test(expectedExceptions = SmartNullPointerException.class)
    public void shouldReturnNicerErrorMessageOnNPE() {
        OperationsStation operationsStationMock = mock(OperationsStation.class, Mockito.RETURNS_SMART_NULLS);
        SpaceShip nullableShip = new SpaceShip(mock(TacticalStation.class), operationsStationMock);

        nullableShip.generateNPE();
    }
}
