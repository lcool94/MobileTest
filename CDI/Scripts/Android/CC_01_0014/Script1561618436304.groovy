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


// TC 0014
// 1. 「ログイン」画面で、「パスワード」に任意の値を入力した状態で目アイコンをタップする
// "入力しているパスワードがマスク表示から、値が見える状態へ変化することもう一度タップすることにより、マスク表示へ戻ること"



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
Mobile.takeScreenshot()

'CHECKPOINT: Password symbol, before tap'
Mobile.verifyMatch(Mobile.getAttribute(findTestObject('Object Repository/Common/Login/tv_Password'), 'password', 0), 'true', false)

'Tap Eye Icon'
Mobile.tap(findTestObject('Object Repository/Common/Login/icon_Password_eye'), 0)

'CHECKPOINT: Password symbol, after tap'
Mobile.verifyMatch(Mobile.getAttribute(findTestObject('Object Repository/Common/Login/tv_Password'), 'password', 0), 'false', false)








