rmdir /s /q pmroot
C:/devel/jdk-11.0.18/bin/java.exe ^
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8088 ^
-jar C:\devel\mavenrepo\fish\payara\extras\payara-micro\6.2023.4\payara-micro-6.2023.4.jar ^
--deploy target/restapp.war ^
--port 8081 ^
--rootDir pmroot
rem --domainConfig domain.xml