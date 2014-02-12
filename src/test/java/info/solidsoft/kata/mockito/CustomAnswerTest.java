package info.solidsoft.kata.mockito;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;

@Test
public class CustomAnswerTest {

    public void shouldReturnTheFirstGivenArgument() {
        //given
        Navigation navigationMock = mock(Navigation.class);
        given(navigationMock.returnFasterCourse(any(Course.class), any(Course.class)))
                .will(ReturnFirstArgumentAnswer.returnFirstArgument());
        Course course1 = new Course();
        Course course2 = new Course();
        //when
        Course returnedCourse = navigationMock.returnFasterCourse(course1, course2);
        //then
        assertThat(returnedCourse).isEqualTo(course1);
    }
}

