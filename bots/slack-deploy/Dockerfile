FROM openjdk:8-jdk

MAINTAINER Pete Cornish <outofcoffee@gmail.com>

RUN mkdir -p /opt/corebot /opt/corebot/config

ADD build/install/bots-slack-deploy /opt/corebot

WORKDIR "/opt/corebot"

ENTRYPOINT [ "./bin/bots-slack-deploy" ]
