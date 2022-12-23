FROM tomcat
VOLUME /usr/local/tomcat/webapps/
ADD ./build/libs/hello-otto-grails-0.1.war /usr/local/tomcat/webapps/otto-grails-service.war
ENTRYPOINT ["sh", "-c", "java  -Dgrails.env=development -jar /usr/local/tomcat/webapps/otto-grails-service.war"]