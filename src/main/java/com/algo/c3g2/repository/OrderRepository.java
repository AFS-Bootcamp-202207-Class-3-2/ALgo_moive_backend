package com.algo.c3g2.repository;

import com.algo.c3g2.controller.dto.OrderResponse;
import com.algo.c3g2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {


    @Query(nativeQuery = true,
            value = "select id,price,status,session_id,movie_id,cinema_id,room_id,user_id,seat_info,create_time from t_order where user_id=?1 order by create_time desc limit ?2,?3")
    List<Order> findAllByUserId(String userId,int page,int pageSize);

//    @Query(nativeQuery=true,
//            value="select \n" +
//                    "o.id,o.price,o.status,\n" +
//                    "s.start_time,s.end_time,s.screening_date,\n" +
//                    "m.movie_name,m.actors,m.movie_desc,m.release_date,\n" +
//                    "m.cover,m.duration,m.duration_unit,\n" +
//                    "c.cinema_name,c.address, \n" +
//                    "r.room_name,\n" +
//                    "u.avatar,u.nickname \n" +
//                    "from t_order o\n" +
//                    "left outer join t_session s on o.session_id = s.id \n" +
//                    "left outer join t_movie m on o.movie_id = m.id \n" +
//                    "left outer join t_cinema c on o.cinema_id = c.id \n" +
//                    "left outer join t_room r on o.room_id = r.id \n" +
//                    "left outer join t_user u on o.user_id = u.id \n" +
//                    "where o.id=:orderId")
//    OrderResponse generateOrderResponseById(@Param("orderId") String orderId);



//    @Query(value="select new com.algo.c3g2.controller.dto.OrderResponse(" +
//                    "o.id,o.price,o.status," +
//                    "s.start_time,s.end_time,s.screening_date," +
//                    "m.movie_name,m.actors,m.movie_desc,m.release_date," +
//                    "m.cover,m.duration,m.duration_unit," +
//                    "c.cinema_name,c.address, " +
//                    "r.room_name," +
//                    "u.nickname,u.avatar) " +
//                    "from t_order o "+
//                    "left outer join t_session s on o.session_id = s.id " +
//                    "left outer join t_movie m on o.movie_id = m.id " +
//                    "left outer join t_cinema c on o.cinema_id = c.id " +
//                    "left outer join t_room r on o.room_id = r.id " +
//                    "left outer join t_user u on o.user_id = u.id " +
//                    "where o.id=:orderId")
//    OrderResponse findOrderResponseById(@Param("orderId") String orderId);
}
