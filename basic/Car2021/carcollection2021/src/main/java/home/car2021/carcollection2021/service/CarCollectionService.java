package home.car2021.carcollection2021.service;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import home.car2021.carcollection2021.model.Car;

@Service
public class CarCollectionService {
    private final Logger logger;

    public CarCollectionService(Logger logger) {
        this.logger = logger;
    }

    public List<Car> getListCar() {
        try {
            File file = ResourceUtils.getFile("classpath:static/carlist.csv");
            logger.info(" " + file.toString());
            CsvMapper mapper = new CsvMapper();
            CsvSchema schema = CsvSchema.emptySchema().withHeader().withColumnSeparator(',');
            ObjectReader objectReader = mapper.readerFor(Car.class).with(schema);
            List<Car> carList = new ArrayList<>();
            Reader reader = new FileReader(file);

            MappingIterator<Car> mappingIterator = objectReader.readValues(reader);
            while(mappingIterator.hasNext()) {
                Car currentCar = mappingIterator.next();
                carList.add(currentCar);
            }

            return carList;
        } catch (Exception e) {
            logger.info("list is empty" + e.getMessage());
            return Collections.emptyList();
        }
    }
}
