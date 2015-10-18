import java.util.*;
public class ArraysWithNoDuplicates {

    public static void main(String[] args) {
        int nums[] = new int[1000];
        Scanner scan = new Scanner(System.in);
        int count = 0;
        int i = 0;
        while(i < nums.length) {
            System.out.print("Enter a number (0 to end) ");
            int input = scan.nextInt();
            if (input == 0)
                break;
            boolean inArray = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == input) {
                    inArray = true;
                    break;
                }
            }
            if (!inArray) {
                nums[i] = input;
                i++;
                count += 1;
            }
        }

        System.out.print("Here are your numbers:");
        for (int k = 0; k < count; k++)
        {
            System.out.print(" " + nums[k]);
        }
    }
}
