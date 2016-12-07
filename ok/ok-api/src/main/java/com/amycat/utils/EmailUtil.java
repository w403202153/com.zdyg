package com.amycat.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {
		
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.163.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			 protected PasswordAuthentication getPasswordAuthentication() {
		            return null;
		        }
		});
		session.setDebug(true);
		Transport ts = session.getTransport();
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("w403202153@163.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("403202153@qq.com"));
		message.setSubject("这是一封测试邮件");
		message.setContent("测试一下你的人品", "text/html;charset=utf-8");
		ts.send(message,message.getAllRecipients());
		ts.close();
	}
}
