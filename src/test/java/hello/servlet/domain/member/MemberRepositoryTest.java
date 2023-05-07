package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("hello", 20);

        //when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById((savedMember.getId()));
        Assertions.assertThat(findMember).isEqualTo(savedMember);
    }
    @Test
    void findAll(){
        //given
        Member member1 = new Member("hello1",21);
        Member member2 = new Member("hello2",22);
        Member member3 = new Member("hello3",23);
        Member member4 = new Member("hello4",24);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);

        // when
        List<Member> findMembers = memberRepository.findAll();

        // then
        Assertions.assertThat(findMembers.size()).isEqualTo(4);
        Assertions.assertThat(findMembers).contains(member1,member2,member3,member4);

    }
}
