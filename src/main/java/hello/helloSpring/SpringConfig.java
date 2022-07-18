package hello.helloSpring;

import hello.helloSpring.repository.MemberInterface;
import hello.helloSpring.repository.MemoryMemberRepository;
import hello.helloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberInterface memberRepository() {
        return new MemoryMemberRepository();
    }
}
