package com.media4all.desafio.component;

import com.media4all.desafio.model.EndPointRegister;
import com.media4all.desafio.model.LogRegister;
import com.media4all.desafio.service.EndPointRegisterService;
import com.media4all.desafio.service.LogRegisterService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ScheduledTasks{

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private LogRegisterService logRegisterService;

	@Autowired
	private EndPointRegisterService endPointRegisterService;


	@Scheduled(fixedDelay = 5000)
	public void sendLog() throws Exception {
		List<List<String>> records = new ArrayList<>();

		try (CSVReader csvReader = new CSVReader(new FileReader("log.csv"));) {
			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				records.add(Arrays.asList(values));
			}
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//
		for(int i=0; i<records.size(); i++){
			String record = records.get(i).get(0);

			List<String> lista = new ArrayList<>();

			String[] data = record.split(" ");

			String date = data[0]+" "+data[1];

			String ip = data[3];
			System.out.println("ip: "+ ip);

			String endpoint = data[5];
			System.out.println("endpoint: "+ endpoint);

//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

			//SALVAR OS DADOS NA TABELA LOG_REGISTER
			LogRegister logRegister = new LogRegister();

			logRegister.setCreateDate(date);
			logRegister.setIp(ip);

			logRegister = logRegisterService.create(logRegister);

			System.out.println("logRegister INSERIDO: "+ logRegister);


			//SALVAR OS DADOS NA TABELA ENDPOINT_REGISTER
			EndPointRegister endPointRegister = new EndPointRegister();

			endPointRegister.setCreateDate(date);
			endPointRegister.setContent(endpoint);

			endPointRegister = endPointRegisterService.create(endPointRegister);

			System.out.println("endPointRegister INSERIDO: "+ endPointRegister);

		}
	}
}
