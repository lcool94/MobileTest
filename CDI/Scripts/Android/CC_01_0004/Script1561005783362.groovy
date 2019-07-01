import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import io.appium.java_client.MobileDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

String appPackage = "jp.connected_design.connectedremocon"

String userDir = RunConfiguration.getProjectDir()

'Install App'
Mobile.startApplication(userDir + '\\App\\Android\\' + GlobalVariable.appName, false)

'Get Mobile driver'
MobileDriver driver = new MobileDriverFactory().getDriver()

driver.removeApp(appPackage)

Mobile.delay(2)

'Install App'
Mobile.startApplication(userDir + '\\App\\Android\\' + GlobalVariable.appName, false)

Mobile.delay(120)

Mobile.tap(findTestObject('Object Repository/Common/Login/bt_Agree_TermsConditions'), 0)

Mobile.delay(10)

'CHECKPOINT: Verify Page 1'
Mobile.verifyElementExist(findTestObject('Object Repository/Common/Login/tv_Page1'), 2)

'CHECKPOINT: Verify text: "Operate home appliances"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page1/tv_Opera home appliances'), 'Operate home appliances')

'CHECKPOINT: Verify text: "Connect to smart device in house by Connectty"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page1/tv_Connect to'), 'Connect to smart device in house by Connectty')






