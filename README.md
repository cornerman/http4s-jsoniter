# http4s-jsoniter

EntityEncoder and EntityDecoder for jsoniter in http4s.

## Get started

Get latest release:
```scala
libraryDependencies += "com.github.cornerman" %% "http4s-jsoniter" % "0.1.2"
```

We additonally publish snapshot releases for every commit.

## Example usage

Import the encoder and decoder using Array[Byte] for reading and writing with jsoniter:
```scala
import http4sJsoniter.ArrayEntityCodec._
```

Import the encoder and decoder based on java `InputStream` and `OutputStream` for reading and writing with jsoniter:
```scala
import http4sJsoniter.JavaIOStreamEntityCodec._
```

TODO: configuring ReaderConfig and WriterConfig

# References

For a more generic approach based on chameleon that supports multiple serialization libraries, checkout the `chameleon-http4s` package: https://github.com/cornerman/chameleon.
