import java.util.Random;
public class RandomGen extends Random {
  int random_number = 5;
  int seed_salt = 0;
 
  public int get_random_number(int low, int high, boolean use_seed, long seed){
        if (use_seed == true){
          seed = seed + seed_salt;
          setSeed(seed);
          seed_salt++;
        }
   
        random_number = nextInt((high - low));
        random_number += low;
        return random_number;
  }
}
