package info.solidsoft.kata.mockito;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class AnnotationTest {

    @Mock
    private TacticalStation tacticalStationMock;

    @Spy
    private OperationsStation operationsStationSpy;

    @InjectMocks
    private SpaceShip excelsior;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    public void shouldVerifyVariousAnnotationFeatures() {
        assertThat(tacticalStationMock).isNotNull();
        assertThat(operationsStationSpy).isNotNull();
        assertThat(excelsior.getTacticalStation()).isEqualTo(tacticalStationMock);
        assertThat(excelsior.getOperationsStation()).isEqualTo(operationsStationSpy);
    }
}
