/*��������û
 * ����������û
 * new��û
 * ��ֵ��û
 * ---------------��������
 * UML��ͼ*************************
 * 
 * SxtStu��                                                 *����
 * ---------------------------*
 *  int id;                   *����     
 *	String sname;             *    
 *	int age;                  * 
 *	Computer comp;//�����              *                                                  
 *                            *                                          
 *----------------------------*                                                                      
 * study/play                 *����                                                    
 *                            *                                        
 ******************************                                                                      
 
 * */

public class SxtStu {
	
	//����fields
	int id;
	String sname;
	int age;
	
	Computer comp;//�����
	
	//methond
	void study() {
		System.out.println("I am study,use computer:"+comp.brand);
	}
	
	void play() {
		System.out.println("I am play games");
	}
	
	//���췽�������ڴ��������Ķ����޲εĹ��췽��������ϵͳ�Զ�����
	SxtStu(){
		
	}
	//����ִ�����
	public static void main(String[] args) {
		SxtStu stu = new SxtStu();//����һ������
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
