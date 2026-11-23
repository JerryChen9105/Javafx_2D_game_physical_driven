package javafx.test.workspace.folder.testOOD.club;

import java.util.LinkedHashMap;

public class Club {

    private String clubName;
    private final LinkedHashMap<String, Member> memberRetrieveMap;

    public Club(String clubName) {
        this.clubName = clubName;
        this.memberRetrieveMap = new LinkedHashMap<>();
    }

    public String getClubName() {
        return clubName;
    }

    public LinkedHashMap<String, Member> getMemberRetriveMap() {
        return memberRetrieveMap;
    }

    public void addMember(Member member) {
        memberRetrieveMap.put(member.getMemberId(), member);
    }

}

