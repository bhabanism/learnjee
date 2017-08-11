# Setup

### Maven
    mvn archetype:generate
        -DgroupId=com.bsm.app
        -DartifactId=lootlo
        -DarchetypeArtifactId=maven-archetype-webapp
        -DinteractiveMode=false


### POM
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
      <modelVersion>4.0.0</modelVersion>
      <groupId>com.bsm.app</groupId>
      <artifactId>lootlo</artifactId>
      <packaging>war</packaging>
      <version>1.0-SNAPSHOT</version>
      <name>lootlo Maven Webapp</name>
      <url>http://maven.apache.org</url>
      <properties>
        <spring.version>4.3.10.RELEASE</spring.version>
      </properties>

      <dependencies>
        <dependency>
          <groupId>junit</groupId>
          <artifactId>junit</artifactId>
          <version>3.8.1</version>
          <scope>test</scope>
        </dependency>

        <!-- Spring Core -->
        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-core</artifactId>
          <version>${spring.version}</version>
        </dependency>

        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-web</artifactId>
          <version>${spring.version}</version>
        </dependency>

        <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-webmvc</artifactId>
          <version>${spring.version}</version>
        </dependency>


      </dependencies>
      <build>
        <finalName>lootlo</finalName>
      </build>
    </project>


## Glassfish

### Start
    cd /mnt/softwares/Ubuntu_programs/glassfish-4.1.1/glassfish/bin

    ./asadmin start-domain lootlo

### Deployment
    copy war file into :

    /mnt/softwares/Ubuntu_programs/glassfish-4.1.1/glassfish/domains/lootlo/autodeploy

### Stop
    cd /mnt/softwares/Ubuntu_programs/glassfish-4.1.1/glassfish/bin

    ./asadmin stop-domain lootlo

### URL
    Domain: http://localhost:8080/lootlo/

    Admin: http://localhost:4848


##### Useful hotkeys and command

 * **Alt+F12** : Terminal
 * **mvn install** : to install dependencies
 * **mvn compile** : to compile the source
 * **mvn package** : to create war file

