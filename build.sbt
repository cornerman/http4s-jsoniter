Global / onChangedBuildSource := IgnoreSourceChanges

inThisBuild(Seq(
  organization := "com.github.cornerman",

  crossScalaVersions := Seq("2.13.12", "3.3.0"),
  scalaVersion := crossScalaVersions.value.head,

  licenses := Seq("MIT License" -> url("https://opensource.org/licenses/MIT")),

  homepage := Some(url("https://github.com/cornerman/http4s-jsoniter")),

  scmInfo := Some(ScmInfo(
    url("https://github.com/cornerman/http4s-jsoniter"),
    "scm:git:git@github.com:cornerman/http4s-jsoniter.git",
    Some("scm:git:git@github.com:cornerman/http4s-jsoniter.git"))
  ),

  pomExtra :=
    <developers>
      <developer>
        <id>jkaroff</id>
        <name>Johannes Karoff</name>
        <url>https://github.com/cornerman</url>
      </developer>
    </developers>
))

lazy val commonSettings = Seq(
  libraryDependencies ++= (CrossVersion.partialVersion(scalaVersion.value) match {
    case Some((3, _)) => Seq.empty
    case _ => Seq(compilerPlugin("org.typelevel" % "kind-projector" % "0.13.2" cross CrossVersion.full))
  }),
)

lazy val core = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .enablePlugins(ScalaJSPlugin)
  .settings(commonSettings)
  .settings(
    name := "http4s-jsoniter",
    libraryDependencies ++= Seq(
      "org.http4s"                            %% "http4s-core"             % "0.23.24",
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"     % "2.28.0",
    ),
  )
