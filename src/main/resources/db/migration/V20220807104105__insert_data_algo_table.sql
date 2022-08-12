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
values
    ('1552837438408228863','czy','ikun','962012d09b8170d912f0669f6d7d9d7','1','https://czy-blog-system.oss-cn-shenzhen.aliyuncs.com/2020/11/01/374.gif','18575986786','用户签名','1','2022-07-29 10:04:30','2022-07-29 10:04:30'),
    ('1552837438408228864','aleri','ikun','962012d09b8170d912f0669f6d7d9d7','1','https://czy-blog-system.oss-cn-shenzhen.aliyuncs.com/2020/11/01/374.gif','18575986786','用户签名','1','2022-07-29 10:04:30','2022-07-29 10:04:30'),
    ('1557268228466540544','testuser','testuser','d9b1d7db4cd6e7935368a1efb10e377','3','https://czy-blog-system.oss-cn-shenzhen.aliyuncs.com/2020/11/01/374.gif','18575986786','这用户很懒，不想说什么~','1','2022-07-29 10:04:30','2022-07-29 10:04:30'),
    ('1557269533679419392','qwer','qwer','962012d09b8170d912f0669f6d7d9d7','3','https://czy-blog-system.oss-cn-shenzhen.aliyuncs.com/2020/11/01/374.gif','18575986786','这用户很懒，不想说什么~','1','2022-07-29 10:04:30','2022-07-29 10:04:30');

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
seat_info,
create_time
) values
      ('ORDER1',39.99,'1','ALGOSESSION1','ALGOMOVIE8','ALGOCINEMA1','ALGOROOM1','1552837438408228863','1,2','2022-08-07 20:04:30'),
      ('ORDER10',39.99,'1','ALGOSESSION1','ALGOMOVIE8','ALGOCINEMA1','ALGOROOM1','1557269533679419392','5,6','2022-08-10 10:11:11'),
      ('ORDER11',79.98,'1','ALGOSESSION15','ALGOMOVIE15','ALGOCINEMA3','ALGOROOM8','1557269533679419392','1,1 1,2','2022-08-10 10:11:11'),
      ('ORDER2',79.98,'1','ALGOSESSION14','ALGOMOVIE8','ALGOCINEMA3','ALGOROOM7','1552837438408228863','6,5 6,4','2022-08-10 10:11:11'),
      ('ORDER3',79.98,'1','ALGOSESSION26','ALGOMOVIE1','ALGOCINEMA6','ALGOROOM13','1552837438408228863','6,7 3,6','2022-08-10 10:11:11'),
      ('ORDER4',39.99,'1','ALGOSESSION12','ALGOMOVIE17','ALGOCINEMA3','ALGOROOM6','1552837438408228864','5,7','2022-08-10 10:11:11'),
      ('ORDER5',39.99,'1','ALGOSESSION22','ALGOMOVIE17','ALGOCINEMA5','ALGOROOM11','1552837438408228864','5,6','2022-08-10 10:11:11'),
      ('ORDER6',39.99,'1','ALGOSESSION25','ALGOMOVIE16','ALGOCINEMA6','ALGOROOM13','1552837438408228864','1,2','2022-08-10 10:11:11'),
      ('ORDER7',79.98,'1','ALGOSESSION10','ALGOMOVIE20','ALGOCINEMA2','ALGOROOM5','1557268228466540544','6,5 6,4','2022-08-10 10:11:11'),
      ('ORDER8',79.98,'1','ALGOSESSION14','ALGOMOVIE8','ALGOCINEMA3','ALGOROOM7','1557268228466540544','6,7 3,6','2022-08-10 10:11:11'),
      ('ORDER9',39.99,'1','ALGOSESSION18','ALGOMOVIE19','ALGOCINEMA4','ALGOROOM9','1557268228466540544','5,7','2022-08-10 10:11:11');

