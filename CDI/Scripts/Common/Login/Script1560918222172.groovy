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

Mobile.startApplication('C:\\Users\\JamesCao\\Desktop\\app-main-release.apk', false)

Mobile.delay(2)

Mobile.tap(findTestObject('Common/Login/bt_Agree_TermsConditions'), 0)

Mobile.delay(2)

Mobile.tap(findTestObject('Common/Login/bt_SignIn'), 0)

Mobile.delay(2)

Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_UserName'), 'cdi03dev')

Mobile.delay(2)

Mobile.sendKeys(findTestObject('Object Repository/Common/Login/et_Password'), '1256')

Mobile.delay(2)

Mobile.tap(findTestObject('Object Repository/Common/Login/bt_Submit'), 0)



