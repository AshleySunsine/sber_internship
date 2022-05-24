package ru.sber.search;

import com.drew.metadata.Metadata;
import org.apache.tika.parser.iwork.IWorkPackageParser;
import ru.sber.model.City;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.List;

public class Searcher {
    public City search(List<City> cities) {
        City[] cityiesArray1 = cities.toArray(new City[0]);
        long maxPopulation = 0;
        int idMaxCity = 0;
        for (int i = 0; i < cityiesArray1.length; i++) {
            long poplation = cityiesArray1[i].getPopulation();
            if  (poplation > maxPopulation) {
                maxPopulation = poplation;
                idMaxCity = i;
            }
        }
        return cities.get(idMaxCity);
    }

    public void open(String file) {
        File fileIn = Paths.get(file).toFile();
        if (!fileIn.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s", fileIn.getAbsoluteFile()
                            ));
        }


        try (InputStream input = new FileInputStream(fileIn)) {
            org.apache.tika.parser.ParseContext parseContext;
            parseContext.set(Parser.class, new AutoDetectParser());
            IWorkPackageParser iWorkParser = new IWorkPackageParser();
            Metadata metadata = new Metadata();
            PagesContentHandler handler = new PagesContentHandler();
            iWorkParser.parse(input, handler, metadata, parseContext);



        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
