package com.zcgr.datasource.custom.entity;

/**
 * @author kevin
 */
public class Member {

    private Long MemberId;
    private String MemberName;
    private String MemberPassword;

    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long memberId) {
        MemberId = memberId;
    }

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String memberName) {
        MemberName = memberName;
    }

    public String getMemberPassword() {
        return MemberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        MemberPassword = memberPassword;
    }
}
