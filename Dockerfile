FROM maven:3.6.3-jdk-11 as build
WORKDIR /build
COPY pom.xml ./
COPY ./src ./src
RUN mvn clean install

FROM openjdk:11-jre
WORKDIR /opt/logger
COPY --from=build /build/target/libs libs
COPY --from=build /build/target/logger.jar .
CMD java -Dlog4j.configurationFile=file:log4j2.properties -jar logger.jar