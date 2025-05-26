FROM maven:3.9.9-amazoncorretto-17-alpine
COPY . /job-board
WORKDIR /job-board
RUN mvn package -DskipTests
ENTRYPOINT ["java","-jar","/job-board/target/job-board.jar"]