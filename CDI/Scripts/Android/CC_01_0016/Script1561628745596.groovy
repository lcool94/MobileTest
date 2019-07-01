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

// TC 0016
// 1. 「ログイン」画面で、「ユーザー名」「パスワード」に正しくない値を入力した状態で「ログイン」ボタンをタップする
// 入力した内容が間違えている旨のエラーメッセージ表示が行われること

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


//

'Input wrong Username'
Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_UserName'), wrongUserName)

'Input wrong password'
Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_Password'), wrongPassword)

'Tap button Sign In'
Mobile.tap(findTestObject('Object Repository/Common/Login/bt_Submit'),0)

Mobile.delay(5)

'CHECKPOINT: Alert message Wrong username or password'
Mobile.verifyMatch(Mobile.getText(findTestObject('Common/Login/alertMessage_Wrong username or password'), 0), Alert_Message, false)












