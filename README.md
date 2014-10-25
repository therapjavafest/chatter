chattter
========

A simple servlet/jsp reference application for therap javafest called chatter. 

 
### Prerequisites ###
 
1. Servlet Container: Apache Tomcat 7  (http://tomcat.apache.org/download-70.cgi)
2. Build Tool: Gradle (http://www.gradle.org/installation)
3. Database: Mysql (http://www.apachefriends.org/en/xampp-windows.html)


## Steps to Run

1. Install gradle 
2. Modify the db.properties file with your own database credentials.
3. Modify the log4j.properties file and set "log4j.appender.file.File" attribute to your preferred log file location from _**chatter/src/main/resources/log4j.properties**_
     
4. Create a table in your mysql database with schema.sql.

5. Now first goto your project directory- 
 > _**cd ~/proejct/chatter**_

6. Then move the war file to your tomcat webapps directory 
> _**mv build/libs/chatter-1.0.war /usr/local/tomcat7/webapps/ROOT.war**_

7. Now got your tomcat bin directory 
> _**cd usr/local/tomcat7/bin**_

8. then run 
> **_./catalina.sh run_**

9. Now navigate to http://localhost:8080/