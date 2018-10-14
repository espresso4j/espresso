package io.github.espresso4j.espresso;

import java.util.function.Consumer;

/**
 *
 */
public interface Espresso {

    Response call(Request request);

    default void call(Request request, Consumer<Response> sendResponse, Consumer<Exception> raiseException){
        throw new UnsupportedOperationException("Async handler not implemented");
    };

}
