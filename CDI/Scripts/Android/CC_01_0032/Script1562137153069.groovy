import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

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

// TC 0032

// 1. 「デバイスの部屋割り当て」画面を表示する
// 2. デバイスが割り当てられている部屋の表示を確認する
// 3. 「リビング」(デフォルト)をタップする

// アカウントに接続されている対応デバイスのすべてが「リビング」に割り当てられていること

String appPackage = GlobalVariable.appPackage

String userDir = RunConfiguration.getProjectDir()

'Start app'
Mobile.startApplication(userDir + '/App/Android/' + GlobalVariable.appName, false)

'Get Mobile driver'
MobileDriver driver = new MobileDriverFactory().getDriver()

'Uninstall app'
driver.removeApp(appPackage)

Mobile.delay(2)

'Install app'
Mobile.startApplication(userDir + '/App/Android/' + GlobalVariable.appName, false)

Mobile.delay(GlobalVariable.delay_Term)

Mobile.tap(findTestObject('Object Repository/Common/Login/bt_Agree_TermsConditions'), 0)

Mobile.delay(10)

'tap button Sign In'
Mobile.tap(findTestObject('Common/Login/bt_SignIn'), 0)

Mobile.delay(2)


//

'Input Username'
Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_UserName'), GlobalVariable.userName)

'Input password'
Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_Password'), GlobalVariable.password)

Mobile.takeScreenshot()

'Tap button Sign In'
Mobile.tap(findTestObject('Object Repository/Common/Login/bt_Submit'),0)

Mobile.delay(GlobalVariable.delay_Term)

Mobile.takeScreenshot()

'Tap button I agree...'
Mobile.tap(findTestObject('Object Repository/Android/IH_Agreement/bt_I agree'), 0)

Mobile.delay(5)

'tap Location'
Mobile.tap(findTestObject('Object Repository/Android/User_Setting/tv_Location'), 0)

Mobile.delay(2)

'CHECKPOINT: textview Map'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/Location/tv_Map'), 0), txt_Map, false)

Mobile.delay(2)

'tap Target icon'
Mobile.tap(findTestObject('Object Repository/Android/Location/tv_Target'), 0)

Mobile.takeScreenshot()

//Get location
//String location = ""

Mobile.delay(5)

'tap Save'
Mobile.tap(findTestObject('Object Repository/Android/Location/tv_Save'), 0)

Mobile.delay(2)

'tap Confirm'
Mobile.tap(findTestObject('Object Repository/Android/User_Setting/tv_Confirm'), 0)



Mobile.closeApplication()





