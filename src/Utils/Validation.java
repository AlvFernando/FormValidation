package Utils;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Annotations.Email;
import Annotations.Length;
import Annotations.NotBlank;
import Annotations.PhoneNumber;

public class Validation {
    public static void checkIsBlank(Object object) throws Exception{
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.getAnnotation(NotBlank.class) != null){
                field.setAccessible(true);
                String value = (String) field.get(object);
                //validate
                if(value == null || value.isBlank()){
                    throw new Exception("Field "+field.getName()+" is Blank");
                }
            }
        }
    }

    public static void checkLength(Object object) throws Exception{
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.getAnnotation(Length.class) != null){
                field.setAccessible(true);
                int min = field.getAnnotation(Length.class).min();
                int max = field.getAnnotation(Length.class).max();
                String value = (String) field.get(object);
                //validate
                if(value.length() < min){
                    throw new Exception("Field Length is less than "+ min +" value");
                }else if(value.length() > max){
                    throw new Exception("Field Length is more than "+ max +" value");
                }
            }
        }
    }

    public static void checkIsPhoneNumber(Object object) throws Exception{
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.getAnnotation(PhoneNumber.class) != null){
                field.setAccessible(true);
                String value = (String) field.get(object);
                //validate
                if(value.isBlank() || value == null){
                    throw new Exception("Phone number invalid. Field is empty");
                }else if(value.length() > 15){
                    throw new Exception("Phone number invalid. Length more than 15");
                }else if(value.length() < 10){
                    throw new Exception("Phone number invalid. Length less than 10");
                }
                try {
                    Integer.parseInt(value);
                } catch (Exception e) {
                    // TODO: handle exception
                    throw new Exception("Phone number invalid. Must be digit character");
                }
            }
        }
    }

    public static void checkIsEmailValid(Object object) throws Exception{
        Field[] fields = object.getClass().getDeclaredFields();
        for(Field field : fields){
            if(field.getAnnotation(Email.class) != null){
                field.setAccessible(true);
                String value = (String) field.get(object);
                //validate
                if(value.isBlank() || value == null){
                    throw new Exception("Email invalid. Field is empty");
                }else{
                    String format = "\\w+@\\w+\\.\\w+";
                    Pattern pattern = Pattern.compile(format);
                    Matcher matcher = pattern.matcher(value);
                    if(!matcher.find()){
                        throw new Exception("Email invalid");
                    }
                }
            }
        }
    }
}
