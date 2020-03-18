You first should do the below steps 

1-	Go to linkedin.test\src\test\java\data
2-	Open  userdata.xslx
	   a -To test the registration:
	      Open excel and on the sheet name “RegistrationData” replace this  010000000 with valid Tel number
	   b- To test login I make test account mf069886.test@gmail.com you can use it or replace it by any valid email address
	   C- To test add work experience put data on the excel on the sheet “Add_WorkExPData”

You can run the project 
1-	From Eclipse IDE  
2-	Open project 
3-	Right click on the linkedinTestCases 
4-	Run as testng
5-	Then check the test report from linkedin.test\test-output\index.html

Or using command line 
1-	Open cmd 
2-	java -cp "path-tojar/testng.jar:path_to_yourtest_classes" org.testng.TestNG testng.xml
