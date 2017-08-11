# Setup

### Maven
    mvn archetype:generate
        -DgroupId=com.bsm.app
        -DartifactId=lootlo
        -DarchetypeArtifactId=maven-archetype-webapp
        -DinteractiveMode=false


### POM
 [POM File](./pom.xml)


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
 * [Domain URL](http://localhost:8080/lootlo/)

 * [Admin URL](http://localhost:4848)


## Derby DB

 > Comes with Glassfish!

### Start
    cd /mnt/softwares/Ubuntu_programs/glassfish-4.1.1/javadb/bin

    ./startNetworkServer

### ### Create new DB
 * From a new terminal start ij
 > ij

 > CONNECT 'jdbc:derby:lootlodb;create=true';

### For Derby GUI use netbeans
 1. Connect to JavaDB
 2. Create new connection using Drivers > Java DB (Network)
 3. Config:

    + Host - localhost
    + Port - 1527
    + DB name - lootlodb
    + admin@admin
    + Choose Schema as APP

### Similarly with DBeaver
 - Picked **derbyclient jar** file from derby lib folder for connection

###### **JDBC URL** - jdbc:derby://localhost:1527/lootlodb

#### More Info
 * [Oracle docs](http://docs.oracle.com/javadb/10.8.3.0/getstart/twwdactivity1.html)


___

##### Useful hotkeys and command

 * **Alt+F12** : Terminal in IntelliJ IDEA
 * **mvn install** : to install dependencies
 * **mvn compile** : to compile the source
 * **mvn package** : to create war file

 > TODO: find ways to start server, db and deploy using maven/ant/gradle/bash

