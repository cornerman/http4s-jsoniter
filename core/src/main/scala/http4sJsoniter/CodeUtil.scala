package http4sJsoniter

import org.http4s.{DecodeFailure, MalformedMessageBodyFailure}

private object CodeUtil {
  def decodeResultFailure(error: Throwable): DecodeFailure = MalformedMessageBodyFailure("Invalid JSON", Some(error))
}
