package com.company.websocket;


import com.company.websocket.repo.LogRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class LogRepositoryTest {
    @Autowired
    private LogRepo repo;

    @Test
    public void testAddNew() {
        Log user = new Log();
        user.setContent("123");

        Log savedUser = repo.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId());

    }

}
