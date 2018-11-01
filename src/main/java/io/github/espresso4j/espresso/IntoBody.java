package io.github.espresso4j.espresso;

import io.github.espresso4j.espresso.internal.IoUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public interface IntoBody<T> {

    T get();

    void into(OutputStream outputStream) throws IOException;

    abstract class IntoBodyAdapter<T> implements IntoBody<T> {
        T body;

        @Override
        public T get() {
            return body;
        }

    }

    class StringBody extends IntoBodyAdapter<String> {

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

    class FileBody extends IntoBodyAdapter<File> {
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

    class StreamBody extends IntoBodyAdapter<InputStream> {
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

    class StringIteratorBody extends IntoBodyAdapter<Iterator<String>> {
        StringIteratorBody(Iterator<String> iterator) {
            this.body = iterator;
        }

        @Override
        public void into(OutputStream outputStream) throws IOException {
            while (body.hasNext()) {
                outputStream.write(body.next().getBytes(StandardCharsets.UTF_8));
            }
        }

        @Override
        public String toString() {
            return "StringIteratorBody{" +
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

    static IntoBody from(Iterator<String> strs) {
        return new StringIteratorBody(strs);
    }
}
