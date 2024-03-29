package Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.w3c.dom.Document;

import DriverMaster.MasterWebDriver;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class Constants {
	
	
	public Constants() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static String staticElement;
	
	public static String expectedURLPATH = null;
	public static String actualPageHeader = null;
	public static String expectedPageHeader = null;
	public static String actualCurrentURL = null;

	
	
	public static int createParentTestOnlyOnce;

	public static String TIMESTAMPFOLDER = null;
	public static String rcTicket = null;
	public static String releaseNumber = null;
	public static String companyUsername = null;
	public static String COMMENT = null;
	public static String requestBody= null;
	public static String RELEASE_NUMBER = null;
	public static String APPTYPE = null;
	public static String REGION = null;
	public static String randomUsername = null;
	public static String randomPassword = null;
	public static String ACCOUNTSTATUS = null;
	public static String FIRSTNAME = null;
	public static String LASTNAME = null;
	public static String ADDRESS = null;
	public static String CITY = null;
	public static String STATE = null;
	public static String ZIPCODE = null;
	public static String PHONENUM = null;
	public static String SSN = null;
	public static String USERNAME = null;
	public static String PASSWORD = null;	
	public static int passed = 0;
	public static int failed = 0;
	public static String resultsFolder_testOutput = null;
	public static String path;
	public static String logpath;
	public static String excelResultsPath = null;
	public static String resultsFolder = null;	
	public static Document document;
	public static HttpPost httpPost;
	public static HttpClient httpClient;
	public static StringEntity stringEntity;
	public static HttpResponse response = null;
	public static HttpEntity entity;
	public static String consumer = null;
	public static String StatusMessage = null;
	public static HttpResponse httpResponse = null;
	public static RequestSpecification httpRequest= null;
	public static String requestBodySoap = null;
	public static String responseBody = null;
	public static List<String> failedValidationMessageList = new ArrayList<String>();
	public static int responseStatusCode;
	public static int totalValidationCount;
	public static int passedValidationCount;
	public static int failedValidationCount;	
	public static String Status = null;
	public static String comment = null;
	public static String runResultsFileName = null;
	public static String username_Excel = null;
	public static String password_Excel = null;
	public static String entityBody = null;
	public static String endpoint = null;
	public static String EndpointRunner = null;
	public static String Environment = null;
	public static String Username = null;
	public static String RANDOMUSERNAME = null;
	public static String password = null;
	public static int expectedResponseStatusCode = 0;
	public static String expectedResponseMessage = null;
	public static Map<String, String> headersMap = new HashMap<String, String>();
	public static Headers responseHeaders;

	
}
