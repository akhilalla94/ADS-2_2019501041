import java.util.*;

import java.io.*;
import java.io.File;




public class Assignment{

    public void parsesynsets(String file) throws Exception{
        File synsets_data =new File("E:\\ADS-2_2019501041\\day1\\synsets.txt");
        BufferedReader BR = new BufferedReader(new FileReader(synsets_data));
        String synsets;
        while((synsets=BR.readLine()) != null){
            String [] str = synsets.split(",");

            System.out.println(str[0]);
            System.out.println(str[1]);

        }
    
    }
    public void parsehypernyms(String file) throws Exception{
        File hypernyms_data =new File("E:\\ADS-2_2019501041\\day1\\hypernyms.txt");
        BufferedReader BRR = new BufferedReader(new FileReader(hypernyms_data));
        String hypernyms;
        while((hypernyms  =BRR.readLine()) != null){
            String [] str = hypernyms.split(",");
            System.out.println(str[0]);
            System.out.println(str[1]);   
        }        
    }
    public static void main(String[] args) throws Exception{

        Assignment a = new Assignment();
        a.parsesynsets("synsets");

        a.parsehypernyms("hypernyms");


    }
}