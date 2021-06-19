FROM adoptopenjdk/openjdk11:ubi

VOLUME /tmp

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS

ENV REDIS_HOST=redis-10651.c10.us-east-1-4.ec2.cloud.redislabs.com

ENV REDIS_PORT=10651

ENV REDIS_PASS=5zuxMied8q6U2WnuSGett9bxeYO8JwhV

COPY target/melitest-0.0.1-SNAPSHOT.jar melitest.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -jar melitest.jar
