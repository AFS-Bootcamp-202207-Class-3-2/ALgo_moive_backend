insert into t_user (
id,
username,
nickname,
password,
role_id,avatar,
phone,sign,
status,
create_time,
update_time
)
VALUES
    ('1552837438408228864','aleri','ikun','admin','1','https://czy-blog-system.oss-cn-shenzhen.aliyuncs.com/2020/11/01/374.gif','18575986786','用户签名','1','2022-07-29 10:04:30.298000','2022-07-29 10:04:30.298000'),
    ('1552837438408228863','czy','ikun','user','1','https://czy-blog-system.oss-cn-shenzhen.aliyuncs.com/2020/11/01/374.gif','18575986786','用户签名','1','2022-07-29 10:04:30.298000','2022-07-29 10:04:30.298000');

insert into t_role(
id,
role_name
) values
('1','admin'),
('2','business'),
('3','user');

insert into t_order(
id,
price,
status,
session_id,
movie_id,
cinema_id,
room_id,
user_id,
seat_info
) values
(
'1552837438408221364',
12.12,
'0',
'ALGOSESSION1',
'ALGOMOVIE1',
'ALGOCINEMA1',
'ALGOROOM1',
'1552837438408228864',
'1,2'
);

INSERT INTO t_session(
id,
room_id,
movie_id,
seats_info,
start_time,
end_time,
screening_date,
price
) VALUES (
'ALGOSESSION1',
'ALGOROOM1',
'ALGOMOVIE1',
'1121111121111111121111121211211211111111101101111',
'2022-07-29 10:04:30.298000',
'2022-07-29 22:04:30.298000',
'2022-07-29',
39.99);

INSERT INTO t_room(
id,
room_name,
seats_layout,
cinema_id
) VALUES (
'ALGOROOM1',
'巨幕厅',
'1111111111111111111111111111111111111111101101111',
'ALGOCINEMA1'
);

INSERT INTO t_cinema(
id,
cinema_name,
address
) VALUES (
'ALGOCINEMA1',
'ALGO巨幕影院',
'位于亚洲与大洋洲，太平洋与印度洋的十字路口'
);

INSERT INTO t_movie(
id,
movie_name,
actors,
movie_desc,
release_date,
score,
cover,
video,
hot_spot,
duration,
duration_unit
) VALUES (
'ALGOMOVIE1',
'ALGO',
'第二组全部成员',
'梦想始于剧本，而终结于电影。',
'2022-07-29 08:04:30.298000',
5.0,
'',
'',
10,
2,
'minute'
);


