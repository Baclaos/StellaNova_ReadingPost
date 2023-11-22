#FROM alpine:latest as packager
#
#RUN apk --no-cache add openjdk11-jdk openjdk11-jmods
#
#ENV JAVA_MINIMAL="/opt/java-minimal"
#
## build minimal JRE
#RUN /usr/lib/jvm/java-11-openjdk/bin/jlink \
#    --verbose \
#    --add-modules \
#        java.base,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument \
#    --compress 2 --strip-debug --no-header-files --no-man-pages \
#    --release-info="add:IMPLEMENTOR=radistao:IMPLEMENTOR_VERSION=radistao_JRE" \
#    --output "$JAVA_MINIMAL"
#
#FROM alpine:latest
#
#ENV JAVA_HOME=/opt/java-minimal
#ENV PATH="$PATH:$JAVA_HOME/bin"
#
#COPY --from=packager "$JAVA_HOME" "$JAVA_HOME"
#COPY build/libs/stellanova-1.jar app.jar
#
#ENTRYPOINT ["java","-jar","/app.jar"]

# Use a base image with Java 11
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory
WORKDIR /app
# Copy the JAR file to the container
COPY build/libs/stellanova-1.jar app.jar
# Expose the port that your Spring Boot application listens on (default is 8080)
EXPOSE 9003
# Define the command to run your application
CMD ["java", "-jar", "app.jar"]