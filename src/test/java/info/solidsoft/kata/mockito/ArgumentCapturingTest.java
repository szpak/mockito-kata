package info.solidsoft.kata.mockito;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArgumentCapturingTest {

    private static final int TEST_MINIMUM_RANGE = 100000;
    private static final int TEST_NUMBER_OF_PHASERS = 2;

    @Test
    public void shouldAllowToAssertCapturedArgument() {
        //given
        TacticalStation tacticalStationMock = mock(TacticalStation.class);
        ShipSearchCriteria searchCriteria = new ShipSearchCriteria(TEST_MINIMUM_RANGE, TEST_NUMBER_OF_PHASERS);
        //when
        tacticalStationMock.findNumberOfShipsInRangeByCriteria(searchCriteria);
        //then
        ArgumentCaptor<ShipSearchCriteria> captor = ArgumentCaptor.forClass(ShipSearchCriteria.class);
        verify(tacticalStationMock).findNumberOfShipsInRangeByCriteria(captor.capture());
        ShipSearchCriteria usedSearchCriteria = captor.getValue();
        assertThat(usedSearchCriteria.getMinimumRange()).isEqualTo(100000);
        assertThat(usedSearchCriteria.getNumberOfPhasers()).isEqualTo(2);
    }
}
