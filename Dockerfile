FROM tomcat:8.0.50-jre8-slim
COPY fvc.war $CATALINA_HOME/webapps/fvc.war
#设置时区
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
  && echo 'Asia/Shanghai' >/etc/timezone
EXPOSE 8080
CMD ["catalina.sh", "run"]
