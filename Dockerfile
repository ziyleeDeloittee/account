# start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# information about who mataining the image
MAINTAINER ziylee

# copy the jar file created in the target folder to the image
COPY target/account-0.0.1-SNAPSHOT.jar account-0.0.1-SNAPSHOT.jar

# tell need to append this before executing the docker image (to exec the application)
ENTRYPOINT ["java", "-jar", "account-0.0.1-SNAPSHOT.jar"]


# then:
# -----
# docker build . -t ziyleedeloitte/account:v1
# this is to build the docker image based on what been spesified within the Dockerfile

# docker images
# this is to see the list of docker images

# docker ps
# this is to see the list of docker containers
# attach -a to see the closed docker container

# docker run -d -p 8080:8080 ziyleedeloitte/account:v1
# this is to run the docker image at the port spesified
# -d meant to run the docker image in the detached mode
# if wanna run multiple container, pls change the port number exposed to other port, exp: 8081:8080
#       +--> since we cant access to the same port number
#            however, the container in docker is isolated hence the second port number doesnt matter