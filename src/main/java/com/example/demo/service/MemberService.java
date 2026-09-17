package com.example.demo.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
    public List<Member> ListAllMembers() {
        return getAllMembers();
    }
    public Member getMemberById(Long Memberid) {
        return memberRepository.findById(Memberid).orElseThrow(() -> new RuntimeException("Member not found"));
    }
    public Member updateMember(Long Memberid, Member updatedMember) {
        Member existingMember = memberRepository.findById(Memberid).orElseThrow(() -> new RuntimeException("Member not found"));
        existingMember.setMemberName(updatedMember.getMemberName());
        existingMember.setMemberEmail(updatedMember.getMemberEmail());
        return memberRepository.save(existingMember);
    }
    public String deleteMember(Long Memberid) {
        memberRepository.deleteById(Memberid);
        return "Member with id " + Memberid + " has been deleted.";
    }
}
