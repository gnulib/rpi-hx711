# pi4j-hx711
HX711 controller based on pi4j for Raspberry Pi Model 3B.

# Build setup
### Install Maven
```
cd /tmp
wget http://www.mirrorservice.org/sites/ftp.apache.org/maven/maven-3/3.2.5/binaries/apache-maven-3.2.5-bin.tar.gz
cd /opt
sudo tar -xzvf /tmp/apache-maven-3.2.5-bin.tar.gz
sudo echo "export M2_HOME=/opt/apache-maven-3.2.5" > /etc/profile.d/maven.sh
sudo echo "export PATH=$PATH:$M2_HOME/bin" > /etc/profile.d/maven.sh
```
Once above is done, logout and relogin

### Clone Repo
```
git clone https://github.com/gnulib/rpi-hx711.git
```

### Build
```
mvn clean package
[INFO] Scanning for projects...
Downloading: https://repo.maven.apache.org/maven2/org/springframework/boot/spring-boot-starter-parent/1.3.3.RELEASE/spring-boot-starter-parent-1.3.3.RELEASE.pom
Downloaded: https://repo.maven.apache.org/maven2/org/springframework/boot/spring-boot-starter-parent/1.3.3.RELEASE/spring-boot-starter-parent-1.3.3.RELEASE.pom (7 KB at 1.3 KB/sec)
:
:
Downloaded: https://repo.maven.apache.org/maven2/asm/asm-analysis/3.2/asm-analysis-3.2.jar (18 KB at 3.4 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/com/google/guava/guava/18.0/guava-18.0.jar (2204 KB at 244.3 KB/sec)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 02:55 min
[INFO] Finished at: 2018-02-24T10:59:39-08:00
[INFO] Final Memory: 21M/52M
[INFO] ------------------------------------------------------------------------
```
# Usage
```
java -Dpi4j.linking=dynamic -jar target/rpi-hx711-0.0.1-SNAPSHOT.war <data pin#> <control pin#>
```
