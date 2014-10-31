@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  TicTacToe startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and TIC_TAC_TOE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\TicTacToe.jar;%APP_HOME%\lib\slf4j-api-1.7.5.jar;%APP_HOME%\lib\icndb-java-api-1.0.jar;%APP_HOME%\lib\spark-core-1.1.1.jar;%APP_HOME%\lib\guava-16.0.1.jar;%APP_HOME%\lib\gson-2.3.jar;%APP_HOME%\lib\jersey-client-2.13.jar;%APP_HOME%\lib\jetty-server-9.0.2.v20130417.jar;%APP_HOME%\lib\jetty-webapp-9.0.2.v20130417.jar;%APP_HOME%\lib\jersey-common-2.13.jar;%APP_HOME%\lib\javax.ws.rs-api-2.0.1.jar;%APP_HOME%\lib\hk2-api-2.3.0-b10.jar;%APP_HOME%\lib\javax.inject-2.3.0-b10.jar;%APP_HOME%\lib\hk2-locator-2.3.0-b10.jar;%APP_HOME%\lib\javax.servlet-3.0.0.v201112011016.jar;%APP_HOME%\lib\jetty-http-9.0.2.v20130417.jar;%APP_HOME%\lib\jetty-io-9.0.2.v20130417.jar;%APP_HOME%\lib\jetty-xml-9.0.2.v20130417.jar;%APP_HOME%\lib\jetty-servlet-9.0.2.v20130417.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\jersey-guava-2.13.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.1.jar;%APP_HOME%\lib\hk2-utils-2.3.0-b10.jar;%APP_HOME%\lib\aopalliance-repackaged-2.3.0-b10.jar;%APP_HOME%\lib\javassist-3.18.1-GA.jar;%APP_HOME%\lib\jetty-util-9.0.2.v20130417.jar;%APP_HOME%\lib\jetty-security-9.0.2.v20130417.jar;%APP_HOME%\lib\javax.inject-1.jar

@rem Execute TicTacToe
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %TIC_TAC_TOE_OPTS%  -classpath "%CLASSPATH%" Game %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable TIC_TAC_TOE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%TIC_TAC_TOE_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
