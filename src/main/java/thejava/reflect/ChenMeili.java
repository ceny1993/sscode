package thejava.reflect;

/**
 * Created by chensongkui on 2018/1/13.
 */
public class ChenMeili {
    private String fatherName;
    private String motherName;
    private Integer dogeCount;

    public ChenMeili(){
        System.out.println("i am chenmeili");
    }

    public ChenMeili(String fatherName, String motherName, Integer dogeCount) {
        System.out.println("oh i am detail chenmeili");
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.dogeCount = dogeCount;
    }

    public ChenMeili(String fatherName){
        this.fatherName = fatherName;
        this.motherName = "chulian";
        this.dogeCount = 7;
    }

    public ChenMeili(String fatherName, String motherName) {
        System.out.println("i do not have doges");
        this.fatherName = fatherName;
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public Integer getDogeCount() {
        return dogeCount;
    }

}
