@ rem ----- ��Ϣ -----
@ rem @filename ProjectStarter.bat
@ rem @version 1.0
@ rem @author qye.zheng
@ rem @description 

@ rem @warning Ϊ�˷�ֹ���Ļ������룬�����ļ���ʱ��Ӧ�ñ���ΪANSI�����ʽ.
@ rem ################################################################################

:: ��ȡbat�ļ����ڵĴ��������������� C:
set currentDriver=%~dp0
set currentDriver=%currentDriver:~0,2%
:: ִ���������������ű������뵱ǰ�ű����ڵ�·��
%currentDriver%
cd %~dp0

set JAVA_HOME=.\env\jre8
set classpath=%classpath%;.\lib\*

@ rem ����
@ title 
@ rem ########## begin  ##########

@ rem �ر���ʾ���ʹ��������ִ��ǰ����ʾ
@ rem @ echo off
@ echo off
@ rem ��������ʾ @ echo on

@ rem ----- ����������

:: ��������·��
:: set starterClass=com.hua.update.starter.UpdateStarter
set starterClass=

@ rem ----- ���������

if not exist "%JAVA_HOME%" (
	echo "���� jdk ����!"
	goto failure
)

:: ִ�� java Ӧ�ó���
java org.junit.runner.JUnitCore com.hua.starter.FetchAllImgStarter




@ rem pause

@ rem

@ rem
@ rem �����ʾ��Ϣ

::
:: 1) 
:: 2)
:: 3)
:: 4)
:: 5)
:: 6)
:: 7)
:: 8)
:: 9)
:: 10)

:: �ڳ����ĩβ�����Ը���ִ�еĽ��(�ɹ���ʧ��) ������ʾ��Ϣ���ɹ�����ֱ��ִ��exit����ʧ��
:: ����ִ��pause��Ȼ�����ͨ������̨�����Ϣ�����ԡ���λ����.
:: �����ڳ���������һ���ɹ���ʧ�ܵı�־-����ֵ���������������ִ������.

@ rem echo
@ rem exit
@ rem ########## end of ##########

@ rem ע��˵��: @ rem ע������  ���� :: ע������
@ rem rem ������ð�� ���� ������дע��