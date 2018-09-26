/*
 * �ݹ����(�൱����Դ)
 * �ݹ�ͷ
 * �ݹ���
 * */
public class TestRecursion {
	public static void main(String[] args) {
		long d1 = System.currentTimeMillis();
		System.out.printf("%d�׳˵ĵ��ý����%s%n",10,factorial(10));
		long d2 = System.currentTimeMillis();
		System.out.printf("��ʱ��%s%n",d2-d1);
		
		factorialLoop(10);
	}
	
	static long factorial(int n) {
		if(n == 1) {      //�ݹ�ͷ
			return 1;
		}else {           //�ݹ���
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
		System.out.printf("��ʱ��%s%n",d4-d3);
		return result;
	}

}
