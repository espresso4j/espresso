package io.github.espresso4j;

import java.util.function.Consumer;

/**
 *
 */
public interface Espresso {

    Response call(Request request) throws Exception;

    void call(Request request, Consumer<Response> sendResponse, Consumer<Exception> raiseException);

}
