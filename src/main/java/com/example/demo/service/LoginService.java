package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class LoginService {

    private final MemberRepository memberRepository;

    @Autowired
    public LoginService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean login(Member member){
        Optional<Member> findMember = memberRepository.findByName(member.getName());

        if(findMember == null){
            return false;
        }
        if(!findMember.get().getPassword().equals(member.getPassword())){
            return false;
        }
        return true;
    }
}
