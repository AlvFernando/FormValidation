import Test.People;
import Utils.Validation;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        People people = new People("al","23");
        Validation.checkIsBlank(people);
        Validation.checkLength(people);
        System.out.println(people);
    }
}
