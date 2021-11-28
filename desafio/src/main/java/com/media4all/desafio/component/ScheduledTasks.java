package com.media4all.desafio.component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Component
public class ScheduledTasks{

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private ReadCSV readCSV;

	
	@Scheduled(fixedDelay = 5000)
	public void sendLog() {
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

		System.out.println("records: "+records);

		for(int i=0; i<records.size(); i++){
			String record = records.get(i).get(0);
			System.out.println("record: "+ record);

			List<String> lista = new ArrayList<>();
			//lista.add();

			String[] data = record.split(" ");

			String date = data[0]+" "+data[1];
			System.out.println("date: "+ date);

			String ip = data[3];
			System.out.println("ip: "+ ip);

			String endpoint = data[5];
			System.out.println("endpoint: "+ endpoint);







//			for(int j=0; j<lista.size(); j++) {
//				System.out.println("lista: " + lista);
//			}



		}


		//String records.get(0).split("");






		//log.info("The time is now {}", dateFormat.format(new Date()));

//		try (CSVReader reader = new CSVReader(new FileReader("log.csv"))) {
//			String[] lineInArray;
//			Integer i = 0;
//
//			while ((lineInArray = reader.readNext()) != null){
//
//				log.info("{}", lineInArray[i]);
//				i++;
//
//
//			}
//			//log.info("The time is now {}", dateFormat.format(new Date()));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException | CsvValidationException e) {
//			e.printStackTrace();
//		}
		//log.info("{}", lineInArray);

	}
}
