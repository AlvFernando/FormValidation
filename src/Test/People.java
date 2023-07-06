package Test;

import Annotations.Email;
import Annotations.Length;
import Annotations.NotBlank;
import Annotations.PhoneNumber;

public class People {
    @Length(min = 3, max = 10)
    private String name;
    @NotBlank
    private String age;
    @Email
    private String email;
    @PhoneNumber
    private String phoneNumber;

    public People(String name, String age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "People [name=" + name + ", age=" + age + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
    }
}
