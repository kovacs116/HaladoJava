package hu.me;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Controller {
    private Calculator calculator = new Calculator();
    private ObjectMapper objectMapper;
    private InputClass inputClass = null;
    private OutputClass outputClass = new OutputClass();


    public void readFileIn(File inputFile) {
        String extension = "";

        int i = inputFile.getName().lastIndexOf('.');
        if (i > 0) {
            extension = inputFile.getName().substring(i+1);
        }

        switch (extension) {
            case "json": objectMapper = new ObjectMapper(); break;
            case "yaml": objectMapper = new ObjectMapper(new YAMLFactory());break;
            case "yml": objectMapper = new ObjectMapper(new YAMLFactory());break;
            default:
                System.out.println("You have given an unsupported file type!");
                return;
        }


        try {
            inputClass = objectMapper.readValue(inputFile, InputClass.class);
        } catch (Exception e) {
            System.out.println("You have given wrong route to file!");
            return;
        }
        System.out.println(inputClass.toString());
    }


    public void calculateAndWriteOut(File outputFile) {
        if (inputClass == null) {
            System.out.println("First you have to choose to read a file in!!");
            return;
        }
        switch (inputClass.getMuvelet()) {
            case "osszeadas": {
                outputClass.setEredmeny(calculator.add(inputClass.getOperandusok().get(0), inputClass.getOperandusok().get(1)));
                outputClass.setHibakod(0);
                outputClass.setUzenet("nincs");
            }break;
            case "kivonas": {
                outputClass.setEredmeny(calculator.sub(inputClass.getOperandusok().get(0), inputClass.getOperandusok().get(1)));
                outputClass.setUzenet("nincs");
                outputClass.setHibakod(0);
            }break;
            case "szorzas": {
                outputClass.setEredmeny(calculator.mult(inputClass.getOperandusok().get(0), inputClass.getOperandusok().get(1)));
                outputClass.setHibakod(0);
                outputClass.setUzenet("nincs");
            }break;
            case "osztas":
                try {
                    outputClass.setEredmeny(calculator.div(inputClass.getOperandusok().get(0), inputClass.getOperandusok().get(1)));
                    outputClass.setUzenet("nincs");
                    outputClass.setHibakod(0);
                } catch (DivisionByZeroException e) {
                    outputClass.setUzenet(e.getMessage());
                    outputClass.setHibakod(100);
                    outputClass.setEredmeny(0);
                }
                break;
        }
        try {
            objectMapper.writeValue(new FileOutputStream(outputFile), outputClass);
        } catch (IOException e) {
            System.out.println("You have given an unsupported file type!");
            return;
        }

        System.out.println("Successfully written to file!");

    }

}
