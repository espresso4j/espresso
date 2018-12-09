package io.github.espresso4j.espresso;

import io.lacuna.bifurcan.IMap;
import io.lacuna.bifurcan.LinearMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Holds some extension that middlewares write into.
 *
 * Extensions are keyed by the middleware class.
 */
public class ExtensionHolder {

    IMap<Class<?>, Object> extensions = new LinearMap<>();

    /**
     * Get the stored extensions
     *
     * @return the map of extensions
     */
    @Nonnull
    public IMap<Class<?>, Object> extensions() {
        return this.extensions;
    }

    /**
     * Get extension for a particular middleware
     *
     * @param clazz the key class
     * @return the extension object
     */
    @Nullable
    public Object extension(Class<?> clazz) {
        return this.extensions.get(clazz);
    }

    /**
     * Set extension
     *
     * @param clazz the extension class
     * @param value the value
     */
    public void extension(Class<?> clazz, Object value) {
        this.extensions.put(clazz, value);
    }

}
