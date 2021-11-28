package com.media4all.desafio.component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ReadCSV {

    @Async
    public List<String> lerCSV() {

        List<String> data = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("log.csv"))) {

            String[] lineInArray;

            int i = 0;
            while ((lineInArray = reader.readNext()) != null){

                data.add(lineInArray[i]);
                i++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        System.out.println("data: "+data);
        return data;
    }

}
