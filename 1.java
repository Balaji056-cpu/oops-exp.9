package oopslab8;

import java.io.*;//import all file reading input output
import java.util.*;

public class FileMenu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n1. Create New File");
            System.out.println("2. Rename File");
            System.out.println("3. Delete File");
            System.out.println("4. Create Directory");
            System.out.println("5. Find Absolute Path of File");
            System.out.println("6. Display All File Names of a Directory");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch(ch){
                case 1:
                    System.out.print("Enter file name: ");
                    String fname = sc.next();
                    try{
                        File f = new File(fname); //create new file 
                        if(f.createNewFile())
                            System.out.println("File Created");
                        else
                            System.out.println("File Already Exists");
                    }catch(Exception e){System.out.println(e);}//print any exception and return to main menu
                    break;

                case 2:
                    System.out.print("Enter existing file name: ");
                    String oldf = sc.next();
                    System.out.print("Enter new file name: ");
                    String newf = sc.next();
                    File fold = new File(oldf);
                    File fnew = new File(newf);
                    if(fold.renameTo(fnew))
                        System.out.println("File Renamed");
                    else
                        System.out.println("Rename Failed");
                    break;

                case 3:
                    System.out.print("Enter file name to delete: ");
                    String df = sc.next();
                    File fd = new File(df);
                    if(fd.delete())
                        System.out.println("File Deleted");
                    else
                        System.out.println("Delete Failed");
                    break;

                case 4:
                    System.out.print("Enter directory name: ");
                    String dname = sc.next();
                    File dir = new File(dname);
                    if(dir.mkdir())
                        System.out.println("Directory Created");
                    else
                        System.out.println("Directory not Created");
                    break;

                case 5:
                    System.out.print("Enter file name to get absolute path: ");
                    String af = sc.next();
                    File file = new File(af);
                    System.out.println("Absolute Path: " + file.getAbsolutePath()); //get absolute path to get the path of the file 
                    break;

                case 6:
                    System.out.print("Enter directory name: ");
                    String dirname = sc.next();
                    File d = new File(dirname);
                    String list[] = d.list();//list to get all the files in the directory
                    if(list != null){
                        for(String s:list)
                            System.out.println(s);
                    } else {
                        System.out.println("Not a directory or empty");
                    }
                    break;

                case 7:
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}


