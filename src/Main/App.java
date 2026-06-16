package Main;
import java.util.Scanner;

import Models.School;
import Services.SchoolServices;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        School school = new School("Tech School","Egypt","01060834270");

        SchoolServices services = new SchoolServices(school);
        Hmi hmi = new Hmi(services, scanner);
        hmi.Start();
    }
    


}
