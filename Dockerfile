# ==============================================================
# NorthClimbing's Dockerfile
# hub.docker.com/
# Modif: Antoine Duquennoy
# 30 May 2016
# ==============================================================

# DEFINE IMAGE
# ==============================================================
FROM debian:latest
# ==============================================================

# Before install
# ==============================================================
# Sets language to UTF8 : this works in pretty much all cases
ENV LANG en_US.UTF-8

# run update
RUN apt-get update
# ==============================================================

# INSTALL & CONFIGURE JAVA
# ==============================================================
# Install java8
RUN apt-get install -y openjdk-8-jdk

# Setup JAVA_HOME and other environment variables
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64/
ENV PATH $PATH:$JAVA_HOME/bin
ENV CLASSPATH $JAVA_HOME/lib/tools.jar
ENV MANPATH $JAVA_HOME/man
# ==============================================================

# INSTALL & CONFIGURE MAVEN
# ==============================================================
RUN apt-get install -y --force-yes maven
ADD pom.xml /srv/NorthClimbing/
WORKDIR /srv/NorthClimbing/
RUN mvn install
# ==============================================================

# SQLITE & database TODO => Run mySQL on other Docker link
# ==============================================================
#RUN apt-get install -y --force-yes sqlite3
#
# Add database init script & run it
#ADD dbinit.sql /srv/StrongBox/
#RUN sqlite3 /tmp/data.db < /srv/StrongBox/dbinit.sql
#
# TODO Add database epuration scipt and run it via cron
# ADD dbepuration.sql /srv/StrongBox/
# launch via crontab
# ==============================================================

# CLEAN UP
# ==============================================================
RUN apt-get autoremove && \
    apt-get autoclean && \
    apt-get clean
# ==============================================================

# web service configuration
# ==============================================================
# Precise the source folder
ADD src /srv/StrongBox/src/
# Listen on the specified network port
EXPOSE 8080
# ==============================================================

# Start the web service
# ==============================================================
CMD mvn jetty:run
# ==============================================================