insert  into t_session(id,room_id,movie_id,seats_info,start_time,end_time,screening_date,price) values ('ALGOSESSION1','ALGOROOM1','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-07 20:04:30','2022-08-07 22:04:30','2022-08-07',29.9),('ALGOSESSION10','ALGOROOM5','ALGOMOVIE20','1121111121111111121111121211211211111111111111111','2022-08-14 13:45:51','2022-08-14 15:45:57','2022-08-14',39.9),('ALGOSESSION11','ALGOROOM6','ALGOMOVIE2','2221111121111111121211121211211212211122121121111','2022-08-22 09:04:30','2022-08-22 11:04:30','2022-08-22',39.9),('ALGOSESSION12','ALGOROOM6','ALGOMOVIE17','2221111121111111121211121211211212211122121121111','2022-08-12 12:44:33','2022-08-12 14:44:44','2022-08-12',39.9),('ALGOSESSION13','ALGOROOM7','ALGOMOVIE3','1121111121111111121111121211211211111111111111111','2022-08-18 12:44:33','2022-08-18 14:44:44','2022-08-18',39.9),('ALGOSESSION14','ALGOROOM7','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-10 12:45:51','2022-08-10 14:45:57','2022-08-10',39.9),('ALGOSESSION15','ALGOROOM8','ALGOMOVIE15','2221111121111111121211121211211212211122121121111','2022-08-11 10:04:30','2022-08-11 12:04:30','2022-08-11',39.9),('ALGOSESSION16','ALGOROOM8','ALGOMOVIE11','2221111121111111121211121211211212211122121121111','2022-08-11 12:44:33','2022-08-11 14:44:44','2022-08-11',39.9),('ALGOSESSION17','ALGOROOM9','ALGOMOVIE14','1121111121111111121111121211211211111111111111111','2022-08-15 09:45:51','2022-08-15 11:45:57','2022-08-15',39.9),('ALGOSESSION18','ALGOROOM9','ALGOMOVIE19','1121111121111111121111121211211211111111111111111','2022-08-07 10:04:30','2022-08-07 12:04:30','2022-08-07',39.9),('ALGOSESSION19','ALGOROOM10','ALGOMOVIE5','1121111121111111121111121211211211111111111111111','2022-08-25 12:44:33','2022-08-25 14:44:44','2022-08-25',39.9),('ALGOSESSION2','ALGOROOM1','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-10 10:00:30','2022-08-10 11:50:30','2022-08-10',29.9),('ALGOSESSION20','ALGOROOM10','ALGOMOVIE18','1121111121111111121111121211211211111111111111111','2022-08-09 12:45:51','2022-08-09 14:45:57','2022-08-09',39.9),('ALGOSESSION21','ALGOROOM11','ALGOMOVIE6','1121111121111111121111121211211211111111121111111','2022-08-25 12:46:37','2022-08-25 14:46:41','2022-08-25',39.9),('ALGOSESSION22','ALGOROOM11','ALGOMOVIE17','1121111121111111121111121211211211111111111111111','2022-08-11 12:45:51','2022-08-11 14:45:57','2022-08-11',39.9),('ALGOSESSION23','ALGOROOM12','ALGOMOVIE7','2221111121111111121211121211211212211122121121111','2022-08-18 20:04:30','2022-08-18 22:04:30','2022-08-18',39.9),('ALGOSESSION24','ALGOROOM12','ALGOMOVIE15','1121111121111111121111121211211211111111111111111','2022-08-11 12:44:33','2022-08-11 14:44:44','2022-08-11',39.9),('ALGOSESSION25','ALGOROOM13','ALGOMOVIE16','1121111121111111121111121211211211111111111111111','2022-08-11 09:45:51','2022-08-09 11:45:57','2022-08-11',39.9),('ALGOSESSION26','ALGOROOM13','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-12 10:04:30','2022-08-12 22:04:30','2022-08-12',39.9),('ALGOSESSION27','ALGOROOM14','ALGOMOVIE9','1121111121111111121111121211211211111111111111111','2022-08-20 12:44:33','2022-08-20 14:44:44','2022-08-20',39.9),('ALGOSESSION28','ALGOROOM14','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-11 12:45:51','2022-08-11 14:45:57','2022-08-11',39.9),('ALGOSESSION29','ALGOROOM15','ALGOMOVIE4','2221111121111111121211121211211212211122121121111','2022-08-20 10:04:30','2022-08-20 22:04:30','2022-08-20',39.9),('ALGOSESSION3','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-12 12:44:33','2022-08-12 14:44:44','2022-08-12',25.9),('ALGOSESSION30','ALGOROOM15','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-12 12:44:33','2022-08-12 14:44:44','2022-08-12',39.9),('ALGOSESSION31','ALGOROOM16','ALGOMOVIE4','1121111121111111121111121211211211111111111111111','2022-08-21 12:45:51','2022-08-21 14:45:57','2022-08-21',39.9),('ALGOSESSION32','ALGOROOM16','ALGOMOVIE11','2221111121111111121211121211211212211122121121111','2022-08-11 10:04:30','2022-08-11 22:04:30','2022-08-11',39.9),('ALGOSESSION33','ALGOROOM17','ALGOMOVIE13','1121111121111111121111121211211211111111111111111','2022-08-11 12:44:33','2022-08-11 14:44:44','2022-08-11',39.9),('ALGOSESSION34','ALGOROOM17','ALGOMOVIE14','1121111121111111121111121211211211111111111111111','2022-08-15 12:44:33','2022-08-15 14:44:44','2022-08-15',39.9),('ALGOSESSION35','ALGOROOM18','ALGOMOVIE12','1121111121111111121111121211211211111111111111111','2022-08-11 12:45:51','2022-08-11 14:45:57','2022-08-11',39.9),('ALGOSESSION36','ALGOROOM18','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-12 10:04:30','2022-08-12 22:04:30','2022-08-12',39.9),('ALGOSESSION37','ALGOROOM19','ALGOMOVIE3','1121111121111111121111121211211211111111111111111','2022-08-18 12:44:33','2022-08-18 14:44:44','2022-08-18',39.9),('ALGOSESSION38','ALGOROOM19','ALGOMOVIE2','1121111121111111121111121211211211111111111111111','2022-08-22 12:45:51','2022-08-22 14:45:57','2022-08-22',39.9),('ALGOSESSION39','ALGOROOM1','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-12 09:04:30','2022-08-12 11:04:30','2022-08-12',29.9),('ALGOSESSION4','ALGOROOM2','ALGOMOVIE20','1121111121111111121111121211211211111111111111111','2022-08-13 13:45:51','2022-08-13 15:38:57','2022-08-13',39.9),('ALGOSESSION40','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-12 09:45:51','2022-08-12 11:45:57','2022-08-12',25.9),('ALGOSESSION41','ALGOROOM3','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-12 12:04:30','2022-08-12 14:04:30','2022-08-12',39.9),('ALGOSESSION42','ALGOROOM1','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-13 09:44:33','2022-08-13 11:44:44','2022-08-13',29.9),('ALGOSESSION43','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-13 09:44:33','2022-08-13 11:44:44','2022-08-13',25.9),('ALGOSESSION44','ALGOROOM3','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-13 12:45:51','2022-08-13 14:45:57','2022-08-13',39.9),('ALGOSESSION45','ALGOROOM1','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-14 09:04:30','2022-08-14 11:04:30','2022-08-14',29.9),('ALGOSESSION46','ALGOROOM2','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-14 09:44:33','2022-08-14 11:44:44','2022-08-14',25.9),('ALGOSESSION47','ALGOROOM3','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-14 12:45:51','2022-08-14 14:45:57','2022-08-14',39.9),('ALGOSESSION48','ALGOROOM1','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-12 10:04:30','2022-08-12 12:04:30','2022-08-12',29.9),('ALGOSESSION49','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-12 13:44:33','2022-08-12 15:44:44','2022-08-12',25.9),('ALGOSESSION5','ALGOROOM3','ALGOMOVIE12','2221111121111111121211121211211212211122121121111','2022-08-11 10:04:30','2022-08-11 11:54:30','2022-08-11',39.9),('ALGOSESSION50','ALGOROOM3','ALGOMOVIE1','2221111121111111121211121211211212211122121121111','2022-08-13 15:00:30','2022-08-13 17:50:30','2022-08-13',39.9),('ALGOSESSION51','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111121111111','2022-08-14 21:46:37','2022-08-14 23:46:41','2022-08-14',25.9),('ALGOSESSION52','ALGOROOM1','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-12 09:04:30','2022-08-12 11:04:30','2022-08-12',29.9),('ALGOSESSION53','ALGOROOM2','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-12 09:45:51','2022-08-12 11:45:57','2022-08-12',25.9),('ALGOSESSION54','ALGOROOM3','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-12 12:04:30','2022-08-12 14:04:30','2022-08-12',39.9),('ALGOSESSION55','ALGOROOM1','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-13 09:44:33','2022-08-13 11:44:44','2022-08-13',29.9),('ALGOSESSION56','ALGOROOM2','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-13 09:44:33','2022-08-13 11:44:44','2022-08-13',25.9),('ALGOSESSION57','ALGOROOM3','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-13 12:45:51','2022-08-13 14:45:57','2022-08-13',39.9),('ALGOSESSION58','ALGOROOM1','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-14 09:04:30','2022-08-14 11:04:30','2022-08-14',29.9),('ALGOSESSION59','ALGOROOM2','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-14 09:44:33','2022-08-14 11:44:44','2022-08-14',25.9),('ALGOSESSION6','ALGOROOM3','ALGOMOVIE13','2221111121111111121211121211211212211122121121111','2022-08-11 13:44:33','2022-08-11 16:03:44','2022-08-11',39.9),('ALGOSESSION60','ALGOROOM1','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-13 17:45:51','2022-08-13 19:45:57','2022-08-13',29.9),('ALGOSESSION61','ALGOROOM1','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-12 10:04:30','2022-08-12 12:04:30','2022-08-12',29.9),('ALGOSESSION62','ALGOROOM2','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-12 13:44:33','2022-08-12 15:44:44','2022-08-12',25.9),('ALGOSESSION63','ALGOROOM3','ALGOMOVIE10','2221111121111111121211121211211212211122121121111','2022-08-13 15:00:30','2022-08-13 17:50:30','2022-08-13',39.9),('ALGOSESSION64','ALGOROOM1','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-13 17:45:51','2022-08-13 19:45:57','2022-08-13',29.9),('ALGOSESSION65','ALGOROOM2','ALGOMOVIE10','1121111121111111121111121211211211111111121111111','2022-08-14 21:46:37','2022-08-14 23:46:41','2022-08-14',25.9),('ALGOSESSION66','ALGOROOM3','ALGOMOVIE10','1121111121111111121111121211211211111111111111111','2022-08-14 12:45:51','2022-08-14 14:45:57','2022-08-14',39.9),('ALGOSESSION67','ALGOROOM1','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-12 09:04:30','2022-08-12 11:04:30','2022-08-12',29.9),('ALGOSESSION68','ALGOROOM2','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-12 09:45:51','2022-08-12 11:45:57','2022-08-12',25.9),('ALGOSESSION69','ALGOROOM3','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-12 12:04:30','2022-08-12 14:04:30','2022-08-12',39.9),('ALGOSESSION7','ALGOROOM4','ALGOMOVIE18','1121111121111111121111121211211211111111111111111','2022-08-12 15:45:51','2022-08-12 17:45:57','2022-08-12',39.9),('ALGOSESSION70','ALGOROOM1','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-13 09:44:33','2022-08-13 11:44:44','2022-08-13',29.9),('ALGOSESSION71','ALGOROOM2','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-13 09:44:33','2022-08-13 11:44:44','2022-08-13',25.9),('ALGOSESSION72','ALGOROOM3','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-13 12:45:51','2022-08-13 14:45:57','2022-08-13',39.9),('ALGOSESSION73','ALGOROOM1','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-14 09:04:30','2022-08-14 11:04:30','2022-08-14',29.9),('ALGOSESSION74','ALGOROOM2','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-14 09:44:33','2022-08-14 11:44:44','2022-08-14',25.9),('ALGOSESSION75','ALGOROOM3','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-14 12:45:51','2022-08-14 14:45:57','2022-08-14',39.9),('ALGOSESSION76','ALGOROOM1','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-12 10:04:30','2022-08-12 12:04:30','2022-08-12',29.9),('ALGOSESSION77','ALGOROOM2','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-12 13:44:33','2022-08-12 15:44:44','2022-08-12',25.9),('ALGOSESSION78','ALGOROOM3','ALGOMOVIE8','2221111121111111121211121211211212211122121121111','2022-08-13 15:00:30','2022-08-13 17:50:30','2022-08-13',39.9),('ALGOSESSION79','ALGOROOM1','ALGOMOVIE8','1121111121111111121111121211211211111111111111111','2022-08-13 17:45:51','2022-08-13 19:45:57','2022-08-13',29.9),('ALGOSESSION8','ALGOROOM4','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-13 10:04:30','2022-08-13 12:04:30','2022-08-13',39.9),('ALGOSESSION80','ALGOROOM2','ALGOMOVIE8','1121111121111111121111121211211211111111121111111','2022-08-14 21:46:37','2022-08-14 23:46:41','2022-08-14',25.9),('ALGOSESSION9','ALGOROOM5','ALGOMOVIE19','1121111121111111121111121211211211111111111111111','2022-08-12 14:44:33','2022-08-12 16:34:44','2022-08-12',39.9);


