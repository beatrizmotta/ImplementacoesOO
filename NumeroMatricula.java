import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class NumeroMatricula {
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int numeroCreator() {

        int numeroDeMatricula = getRandomNumber(100000, 200000);
        boolean uniqueValue = true; 
        

        try {
            File myObj = new File("matriculas.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              
              if (Integer.toString(numeroDeMatricula) == data) {
                uniqueValue = false; 
              }

            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

          if (uniqueValue == false) {
              numeroCreator();
          }

            return numeroDeMatricula;
          


        }

}