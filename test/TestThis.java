/*this�ı���
 * 
 * ����Ĵ�������
 * �������ռ䣬���������Ա������ʼ��Ϊ0���
 * ִ������ֵ����ʽ��ʼ��
 * ִ�й��췽��
 * ���ض���ĵ�ַ����صı��� 
 * */
public class TestThis {
	int a,b,c;
	
	TestThis(){
		System.out.println("start init a hello object");
	}
	TestThis(int a,int b){
		//TestThis() �����޷����ù��췽��
		this();//�����޲εĹ��췽�������ұ���λ�ڵ�һ��
		a=a;//�˴�ָ�ֲ�����������ȫ�ֱ���
		//this �ĵ����÷�������ֲ�������ȫ�ֱ���
		this.a = a;
		this.b = b;
	}
	TestThis(int a,int b,int c){
		this(a,b);//�����вεĹ��췽�������ұ���λ�ڵ�һ��
		this.c = c;
	}
	
	void sing() {
		
	}
	void eat() {
		this.sing();//���ñ����е�sing()
		System.out.println("start eat food");
	}
	
	public static void main(String[] args) {
		TestThis hi = new TestThis(2,3);
		hi.eat();
	}

}
