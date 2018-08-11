echo off
SET PROJECT_HOME=%cd%

cd %PROJECT_HOME%

:mvn_command
ECHO.
ECHO.注意：现在的编译和部署步骤分开，需要先选择编译打包，成功后再选择启动jetty
ECHO.
ECHO 2-增量编译打包
ECHO.

ECHO 0-退出菜单

set /p isopt=【选择命令】

if /i "%isopt%"=="2" goto mvn_incremental_package

if /i "%isopt%"=="0" goto mvn_end

echo "无效选项，请选择(0-9)"
goto mvn_command


	
:mvn_incremental_package
	cd %PROJECT_HOME%	
	start /HIGH mvn clean install -Dmaven.test.skip=true 
	goto mvn_command
	

	
:mvn_end
cd %PROJECT_HOME%
