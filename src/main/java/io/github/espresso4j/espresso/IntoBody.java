package io.github.espresso4j.espresso;

import io.github.espresso4j.espresso.internal.IoUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public interface IntoBody {

    void into(OutputStream outputStream) throws IOException;

    class StringBody implements IntoBody {

        private String body;

        StringBody(String body) {
            this.body = body;
        }

        @Override
        public void into(OutputStream outputStream) throws IOException {
            outputStream.write(body.getBytes(StandardCharsets.UTF_8));
        }

        @Override
        public String toString() {
            return "StringBody{" +
                    "body='" + body + '\'' +
                    '}';
        }
    }

    class FileBody implements IntoBody {
        private File body;

        FileBody(File body) {
            this.body = body;
        }

        @Override
        public void into(OutputStream outputStream) throws IOException {
            try (InputStream in = new BufferedInputStream(new FileInputStream(this.body))) {
                IoUtils.copyStream(in, outputStream);
            }
        }

        @Override
        public String toString() {
            return "FileBody{" +
                    "body=" + body +
                    '}';
        }
    }

    class StreamBody implements IntoBody {
        private InputStream body;

        StreamBody(InputStream in) {
            this.body = in;
        }

        @Override
        public void into(OutputStream outputStream) throws IOException {
            try ( InputStream in = this.body ) {
                IoUtils.copyStream(in, outputStream);
            }
        }

        @Override
        public String toString() {
            return "StreamBody{" +
                    "body=" + body +
                    '}';
        }
    }

    static IntoBody from(String s) {
        return new StringBody(s);
    }

    static IntoBody from(File file) {
        return new FileBody(file);
    }

    static IntoBody from(InputStream in) {
        return new StreamBody(in);
    }


}
