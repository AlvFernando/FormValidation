package Test;

import Annotations.Length;
import Annotations.NotBlank;

public class People {
    @Length(min = 3, max = 10)
    private String name;
    @NotBlank
    private String age;

    public People(String name, String age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "People [name=" + name + ", age=" + age + "]";
    }
}
