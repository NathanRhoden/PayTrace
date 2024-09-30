package com.nathanrhoden.paytrace;

import com.nathanrhoden.paytrace.entity.Message;
import com.nathanrhoden.paytrace.entity.TransferMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaytraceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaytraceApplication.class, args);
	}

	Message m = new TransferMessage("BAAADB");


}
