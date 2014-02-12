package info.solidsoft.kata.mockito;

import org.mockito.exceptions.base.MockitoException;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ReturnFirstArgumentAnswer implements Answer<Object> {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        if (arguments.length == 0) {
            throw new MockitoException("...");
        }
        return arguments[0];
    }

    public static ReturnFirstArgumentAnswer returnFirstArgument() {
        return new ReturnFirstArgumentAnswer();
    }
}
