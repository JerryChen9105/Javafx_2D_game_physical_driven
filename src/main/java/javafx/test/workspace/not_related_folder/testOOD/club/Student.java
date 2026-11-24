package javafx.test.workspace.not_related_folder.testOOD.club;

public class Student extends Member {

    protected double gpa;

    public Student(String memberId, String name, double gpa) {
        super(memberId, name);
        this.gpa = gpa;
    }

    @Override
    public String getMemberId() {
        return super.getMemberId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public void setMemberId(String memberId) {
        super.setMemberId(memberId);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}

