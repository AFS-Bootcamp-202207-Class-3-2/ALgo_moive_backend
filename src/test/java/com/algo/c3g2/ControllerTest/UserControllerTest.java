//package com.algo.c3g2.ControllerTest;
//
//import com.algo.c3g2.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//@ActiveProfiles("test")
//@AutoConfigureMockMvc
//@SpringBootTest
//public class UserControllerTest {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    MockMvc client;
//
//    @Test
//    void should_get_user_when_regesiter_given_right_username_password() throws Exception {
//        //given
//        String userJson = "{\n" +
//                "    \"username\":\"1236\",\n" +
//                "    \"password\":\"123456\"\n" +
//                "}";
//
//        client.perform(MockMvcRequestBuilders.post("/users/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(userJson))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.data.data.username").value("1236"));
//
//    }
//
//}
