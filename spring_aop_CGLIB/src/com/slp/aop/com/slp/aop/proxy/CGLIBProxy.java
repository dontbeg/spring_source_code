package src.com.slp.aop.com.slp.aop.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.Proxy;
import src.com.slp.aop.UserDao;

import java.lang.reflect.Method;

/**
 * @Author shenlp
 * @Date 2023/10/18 17:36
 * @Description:
 **/
public class CGLIBProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(new UserDaoCGLIBProxy());
        UserDao userDao = (UserDao) enhancer.create();
        int add = userDao.add(3, 5);
        System.out.println("res："+add);
    }

    public static class UserDaoCGLIBProxy implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            System.out.println("Before method: " + method.getName());
            //执行目标方法
            Object invoke = methodProxy.invokeSuper(o, objects);
            System.out.println("After method: " + method.getName());
            return invoke;
        }
    }
}
