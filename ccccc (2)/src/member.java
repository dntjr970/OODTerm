

/**
 * Created by empti on 2017-12-03.
 */
import java.util.Scanner;

public class member {
    static final int MALE = 0;
    static final int FEMALE = 1;
    private String id;
    private String pw;
    private String name;
    private int sex;
    private String idealName;

    public String id() {
        return id;
    }
    public void setId(String newId) {
        id = newId;
    }
    public String pw() {
        return pw;
    }
    public void setPw(String newPw) {
        pw = newPw;
    }
    public String name() {
        return name;
    }
    public void setName(String newName) {
        name = newName;
    }
    public String IdealName() {return idealName;}
    public void setIdealName(String newIdealName) {idealName = newIdealName;}
    public int sex() {
        return sex;
    }
    public void setSex(int newSex) {
        if(newSex == 0)
            sex = MALE;
        else if(newSex == 1) {
            sex = FEMALE;
        }
        else {
            System.out.println("잘못 입력하셨습니다. 0과 1중에 입력해주세요. (0: 남자, 1: 여자)");
            Scanner input = new Scanner(System.in);
            setSex(input.nextInt());
        }
    }
    public member(String newId, String newPw, String newName, int newSex) {
        setId(newId);
        setPw(newPw);
        setName(newName);
        setSex(newSex);
    }
}

