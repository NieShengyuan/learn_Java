
public class TestMethod {
	public static void test01(int a) {
		int oddSum = 0;
		int evenSum = 0;
		for (int i = 0;i<=a;i++) {
			if(i % 2 != 0) {
				oddSum += i;
			}else {
				evenSum += i;
			}
		}
		System.out.println("奇数的和："+ oddSum);
		System.out.println("偶数的和："+ evenSum);
	}
	
	public static void test02(int a,int b,int c) {
		for(int j = 1;j <=a ; j++) {
			if(j % b == 0) {
				System.out.println(j + "\t");
			}
			if (j % (b * c) == 0) {
				System.out.println();
			}
		}
	}
	
	public static int add(int a,int b) {
		int sum = a+b;
		if(a==3) {
			return 0;
		}
		System.out.println("输出");
		return sum;
	}
	
	public static void main(String[] args) {
		test01(1000);
		test02(100,6,3);
		System.out.println("-------------------");
		int s = add(3,5);
		System.out.println(s);
	}

}
