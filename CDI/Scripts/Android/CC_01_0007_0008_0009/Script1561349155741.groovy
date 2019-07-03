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

String appPackage = GlobalVariable.appPackage

String userDir = RunConfiguration.getProjectDir()

'Install App'
Mobile.startApplication(userDir + '\\App\\Android\\' + GlobalVariable.appName, false)

'Get Mobile driver'
MobileDriver driver = new MobileDriverFactory().getDriver()

Mobile.delay(10)

Mobile.takeScreenshot()

'CHECKPOINT: Verify text: "Operate home appliances"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page1/tv_Opera home appliances'), 'Operate home appliances')

'CHECKPOINT: Verify text: "Connect to smart device in house by Connectty"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page1/tv_Connect to'), 'Connect to smart device in house by Connectty')

//
device_Height = Mobile.getDeviceHeight()

device_Width = Mobile.getDeviceWidth()

int startX = device_Width * 0.95

int endX = device_Width * 0.05

int startY = device_Height / 2

int endY = startY
//

'swipe right -> left: to page 2'
Mobile.swipe(startX,startY,endX,endY,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tapAtPosition(endX, endY)

Mobile.takeScreenshot()

'CHECKPOINT: Verify text: "Confirm the condition of the house"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page2/tv_Confirm the condition of the house'), 'Confirm the condition of the house')

'CHECKPOINT: Verify text: "Connect to many service"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page2/tv_Connect to many service'), 'Connect to many service')



'swipe right -> left: to page 3'
Mobile.swipe(startX,startY,endX,endY,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tapAtPosition(endX, endY)

Mobile.takeScreenshot()

'CHECKPOINT: Verify text: "Smart button"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page3/tv_Smart button'), 'Smart button')

'CHECKPOINT: Verify text: "Make your life more comfortable"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page3/tv_Make your life more comfortable'), 'Make your life more comfortable')


//TC0008: Check swipe end right
'swipe right -> left: to check page 3'
Mobile.swipe(startX,startY,endX,endY,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tapAtPosition(endX, endY)

Mobile.takeScreenshot()

'CHECKPOINT: Verify text: "Smart button"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page3/tv_Smart button'), 'Smart button')

'CHECKPOINT: Verify text: "Make your life more comfortable"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page3/tv_Make your life more comfortable'), 'Make your life more comfortable')


'swipe left -> right : page 3 to page 2'
Mobile.swipe(endX,endY,startX,startY,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tapAtPosition(startX, startY)

'swipe left -> right : page 2 to page 1'
Mobile.swipe(endX,endY,startX,startY,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tapAtPosition(startX, startY)

//TC0009: check swipe end left
'swipe left -> right : page 2 to page 1'
Mobile.swipe(endX,endY,startX,startY,FailureHandling.CONTINUE_ON_FAILURE)

Mobile.tapAtPosition(startX, startY)

Mobile.takeScreenshot()

'CHECKPOINT: Verify text: "Operate home appliances"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page1/tv_Opera home appliances'), 'Operate home appliances')

'CHECKPOINT: Verify text: "Connect to smart device in house by Connectty"'
Mobile.verifyElementText(findTestObject('Object Repository/Android/Page1/tv_Connect to'), 'Connect to smart device in house by Connectty')




