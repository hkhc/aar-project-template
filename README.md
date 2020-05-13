# Android AAR Library Project Skeleton

You shall do the following before starting your own work.

- Fork the project in Github.

- `git clone` to directory of your name, and not the default name
  
  - `git clone http://githhub.com/hkhc/aar-project-skeleton <your-project-name`

- Change the copyright template name
  
  - In Android Studio, select "Preferences..." -> "Editor" -> "Copyright" -> "Copyright Profiles"
  
  - Fill in your name at [MyName], and optional change the profile name "ASL MyName". And of course you may change the license entirely.

- Change the AAR library details at `library-android\pom.yaml` directory.

- Make sure your gradle.properties somewhere (preferbly `.gradle/gradle.properties`) contains sufficient information for publishing

e.g.

```properties
# For GPG key for herman.kh.cheung@gmail.com
# https://central.sonatype.org/pages/working-with-pgp-ignatures.html
# Some PGP tools generates sub keys and use them for signing by default, 
# but to make Maven tools recognize the signature, you must use the 
# primary key to sign your artifacts.
# publish key : gpg --keyserver <server> --send-key <keyId>
# remove subkey : 
#    gpg --edit-keys <keyId>
#    key <number> (0-based)
#    delkey
#    save
# verify signature : gpg --verify <asc-file> <signed-file> 

# Gradle signing plugin accept GPGv1 keyring format natively, and not GPGv2 keybox
# format. So useGpgCmd() settings in build script must be used for key generated by
# GPGv2. 

# GPGv1 and GPGv2 can be coexist (at least on MacOS and Linux). So install both
# of them when we need to handle both type of keys
# Ref: https://dltn.hatenadiary.jp/entry/20170621/1498017747

# GNUPG v1 or v2 (one of them is sufficient)

# v1
signing.keyId=[short form key ID]
signing.password=[password of keyring file]
signing.secretKeyRingFile=[keyring filename, usually ~/.gnupg/secring.gpg]

# v2
signing.gnupg.keyName=[short form key ID]
signing.gnupg.passphrase=[keybox passphrase]

# Maven Central (needs only to publish to maven central)
repository.mavencentral.username=[username of oss.sonatype.org]
repository.mavencentral.password=[password of oss.sonatype.org]

# Bintray (need only to publish to Bintray)
bintrayUser=[username of bintray]
bintrayApiKey=[API key of your bintray account]

# Gradle (need only to publish Gradle plugin to Gradle plugin portal)
gradle.publish.key=[Gradle Plugin Portal account key]
gradle.publish.secret=[Gradle Plugin Portal account secret]

# temporary fix for SHA512 issue when publish to Maven Central
# https://github.com/gradle/gradle/pull/11358
systemProp.org.gradle.internal.publish.checksums.insecure=true


```
