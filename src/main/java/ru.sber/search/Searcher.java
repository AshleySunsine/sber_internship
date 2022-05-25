package ru.sber.search;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.iwork.IWorkPackageParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.DefaultHandler2;
import ru.sber.model.City;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Arrays;
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

   /* public void open(String file) {
        File fileIn = Paths.get(file).toFile();
        if (!fileIn.exists()) {
            throw new IllegalArgumentException(
                    String.format("Not exist %s", fileIn.getAbsoluteFile()
                            ));
        }

        try (InputStream input = new FileInputStream(fileIn)) {
            IWorkPackageParser iWorkParser = new IWorkPackageParser();
            ParseContext parseContext = new ParseContext();
            Metadata metadata = new Metadata();
            ContentHandler handler = new BodyContentHandler();
            iWorkParser.parse(input, handler, metadata, parseContext);

            List<String> metadataKeys = Arrays.asList(metadata.names());
            metadataKeys.stream().forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

}
