/*
 * ���Ծ�̬��ʼ�����ʹ��
 * */
public class TestStatic {
	int id;
	String name;
	static String company;
	
	static {//�˴�Ϊ��ĳ�ʼ�������ܵ�����ͨ���Ի���ͨ����
		System.out.println("��ʼִ����ĳ�ʼ������");
		company = "LY";
		printCompany();
	}
	//�ȼ����࣬�ٹ������
	public static void printCompany() {
		System.out.println(company);
	}
	
	public static void main(String[] args) {
		TestStatic TS = null;
	} 

}
