package CS201LLab3Base;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        
        //define variables & arrays
    int[] x = new int[7];
    int[] y = new int[7];
    int[] z = new int[7];
 
        try {
            //establish File, Scanner, FileWriter and PrintWriter objects
            File inputFile = new File("input.txt"); 
            Scanner scanner = new Scanner(inputFile);
            FileWriter fileWriter = new FileWriter("output.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);

            //read input file & load the values into the arrays created for input values
            for (int i = 0; i < 7; i++) {
                if (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.trim().split("\\s+");
                    x[i] = Integer.parseInt(parts[0]);
                    y[i] = Integer.parseInt(parts[1]);
                    z[i] = Integer.parseInt(parts[2]);
                }
            }
            scanner.close();

            //loop through array values and output distance to the output file
            System.out.println("X1\tX2\tY1\tY2\tZ1\tZ2\tDistance between points");
            System.out.println("-----------------------------------------------------");
            for (int i = 0; i < 6; i++) {
                double distance = Math.sqrt(Math.pow(x[i+1]-x[i],2) + Math.pow(y[i+1]-y[i],2) + Math.pow(z[i+1]-z[i],2));
                System.out.printf("%d\t%d\t%d\t%d\t%d\t%d\t%.2f\n", x[i], x[i+1], y[i], y[i+1], z[i], z[i+1], distance);
                printWriter.printf("%d\t%d\t%d\t%d\t%d\t%d\t%.2f\n", x[i], x[i+1], y[i], y[i+1], z[i], z[i+1], distance);
            }

            //Close 
            printWriter.close();
            fileWriter.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found" );
            return;
        }
        catch (IOException e){
            System.out.println("An error occured during processing");
            return;
        }

    }
    
}
