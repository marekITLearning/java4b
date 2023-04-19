rmdir /s /q pmroot
C:/devel/jdk-11.0.16.1/bin/java.exe ^
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8088 ^
-jar C:\devel\payara-micro-5.2021.2.jar ^
--deploy target/restapp.war ^
--port 8081 ^
--rootDir pmroot
rem --domainConfig domain.xml