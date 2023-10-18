package src.com.slp.aop.dao;

/**
 * @Author shenlp
 * @Date 2023/10/18 16:35
 * @Description:
 **/
public class PersonDaoImpl implements PersonDao{

    @Override
    public String eat() {
        System.out.println("执行了PersonDao的eat方法");
        return "人会吃";
    }
}
