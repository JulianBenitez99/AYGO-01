FROM openjdk:8
WORKDIR /usrapp/bin

ENV PORT 6001
ENV SERVERS http://log-service-1:6000,http://log-service-2:6000,http://log-service-3:6000

COPY /target/classes /usrapp/bin/classes
COPY /target/dependency /usrapp/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","co.edu.escuelaing.app.SparkLBWebApp"]
