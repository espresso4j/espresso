# espresso

[![Maven Central](https://img.shields.io/maven-central/v/io.github.espresso4j/espresso.svg)](https://search.maven.org/artifact/io.github.espresso4j/espresso)
[![Javadocs](http://www.javadoc.io/badge/io.github.espresso4j/espresso.svg)](http://www.javadoc.io/doc/io.github.espresso4j/espresso)
[![Travis (.org)](https://img.shields.io/travis/espresso4j/espresso.svg)](https://travis-ci.org/espresso4j/espresso)
![GitHub](https://img.shields.io/github/license/espresso4j/espresso.svg)
[![Liberapay patrons](https://img.shields.io/liberapay/patrons/Sunng.svg)](https://liberapay.com/Sunng/donate)

Web application from a function. The soul of modern Java web
application.

## Rationale

The idea of Espresso is inspired from Ring (Clojure), Iron (Rust) and
WSGI (Python). Espresso defined a protocol between web
application/framework and web server. It tries to replace Servlet API,
which is heavy, verbose, complex and not friendly for unit-test.

Key concept of espresso ecosystem:

* *App*: Espresso function implementation.
* *Server*: A container to run espresso function.
* *Adapter*: A adapter layer for existed Java web server to run
  espresso function.
* *Plugin or Middleware*: An espresso function wrapper that provides
  additional features or data to core espresso function.

## Usage

The core of Espresso is an Java interface `Espresso`, which has only
one method that takes a `Request` as input, and returns a `Response`.

With Java's functional interface feature, the implementation can be as
short as a lambda.

```java
import io.github.espresso4j.espresso.*;

// ...

var app = (req) -> Response.of(200).body("<h1>It works</h1>");
```

The web app will always return a page says `It works`.

Espresso also provides an async variance called `Espresso.Async` if
your application is fully asynchronous:

```java

// ...
import io.github.espresso4j.espresso.*;

// ...

var app = (req, sender, raiser) ->
        sender.accept(Response.of(200).body("<h1>It works</h1>"));
```

## Espresso Echosystem

* [Jettino](https://github.com/espresso4j/jettino) An espresso adapter
  for Jetty
* [Latte](https://github.com/espresso4j/latte) An espresso url router

## License

See [license](https://github.com/espresso4j/espresso/blob/master/LICENSE)
