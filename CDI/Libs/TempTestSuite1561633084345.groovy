import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/Sample')

suiteProperties.put('name', 'Sample')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("D:\\CONG_VIEC\\GMO-Z RUNSYSTEM\\CDI\\CDI\\Reports\\Sample\\20190627_175748\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Sample', suiteProperties, [new TestCaseBinding('Test Cases/Android/CC_01_0001', 'Test Cases/Android/CC_01_0001',  null), new TestCaseBinding('Test Cases/Android/CC_01_0002', 'Test Cases/Android/CC_01_0002',  null), new TestCaseBinding('Test Cases/Android/CC_01_0003', 'Test Cases/Android/CC_01_0003',  null), new TestCaseBinding('Test Cases/Android/CC_01_0004', 'Test Cases/Android/CC_01_0004',  null), new TestCaseBinding('Test Cases/Android/CC_01_0007_0008_0009', 'Test Cases/Android/CC_01_0007_0008_0009',  null), new TestCaseBinding('Test Cases/Android/CC_01_0010_0011', 'Test Cases/Android/CC_01_0010_0011',  null), new TestCaseBinding('Test Cases/Android/CC_01_0012_0013', 'Test Cases/Android/CC_01_0012_0013',  null), new TestCaseBinding('Test Cases/Android/CC_01_0014', 'Test Cases/Android/CC_01_0014',  null), new TestCaseBinding('Test Cases/Android/CC_01_0015', 'Test Cases/Android/CC_01_0015',  null), new TestCaseBinding('Test Cases/Android/CC_01_0016', 'Test Cases/Android/CC_01_0016',  null), new TestCaseBinding('Test Cases/Android/CC_01_0017', 'Test Cases/Android/CC_01_0017',  null)])
