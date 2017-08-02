#!/usr/bin/env bash
rm -rf src/main/resources

# Download chromedriver for the OS
OS="`uname`"
case $OS in
  'Linux')
    OS='Linux'
    echo "Using Linux OS"
    wget -N https://chromedriver.storage.googleapis.com/2.31/chromedriver_linux64.zip -P src/main/resources/drive
    unzip src/main/resources/driver/chromedriver_linux64.zip -d src/main/resources/driver
    ;;
  'Darwin')
    OS='Mac'
    echo "Using MAC OS"
    wget -N https://chromedriver.storage.googleapis.com/2.31/chromedriver_mac64.zip -P src/main/resources/driver
    unzip src/main/resources/driver/chromedriver_mac64.zip -d src/main/resources/driver
    ;;
  *) ;;
esac

# Make the chromedrive executable
chmod +x src/main/resources/driver/chromedriver

# Compile and run the tests
mvn compile
mvn clean test