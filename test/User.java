
public class User {
	int id;
	String name;
	String pwd;
	
	public User() {
		
	}
	//�������������뷽��������һ��
	public User(int id,String name) {
		super();  //���췽���ĵ�һ������super(),���Զ�����
		this.id = id;//this ��ʾ�����õĶ���
		this.name = name;
	}
	public User(int id,String name,String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	public static void main(String[] args) {
		User u1 = new User();
		User u2 = new User(101,"Seth Nie");
		User u3 = new User(100,"SN","12345");
		System.out.println(u1.id);
		System.out.println(u2.id);
		System.out.println(u3.id);
	}

}
