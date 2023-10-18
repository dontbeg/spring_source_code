package src.com.slp.aop.dao;

/**
 * @Author shenlp
 * @Date 2023/10/18 11:27
 * @Description:
 **/
public class UserDaoImpl implements  UserDao{

    @Override
    public int add(int a, int b) {

        System.out.println("执行了userDao的add方法");
        return a+b;
    }

    @Override
    public String update(String id) {
        return id;
    }
}
