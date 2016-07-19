package com.github.rsallar.underevalprj.repository;

import org.junit.Test;

public class EmailRepositoryIntegrationTest {
	
	MailRepository emailRepo = new MailRepository();
	
	@Test
	public void test(){
		emailRepo.sendEmail("rsallar@gmail.com", "noreply@noreply.com", "hi there!", "<b>works</b>", "you've got an email");
	}

}
