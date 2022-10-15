import java.util.ArrayList;
import java.util.Scanner;

    class Loader extends Thread{
        public void run(){
            for(int i = 0 ; i < 50 ; i++){
                try {
                    this.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print("*");

            }
            System.out.println(" ");

        }
    }
    public class main {

        public static void main(String[] args) {
            Loader l1 = new Loader();
            l1.start();
            try {
                l1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BankAccount c1 = new BankAccount();

            c1.Show_Menu();
        }
    }

    class BankAccount {

        int Amount;
        int balance = 0;
        int previous_Transition;
        String Name;
        String Accno;
        int choice;
        ArrayList<String> transactions = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

        void deposit(int Amount) {
            if (Amount != 0) {
                balance += Amount;
                System.out.println("***************");
                System.out.println("    PKR " + Amount + " added to your Bank Account");
                System.out.println("***************");
                transactions.add("Deposited PKR " + Amount + " to your Bank Account. Total Balance is PKR " + balance);

            } else {
                System.out.println("****************");
                System.out.println("****** EXIT ********");
                System.out.println("***************");

            }
            System.out.println(" Do you want to check your account balance? ");
            System.out.println("ENTER AN OPTION : ");
            System.out.println("1. YES");
            System.out.println("2. NO");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("***************");
                    System.out.println("           Current balance= " + balance);
                    System.out.println("***************");

                    break;
                case 2:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("error");
            }
        }

        void withdraw(int Amount) {
            if (Amount != 0 && Amount <= balance) {
                balance -= Amount;
                System.out.println("***************");
                System.out.println("  PKR " + Amount + " withdrawn from your Bank Account");
                System.out.println("***************");

                transactions.add("PKR " + Amount + " withdrawn from your Bank Account. Total Balance : " + balance);
                System.out.println(" Do you want to check your account balance? ");
                System.out.println("ENTER AN OPTION : ");
                System.out.println("1. YES");
                System.out.println("2. NO");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("***************");
                        System.out.println("         Current balance = " + balance);
                        System.out.println("***************");
                        break;
                    case 2:
                        System.out.println("EXIT");
                        break;
                }
            }
        }

        void getprevious_Transition() {
            for(String transaction: transactions){
                System.out.println(transaction);
            }
        }

        void Show_Menu() {
            int Option = 0;
            Scanner sc = new Scanner(System.in);
            System.out.println("******************");
            System.out.println("*** Enter Account Holder's name: *****");
            System.out.println("******************");
            Name = sc.nextLine();

            System.out.println("******************");
            System.out.println("**** Enter Account Number: *****");
            System.out.println("******************");
            Accno = sc.next();

            do{
                System.out.println("            HELLO ! & WELCOME  " + Name + ":)"+ "\nPlease select the option from the following to proceed:");
                System.out.println("*******************");
                System.out.println("1) Check Balance");
                System.out.println("2) Deposit");
                System.out.println("3) Withdraw");
                System.out.println("4) Previous Transition");
                System.out.println("5) Exit");
                System.out.println("***************");
                System.out.println("***************");

                System.out.println("ENTER AN OPTION : ");
                Option = sc.nextInt();
                System.out.println("\n");


                switch (Option) {

                    case 1:
                        System.out.println("***************");
                        System.out.println("***************");
                        System.out.println("**** Current Balance = " +balance+ " ******");
                        System.out.println("***************");
                        System.out.println("***************");
                        System.out.println("\n");
                        break;

                    case 2:
                        System.out.println("***************");
                        System.out.println("***************");
                        System.out.println("** ENTER AN AMOUNT TO DEPOSIT : ***");
                        System.out.println("***************");
                        System.out.println("***************");
                        int amount = sc.nextInt();
                        deposit(amount);
                        System.out.println("\n");
                        break;

                    case 3:
                        System.out.println("***************");
                        System.out.println("        YOUR CURRENT BALANCE : " + balance     );
                        System.out.println("        ENTER AN AMOUNT TO WITHDRAW :        ");
                        System.out.println("***************");
                        int amount2 = sc.nextInt();
                        withdraw(amount2);
                        System.out.println("\n");
                        break;

                    case 4:
                        System.out.println("**********************");
                        System.out.println("**********************");
                        getprevious_Transition();
                        System.out.println("**********************");
                        System.out.println("**********************");
                        System.out.println("\n");
                        break;

                    case 5:
                        System.out.println("***************");
                        System.out.println("***************");
                        System.out.println("******* EXIT ********");
                        System.out.println("***************");
                        System.out.println("***************");
                        break;

                    default:
                        System.out.println("***************");
                        System.out.println("***** INVALID OPTION ******");
                        System.out.println("**** PLEASE ENTER AGAIN *****");
                        System.out.println("***************");
                        System.out.println("\n");
                        break;
                }
            }while(Option != 5);

        }
    }