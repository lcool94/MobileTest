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
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.WebElement

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

// TC 0050

// 1. 「デバイスの部屋割り当て 詳細」画面を表示する
// 2. 表示されているデバイスから任意のデバイスをタップして選択状態にする
// 3. 「登録」ボタンをタップする

// 「デバイスの部屋割り当て」画面へ遷移すること
// 部屋に割り当てられているデバイスの数が、選択した数と同数に変化していること

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

'tap Target icon'
Mobile.tap(findTestObject('Object Repository/Android/Location/tv_Target'), 0)

Mobile.takeScreenshot()

Mobile.delay(5)

'tap Save'
Mobile.tap(findTestObject('Object Repository/Android/Location/tv_Save'), 0)

Mobile.delay(2)

'tap Confirm'
Mobile.tap(findTestObject('Object Repository/Android/User_Setting/tv_Confirm'), 0)

Mobile.delay(5)

MobileDriver driver2 = new MobileDriverFactory().getDriver()

String xPath_group = '/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[*]/android.view.View/android.widget.TextView[1]'

int index = getIndex(driver2, xPath_group, 'Auto')

String xPath_devices = '/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[*]/android.view.View/android.widget.TextView[2]'

//Get total devices in group
println index.toString()
println getTotal(driver2, xPath_devices, index)

int device_before = getTotal(driver2, xPath_devices, index)

Mobile.takeScreenshot()

'Tap Item Auto'
Mobile.tap(findTestObject('Android/Group_Setting/tv_Item_Auto'), 0)

Mobile.delay(2)

String xPath_group_details = '/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.view.View/android.view.View[*]/android.view.View'
driver2.findElements(MobileBy.xpath(xPath_group_details)).get(0).click()

'Tap button Edit'
Mobile.tap(findTestObject('Object Repository/Android/Group_Setting_Details/tv_Edit'), 0)

Mobile.delay(2)

'CHECKPOINT: Check total devices on group not changes'
Mobile.verifyMatch(getTotal(driver2, xPath_devices, index).toString(), device_before.toString(), false)

Mobile.takeScreenshot()

Mobile.closeApplication()


def int getIndex(MobileDriver driver, String xPath, String name){
	List<MobileElement> list_mE = driver.findElements(MobileBy.xpath(xPath))
	for(int i=0;i<list_mE.size();i++){
		
		if(list_mE.get(i).getAttribute('text').equals(name)){
			return i
		}
	}
	return null
}

def int getTotal(MobileDriver driver, String xPath, int index){
	List<MobileElement> list_mE = driver.findElements(MobileBy.xpath(xPath))
	String devices = list_mE.get(index).getAttribute('text')
	List<String> total_devices = devices.split(" ")
	return (int)total_devices[0]
}









