package com.Jarvis.Library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import javax.mail.*;

public class UtilityClass {
	public static String getTD(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("/home/ts/eclipse-workspace/JARVIS/TestData/Jarvis.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		return value;
	}
	
	public static String getDatafromPropertyFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("/home/ts/eclipse-workspace/JARVIS/Config.properties");
		Properties prop=new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String captureScreenshot(String testCaseName,WebDriver driver) {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"//Screenshots//"+testCaseName+".png";
		
		try {
			FileHandler.copy(srcScreenshot,new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
	
	public static CharSequence generateRanodmEmail() 
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		String email = generatedstring+"@gmail.com";
		return email;
	}
	
//	public static String generateRandomEmail(int length)
//	{
//		//log.info("Generating a Random email String");
//	    String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
//	    String email = "";
//	    String temp = RandomStringUtils.random(length, allowedChars);
//	    email = temp.substring(0, temp.length() - 9) + "@testdata.com";
//	    return email;
//	}
	public static String GmailUtils() throws Exception {
		System.out.println("Wait for 30 second");
		Thread.sleep(30000);
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imap");
		props.setProperty("mail.imaps.partialfetch", "false");
		props.put("mail.imap.ssl.enable", "true");
		props.put("mail.mime.base64.ignoreerrors", "true");
		Session session = Session.getDefaultInstance(props, null);
		Store store = session.getStore("imap");
		store.connect("imap.gmail.com", "gangurdemayur97@gmail.com","oenqvzakqjdmhwlm");
		Folder folder = store.getFolder("Inbox");
		folder.open(Folder.READ_WRITE);

		//		    System.out.println("Total Messages:" + folder.getMessageCount());
		//		    System.out.println("Unread Messages:" + folder.getUnreadMessageCount());

		Message[] messages = folder.getMessages();

		for(int i = folder.getMessageCount() - 1; i > 0; i--) {
			Message msg = messages[i];
			if(!msg.isSet(Flags.Flag.SEEN)) {
				return getOtpFromBody(msg);
			}
		}
		return "";
	}

	public static String getOtpFromBody(Message email) throws IOException, MessagingException {
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(email.getInputStream()));
		while ((line = reader.readLine()) != null) {
			if(line.contains("OTP :")) {
				String[] otp = line.split(" : ", 2);
				return otp[1];
			}
		}
		return "";
	}
	

}
