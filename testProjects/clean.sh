#!/bin/bash

echo "Cleaning Projects"
projects="testProject testProject2_10 multiModuleTestProject testIntegrationProject integrationTestIntegrationProject"
for project in $projects; do
    echo "Processing: $project..."
    cd $project
    sbt clean
    cd ..
done



