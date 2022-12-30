package stream;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-20-15:02
 */
public class User {
    String name;
    String age;
    String sex;
    String code;
    String type;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    public User (User sourceUser,User targetUser){
        System.out.println(sourceUser+" "+targetUser);
    }
    public User (){

    }

}
