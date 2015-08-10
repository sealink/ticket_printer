# ticket_printer

Back-end component for local printer service.

## Requirements

* Java 8.
* Eclipse 4.5 (Mars) with Maven 3.3.3 embedded, or standalone Maven.


### Java

Install Java 8, via your package manager, PPA, etc on Linux, or via Oracle's website on other platforms.

Oracle Java 8 is recommended. OpenJDK 8 is not tested.

Check that you've Java 8 and JAVA_HOME is set:

    user@host:~/projects$ java -version
    java version "1.8.0_51"
    Java(TM) SE Runtime Environment (build 1.8.0_51-b16)
    Java HotSpot(TM) 64-Bit Server VM (build 25.51-b03, mixed mode)

    user@linuxbox:~/projects$ echo $JAVA_HOME
    /usr/lib/jvm/java-8-oracle

    user@macosx$ echo $JAVA_HOME
    /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home

### Maven

* Install Eclipse 4.5 (Mars) and use the embedded Maven 3.3.3; build via the Maven integration in Eclipse.

OR

* If you prefer to script your build and would like to avoid Eclipse, install standalone Maven

OS X:


    brew install maven
    mvn --version
    Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T21:27:37+09:30)
    Maven home: /usr/local/Cellar/maven/3.3.3/libexec
    Java version: 1.8.0_45, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_45.jdk/Contents/Home/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "mac os x", version: "10.10.4", arch: "x86_64", family: "mac"


Linux (Ubuntu)


    sudo apt-get install maven
    mvn --version
    Apache Maven 3.0.5
    Maven home: /usr/share/maven
    Java version: 1.8.0_51, vendor: Oracle Corporation
    Java home: /usr/lib/jvm/java-8-oracle/jre
    Default locale: en_AU, platform encoding: UTF-8
    OS name: "linux", version: "3.13.0-61-generic", arch: "amd64", family: "unix"


## Building

* Eclipse:
Run -> Run configurations -> Maven build -> New -> Set base directory and set goals to "clean install"

OR

Command-line Maven:

    cd ticket_printer
    mvn clean install
