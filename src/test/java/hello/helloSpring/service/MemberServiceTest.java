package hello.helloSpring.service;

import hello.helloSpring.domain.Member;
import hello.helloSpring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryRepository;

    @BeforeEach
    public void beforeEach() {
        memoryRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryRepository);
        //실행할때맏 생성한 리포지토리를 생성자로 넘기기때문에
        //같은 리포지토리를 공유하게 됨
    }


    @AfterEach
    public void afterEach() {
        memoryRepository.clearStore();
    }

    @Test
    void 회원가입() { //memberService의 join을 검증
        //join으로 저장한 게 repository에 있는게 맞는지 검증
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long savedId=memberService.join(member);

        //then
        Member findMember = memberService.findOne(savedId).get();
        assertEquals(member.getName(),findMember.getName());
    }

    @Test
    public void 중복회원예외() {
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, //이 예외가 터져야한다.
                () -> memberService.join(member2)); //이 로직을 실행하면

        //assertThrows 실행하고 받은 반환값으로 오류문구도 검증 가능능
       assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}