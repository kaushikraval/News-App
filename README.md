# NY Times Popular Article Fetch

## Features

This app provides the following features:

- Minimal and simple user interface, which user can get easily acquainted with
- Check Most Popular news article of NY Times
- Read the full story of the article with images

## Setup

### Requirements

- JDK 1.8 or 11 or 15
- Latest Android SDK tools
- Latest Android platform tools
- Android SDK 21 or newer
- AndroidX

This project does not require any other configuration changes to run the project

## How to run test cases

- This project contains UI test cases for fragment and activity
- To run test cases go to -> androidtest lib -> Ui test -> and click on arrow left to the test functions
- For fragment test case go to same folder -> ui -> fragment -> LatestArticleTest and click on arrow left to the test function
One test case contains click of recycler view item click and move to next fragment and pass data using navargs


## Download Code Coverage Report

- JDK - 1.8 or 11 or 15

This project runs on jacoco dependency to get Code Coverage Report

- run belo command in terminal in Android Studio (set path to project location in terminal) to Generate Code Coverage Report
 
/.gradlew createDebugCoverageReport
  
this will take approx 2 to 3 minutes depending upon system configuration to generate report

Generated Report will be located at:

project location/app/build/reports/coverage/debug/index.html

and

project location/app/build/reports/androidTests/connected/index.html


  