package info.solidsoft.kata.mockito;

import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertEquals;

@Test
public class SpyingRealObjectTest {

    private static final int ORIGINAL_COORDINATE1 = 142;
    private static final int NEW_COORDINATE1 = 210;

    public void shouldNotCallOriginalMethod() {
        //given
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> spiedList = spy(list);
        willReturn(3).given(spiedList).get(0);
        //when
        Integer readValue = spiedList.get(0);
        //then
        assertThat(readValue).isEqualTo(3);
    }

    public void shouldStubMethodAndCallRealNotStubbedMethod() {
        //given
        Course realCourse = new Course();
        realCourse.setCordinate1(ORIGINAL_COORDINATE1);
        Course courseSpy = spy(realCourse);
        willDoNothing().given(courseSpy).setCordinate1(anyInt());

        //when
        courseSpy.setCordinate1(NEW_COORDINATE1); //stubbed - should do nothing

        //then
        verify(courseSpy).setCordinate1(NEW_COORDINATE1);
        assertEquals(courseSpy.getCoordinate1(), ORIGINAL_COORDINATE1); //value was not changed
    }

}
