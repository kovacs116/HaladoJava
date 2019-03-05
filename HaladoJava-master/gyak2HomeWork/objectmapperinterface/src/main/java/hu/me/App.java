package hu.me;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        int choose = 0;
        Controller controller = new Controller();
        Scanner sc = new Scanner(System.in);

        do{

            switch(choose) {
                case 1: {
                    System.out.println("Please give me the route to file!");
                    sc.nextLine();
                    controller.readFileIn(new File(sc.nextLine()));
                }break;

                case 2: {
                    System.out.println("Please give me the route to the output file!");
                    sc.nextLine();
                    controller.calculateAndWriteOut(new File(sc.nextLine()));

                }break;
                case 3: System.exit(0);
                default:
                    System.out.println("Lets go. You can do it....");
            }

            System.out.println("1. read file in and write to console");
            System.out.println("2. calculate and write to file");
            try{
                choose = sc.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("You have given wrong input!!");
            }
            catch(NumberFormatException e){
                System.out.println("Numberformat");
                e.printStackTrace();}

        }while(true);

    }

}
