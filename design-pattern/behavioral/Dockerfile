FROM java:8
VOLUME /tmp
ADD target/behavioral-0.0.1-SNAPSHOT.jar /usr/local/behavioral-0.0.1-SNAPSHOT.jar
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone
ENTRYPOINT ["java","-jar","/usr/local/behavioral-0.0.1-SNAPSHOT.jar"]