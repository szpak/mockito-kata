package info.solidsoft.kata.mockito;

import org.mockito.InOrder;
import org.testng.annotations.Test;

import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.Mockito.*;

@Test
public class VerificationTest {

    public void shouldVerifyMethodCalls() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        OperationsStation operationsStation = mock(OperationsStation.class);
        //when
        operationsStation.doSelfCheck();
        tacticalStationMock.doSelfCheck();
        operationsStation.doSelfCheck();
        //then
        verify(tacticalStationMock).doSelfCheck();
        verify(operationsStation, times(2)).doSelfCheck();
    }

    public void shouldVerifyInOrderThroughDifferentMocks() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        OperationsStation operationsStation = mock(OperationsStation.class);
        //when
        operationsStation.doSelfCheck();
        tacticalStationMock.doSelfCheck();
        operationsStation.doSelfCheck();
        //then
        InOrder inOrder = inOrder(tacticalStationMock, operationsStation);
        inOrder.verify(operationsStation).doSelfCheck();
        inOrder.verify(tacticalStationMock).doSelfCheck();
        inOrder.verify(operationsStation).doSelfCheck();
    }

    public void shouldVerifyWithSimpleArgumentMatching() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        //when
        tacticalStationMock.fireTorpedo(5);
        //then
        verify(tacticalStationMock).fireTorpedo(gt(3));
    }
}
