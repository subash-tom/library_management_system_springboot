package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long MemberId;
    private String MemberName;
    private String MemberEmail;
    private String MemberPhone;

    protected Member() {
    }
    public Member(String MemberName, String MemberEmail, String MemberPhone,Long MemberId) {
        this.MemberName = MemberName;
        this.MemberEmail = MemberEmail;
        this.MemberPhone = MemberPhone;
        this.MemberId = MemberId;
    }


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

    public String getMemberEmail() {
        return MemberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        MemberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return MemberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        MemberPhone = memberPhone;
    }
}