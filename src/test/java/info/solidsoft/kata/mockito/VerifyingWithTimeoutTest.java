package info.solidsoft.kata.mockito;

import org.mockito.exceptions.base.MockitoAssertionError;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.fail;

public class VerifyingWithTimeoutTest {

    @Test
    public void shouldFailForLateCall() {
        //given
        OperationsStation operationsStationMock = mock(OperationsStation.class);
        Thread t = waitAndCallSelfCheck(40, operationsStationMock);

        //when
        t.start();

        //then
        verify(operationsStationMock, never()).doSelfCheck();
        try {
            verify(operationsStationMock, timeout(20)).doSelfCheck();
            fail("verification should fail");
        } catch (MockitoAssertionError e) {
            //expected
        }
    }

    private Thread waitAndCallSelfCheck(final int sleepInMillis, final OperationsStation operationsStationMock) {
        return new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(sleepInMillis);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                operationsStationMock.doSelfCheck();
            }
        };
    }
}
