/*
 * 测试静态初始化块的使用
 * */
public class TestStatic {
	int id;
	String name;
	static String company;
	
	static {//此处为类的初始化，不能调用普通属性或普通方法
		System.out.println("开始执行类的初始化工作");
		company = "LY";
		printCompany();
	}
	//先加载类，再构造对象
	public static void printCompany() {
		System.out.println(company);
	}
	
	public static void main(String[] args) {
		TestStatic TS = null;
	} 

}
