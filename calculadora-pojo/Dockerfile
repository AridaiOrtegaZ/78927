FROM ubuntu-java
RUN curl -G https://dlcdn.apache.org/axis/axis2/java/core/1.8.0/axis2-1.8.0-bin.zip -o /opt/axis2.zip
RUN unzip /opt/axis2.zip -d /opt
ENV AXIS2_HOME=/opt/axis2-1.8.0
ENV PATH=$PATH:$AXIS2_HOME/bin
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
WORKDIR /ws
COPY calculadora.java .
COPY services.xml META-INF/
EXPOSE 8080
