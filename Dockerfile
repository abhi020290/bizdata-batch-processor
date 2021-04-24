#Base Image
FROM openjdk:8-jdk-alpine

#Port to expose
EXPOSE 8082

#Env varibale for Working Directory
ENV CC_APP_HOME /usr/src/app
#ADD target/spring-boot-openapi.jar spring-boot-openapi.jar
RUN mkdir -p /usr/src/inbound/

COPY /src/main/resources/inbound/ /usr/src/inbound/

#Locate and Create JAR path
ARG CASSANDRA_CONNECTIVITY_JAR=target/bizdata-batch-processor.jar

#Copy jar to container app directory
COPY $CASSANDRA_CONNECTIVITY_JAR $CC_APP_HOME/bizdata-batch-processor.jar

#Set Working Directory
WORKDIR $CC_APP_HOME

#Start Command
ENTRYPOINT ["java", "-jar","bizdata-batch-processor.jar"]