insert into t_room(
id,
room_name,
seats_layout,
cinema_id
) values
      ('ALGOROOM1','巨幕厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA1'),
      ('ALGOROOM2','会员尽享厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA1'),
      ('ALGOROOM3','3D环绕厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA1'),
      ('ALGOROOM4','CGS中国巨幕厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA2'),
      ('ALGOROOM5','杜比全景声厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA2'),
      ('ALGOROOM6','60帧厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA3'),
      ('ALGOROOM7','进口幕布厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA3'),
      ('ALGOROOM8','会员尽享厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA3'),
      ('ALGOROOM9','小区广场厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA4'),
      ('ALGOROOM10','1号厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA5'),
      ('ALGOROOM11','2号厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA5'),
      ('ALGOROOM12','1号厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA6'),
      ('ALGOROOM13','2号厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA6'),
      ('ALGOROOM14','巨幕厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA7'),
      ('ALGOROOM15','会员尽享厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA7'),
      ('ALGOROOM16','3D环绕厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA7'),
      ('ALGOROOM17','ikun厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA8'),
      ('ALGOROOM18','lizhi厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA8'),
      ('ALGOROOM19','会员厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA8');

insert into t_cinema(
id,
cinema_name,
address,
phone,
cinema_service
) values
      ('ALGOCINEMA1','ALGO巨幕影院','位于亚洲与大洋洲，太平洋与印度洋的十字路口','13352147665','儿童优惠,3D眼镜免费提供'),
      ('ALGOCINEMA2','无名影院','地球的某一个角落','14524789554','CGS中国巨幕厅,杜比全景声厅,退'),
      ('ALGOCINEMA3','CC影城（华发水岸店）','香洲区南屏镇珠海大道3888号华发水岸商业街2层','15547895442','改签,折扣卡,会员优惠'),
      ('ALGOCINEMA4','万达影城（香洲铭泰城市广场店）','香洲区紫荆路93号铭泰城市广场三楼(1234厅)、五楼（5.6.7.8.9厅）','14458745995','改签,折扣卡,全屏大厅'),
      ('ALGOCINEMA5','中影佰纳国际影城（珠海DMAX店）','金湾区湖心路1138号家和城广场F区商业三楼','14588966446','3D环绕,会员卡,儿童优惠'),
      ('ALGOCINEMA6','中影南方4D影城（玖洲道店）','香洲区兰埔路玖洲道购物公园综合楼三楼','13345784115','改签,儿童优惠,免费爆米花'),
      ('ALGOCINEMA7','中影国际影城（优特汇店）','香洲区银桦路102号优特广场L439商铺','14785461225','CGS中国巨幕厅,杜比全景声厅,退'),
      ('ALGOCINEMA8','中影国际影城（华发世纪城店）','香洲区昌盛路376号华发新天地商业街2101铺','14452879554','退,改签,折扣卡,60帧厅');

