#!/usr/bin/env bash
mvn clean test -q -Dsurefire.suiteXmlFiles=mac-only.xml
mvn allure:serve