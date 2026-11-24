package javafx.test.workspace.not_related_folder.testOOD.club;

public abstract class Member {

    protected String memberId;
    protected String name;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }
}

