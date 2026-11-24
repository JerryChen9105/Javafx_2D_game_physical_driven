package javafx.test.workspace.not_related_folder.testOOD.club;

public class Stuff extends Member {

    protected String department;

    public Stuff(String memberId, String name, String department) {
        super(memberId, name);
        this.department = department;
    }

    @Override
    public String getMemberId() {
        return super.getMemberId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void setMemberId(String memberId) {
        super.setMemberId(memberId);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

