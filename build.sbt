/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import sbt.Keys._
import sbt._

val silhouette = Project(
  id = "play-silhouette",
  base = file("silhouette")
)

val silhouetteCas = Project(
  id = "play-silhouette-cas",
  base = file("silhouette-cas"),
  dependencies = Seq(silhouette % "compile->compile;test->test")
)

val silhouetteTotp = Project(
  id = "play-silhouette-totp",
  base = file("silhouette-totp"),
  dependencies = Seq(silhouette % "compile->compile;test->test")
)

val silhouetteCryptoJca = Project(
  id = "play-silhouette-crypto-jca",
  base = file("silhouette-crypto-jca"),
  dependencies = Seq(silhouette)
)

val silhouettePasswordArgon2 = Project(
  id = "play-silhouette-password-argon2",
  base = file("silhouette-password-argon2"),
  dependencies = Seq(silhouette)
)

val silhouettePasswordBcrypt = Project(
  id = "play-silhouette-password-bcrypt",
  base = file("silhouette-password-bcrypt"),
  dependencies = Seq(silhouette)
)

val silhouettePersistence = Project(
  id = "play-silhouette-persistence",
  base = file("silhouette-persistence"),
  dependencies = Seq(silhouette)
)

val silhouetteTestkit = Project(
  id = "play-silhouette-testkit",
  base = file("silhouette-testkit"),
  dependencies = Seq(silhouette)
)

val root =
  project.in(file("."))
    .enablePlugins(ScalaUnidocPlugin)
    .settings(
      Defaults.coreDefaultSettings,
      APIDoc.settings,
      publishLocal := {},
      publishM2 := {},
      publishArtifact := false
    )
    .aggregate(
      silhouette,
      silhouetteCas,
      silhouetteTotp,
      silhouetteCryptoJca,
      silhouettePasswordArgon2,
      silhouettePasswordBcrypt,
      silhouettePersistence,
      silhouetteTestkit
    )

val repo: String = "https://s01.oss.sonatype.org"
publishTo := {
  if(version.value.endsWith("-SNAPSHOT")) {
    Some("Sonatype Nexus Repository Manager" at s"$repo/content/repositories/snapshots/")
  }
  else {
    Some("Sonatype Nexus Repository Manager" at s"$repo/service/local/staging/deploy/maven2/")
  }
}
