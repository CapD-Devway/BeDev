package dev.com.bedev;
import dev.com.bedev.domain.user.User;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData {

    private final EntityManagerFactory emf;
    @PostConstruct
    public void init(){
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //테스트용 계정 추가 + 시큐리티 추가전 => 개발단계 급속화를 위해
        User user = User.builder()
                .email("smjsih@naver.com")
                .password("1111")
                .name("서명진")
                .build();


        em.persist(user);
        tx.commit();
        em.close();
    }
}