insert  into t_movie(id,movie_name,actors,movie_desc,release_date,score,cover,video,hot_spot,movie_type,language_version,box_office,duration,duration_unit,pictures) values ('ALGOMOVIE1','ALGO','第二组全体人员','梦想始于剧本，而终结于电影。','2022-08-12 08:04:30',9.9,'https://p0.pipi.cn/mmdb/25bfd671339c7e8ea33139d0476cb0d92908d.jpg?imageView2/1/w/218/h/300','',100,'喜剧,科幻','国语2D',100,120,'min','https://p0.pipi.cn/friday/f038cdd82436839a63e0dd030729dd6f.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/23f44566e055e044bc32efd6988f0549.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/8ba0a78fb03b3b0a7492d13b9cff7e7d.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/31dfd4762d21bca655b9e789382901c3.jpg?imageMogr2/thumbnail/2500x2500%3E'),('ALGOMOVIE10','独行月球','沈腾,玛丽','人类为抵御小行星的撞击，拯救地球，在月球部署了月盾计划。','2022-08-11 08:04:30',5,'https://p0.pipi.cn/mmdb/25bfd6d72c992367cb537c020675f703a7045.jpg?imageView2/1/w/160/h/220','',20,'喜剧,科幻','国语2D',99.99,120,'min','https://p0.pipi.cn/friday/531b7d1311fcb84b463e313bd92fc843.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/27f7ed0e5de4ad8ca08bcafdd23a2e2e.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/d401d9cabfdb423fc09e941967c9b728.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/f6337b044cc2874eb9b2a8546529e9f9.jpg?imageMogr2/thumbnail/2500x2500%3E'),('ALGOMOVIE11','遇见你','李文翰，徐若晗','女孩在最美好的青春里，遇到了一个想要勇敢去爱的男孩。 18岁那年，被同学嘲笑为“垃圾桶”的余骄阳遇见了让她一见钟情的转校生周灿。她帮助周灿实现梦想，将周灿视为命中注定，并努力和周灿考到了一个城市，陪伴周灿成长。','2022-08-10 17:12:36',7,'	https://p0.pipi.cn/mmdb/25bfd63387a51b1789d7c3e691b17817dadea.jpg?imageView2/1/w/464/h/644','',15,'剧情,爱情','国语2D',15.14,110,'min','https://p0.pipi.cn/friday/d7589817477fc8269ee05b946c2cd256.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/f661d1c2f5ebf5c98385b703a60ef921.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/fb703fd6da3001a3f1395597cd2e0b7a.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/ff821d802ca7d4f06484498b9d5631a0.jpg?imageMogr2/thumbnail/2500x2500%3E'),('ALGOMOVIE12','小马宝莉：新世代','凡妮莎·哈金斯','不可思议的事情发生了······小马利亚失去了魔力！陆马、独角兽和飞马不再是朋友，如今只有同种族的小马才会待在一起。但理想主义 的年轻陆马希悦决心找到一种方法，让世界重新拥有魔法并变得 像以前一样团结。','2022-08-10 17:15:11',8.8,'https://p0.pipi.cn/mmdb/25bfd6d7c69923d2369235777ef3a3aad278f.jpg?imageView2/1/w/464/h/644','',10,'动画,冒险,家庭','英语',8.5,90,'min',NULL),('ALGOMOVIE13','长津湖之水门桥','吴京,易烊千玺','电影《长津湖之水门桥》以抗美援朝战争第二次战役中的长津湖战役为背景，讲述了在结束了新兴里和下碣隅里的战斗之后，七连战士们又接到了更艰巨的任务……','2022-08-10 17:17:28',9.6,'https://p0.pipi.cn/mmdb/25bfd6be9abc7e8d3311e5bd9b6d287be0f28.png?imageView2/1/w/464/h/644','',99,'历史,战争,剧情','国语2D',9.8,149,'min','https://p0.pipi.cn/friday/7cf8708a40511016271ea03629497f7c.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/020ff095266c7e4e5425608a3682489c.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/d8a9a3d3d166269eecc8194584930b2e.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/4dc8fcb1e14331028247fdfbf68c49d8.jpg?imageMogr2/thumbnail/2500x2500%3E'),('ALGOMOVIE14','流浪地球','吴京,李光洁','故事背景设定在2075年，讲述了太阳即将毁灭，已经不适合人类生存，而面对绝境，人类将开启“流浪地球”计划，试图带着地球一起逃离太阳系，寻找人类新家园的故事。','2022-08-15 17:19:48',0,'https://p0.pipi.cn/mmdb/d2dad592b12f2aecd85bf1e2b67ecef72192c.jpg?imageView2/1/w/464/h/644','',0,'科幻,冒险,剧情','国语2D',0,125,'min',NULL),('ALGOMOVIE15','迷你世界之觉醒','何春,华信','电影《迷你世界之觉醒》脱胎于人气沙盒游戏《迷你世界》，为首部沙盒类游戏改编大电影。故事讲述了主人公卡卡为了守护部落，联合妮妮、熊孩子和黑龙，试图摧毁地心人邪恶计划的冒险故事，一场热血较量爆笑展开。','2022-07-30 17:22:01',8.6,'https://p0.pipi.cn/mmdb/25bfd6d7338ddd300bd2366ad18f464363723.jpg?imageView2/1/w/464/h/644','',25,'动画,奇幻,冒险','国语2D',10.4,99,'min',NULL),('ALGOMOVIE16','七人乐队','吴镇宇,许天华','七位导演自上世纪五十年代一直到当下，各自抽签负责一个年代，讲述普通人与香港之间息息相关的故事。','2022-08-07 17:24:03',6.6,'https://p0.pipi.cn/mmdb/25bfd671c7e51bc696cf3e73c07f267bbe242.jpg?imageView2/1/w/464/h/644','',30,'剧情','国语2D',8.5,111,'min','https://p1.meituan.net/movie/2173a93794a216a1ef4b24ed2462ff4c2173561.jpg,https://p0.meituan.net/movie/f446e29dbd444ecc6ee9e999d8cd4e9d1969845.jpg,https://p0.meituan.net/movie/d5e55d78cc90e9d5c412048cdbe92e921998569.jpg,https://p0.meituan.net/movie/8d01ddaf8f252b925b23891d9235b2982125315.jpg'),('ALGOMOVIE17','迷失之城','艾伦.尼,亚当.尼','洛蕾塔·塞琪（桑德拉·布洛克饰）是一位才华横溢但与世隔绝的作家。在她的畅销爱情冒险小说里，总会出现许多奇异的地方。而作为本书的封面模特，艾伦（查宁·塔图姆饰）一生都在致力于展现书中英雄角色“达什”的个人魅力。','2022-08-08 17:26:24',4.5,'https://p0.pipi.cn/mmdb/25bfd6338d3dddaf33b860d65ffd6e4797af8.jpg?imageView2/1/w/464/h/644','',45,'戏剧,动作,爱情','美国片',40.4,110,'min','https://p0.pipi.cn/friday/07cb129c7416f4733774c9d404807dbc.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/bcbc4bd2806cebefdfe5561ae4c17bde.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/3827c4d9c2844c8a523642084abb71d9.jpg?imageMogr2/thumbnail/2500x2500%3E,https://p0.pipi.cn/friday/15a49d32d39ccbdace562b7e28b35dfe.jpg?imageMogr2/thumbnail/2500x2500%3E'),('ALGOMOVIE18','中国机长','张涵予,欧豪','四川航空3U8633航班机组执行航班任务时，在万米高空突遇驾驶舱风挡玻璃爆裂脱落、座舱释压的极端罕见险情。机组成员凭借着极少仍在工作状态的仪器，艰难地进行手动驾驶。','2022-08-01 17:28:54',9.7,'https://p0.pipi.cn/mmdb/d2dad5925370fa2ff787a978c22d7824921cc.jpg?imageView2/1/w/464/h/644','',55,'剧情,灾难','国语2D',88.8,111,'min','https://p1.meituan.net/movie/1b464f1bc3b99b8d34ea9683d98ee6fe148359.jpg@106w_106h_1e_1c,https://p1.meituan.net/movie/d5ec3a81cf37384a21d04f22bf034e7d108156.jpg@106w_106h_1e_1c,https://p1.meituan.net/movie/750015567602c58e8780331c212721d880716.jpg@106w_106h_1e_1c,	https://p1.meituan.net/mmdb/a3a00d98b308571bbee2c501f7250599967059.jpg@106w_106h_1e_1c'),('ALGOMOVIE19','狙击手','张末,陈永胜','影片根据抗美援朝战争“冷枪冷炮”运动中神枪手群体事迹改编。1952年冬至1953年初，中国人民志愿军与联合国军在朝鲜战场形成僵持，双方发起了低强度的密集狙击战，史称“冷枪冷炮运动”。','2022-08-02 19:54:32',9.5,'https://p0.pipi.cn/mmdb/d2dad5927a302fd23651ba357a97181552c5d.jpg?imageView2/1/w/464/h/644','',44,'剧情,战争,历史','国语2D',58.5,96,'min','https://p0.pipi.cn/friday/2b307852b0adcbef3260cbc55969f4e7.jpg?imageView2/1/w/106/h/106,https://p1.meituan.net/movie/6edce4446f337be98df2ac6ba097ade22988933.jpg@106w_106h_1e_1c,https://p0.pipi.cn/friday/16c2706844c3deb05b4b7ac18c309a9c.jpg?imageView2/1/w/106/h/106,	https://p0.pipi.cn/friday/ee45bf09f3dd488b0e7045f4e92ccd40.jpg?imageView2/1/w/106/h/106'),('ALGOMOVIE2','神探大战','第二组全体人员','连环命案、私刑执法、预告杀人、以暴制暴...一群号称“神探”的团伙掀起了一场香港有史以来最邪恶的犯罪！','2022-08-22 08:04:30',0,'https://p0.pipi.cn/mmdb/25bfd6d771f0fa57e267cb131f671a5889b2d.jpg?imageView2/1/w/160/h/220','',0,'犯罪,动作,悬疑','国语2D',0,120,'min',NULL),('ALGOMOVIE20','断桥','马思纯,王俊凯','黄雀市大桥突然垮塌，桥墩中一副被活埋多年的人骨赫然惊现。死者女儿闻晓雨（马思纯 饰）为追查父亲死因，得到一个自称孟超（王俊凯 饰）的男孩协助，并携手走上探寻真相与复仇之路。渐渐地，他们发现，闻晓雨的养父朱方正（范伟 饰）很可能就是杀人凶手，而他背后似乎隐藏着惊天的秘密…','2022-08-13 19:57:06',0,'https://p0.pipi.cn/mmdb/25bfd63351bdddf0eeaf33736324b208ccd73.jpg?imageView2/1/w/464/h/644','',0,'剧情,犯罪','国语2D',0,113,'min',NULL),('ALGOMOVIE3','明日战记','古天乐,刘青云','机甲大战外星生物，硬核守护家园！','2022-08-18 08:04:30',0,'https://p0.pipi.cn/mmdb/25bfd63302f0fa395b07accde068bfd3c361f.jpg?imageView2/1/w/218/h/300','',0,'动作,科幻,冒险','国语2D',0,120,'min',NULL),('ALGOMOVIE4','猎屠','郭晓峰,王千源','府河市公安局接收到多起涉及全国以“恋爱”为名的“杀猪盘”电信诈骗案件，其中几起案件的受害者甚至因此自杀。','2022-08-20 08:04:30',0,'https://p0.pipi.cn/mmdb/25bfd633ddd2ffddd250c89d929469891238a.jpg?imageView2/1/w/218/h/300','',0,'剧情,动作,犯罪','国语2D',0,120,'min',NULL),('ALGOMOVIE5','迷你世界之觉醒','何春,花信','脱胎于人气沙盒游戏《迷你世界》，为首部沙盒类游戏改编大电影。','2022-08-25 08:04:30',0,'https://p0.pipi.cn/mmdb/25bfd6d7338ddd300bd2366ad18f464363723.jpg?imageView2/1/w/464/h/644','',0,'喜剧,科幻','国语2D',0,120,'min',NULL),('ALGOMOVIE6','流浪地球2','吴京,刘德华','太阳即将毁灭，人类在地球表面建造出巨大的推进器，寻找新的家园，然而宇宙之路危机四伏，为了拯救地球，流浪地球时代的年轻人再次挺身而出，展开争分夺秒的生死之战...','2022-08-25 08:04:30',0,'https://p0.pipi.cn/mmdb/d2dad5927a302f11e5e7aa3693d8e32412fb5.jpg?imageView2/1/w/218/h/300','',0,'科幻,冒险,灾难','国语2D',0,120,'min',NULL),('ALGOMOVIE7','刺猬索尼克2','杰夫·福勒,本·施瓦茨','蓝色的音速刺猬“索尼克”回归，搭档新朋友黄色狐狸，大战新对手红色针鼹。','2022-08-18 08:04:30',0,'https://p0.pipi.cn/mmdb/25bfd6025bf51bddd2e7aae175db712038100.jpg?imageView2/1/w/218/h/300','',0,'喜剧,动作,冒险','国语2D',0,120,'min',NULL),('ALGOMOVIE8','我是哪吒2之大闹东海','文帝,四喜','东海龙王在得知三太子被哪吒打败后羞恼成怒，发誓要替儿子报仇。','2022-07-31 08:04:30',7.9,'https://p0.pipi.cn/mmdb/25bfd6d7923f2a67cbb535ffbc4115a91ba03.jpg?imageView2/1/w/218/h/300','',9,'动画,喜剧,奇幻','国语2D',22.22,120,'min',NULL),('ALGOMOVIE9','暗杀风暴','张智霖,古天乐','轰动全城的连环杀人案接连发生，凡是收到“死亡通知单”的人，都将按预告日期，被神秘杀手残忍杀害。','2022-08-20 08:04:30',0,'https://p0.pipi.cn/mmdb/25bfd68d11eddde7aabe2a448f95e847d36a3.jpg?imageView2/1/w/218/h/300','',0,'犯罪,悬疑','国语2D',0,120,'min',NULL);

