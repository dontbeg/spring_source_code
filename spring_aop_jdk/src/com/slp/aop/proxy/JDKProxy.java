package src.com.slp.aop.proxy;

import src.com.slp.aop.dao.PersonDao;
import src.com.slp.aop.dao.PersonDaoImpl;
import src.com.slp.aop.dao.UserDao;
import src.com.slp.aop.dao.UserDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author shenlp
 * @Date 2023/10/18 11:30
 * @Description:JDK动态代理
 **/
public class JDKProxy {
    public static void main(String[] args) {
        //增强方法所在的类，这个类实现的接口，支持多个接口
        Class[] interfaces = {UserDao.class, PersonDao.class};
        UserDaoImpl userDao = new UserDaoImpl();
        PersonDaoImpl personDao = new PersonDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        PersonDao dao1 = (PersonDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(personDao));
        String eat = dao1.eat();
        System.out.println("eat:"+eat);
        int result = dao.add(1, 2);
        System.out.println("result:" +result);
    }


    public static class UserDaoProxy implements InvocationHandler{

        private Object obj;

        public  UserDaoProxy(Object obj){
            this.obj  = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            System.out.println("方法执行之前。。。"+method.getName()+" :传递的参数。。。" + Arrays.toString(args));
            //开始执行add方法
            Object res = method.invoke(obj, args);

            System.out.println("方法执行之后。。。"+obj);
            return res;
        }
    }
}
