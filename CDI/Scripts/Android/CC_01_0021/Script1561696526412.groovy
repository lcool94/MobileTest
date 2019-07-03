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

// TC 0021
// 1. 「ユーザー登録」画面の表示を確認する
// 正しく表示されていること
// ※誤字・脱字、見キレ、翻訳されていない箇所、翻訳の不備等がないこと
// ※初回起動時のみ表示されること
// ユーザー名の表示部に端末に設定されているデフォルトの名称が表示されていること(***のiPhone等)

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

Mobile.delay(120)

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

Mobile.delay(120)

Mobile.takeScreenshot()

'Tap button I agree...'
Mobile.tap(findTestObject('Object Repository/Android/IH_Agreement/bt_I agree'), 0)

Mobile.delay(5)

'CHECKPOINT: Verify User Setting screen'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_User Setting'), 0), txt_UserSetting, false)

'CHECKPOINT: textview Please enter username'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Please enter username'), 0), txt_Please, false)

'CHECKPOINT: textview Username'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Username'), 0), txt_Username, false)

'CHECKPOINT: textview Gender'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Gender'), 0), txt_Gender, false)

'CHECKPOINT: textview Male'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Male'), 0), txt_Male, false)

'CHECKPOINT: textview Female'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Female'), 0), txt_Female, false)

'CHECKPOINT: textview Later'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Later'), 0), txt_Later, false)

'CHECKPOINT: textview Location'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Location'), 0), txt_Location, false)

'CHECKPOINT: textview Tokyo'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Tokyo'), 0), txt_Tokyo, false)

'CHECKPOINT: textview Confirm'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Android/User_Setting/tv_Confirm'), 0), txt_Confirm, false)

Mobile.delay(2)

Mobile.takeScreenshot()

//Mobile.verifyElementChecked(findTestObject('Object Repository/Android/User_Setting/tv_Male'), 0)
//Mobile.verifyElementChecked(findTestObject('Object Repository/Android/User_Setting/tv_Female'), 0)

Mobile.closeApplication()








