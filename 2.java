package oopslab8;

import java.io.*;  //imports all the packages regarding file io

public class BankSummary {//class name is banksummary the main class is inside this 
    public static void main(String[] args) {
        int success = 0;//counters to count how many passed and failed
        int failed = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("transactions.txt"));//open the transction txt for reading 
            String line;

            while((line = br.readLine()) != null) {
                String parts[] = line.split("\\|");//lines are split by these symbols in the text file 
                String status = parts[3];

                if(status.equalsIgnoreCase("SUCCESS"))
                    success++;
                else if(status.equalsIgnoreCase("FAILED"))
                    failed++;
            }
            br.close();//closes the bufferreader

            BufferedWriter bw = new BufferedWriter(new FileWriter("summary.txt"));//open new text file summary.txt
            bw.write("Total Successful Transactions : " + success);
            bw.newLine();
            bw.write("Total Failed Transactions     : " + failed);
            bw.close();

            System.out.println("Summary file written");

        } catch(Exception e) {
            System.out.println(e);
