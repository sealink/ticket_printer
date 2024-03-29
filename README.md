[ ![Download](https://img.shields.io/github/v/release/sealink/ticket_printer) ](https://github.com/sealink/ticket_printer/packages/961689)
[![Coverage Status](https://coveralls.io/repos/github/sealink/ticket_printer/badge.svg?branch=master)](https://coveralls.io/github/sealink/ticket_printer?branch=master)
[![Build Status](https://github.com/sealink/ticket_printer/actions/workflows/gradle.yml/badge.svg?branch=master)](https://github.com/sealink/ticket_printer/actions)

Back-end library to handle printing tickets to a physical printer

#### Deployment

Deployment is handled via gradle and travis if you follow the correct git conventions.

If you are creating a new minor or major release then you would do the following.

* Create a new release branch, based upon the major and min
```concept
git checkout -b release/0.1
```
* Update the changelog with the correct version number (in this case 0.1.0)

```concept
git commit -m "Release 0.1.0"
git tag 0.1.0
git push origin master --tags
```

A point release would simply be a tag on this branch and you would follow the previous procedure.


#### Project Builds and Structure

* Gradle is the build tool of choice and all things related are contained within the project.

Some example build tasks include

```concept
./gradlew build
./gradlew test
./gradlew versionInfo
```

* Project is maven compatible however we only publish to Bintray so you will need to manually configure
 the repository, full instructions can be found at the following site
 https://bintray.com/sealink/maven/printing
* TravisCI is used to test / build and publish new versions.
* JUnit is used for integration and unit level testing.

#### Development

If you want to use this library directly in an Android Studio project, you can
make the following changes to the gradle build

Edit ```settings.gradle``` and create a new project dependency.

```
include ':Dependency'
project(':Dependency').projectDir = new File('~user/src/ticket_printer/')
```

Edit ```app/build.gradle```
Replace the original dependency, i.e.

```
implementation 'au.com.sealink:printing:x.x.x'
```

with
```
 compile project(':Dependency')
```

Resync the gradle process.

The ticket_printer project should now be a direct dependency and any changes made should be immediately effective, if not you may be required to restart Android Studio.
