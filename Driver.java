/**
 * @fileName :Driver.java
 **/
package toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @Author :
 * @Date : 19 Feb, 2017,1:57:19 AM
 */
public class Driver {
    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String option=null;
        int age;
        String toyName;
        do{
            System.out.println("Age Range:");
            System.out.println(" plushie: 0 to 2 years");
            System.out.println(" book: 4 to 7 years");
            System.out.println(" block: 3 to 5 years");

            System.out.print("Enter the Child Age:");
            age = sc.nextInt();
            System.out.print("Enter the  toy name:");
            toyName  = sc.next();
            Toy toy = new Toy(toyName,age);
            while (!toy.ageOK()){
            System.out.print("change the Age:");
                age = sc.nextInt();
                toy.setAge(age);
            }

            String flag;
            System.out.print("You want to add card?yes/no:");
            flag = sc.next();
            toy.addCard(flag);
            System.out.print("You want to add balloon?yes/no:");
            flag = sc.next();
            toy.addBalloon(flag);
            toys.add(toy);
            System.out.print("you want to purchase More?yes/no:");
            option=sc.next();
        }while (!option.equalsIgnoreCase("no"));

        int orderId = 100000 + new Random().nextInt(900000);

        System.out.println("------------------- Yor Order --------------------------");
        System.out.println("--------------------------------------------------------");
        System.out.println("Order Number :"+orderId);
        double orderTotal=0;
        System.out.print(String.format("%-15s%-15s\n","Toy Name","Cost"));
        for (Toy toy:toys){
            System.out.print(String.format("%-15s%-13.2f\n",toy.getToy(),toy.getCost()));
            orderTotal+=toy.getCost();
        }
        System.out.println("---------------------------------------------------------");
        System.out.print(String.format("%-15s%-13.2f\n","Order total:",orderTotal));
    }
}