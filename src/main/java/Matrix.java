import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {

        int[][] mat = new int[10][10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter no of rows");
        int row = scanner.nextInt();
        System.out.println("Enter no of cols");
        int col = scanner.nextInt();
        for(int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }
        int sum =0;

        if(row == col){
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){
                    if(i==j || (i+j==(row-1))){
                        sum += mat[i][j];

                    }
                }
            }
            System.out.println(sum);
        }
        else{
            System.out.println("Enter equal rows and cols");
        }

    }
}
