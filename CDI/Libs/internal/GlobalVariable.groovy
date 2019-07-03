package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object userName
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object deviceID
     
    /**
     * <p></p>
     */
    public static Object appName
     
    /**
     * <p></p>
     */
    public static Object appPackage
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['userName' : 'cdi03dev', 'password' : '1256'])
        allVariables.put('Android', allVariables['default'] + ['deviceID' : '', 'appName' : 'app-original-release.apk', 'appPackage' : 'jp.connected_design.connectedremocon'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        userName = selectedVariables['userName']
        password = selectedVariables['password']
        deviceID = selectedVariables['deviceID']
        appName = selectedVariables['appName']
        appPackage = selectedVariables['appPackage']
        
    }
}
