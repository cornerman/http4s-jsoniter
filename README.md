# http4s-jsoniter

EntityEncoder and EntityDecoder for jsoniter in http4s.

## Get started

Get latest release:
```scala
libraryDependencies += "com.github.cornerman" %% "http4s-jsoniter" % "0.1.0"
```

We additonally publish snapshot releases for every commit.

## Example usage

Import the encoder and decoder using Array[Byte] for reading and writing with jsoniter:
```scala
import http4sJsoniter.ArrayEntityCodec._
```

Import the encoder and decoder based on java `InputStream` and `OutputStream` for reading and writing with jsoniter:
```scala
import http4sJsoniter.InputStreamEntityCodec._
```

TODO: configuring ReaderConfig and WriterConfig
