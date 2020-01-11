import java.util.*;

import java.io.*;
import java.io.File;
import java.net.Inet6Address;
import java.util.Arrays;
import java.util.Map; 



public class Solution{

    HashMap<Integer, String> hashMap  = new HashMap<>(); 
    HashMap<Integer, Integer> hashMap1  = new HashMap<>(); 
    HashMap<Integer, Integer> hashMap2 = new HashMap<>(); 

    int [] array;


  


    public void parseemails(String file) throws Exception{
        File emails = new File("E:\\ADS-2_2019501041\\ADS-2_2019501041\\ADS - 2 Exam - 1\\emails.txt");
        
        BufferedReader BR = new BufferedReader(new FileReader(emails));
        //ArrayList<String[]> AL = new ArrayList<String[]>();
        String string;
        
        while((string = BR.readLine()) != null){

            String [] str =string.split(";");

            int id1 =Integer.parseInt(str[0]);
            hashMap.put(id1,str[1]);


            //System.out.println(str[0] + " " + str[1]);

        }
        array = new int[hashMap.size()];

            for(int i=0; i<array.length;i++){
                array[i] = 0;

            }

    }

    public void parseemaillogs(String file) throws Exception{
        File emaillogs = new File("E:\\ADS-2_2019501041\\ADS-2_2019501041\\ADS - 2 Exam - 1\\email-logs.txt");

        BufferedReader BRR = new BufferedReader(new FileReader(emaillogs));
        //ArrayList<String[]> AL = new ArrayList<String[]>();
        String st;

        while((st = BRR.readLine()) != null){
            String [] str = st.split(" ");

            String [] str1 = str[1].split(",");
            int id1 = Integer.parseInt(str1[0]);
            int id2 = Integer.parseInt(str[3]);
            hashMap1.put(id1,id2);

            array[id2]++;


            //System.out.println(str1[0] + " " + str[3]);
            //System.out.println(str[1]);
        }

        for(int j=0;j<array.length;j++){
            hashMap2.put(array[j],j);
        }

        Arrays.sort(array);
        for(int k = array.length-1; k>array.length-10;k--){
            System.out.println(hashMap.get(hashMap2.get(array[k]))+ " ,"+ array[k]);

        }


   }
    public static void main(String[] args) throws Exception{

        Solution S = new Solution();

        S.parseemails("emails");
        S.parseemaillogs("emaillogs");
        // System.out.println(S.hashMap1);
        // System.out.println(S.hashMap);



    }
}