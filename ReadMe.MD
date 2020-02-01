# yactci

[![Build Status](https://jenkins.ucar.land/buildStatus/icon?job=yactci)](https://jenkins.ucar.land/job/yactci/)



yactci *(yet another cracking the coding interview)* is a java implementation of the data structures, algorithms 
and many other things mentioned in the holy book of programmers, Cracking The Coding Interview.

## repository structure

## pipeline

every commit in every branch triggers a jenkins pipeline for the repository. pipeline executes the command
*```mvn clean install```* to build project as well as runs the *```junit5```* tests. *```jacoco```* will generate the code coverage 
report and then the project will be analysed by *```sonarqube```*. 

    