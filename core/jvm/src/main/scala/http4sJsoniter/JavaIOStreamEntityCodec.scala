package http4sJsoniter

import http4sJsoniter.CodeUtil.decodeResultFailure

import cats.effect.Async
import cats.implicits._
import com.github.plokhotnyuk.jsoniter_scala.core.{readFromStream, writeToStream, JsonValueCodec}
import org.http4s.headers.`Content-Type`
import org.http4s.{DecodeResult, Entity, EntityDecoder, EntityEncoder, Headers, MediaType}

object JavaIOStreamEntityCodec {

  implicit def entityDecoder[F[_]: Async, A](implicit codec: JsonValueCodec[A]): EntityDecoder[F, A] =
    EntityDecoder.decodeBy[F, A](MediaType.application.json) { msg =>
      DecodeResult(fs2.io.toInputStreamResource(msg.body).use { is =>
        Async[F]
          .delay(readFromStream[A](is))
          .redeem(
            error => Left(decodeResultFailure(error)),
            value => Right(value),
          )
      })
    }

  implicit def entityEncoder[F[_]: Async, A](implicit codec: JsonValueCodec[A]): EntityEncoder[F, A] =
    EntityEncoder.encodeBy[F, A](Headers(`Content-Type`(MediaType.application.json))) { msg =>
      Entity(fs2.io.readOutputStream(1024) { os =>
        Async[F].delay(writeToStream(msg, os))
      })
    }
}
