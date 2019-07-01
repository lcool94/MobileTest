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



// TC 0010
// 「トップ」画面で「ログイン」ボタンをタップする	「ログイン」画面へ遷移すること

// Check exist Element Username, Password
Mobile.verifyElementExist(findTestObject('Object Repository/Common/Login/et_UserName'), 2, FailureHandling.OPTIONAL)

Mobile.verifyElementExist(findTestObject('Object Repository/Common/Login/et_Password'), 2, FailureHandling.OPTIONAL)





// TC 0011
// 「ログイン」画面の表示を確認する	"正しく表示されていること
// ※誤字・脱字、見キレ、翻訳されていない箇所、翻訳の不備等がないこと"

'Check text: Remocon'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/tv_Remocon'), 0), 'Remocon', false)

'check placeholder text: Username'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/tv_UserName'), 0), 'Username', false)

'check placeholder text: Password'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/tv_Password'), 0), 'Password', false)

'check button submit text: Submit'
Mobile.verifyMatch(Mobile.getText(findTestObject('Object Repository/Common/Login/tv_Submit'), 0), 'Submit', false)


















