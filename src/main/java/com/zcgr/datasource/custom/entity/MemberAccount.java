package com.zcgr.datasource.custom.entity;

public class MemberAccount {

    private Long MemberAccountId;
    private Long MemberId;

    public Long getMemberAccountId() {
        return MemberAccountId;
    }

    public void setMemberAccountId(Long memberAccountId) {
        MemberAccountId = memberAccountId;
    }

    public Long getMemberId() {
        return MemberId;
    }

    public void setMemberId(Long memberId) {
        MemberId = memberId;
    }
}
