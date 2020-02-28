package toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 *
 * @Author : Abdullah Nabeel
 * 
 */
public class Birthday {
    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        List<String> Names = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String option=null;
        int age;
        String toyName;
        String name;
        String last;
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        do{
            System.out.println("Age Range:");
            System.out.println(" plushie: 0 to 2 years");
            System.out.println(" book: 4 to 7 years");
            System.out.println(" block: 3 to 5 years");

            System.out.print("Enter the name of the child (Please enter the full name) : ");
            name = sc.next();
            last = sc.next();
            Names.add(name+" "+last);
            System.out.print("Enter the Child Age:");
            age = sc.nextInt();
            System.out.print("Enter the  toy name:");
            toyName  = sc.next();
            Toy toy = new Toy(toyName,age);
            
            if(!toy.ageOK()){
            System.out.print("the toy is not age appropriate and do you still want to continue with this toy? Yes/No");
                String temp = sc.next();
                if(temp.equalsIgnoreCase("no"))
                continue;
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
        sc.close();

        int orderId = 100000 + new Random().nextInt(900000);

        // System.out.println("------------------- Yor Order --------------------------");
        // System.out.println("--------------------------------------------------------");
        double orderTotal=0;
        // System.out.print(String.format("%-15s%-15s\n","Toy Name","Cost"));
        int count = 0;
        for (Toy toy:toys){
            System.out.println("The Gift for "+Names.get(count++)+" "+toy.getAge()+" years old is "+toy.getToy()+" $"+toy.getCost());
            orderTotal+=toy.getCost();
            // count++;
        }
        // System.out.println("---------------------------------------------------------");
        System.out.println("The total cost for your order is $"+dollar.format(orderTotal));
        System.out.println("Order Number is "+orderId);
    }
}