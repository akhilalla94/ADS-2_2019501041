import java.util.*;

import java.io.*;
import java.io.File;
import java.util.ArrayList;




public class WORDNET {
    int count =0;


    public void parsesynsets(String file) throws Exception {
        File synsets_data =new File("E:\\ADS-2_2019501041\\ADS-2_2019501041\\day2\\synsets.txt");
        BufferedReader BR = new BufferedReader(new FileReader(synsets_data));
        ArrayList<String[]> AL = new ArrayList<String[]>();
        String synsets;
        while((synsets=BR.readLine()) != null){
            
            String [] str = synsets.split(",");

            String []  str1 = str[1].split(" ");

            int len = str1.length+1;

            String []  str2 =new String[len];

            str2[0] =str[0];

            for(int i=1;i<len;i++){

                str2[i] =str1[i-1];

            }

            AL.add(str2);
            count++;
        }

        System.out.println(count);

    }   


    public void parsehypernyms(String file) throws Exception{

        Digraph D =new Digraph(count);

        File hypernyms_data =new File("E:\\ADS-2_2019501041\\ADS-2_2019501041\\day2\\hypernyms.txt");
        BufferedReader BRR = new BufferedReader(new FileReader(hypernyms_data));
        ArrayList<String[]> AL = new ArrayList<String[]>();
        String hypernyms;
        while((hypernyms  =BRR.readLine()) != null){
            String [] str = hypernyms.split(",");
            AL.add(str);
            int  id =Integer.parseInt(str[0]);

            for(int i=1 ; i< str.length; i++){
                D.addEdge(id,Integer.parseInt(str[i]));
            }
        }
        System.out.println(D.toString());
        System.out.println(count);
    }


    public static void main(String [] args) throws Exception {

        WORDNET a = new WORDNET();
        a.parsesynsets("synsets");

        a.parsehypernyms("hypernyms");


    }
}