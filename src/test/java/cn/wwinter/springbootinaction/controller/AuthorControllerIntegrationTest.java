package cn.wwinter.springbootinaction.controller;

import cn.wwinter.springbootinaction.TestDataUtil;
import cn.wwinter.springbootinaction.domain.entities.AuthorEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * ClassName: AuthorControllerIntegrationTest
 * Package: cn.wwinter.springbootinaction.controller
 * Description:
 * Datetime: 2023/11/13
 * Author: zhangdd
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
@Slf4j
public class AuthorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testThatCreateAuthor() throws Exception {
        AuthorEntity authorA = TestDataUtil.createAuthorA();
        authorA.setId(null);
        String authorJson = objectMapper.writeValueAsString(authorA);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/createAuthor")
                .contentType(MediaType.APPLICATION_JSON)
                .content(authorJson)
        ).andExpect(
                MockMvcResultMatchers.status().isCreated()
        );
    }
}
