package org.kevinoff.samplecode.samples;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.kevinoff.samplecode.DotNotationList;
import org.kevinoff.samplecode.DotNotationMap;
import org.kevinoff.samplecode.IteratorToInputStream;
import org.kevinoff.samplecode.JsonInputStreamToIterator;

public class StreamingSample {

    
    /**
     * This sample demonstrates a couple streaming classes that I built so
     * we could process streams of JSON without running out of memory.
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void runSample() throws FileNotFoundException, IOException {
        
        //Lets say that we did a web request and came back with a list of 11 Billion results in the input stream.
        IteratorToInputStream streamOfCars = IteratorToInputStream.jsonProducerIteratorToJsonArrayInputStream(DotNotationList.fromJson(getSampleJson()).iterator());
        
        //Now we can read that InputStream one object at a time
        JsonInputStreamToIterator<DotNotationMap> iterator = JsonInputStreamToIterator.makeIterator(streamOfCars, DotNotationMap.class);
        
        while(iterator.hasNext()) {
            //Each call to next ONLY loads the next object from the stream into memory
            DotNotationMap thing = iterator.next();
            System.out.println((String)thing.getProperty("make"));
        }
        
            
    }
    
    private String getSampleJson() {
        return "[{\"make\": \"Ford\"},{\"make\": \"Dodge\"},{\"make\": \"Pontiac\"},{\"make\": \"Fiat\"}]";
            
    }

}
