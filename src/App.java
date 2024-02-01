import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1. compiling
// javac --source-path src -d bin src/*
// 2. run
// java -cp bin App
// 3. packing to jar
// jar -c -v -f myapp.jar -e App . (Do inside bin folder)
// 4. run the jar package (slide 12)
// java -cp bin/day01.jar App
// java -cp day01.jar App (run inside bin folder)


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        List<String> cartItems = new ArrayList<>();

        Console cons = System.console();
        String input = "";


        while (!input.equals("quit")) {

            input = cons.readLine("> ").toLowerCase();

            if (input.equals("list")){

                if (cartItems.size() > 0) {
                    for (int i = 0; i < cartItems.size(); i++) {
                        System.out.printf ("%d. %s\n",i+1,cartItems.get(i));
                    }
                } else {
                    System.out.println("Your cart is empty");
                }
            }

            if (input.startsWith("add")) {
                input = input.replace(',',' ');

                Scanner scan = new Scanner(input.substring(4));
                String stringVal = "";
                while (scan.hasNext()) {
                    stringVal = scan.next();
                    cartItems.add(stringVal);
                }
            }

            if (input.startsWith("delete")) {

                Scanner scan = new Scanner(input.substring(7));
                String stringVal = "";

                while (scan.hasNext()) {
                    stringVal = scan.next();
                    int itemIndex = Integer.parseInt(stringVal);
                    itemIndex = itemIndex - 1;
    
                    if (itemIndex < cartItems.size()) {
                        cartItems.remove(itemIndex);
                    } else {
                        System.err.println("Incorrect item index");
                    }

                }

            

            }


        }

        System.out.println("Bye! See you again...");


    }
}
