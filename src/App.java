import Test.People;
import Utils.Validation;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        People people = new People("alvin","23","alvin@yahoo.com","0813886");
        Validation.checkIsBlank(people);
        Validation.checkLength(people);
        Validation.checkIsEmailValid(people);
        Validation.checkIsPhoneNumber(people);
        System.out.println(people);
    }
}
