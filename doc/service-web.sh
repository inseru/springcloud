#!/bin/sh

## change here
SERVICE_DIR=/home/appadmin/jmcapp/service/activity
SERVICE_NAME=service-activity
EUREKA_URL=http://10.28.32.171:8761/eureka/,http://10.28.32.172:8761/eureka/,http://193.28.3.138:8761/eureka/
CONFIG_PROFILE=jmcpro

## java env
export JAVA_HOME=/home/appadmin/jdk1.8.0_66
export JRE_HOME=${JAVA_HOME}/jre

case "$1" in 
	start)
		procedure=`ps -ef | grep -w "${SERVICE_NAME}" |grep -w "java"| grep -v "grep" | awk '{print $2}'`
		if [ "${procedure}" = "" ];
		then
			echo "start ..."
			if [ "$2" != "" ];
			then
				SPRING_PROFILES_ACTIVE=$2
			fi
			echo "spring.profiles.active=${SPRING_PROFILES_ACTIVE}"
			exec nohup ${JRE_HOME}/bin/java -Xms512m -Xmx1024m -XX:PermSize=128m -XX:MaxPermSize=256m -jar -Deureka.url=${EUREKA_URL} -Dconfig.profile=${CONFIG_PROFILE} ${SERVICE_DIR}/${SERVICE_NAME}\.jar  >/dev/null 2>&1 &
			echo "start success"
		else
			echo "${SERVICE_NAME} is start"
		fi
		;;
		
	stop)
		procedure=`ps -ef | grep -w "${SERVICE_NAME}" |grep -w "java"| grep -v "grep" | awk '{print $2}'`
		if [ "${procedure}" = "" ];
		then
			echo "${SERVICE_NAME} is stop"
		else
			kill -9 ${procedure}
			sleep 1
			argprocedure=`ps -ef | grep -w "${SERVICE_NAME}" |grep -w "java"| grep -v "grep" | awk '{print $2}'`
			if [ "${argprocedure}" = "" ];
			then
				echo "${SERVICE_NAME} stop success"
			else
				kill -9 ${argprocedure}
				echo "${SERVICE_NAME} stop error"
			fi
		fi
		;;
		
	restart)
		$0 stop
		sleep 1
		$0 start $2
		;;  
		
	*)
		echo "usage: $0 [start|stop|restart] [dev|test|prod]"
		;;  
esac

