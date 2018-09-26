/*创建类了没
 * 创建对象了没
 * new了没
 * 赋值了没
 * ---------------连问三连
 * UML类图*************************
 * 
 * SxtStu类                                                 *类名
 * ---------------------------*
 *  int id;                   *属性     
 *	String sname;             *    
 *	int age;                  * 
 *	Computer comp;//计算机              *                                                  
 *                            *                                          
 *----------------------------*                                                                      
 * study/play                 *方法                                                    
 *                            *                                        
 ******************************                                                                      
 
 * */

public class SxtStu {
	
	//属性fields
	int id;
	String sname;
	int age;
	
	Computer comp;//计算机
	
	//methond
	void study() {
		System.out.println("I am study,use computer:"+comp.brand);
	}
	
	void play() {
		System.out.println("I am play games");
	}
	
	//构造方法。用于创建这个类的对象。无参的构造方法可以由系统自动创建
	SxtStu(){
		
	}
	//程序执行入口
	public static void main(String[] args) {
		SxtStu stu = new SxtStu();//创建一个对象
		stu.id = 1001;
		stu.age = 18;
		stu.sname = "Seth Nie";
		
		Computer cp = new Computer();
		cp.brand = "XiaoMi";
		stu.comp = cp;
		
		stu.play();
		stu.study();
	}

}

class Computer {
	String brand;	
}
