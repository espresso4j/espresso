package io.github.espresso4j.espresso;

public interface Adapter {

    void start(Espresso app) throws Exception;

    void stop() throws Exception;

}
