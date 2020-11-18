package Week_05.First_class.JavaProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Agency implements InvocationHandler {
    private Bird bird;

    /**
     * 装配被代理对象，返回代理对象
     * @param bird 被代理对象
     * @return 代理对象
     */
    public Object bind(Bird bird) {
        this.bird = bird;
        Object obj = Proxy.newProxyInstance(Verify.class.getClassLoader(), bird.getClass().getInterfaces(), this);
        return obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 前置增强处理
        System.out.println("+++++++++Agency begin+++++++");
        // 这里应该是用了java的反射机制进行方法调用
        method.invoke(bird, args);
        // 后置增强处理
        System.out.println("+++++++++Agency end+++++++");
        return null;
    }
}
