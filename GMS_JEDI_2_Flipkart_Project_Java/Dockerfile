FROM jfrog.fkinternal.com/fk-base-images/adoptopenjdk/jdk:8u322-debian11.3-slim-20220527
WORKDIR /app
COPY target/Jedi_GMS_a-1.0-SNAPSHOT.jar /app/code.jar
#COPY src/main/resources/config_local.yaml /app/config_local.yaml
EXPOSE 5000

ENTRYPOINT exec java -jar code.jar server /etc/config/configmap.yml
#CMD ["java", "-jar", "code.jar","server","/etc/config/config_local.yaml"]
