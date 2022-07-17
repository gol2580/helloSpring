package hello.helloSpring.repository;
import hello.helloSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberInterface {

    Member save(Member member);

    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
