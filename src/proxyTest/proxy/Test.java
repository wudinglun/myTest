package proxyTest.proxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		//��̬����
//		Hello helloProxy= new HelloProxy();
//		helloProxy.say("lian");
		//��̬����
		Hello hello=new HelloImpl();
		DynamicProxy dynamicProxy=new DynamicProxy(hello);
		Hello helloProxy=dynamicProxy.getProxy();
		helloProxy.say("lian");
	}
}
