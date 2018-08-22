# 6th-cycle-02
Lab projet for lecture Spring-Boot, JPA by JeSung Park

## 반복주기 6 학습목표
* JSON API 및 AJAX를 활용해 답변 추가/삭제 구현

## 6-1. AJAX를 활용해 답변 추가 기능 구현

## 6-2. AJAX를 활용해 답변 삭제 기능 구현

## 6-3. 질문 목록에 답변 수 보여주기 기능 추가

## 6-4. 중복 제거 및 리팩토링

## 6-5. JSON API 추가 및 테스트

## 6-6. 쉘 스크립트를 활용해 배포 자동화

deploy.sh
#!/bin/bash
echo "deploy.sh about to run!"
TOMCAT_HOME=~/tomcat
cd ~/6th-cycle-02
git pull

./mvnw clean package

cd $TOMCAT_HOME/bin
./shutdown.sh

cd $TOMCAT_HOME/webapps
rm -rf ./ROOT

mv ~/6th-cycle-02/target/6th-cycle-02-1.0 $TOMCAT_HOME/webapps/ROOT

cd $TOMCAT_HOME/bin
./startup.sh

tail -500f $TOMCAT_HOME/logs/catalina.out