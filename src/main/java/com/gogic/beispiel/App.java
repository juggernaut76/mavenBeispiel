package com.gogic.beispiel;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        File file = new File("/Users/Gogic/Desktop/BeendeteBuchungen.csv");

        try {
            CSVParser parser = CSVParser.parse(file, Charset.forName("UTF-8"), CSVFormat.DEFAULT.withQuote(null));
            Iterator<CSVRecord> iterator = parser.iterator();
            iterator.next();
            Integer sum = 0;
            while (iterator.hasNext()) {
                CSVRecord csvRecord = iterator.next();
                String csvLine = csvRecord.get(0);
                String[] arr = csvLine.split(";");
                sum = sum + Integer.parseInt(arr[arr.length - 1]);
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}