package kadai1_triangle;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class triangle  {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// 課題1の入力
		int rows1 = getValidInput(scanner, "課題1の数字を入力: ");
		shape1(rows1);
				
		System.out.println(); 
				
		// 課題2の入力
		int rows2 = getValidInput(scanner, "課題2の数字を入力: ");
		shape2(rows2);
				
		System.out.println(); 
				
		// 課題3の入力
		int rows3 = getValidInput(scanner, "課題3の数字を入力: ");
		shape3(rows3);
				
		System.out.println(); 
				
		// 課題4の入力
		int rows4 = getValidInput(scanner, "課題4の数字を入力: ");
		shape4(rows4);
				
		scanner.close();
		}
	
	// 有効な入力を取得するメソッド
	public static int getValidInput(Scanner scanner, String prompt) {
		int rows = -1;  // 初期値は無効な値に設定
		while (true) {
			System.out.print(prompt);
			
			//文字入力時に無効な文字であればエラーを出して読み飛ばす。
			try {
				rows = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("エラー: 無効な入力です。数字を入力してください。");
				scanner.next();
			}
			// 0 または負の数が入力された場合は再入力を促す
			if (rows <= 0) {
				System.out.println("エラー: 無効な入力です。正の整数を入力してください。");
			} else {
				break;  // 有効な入力がされた場合はループを終了
			}
		}
		return rows;  // 有効な値を返す
	}
	
	//課題1
	public static void shape1(int rows) {
		
		for(int i = 0; i <= rows; i ++) { //入力した値の行数まで繰り返す
			
			for(int d = 1; d <= i; d ++) { //$をiの数分同列に出力
				System.out.print("$");
			}
			System.out.println(); //行ごとに改行
		}
	}
	
	//課題2
	public static void shape2(int rows) {
		for(int i = 1; i <= rows; i ++) { //入力した値の行数まで繰り返す
			
			for(int j = rows; j >= i; j --) { //jがiより大きい限り*を同列に出力。
				System.out.print("*");
			}
			System.out.println(); //行ごとに改行
		}
		
	}
	
	//課題3
	public static void shape3(int rows) {
		for(int i = 1; i <= rows; i ++) { //入力した値の行数まで繰り返す
			for(int d = 1; d < i; d ++) { //iがdより小さい限り空白を同列に出力
				System.out.print(" ");
			}
			for(int x = rows; x >= i; x --) { //jがiと同じになるまで*を同列に出力。
				System.out.print("*");
			}
			for(int j = rows-1; j >= i; j --) { //jがiより大きい限り*を同列に出力。
				System.out.print("*");
			}
			System.out.println(); //行ごとに改行
		}
	}
	
	//課題4
	public static void shape4(int rows) {
		Random random = new Random(); 
		int[] randomNumbers = new int[rows]; // 生成した数字を格納する配列
		
		System.out.print("生成された数字は　");
		for (int i = 0; i < rows; i++) { // 入力した回数だけ繰り返す
	        randomNumbers[i] = random.nextInt(30) + 1; // 1～30のランダムな数字を生成
	        System.out.print(randomNumbers[i] + " "); // 生成した数字を出力
	    }
		System.out.println("です、");
		
		for (int i = 0; i < rows - 1; i++) {
	        for (int j = 0; j < rows - 1 - i; j++) {
	            if (randomNumbers[j] < randomNumbers[j + 1]) { // 大きい順に並べ替える条件
	                int temp = randomNumbers[j]; // 値を一時的に保存
	                randomNumbers[j] = randomNumbers[j + 1];
	                randomNumbers[j + 1] = temp;
	            }
	        }
	    }
		
		System.out.print("大きい順に並び変えた数字は　");
	    for (int i = 0; i < rows; i++) {
	        System.out.print(randomNumbers[i] + " ");
	    }
	    System.out.println("です。");
		
		
	}
}

