package org.kevinoff.samplecode.samples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import org.kevinoff.samplecode.DotNotationList;
import org.kevinoff.samplecode.DotNotationMap;

public class DotNotationMapExample {

    
    /**
     * This sample shows the use of the DotNotationMap and DotNotationList.
     * It is an extension of a LinkedHashMap so order is preserved.
     * It is intended to be used with the MongoDB library and it is what I used
     * to transform all data in and out of all applications within the enterprise.
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void runSample() throws FileNotFoundException, IOException {
        
        //Load the map up with the JSON source
        DotNotationMap car = DotNotationMap.fromJson(getSampleJson());
        
        //Get individual basic properties
        String make = car.getProperty("make");
        String model = car.getProperty("model");
        
        //Dates are treated special so they are always in ISO8601
        Date date = car.getProperty("date");
        
        //Get another DotNotationMap to traverse
        DotNotationMap engine = car.getProperty("engine");
        int cylindars = engine.getProperty("cylinders");
        
        //Access properties based on "dot notation"
        int horsepower = car.getProperty("engine.hp");
            
        // Get a property from the list 
        DotNotationList<String> features = car.getProperty("features");
        String feature1 = features.getProperty("0");
        
        //Get a property from the List from within the Map
        String feature2 = car.getProperty("features.1");
        
        
       
        
        //You can also set properties the same way on a map
        car.setProperty("engine.type", "LS1");
        
        //or on a list
        car.setProperty("features.3", "Tinted Windows");
        
        //or add a complex object
        car.setProperty("maintenance.2.body", Arrays.asList("Wash", "Rince", "Wax"));
        
        System.out.println(car.toPrettyJson());
        
            
    }
    
    private String getSampleJson() {
        return "{" +
            "    \"date\": \"20201202T130522Z\"," +
            "    \"make\": \"Pontiac\"," +
            "    \"model\": \"Trans Am\"," +
            "    \"engine\": {" +
            "        \"cylinders\": 8," +
            "        \"hp\": 305" +
            "    }," +
            "    \"color\": \"black\"," +
            "    \"features\": [" +
            "        \"Electric Seats\"," +
            "        \"Upgraded Radio\"," +
            "        \"T-Tops\"" +
            "    ]," +
            "    \"maintenance\": [" +
            "        {" +
            "            \"engine\": [\"Regular Oil Changes\", \"Changed Transmission Fluid\"]" +
            "        },{" +
            "            \"tires\": [\"Regular tire rotation\", \"Maintain 30 lbs of air\"]" +
            "        }" +
            "    ]" +
            "}";
    }

}
