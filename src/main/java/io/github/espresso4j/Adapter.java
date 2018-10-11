package io.github.espresso4j;

public interface Adapter {

    void start(Espresso app, BaseAdapterOptions options);

    void stop();

}
