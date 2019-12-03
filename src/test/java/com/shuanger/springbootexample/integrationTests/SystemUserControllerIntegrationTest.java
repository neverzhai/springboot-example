package com.shuanger.springbootexample.integrationTests;

import com.shuanger.springbootexample.VO.SystemUserVO;
import com.shuanger.springbootexample.params.QueryUserParam;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SystemUserControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void should_query_user_when_given_valid_user_name() {
        QueryUserParam queryUserParam = new QueryUserParam();
        queryUserParam.setUsername("shuanger");

        SystemUserVO systemUserVO = this.testRestTemplate.postForObject("http://localhost:" + port + "/user", queryUserParam, SystemUserVO.class);

        assertThat(systemUserVO.getUsername()).isEqualTo("shuanger");
        assertThat(systemUserVO.getUserEmail()).isEqualTo("zhaixiaoshuang@jd.com");
        assertThat(systemUserVO.getUserInfo()).isEqualTo("a programmer");

    }
}
