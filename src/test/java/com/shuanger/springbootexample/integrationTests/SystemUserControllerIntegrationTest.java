package com.shuanger.springbootexample.integrationTests;

import com.shuanger.springbootexample.DTO.SystemUserDTO;
import com.shuanger.springbootexample.params.CreateUserParam;
import com.shuanger.springbootexample.params.QueryUserParam;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("ut")
public class SystemUserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    @Sql({"classpath:init_table.sql"})
    public void init() {

    }

    @AfterEach
    @Sql("classpath:drop_table.sql")
    public void cleanUpDatabase() {

    }

    @Test
    public void should_insert_user() {
        CreateUserParam createUserParam = new CreateUserParam();
        createUserParam.setUsername("username");
        createUserParam.setUserEmail("useremail@jd.com");
        createUserParam.setUserPassword("12334");
        createUserParam.setUserInfo("a test user");

        Integer count = this.template.postForObject("http://localhost:" + port + "/user/create", createUserParam, Integer.class);

        assertThat(count).isEqualTo(1);
    }

    @Test
    @Sql({"classpath:init_table.sql","classpath:data.sql"})
    public void should_query_user_when_given_valid_user_name() {
        QueryUserParam queryUserParam = new QueryUserParam();
        queryUserParam.setUsername("shuanger");

        SystemUserDTO systemUserDTO = this.template.postForObject("http://localhost:" + port + "/user/query", queryUserParam, SystemUserDTO.class);

        assertThat(systemUserDTO.getUsername()).isEqualTo("shuanger");
        assertThat(systemUserDTO.getUserEmail()).isEqualTo("zhaixiaoshuang@jd.com");
        assertThat(systemUserDTO.getUserInfo()).isEqualTo("a programmer");
    }
}
