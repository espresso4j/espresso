package io.github.espresso4j.espresso.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IoUtils {

    public static void copyStream(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[4096];
        while (in.read(buffer) > 0) {
            out.write(buffer);
        }
    }

}
