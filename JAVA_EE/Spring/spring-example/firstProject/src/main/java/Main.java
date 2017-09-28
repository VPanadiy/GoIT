import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Splayd on 26.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext;
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        LabRat rat = (LabRat) classPathXmlApplicationContext.getBean("rat");
        rat.sayHi();
        System.out.println(rat.getName());
    }
}

