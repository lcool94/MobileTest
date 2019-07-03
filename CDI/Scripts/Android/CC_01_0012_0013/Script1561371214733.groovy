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
Mobile.startApplication(userDir + '/App/Android/' + GlobalVariable.appName, false)

'Get Mobile driver'
MobileDriver driver = new MobileDriverFactory().getDriver()

Mobile.delay(2)

'tap button Sign In'
Mobile.tap(findTestObject('Common/Login/bt_SignIn'), 0)

Mobile.delay(2)

//TC 0012
// 1. 「ログイン」画面で、「ユーザー名」「パスワード」に未入力の状態で画面右上の「×」ボタンをタップする
// "「トップ」画面へ遷移すること
// 再度「ログイン」画面へ遷移した際に、入力した内容が消去されていること"

Mobile.takeScreenshot()

//Check blank Username, Password
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/et_Username'), 0), '', false)

Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/et_Password'), 0), '', false)

'tap button Close'
Mobile.tap(findTestObject('Object Repository/Common/Login/bt_close'), 0)

'tap button Sign In'
Mobile.tap(findTestObject('Common/Login/bt_SignIn'), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

//Check blank Username, Password
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/et_Username'), 0), '', false)

Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/et_Password'), 0), '', false)





// TC 0013
// 1. 「ログイン」画面で、「ユーザー名」「パスワード」に任意の値を入力した状態で画面右上の「×」ボタンをタップする
// "「トップ」画面へ遷移すること
// 再度「ログイン」画面へ遷移した際に、入力した内容が消去されていること"


String data_test = 'Tester01'

'input Username: Tester01'
Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_Username'), data_test)

'input Password: Tester01'
Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_Password'), data_test)

'tap button Close'
Mobile.tap(findTestObject('Object Repository/Common/Login/bt_close'), 0)

'tap button Sign In'
Mobile.tap(findTestObject('Common/Login/bt_SignIn'), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

'CHECKPOINT: blank Username, Password'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/et_Username'), 0), '', false)

Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/et_Password'), 0), '', false)












