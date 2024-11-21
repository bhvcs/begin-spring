import java.util.*;
import java.io.*;

public class Main{
    public static int N,center = 0;
    public static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        center = (N+1) / 2;

        arr = new int[N+1][N+1];

        int i, j, current = 1;

        arr[center][center] = current++;
        for(i=1; i<center; i++){
            current = makeSnail(i, current);
        }
        System.out.println("sss");
        for(i = 1; i < N+1; i++){
            for(j =1; j < N+1; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        int number = Integer.parseInt(br.readLine());
        findNumber(number);
    }
    public static int makeSnail(int i, int current){
        int s,t;
        for(s = center-i+1; s <= center+i; s++){
            arr[center-i][s] = current++;
        }
        for(s = center-i+1; s <= center+i; s++){
            arr[s][center+i] = current++;
        }
        for(s = center+i-1; s >= center-i; s--){
            arr[center+i][s] = current++;
        }
        for(s = center+i-1; s >= center-i; s--){
            arr[s][center-i] = current++;
        }
        return current;
    }

    public static void findNumber(int number) {
        int i, s;
        for(i = 0; i <= N; i++){
            if(number > i*i && number <= (i+1) * (i+1)) break;
        }
        i = (i+1)/2;
        for(s = center-i+1; s <= center+i; s++){

            if( arr[center-i][s] == number ){
                System.out.println((center-i) + " " + s);
                return;
            }
        }
        for(s = center-i+1; s <= center+i; s++){
            if( arr[s][center+i] == number ){
                System.out.println(s + " " + (center+i));
                return;
            }
        }
        for(s = center+i-1; s >= center-i; s--){
            if( arr[center+i][s] == number ){
                System.out.println((center+i) + " " + s);
                return;
            }
        }
        for(s = center+i-1; s >= center-i; s--){
            if( arr[s][center-i] == number ){
                System.out.println((center-i) + " " + s);
                return;
            }
        }
    }
}