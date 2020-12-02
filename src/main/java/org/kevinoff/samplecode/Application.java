package org.kevinoff.samplecode;

import org.kevinoff.samplecode.samples.DotNotationMapExample;
import org.kevinoff.samplecode.samples.StreamingSample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author kevonoff
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        DotNotationMapExample one = new DotNotationMapExample();
        one.runSample();
        
        StreamingSample two = new StreamingSample();
        two.runSample();
        
    }


}
