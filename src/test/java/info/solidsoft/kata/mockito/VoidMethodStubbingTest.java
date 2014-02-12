package info.solidsoft.kata.mockito;

import org.mockito.exceptions.misusing.WrongTypeOfReturnValue;
import org.testng.annotations.Test;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.mock;

public class VoidMethodStubbingTest {

    @Test(expectedExceptions = NotEnoughEnergyException.class)
    public void shouldStubVoidMethod() {
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        willThrow(NotEnoughEnergyException.class).given(tacticalStationMock).firePhaser();

        tacticalStationMock.firePhaser();
    }

    @Test(expectedExceptions = WrongTypeOfReturnValue.class)
    public void shouldPassCompilationAndThrowExceptionInRuntimeOnWrongArgumentTypeWithWillReturn() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        willReturn(true).given(tacticalStationMock).getNumberOfTubes();
        //when
        tacticalStationMock.getNumberOfTubes();
        //then
        //exception expected
    }
}
