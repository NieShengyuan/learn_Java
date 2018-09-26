import java.util.Scanner;
public class TestScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input your name:");
		String name = scanner.nextLine();
		System.out.println("please input your favor:");
		String favor = scanner.nextLine();
		
		System.out.println("--------------------------------");
		System.out.println(name);
		System.out.println(favor);
		
	}

}
