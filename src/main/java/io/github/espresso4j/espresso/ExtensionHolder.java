package io.github.espresso4j.espresso;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds some extension that middlewares write into.
 *
 * Extensions are keyed by the middleware class.
 */
public class ExtensionHolder {

    Map<Class<?>, Object> extensions = new HashMap<>();

    /**
     * Get the stored extensions
     *
     * @return the map of extensions
     */
    @Nonnull
    public Map<Class<?>, Object> extensions() {
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
