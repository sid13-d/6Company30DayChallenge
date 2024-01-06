
import java.util.*;
public class Main {
    public static void print(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void printDeck(int n) {
        int cnt = 1;
        int deck[] = new int[n];
        Arrays.fill(deck, 0); // -1 means blank

        int filled=1;
        int blank=0;
        int i=0;
        while(cnt <= n) {
            if(deck[i%n] == 0) {
                if(blank == 0) {
                    deck[i%n] = 0;
                    blank++;
                    filled--;

                    
                    i++;
                }else{
                    deck[i%n] = cnt;
                    filled++;
                    blank--;

                    cnt++;
                    i++;
                    print(deck);
                }
            }else {
                i++;
            }
        }

        
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the vlalue of N::");
        int n = scan.nextInt();

        printDeck(n);
    }
}
