/*
 * 递归调用(相当耗资源)
 * 递归头
 * 递归体
 * */
public class TestRecursion {
	public static void main(String[] args) {
		long d1 = System.currentTimeMillis();
		System.out.printf("%d阶乘的调用结果：%s%n",10,factorial(10));
		long d2 = System.currentTimeMillis();
		System.out.printf("耗时：%s%n",d2-d1);
		
		factorialLoop(10);
	}
	
	static long factorial(int n) {
		if(n == 1) {      //递归头
			return 1;
		}else {           //递归体
			return n*factorial(n-1);
		}
	}
	
	static long factorialLoop(int a) {
		long d3 = System.currentTimeMillis();
		long result = 1;
		while(a>1) {
			result *= a * (a-1);
			a-=2;
		}
		System.out.println(result);
		long d4 = System.currentTimeMillis();
		System.out.printf("耗时：%s%n",d4-d3);
		return result;
	}

}
