package com.algo.c3g2.ControllerTest;


import com.algo.c3g2.entity.*;
import com.algo.c3g2.repository.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class CinemaControllerTest {

    @Autowired
    CinemaRepository cinemaRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    MockMvc client;

    @BeforeEach
    void clearData(){
        cinemaRepository.deleteAll();
        movieRepository.deleteAll();
        userRepository.deleteAll();
        roomRepository.deleteAll();
        sessionRepository.deleteAll();
    }

    @Test
    void should_get_cinemas_when_post_request_given_cinema_request() throws Exception {
        String cinemaJson = "{\n" +
                "    \"page\":0,\n" +
                "    \"pageSize\":10,\n" +
                "    \"serch\":\"cinema\"\n" +
                "}";

        Cinema cinema = new Cinema(null,"cinema1Name","cinema1Address");
        cinemaRepository.save(cinema);
        Cinema cinema2 = new Cinema(null,"cinema2Name","cinema2Address");
        cinemaRepository.save(cinema2);

        //given
        client.perform(MockMvcRequestBuilders.post("/cinemas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cinemaJson))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cinemas.content[0].cinemaName").value("cinema1Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cinemas.content[1].cinemaName").value("cinema2Name"));
    }

    @Test
    void should_get_all_cinemas_when_get_request_given_null() throws Exception {
        Cinema cinema = new Cinema(null,"cinema1Name","cinema1Address");
        cinemaRepository.save(cinema);
        Cinema cinema2 = new Cinema(null,"cinema2Name","cinema2Address");
        cinemaRepository.save(cinema2);
        //given
        client.perform(MockMvcRequestBuilders.get("/cinemas"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cinemas[0].cinemaName").value("cinema1Name"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cinemas[1].cinemaName").value("cinema2Name"));
    }

    @Test
    void should_get_cinemas_when_get_cinemas_given_movie_id() throws Exception {
        //given
        Cinema cinema = new Cinema(null,"cinema1Name","cinema1Address");
        cinemaRepository.save(cinema);
        Cinema cinema2 = new Cinema(null,"cinema2Name","cinema2Address");
        cinemaRepository.save(cinema2);
        Movie movie = new Movie(null,"movie1Name","movie1Actors","movie1Desc");
        movieRepository.save(movie);
        Room room = new Room(null,"room1Name","seatsLayout",cinema.getId());
        roomRepository.save(room);
        Session session = new Session(null,room.getId(),movie.getId(),"0,1,1,1,1,1,1,1,2,2,2,2,0,0");
        sessionRepository.save(session);

        client.perform(MockMvcRequestBuilders.get("/cinemas/{movieId}/movies",movie.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk());
        //when

        //then
    }

    @Test
    void should_get_cinema_when_get_given_cinema_id() throws Exception {
        Cinema cinema = new Cinema(null,"cinema1Name","cinema1Address");
        Cinema cinema1 = cinemaRepository.save(cinema);
//        given
        client.perform(MockMvcRequestBuilders.get("/cinemas/{id}",cinema1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.cinema.cinemaName").value("cinema1Name"));

    }


}
