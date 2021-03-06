package com.sethnie.Interface;
/*
 * · 为什么需要接口?接口和抽象类的区别?

      接口就是比“抽象类”还“抽象”的“抽象类”，可以更加规范的对子类进行约束。全面地专业地实现了：规范和具体实现的分离。

      抽象类还提供某些具体实现，接口不提供任何实现，接口中所有方法都是抽象方法。接口是完全面向规范的，规定了一批类具有的公共方法规范。

      从接口的实现者角度看，接口定义了可以向外部提供的服务。

      从接口的调用者角度看，接口定义了实现者能提供那些服务。

      接口是两个模块之间通信的标准，通信的规范。如果能把你要设计的模块之间的接口定义好，就相当于完成了系统的设计大纲，剩下的就是添砖加瓦的具体实现了。大家在工作以后，做系统时往往就是使用“面向接口”的思想来设计系统。

      接口和实现类不是父子关系，是实现规则的关系。比如：我定义一个接口Runnable，Car实现它就能在地上跑，Train实现它也能在地上跑，飞机实现它也能在地上跑。就是说，如果它是交通工具，就一定能跑，但是一定要实现Runnable接口。

· 接口的本质探讨

      接口就是规范，定义的是一组规则，体现了现实世界中“如果你是…则必须能…”的思想。如果你是天使，则必须能飞。如果你是汽车，则必须能跑。如果你是好人，则必须能干掉坏人;如果你是坏人，则必须欺负好人。

      接口的本质是契约，就像我们人间的法律一样。制定好后大家都遵守。

      面向对象的精髓，是对对象的抽象，最能体现这一点的就是接口。为什么我们讨论设计模式都只针对具备了抽象能力的语言(比如C++、Java、C#等)，就是因为设计模式所研究的，实际上就是如何合理的去抽象。

区别

      1. 普通类：具体实现

      2. 抽象类：具体实现，规范(抽象方法)

      3. 接口：规范!
      
      
 * [访问修饰符]  interface 接口名   [extends  父接口1，父接口2…]  {
常量定义；  
方法定义；
}
定义接口的详细说明：

      1. 访问修饰符：只能是public或默认。

      2. 接口名：和类名采用相同命名机制。

      3. extends：接口可以多继承。

      4. 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是。

      5. 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract。

要点

      1. 子类通过implements来实现接口中的规范。

      2. 接口不能创建实例，但是可用于声明引用变量类型。

      3. 一个类实现了接口，必须实现接口中所有的方法，并且这些方法只能是public的。

      4. JDK1.7之前，接口中只能包含静态常量、抽象方法，不能有普通属性、构造方法、普通方法。

      5. JDK1.8后，接口中包含普通的静态方法
 * 
 * -------------------------------------------------
 * java 类没有多继承，接口有多继承
 * 
 * 
 * 
 * */
public class a25TestInterface {
	public static void main(String[] args) {
		Volant volant = new Angle();
		volant.fly();
		System.out.println(Volant.FLY_HIGHT);
		
		Honest honest = new GoodMan();
		honest.helpOther();
		
	}
}

interface Volant{
	int FLY_HIGHT = 100;  // 总是：public static final类型的；
    void fly();   //总是：public abstract void fly();
}
interface Honest{
	void helpOther();
}

class Angle implements Volant,Honest{//实现类可以多个父接口
	@Override
	public void helpOther() {
		System.out.println("help other");
	}

	@Override
	public void fly() {
		System.out.println("fly fly");		
	}
}

class GoodMan implements Honest{
	@Override
	public void helpOther() {
		System.out.println("help for honest ");
	}
}

class BirdMan implements Volant{
	@Override
	public void fly() {
		System.out.println("fly for volant");
	}
}


