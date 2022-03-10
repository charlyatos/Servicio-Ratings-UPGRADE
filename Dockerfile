FROM openjdk:11
EXPOSE 8080
#ADD <La carpeta de donde tomara el JAR> <el directorio en donde lo agregara, en este caso al poner / lo guarda en la raiz>
ADD bulid/lib/ratings-course-0.0.1-SNAPSHOT.jar /
ENTRYPOINT ["java","-jar","/ratings-course-0.0.1-SNAPSHOT.jar"]
