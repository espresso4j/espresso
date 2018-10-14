package io.github.espresso4j.espresso;

import java.util.function.Consumer;

/**
 *
 */
public interface Espresso {

    Response call(Request request);

    interface Async {
        void call(Request request, Consumer<Response> sendResponse, Consumer<Exception> raiseException);
    }
}
