/*this的本质
 * 
 * 对象的创建步骤
 * 分配对象空间，并将对象成员变量初始化为0或空
 * 执行属性值得显式初始化
 * 执行构造方法
 * 返回对象的地址给相关的变量 
 * */
public class TestThis {
	int a,b,c;
	
	TestThis(){
		System.out.println("start init a hello object");
	}
	TestThis(int a,int b){
		//TestThis() 这样无法调用构造方法
		this();//调用无参的构造方法，并且必须位于第一行
		a=a;//此处指局部变量而不是全局变量
		//this 的典型用法。区别局部变量和全局变量
		this.a = a;
		this.b = b;
	}
	TestThis(int a,int b,int c){
		this(a,b);//调用有参的构造方法，并且必须位于第一行
		this.c = c;
	}
	
	void sing() {
		
	}
	void eat() {
		this.sing();//调用本类中的sing()
		System.out.println("start eat food");
	}
	
	public static void main(String[] args) {
		TestThis hi = new TestThis(2,3);
		hi.eat();
	}

}
