#!/usr/bin/env bash
mvn compile
mvn package
rm /mnt/softwares/Ubuntu_programs/glassfish-4.1.1/glassfish/domains/lootlo/autodeploy/lootlo.war
cp /mnt/workspace/learnjee/lootlo/target/lootlo.war /mnt/softwares/Ubuntu_programs/glassfish-4.1.1/glassfish/domains/lootlo/autodeploy

echo "go go go!"