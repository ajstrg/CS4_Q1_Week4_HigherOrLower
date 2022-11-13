import java.util.Scanner;
class Game {
  Scanner input = new Scanner(System.in);
 
  int max_guesses = 3;
  int guesses;
  int random_number = 9;
  int low = 0;
  int high = 10;
  boolean use_random_seed = false;
  long seed = 1;
  
  /////// CHANGE THE CODE BELOW TO SOLVE THE PROBLEM
  public void new_game() {
        String choice;
 
          System.out.println("\n\nWelcome to Higher or Lower! What will you do? \n" +
              "- Start game \n" +
              "- Change settings \n" +
              "- End application");
          choice = input.nextLine();

          if (choice.equals("Change settings")) {
            change_settings();
            new_game();
          }
          else if (choice.equals("Start game")) {
            start_game();
          }
          else if (choice.equals("End application")) {
            System.out.println("\nThank you for playing!");
          }
  }

  public void new_game1() {
        String choice;
          choice = input.nextLine();

          if (choice.equals("Change settings")) {
            change_settings();
            new_game();
          }
          else if (choice.equals("Start game")) {
            start_game();
          }
          else if (choice.equals("End application")) {
            System.out.println("\nThank you for playing!");
          }
  }
  
  public void start_game() {
        int guess = -999;
        guesses = max_guesses;
        boolean continue_game = true;
        boolean restart_game = true;
    
        do {
          RandomGen rg = new RandomGen();
          random_number = rg.get_random_number(low, high, use_random_seed, seed);
          do {
            System.out.print("\nYou have " + guesses + " guess(es) left. What is your guess? ");
            guess = input.nextInt();
            input.nextLine();
            guesses--;
            
            if (guess == random_number) {
              System.out.println("You got it!");
              continue_game = false;
            }
  
            else {
  
              if (guesses == 0) {
                System.out.println("You lost...");
                continue_game = false;
              }
  
              else {
                if (guess < random_number) {
                  System.out.println("Guess higher!");
                }
      
                else if (guess > random_number) {
                  System.out.println("Guess lower!");
                }
              }
        
            }
  
            
          } while (continue_game);

          guesses = max_guesses;
          System.out.print("Play again (y/n)? ");
          String ans = input.next();

          if (ans.equals("n")){
            restart_game = false;
            new_game();
            new_game1();
          }

          else if (ans.equals("y")) {
            restart_game = true;
            continue_game = true;
          }
          
        } while (restart_game);
  
  }
   /////// CHANGE THE CODE ABOVE TO SOLVE THE PROBLEM
 
 
  public void change_settings() {
        System.out.print("What is the lower limit of the random number? ");
        low = input.nextInt();
        input.nextLine();
        System.out.print("What is the upper limit of the random number? ");
        high = input.nextInt();
        input.nextLine();
        System.out.print("How many guesses are allowed? ");
        max_guesses = input.nextInt();
        input.nextLine();
        System.out.print("Would you like to seed the random generator? (y/n) ");
        String ans = input.nextLine();
    
        if (ans.equals("y")) {
          use_random_seed = true;
          System.out.print("Enter an integer as a random seed: ");
          seed = input.nextLong();
          input.nextLine();
        }
        else {
          use_random_seed = false;
        }
  }
}
