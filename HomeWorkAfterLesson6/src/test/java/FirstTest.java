import org.testng.annotations.Test;
import ru.lesson6.utills.PropertyReader;

public class FirstTest{
    @Test
    public void test1(){
        //Пример:Как использовать propertyFile
        System.out.println("The property: "+ PropertyReader.getProperty("timeout"));
    }
}
