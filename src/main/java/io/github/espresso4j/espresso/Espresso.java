package io.github.espresso4j.espresso;

import java.util.function.Consumer;

/**
 * The core function of Espresso.
 *
 * It take a request object and returns a response.
 * 
 */
@FunctionalInterface
public interface Espresso {

    Response call(Request request);

    @FunctionalInterface
    interface Async {
        void call(Request request, Consumer<Response> sendResponse, Consumer<Exception> raiseException);
    }
}
