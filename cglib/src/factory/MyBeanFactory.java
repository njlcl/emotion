package factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import aspect.Myaspect;
import service.UserServiceImpl;

public class MyBeanFactory {
	public static UserServiceImpl createService(){
	//目标类
	final UserServiceImpl userService=new UserServiceImpl();
	//切面类
	final Myaspect myAspect=new Myaspect();
	//代理类：cglib，实际上是继承父类，对父类增强
	Enhancer enhancer=new Enhancer();//1.子类,核心类
	enhancer.setSuperclass(userService.getClass());//2.确定父类
	enhancer.setCallback(new MethodInterceptor() {//3.设置回调函数
		
		@Override
		public Object intercept(Object arg0, Method arg1, Object[] arg2,
				MethodProxy arg3) throws Throwable {
			// TODO Auto-generated method stub
			myAspect.before();
			Object obj=arg1.invoke(userService, arg2);
			myAspect.after();
			return obj;
		}
	});
	//4.创建代理
	UserServiceImpl proxService=(UserServiceImpl)enhancer.create();
	
	return proxService;
	}

}
