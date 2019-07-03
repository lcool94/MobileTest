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

// TC 0023
// 1. 「ユーザー登録」画面を表示する
// 2. 「男性」「女性」「未選択」ボタンから任意のボタンをタップする
// タップしたボタンがアクティブになっていることがわかる表示になること

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

'CHECKPOINT: textview Male'
Mobile.tap(findTestObject('Object Repository/Android/User_Setting/tv_Male'), 0)

//driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.widget.ScrollView[1]/android.view.View[1]/android.view.View[2]/android.widget.TextView[1]").getCssValue('background-color')

Mobile.takeScreenshot()

'CHECKPOINT: textview Female'
Mobile.tap(findTestObject('Object Repository/Android/User_Setting/tv_Female'), 0)

Mobile.takeScreenshot()

'CHECKPOINT: textview Later'
Mobile.tap(findTestObject('Object Repository/Android/User_Setting/tv_Later'), 0)

Mobile.takeScreenshot()

Mobile.delay(2)

Mobile.closeApplication()








