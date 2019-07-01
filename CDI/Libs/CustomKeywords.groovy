
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import io.appium.java_client.MobileDriver

import java.lang.String


def static "android.MobileHandle.checkExistApp"(
    	MobileDriver driver	
     , 	String appPackage	) {
    (new android.MobileHandle()).checkExistApp(
        	driver
         , 	appPackage)
}

def static "android.MobileHandle.checkNotExistApp"(
    	MobileDriver driver	
     , 	String appPackage	) {
    (new android.MobileHandle()).checkNotExistApp(
        	driver
         , 	appPackage)
}
