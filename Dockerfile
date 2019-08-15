FROM openjdk
EXPOSE 8080:8080
ADD target/RTPhonestore-1.0-SNAPSHOT.jar RTPhonestore.jar
ENTRYPOINT ["java", "-jar", "RTPhonestore.jar"]