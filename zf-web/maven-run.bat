echo off
SET PROJECT_HOME=%cd%
ECHO PROJECT_HOME:"%PROJECT_HOME%"

IF [%ANTX_PROPERTY%]==[] SET ANTX_PROPERTY="C:%HOMEPATH%\antx.properties"
ECHO ANTX_PROPERTY:%ANTX_PROPERTY%

IF [%JETTY_HOME%]==[] SET JETTY_HOME=D:\alibaba\jetty-7.2.0
ECHO JETTY_HOME: "%JETTY_HOME%"

set MAVEN_OPTS=-Xms256m -Xmx512m -XX:ReservedCodeCacheSize=64m -XX:MaxPermSize=128m
cd %PROJECT_HOME%

:mvn_command
ECHO.
ECHO.ע�⣺���ڵı���Ͳ�����ֿ�����Ҫ��ѡ����������ɹ�����ѡ������jetty
ECHO.
ECHO 2-����������
ECHO.

ECHO 0-�˳��˵�

set /p isopt=��ѡ�����

if /i "%isopt%"=="2" goto mvn_incremental_package

if /i "%isopt%"=="0" goto mvn_end

echo "��Чѡ���ѡ��(0-9)"
goto mvn_command


	
:mvn_incremental_package
	cd %PROJECT_HOME%	
	start /HIGH mvn clean install -Dmaven.test.skip=true 
	goto mvn_command
	

:mvn_full_package
	cd %PROJECT_HOME%
	start /HIGH mvn clean install -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	
:mvn_compile_all
	cd %PROJECT_HOME%
	start /HIGH mvn clean install -DskipTests=true -Pskip.attach.sources -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	
:run_tomcat
	cd %PROJECT_HOME%\deploy\target\web-deploy\bin\
	start catalina.bat jpda start
	goto mvn_command
	
:run_hotswap_jetty
	cd %PROJECT_HOME%\bundle\war
	call mvn compile -DenableHotswap=true -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	start /HIGH call %PROJECT_HOME%\deploy\target\web-deploy\bin\jettyctl.bat true %PROJECT_HOME%
	goto mvn_command
    
:httpd_service
	cd %PROJECT_HOME%\deploy\target\web-deploy\bin
	start /SEPARATE call httpdService.bat
	goto mvn_command
	
:mvn_test_all
	cd %PROJECT_HOME%
	echo ��ʼִ�в���
	start /HIGH mvn clean test
	goto mvn_command
	
:mvn_test_project
	set /p subprj=��������Ŀ·����
	echo %PROJECT_HOME%\%subprj%
	cd %PROJECT_HOME%\%subprj%
	start /HIGH mvn test
	goto mvn_command	
	
:mvn_complie_deploy
	cd %PROJECT_HOME%\deploy	
	start /HIGH mvn clean install -DskipTests -DuserProp=%ANTX_PROPERTY% -Dautoconfig.userProperties=%ANTX_PROPERTY%
	goto mvn_command
	
:mvn_end
cd %PROJECT_HOME%
