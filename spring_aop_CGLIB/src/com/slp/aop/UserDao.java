package src.com.slp.aop;

/**
 * @Author shenlp
 * @Date 2023/10/18 17:35
 * @Description:
 **/
public class UserDao {
    public int add(int a,int b){
        System.out.println("执行了userDao的add方法");
        return a+b;
    }
}
