#!/bin/bash

echo "Building Projects"
projects="testProject testProject2_10 multiModuleTestProject"
for project in $projects; do
    cd $project
    sbt cucumber
    cd ..
done

cd testIntegrationProject
sbt cucumber
sbt test
cd ..

cd integrationTestIntegrationProject
sbt it:test
cd ..

