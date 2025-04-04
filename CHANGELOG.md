# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [7.0.4] - 2022-02-15

### Fixed

- Removing the `provided` for JWT API from [@ndeverge](https://github.com/ndeverge).

## [7.0.3] - 2022-02-07

### Changed

- Updated Atlassian JWT dependencies to address [CVE-2021-27568](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2021-27568) from [@lenin122](https://github.com/lenin122)
- Upgrading Play framework version to 2.8.13 from [@ndeverge](https://github.com/ndeverge).

## [7.0.2] - 2021-12-02

### Added

- Commit steps to PUBLISHING.md from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- Snapshot management to PUBLISHING.md from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).

### Changed

- Spacing to v7.0.1 sections from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- Play framework version to 2.8.11 (note that Play 2.8.10 introduces a binary incompatibility by updating scala-java8-compat as pointed out by [@zmerr](https://github.com/zmerr)) from [@ndeverge](https://github.com/ndeverge).

## [7.0.1] - 2021-11-27

### Security

- Updated Atlassian JWT dependencies to address [CVE-2019-17195](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2019-17195) from [@dspasojevic](https://github.com/dspasojevic).
- Upgrading to Play 2.8.8 to address [CVE-2020-12480](https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2020-12480) from [@ndeverge](https://github.com/ndeverge).

### Fix

- Explicit [Sonatype repository publishing links](https://s01.oss.sonatype.org/) for each silhouette module build.sbt file to adhere to changes outlined [by Sonatype](https://central.sonatype.org/publish/publish-guide/#releasing-to-central) from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).

### Added

- Migration from TravisCI to GitHub script from [@ndeverge](https://github.com/ndeverge).
- Cross compilation on CI from [@ndeverge](https://github.com/ndeverge).
- Notes on running startup scripts with sbt v1.5.x from [@ndeverge](https://github.com/ndeverge).
- Argon2 password hasher from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- Argon2 password hasher tests from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- v7.0.0 release notes to CHANGELOG.md from [@ndeverge](https://github.com/ndeverge).
- PUBLISHING.md outline to explain how libraries are release from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- Installation information to README.md from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).

### Changed

- CHANGELOG.md to [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) format for new releases from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- CONTRIBUTING.md to have up to date information and links from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- Maven publishing information from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).
- Version to 7.0.1-SNAPSHOT from [@honeycomb-cheesecake](https://github.com/honeycomb-cheesecake).

## [7.0.0]

- Update to Play 2.8.1

## [6.0.1]

- Update to Play 2.7.3
- Add support for Scala 2.13

## [6.0]

- Update to Play 2.7

## [5.0]

- Update to Play 2.6
- Handling of OAuth2 based user state with the help of the new social state handler implementation (thanks to @Saheb)
- Implement BCryptSha256PasswordHasher to avoid password truncating issue
- Better error messages for OAuth2 based errors
- Remove Clef support

## [4.0] - 2016-07-14

- Update to Play 2.5
- Removed Play Messages instance from Event, Authorization and ErrorHandler types. The I18nSupport trait should be used instead, to get the Messages instance for the current request
- Rewrite Silhouette trait to provide injectable actions (this is now the default method from Play 2.5 on)
  - Every SecuredAction can now override the global(default injected) error handler if needed
  - A controller is not bound to a single Authenticator anymore
- Remove SecuredErrorHandler in favour of injectable error handler
- Pass the auth info to the profile parsers to easier query additional data from the provider API
- Add UnsecuredRequestHandler and UnsecuredAction
- Dropped Scala 2.10 support
- Projects separated
  - silhouette-password-bcrypt -> contains BCrypt password hasher
  - silhouette-persistence -> contains base implementations for the persistence layer
  - silhouette-persistence-memory -> in-memory implementation of the persistence layer
- Use request extractors to find authenticator values in other parts of the request
- Fix overriding settings method for Providers (thanks @felipefzdz)
- Allow to override the API URL in the OAuth1 and OAuth2 providers
- Allow to override authentication provider constants
- Support for Auth0 authentication provider (thanks @lucamilanesio)
- Support for Gitlab authentication provider (thanks @ThmX)
- Support for CAS authentication provider (thanks @SBSMMO)
- Issue #435: copy customClaims when renewing JWTToken (thanks @mizerlou)
- Define meaningful interface for password re-hashing (thanks @alexmojaki)
- Play Framework independent crypto implementation

## [3.0] - 2015-07-14

- Update to Play 2.4
- Stateless and non-stateless CookieAuthenticator
- Allow to customize the Gravatar service
- Use scala.concurrent.duration.FiniteDuration instead of Int for duration based values
- A lot of API enhancements

## [2.0] - 2015-03-28

- Use lazy val to initialize SecureRandom, so that initialization occurs also async
- Refactor authenticators and add BearerTokenAuthenticator, JWTAuthenticator, SessionAuthenticator and DummyAuthenticator
- Better error handling for authenticators
- Authenticators now using an extra backing store instead of only the cache
- Split up SocialProvider.authenticate method into authenticate and retrieveProfile methods
- Remove authInfo from SocialProfile
- Add OAuth1 token secret implementation
- Add OAuth2 state implementation
- Documentation is now included in the repository and hosted on Read The Docs
- Renamed packages "core" to "api", "contrib" to "impl", "utils" to "util"
- Reorganized the project structure (moved all providers into the "impl" package, moved some classes/traits)
- Add request handlers
- Add request providers in combination with HTTP basic auth provider
- Add Dropbox provider
- Add Clef provider
- Add request extractors
- Better social profile builder implementation
- Add OpenID providers Steam and Yahoo
- Better error handling

## [1.0] - 2014-06-12

- First release for Play 2.3

## [0.9] 2014-06-12

- First release for Play 2.2
