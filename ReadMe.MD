# yactci

[![Build Status](https://jenkins.ucar.land/buildStatus/icon?job=yactci)](https://jenkins.ucar.land/job/yactci/)
[![Quality Gate Status](https://qube.ucar.land/api/project_badges/measure?project=org.github.java.yactci%3Ayactci-parent&metric=alert_status)](https://qube.ucar.land/dashboard?id=org.github.java.yactci%3Ayactci-parent)
[![Security Rating](https://qube.ucar.land/api/project_badges/measure?project=org.github.java.yactci%3Ayactci-parent&metric=security_rating)](https://qube.ucar.land/dashboard?id=org.github.java.yactci%3Ayactci-parent)

[![Bugs](https://qube.ucar.land/api/project_badges/measure?project=org.github.java.yactci%3Ayactci-parent&metric=bugs)](https://qube.ucar.land/dashboard?id=org.github.java.yactci%3Ayactci-parent)
[![Code Smells](https://qube.ucar.land/api/project_badges/measure?project=org.github.java.yactci%3Ayactci-parent&metric=code_smells)](https://qube.ucar.land/dashboard?id=org.github.java.yactci%3Ayactci-parent)
[![Coverage](https://qube.ucar.land/api/project_badges/measure?project=org.github.java.yactci%3Ayactci-parent&metric=coverage)](https://qube.ucar.land/dashboard?id=org.github.java.yactci%3Ayactci-parent)



yactci *(yet another cracking the coding interview)* is a java implementation of the data structures, algorithms 
and many other things mentioned in the holy book of programmers, Cracking The Coding Interview.

## repository structure

repository is a typical java maven multi module project. 

### core-api

core-api module contains only the interfaces for data structures, algorithms any many so other things besides default 
tests. programmer may implement those test interfaces to increase test coverage for own implementations. 

### core-impl

main implementation module for core api. 

## pipeline

every commit in every branch triggers a jenkins pipeline for the repository. pipeline executes the command
*```mvn clean install```* to build project as well as runs the *```junit5```* tests. *```jacoco```* will generate the code coverage 
report and then the project will be analysed by *```sonarqube```*. 

## contribution

using pull requests, anyone can contribute  

