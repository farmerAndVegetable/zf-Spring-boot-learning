echo off
SET PROJECT_HOME=%cd%

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
	

	
:mvn_end
cd %PROJECT_HOME%
