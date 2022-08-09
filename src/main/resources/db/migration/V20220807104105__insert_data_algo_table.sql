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
) VALUES
('ALGOSESSION1','ALGOROOM1','ALGOMOVIE1','1121111121111111121111121211211211111111111121111','2022-08-07 10:04:30','2022-08-07 22:04:30','2022-08-07',39.99),
('ALGOSESSION2','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-08 12:44:33','2022-08-08 14:44:44','2022-08-08',39.99),
('ALGOSESSION3','ALGOROOM2','ALGOMOVIE1','1121111121111111121111121211211211111111111111111','2022-08-09 12:45:51','2022-08-09 14:45:57','2022-08-09',39.99),
('ALGOSESSION4','ALGOROOM3','ALGOMOVIE1','1121111121111111121111121211211211111111121111111','2022-08-10 12:46:37','2022-08-10 14:46:41','2022-08-10',39.99);

INSERT INTO t_room(
id,
room_name,
seats_layout,
cinema_id
) VALUES
('ALGOROOM1','巨幕厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA1'),
('ALGOROOM2','2号厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA1'),
('ALGOROOM3','3号厅','1111111111111111111111111111111111111111111111111','ALGOCINEMA1');

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
language_version,
movie_desc,
release_date,
score,
cover,
video,
hot_spot,
movie_type,
box_office,
duration,
duration_unit
) VALUES
('ALGOMOVIE1','ALGO','第二组全部成员','国语2D','梦想始于剧本，而终结于电影。','2022-08-12 08:04:30',9.9,'https://p0.pipi.cn/mmdb/25bfd671339c7e8ea33139d0476cb0d92908d.jpg?imageView2/1/w/218/h/300','',100,'喜剧,科幻',100.00,250,'min'),
('ALGOMOVIE10','独行月球','沈腾,玛丽','国语2D','人类为抵御小行星的撞击，拯救地球，在月球部署了月盾计划。','2022-08-11 08:04:30',5,'https://p0.pipi.cn/mmdb/25bfd6d72c992367cb537c020675f703a7045.jpg?imageView2/1/w/160/h/220','',20,'喜剧,科幻',99.99,120,'min'),
('ALGOMOVIE2','神探大战','第二组全部成员','国语2D','连环命案、私刑执法、预告杀人、以暴制暴...一群号称“神探”的团伙掀起了一场香港有史以来最邪恶的犯罪！','2022-08-22 08:04:30',4.5,'https://p0.pipi.cn/mmdb/25bfd6d771f0fa57e267cb131f671a5889b2d.jpg?imageView2/1/w/160/h/220','',32,'犯罪,动作,悬疑',88.88,180,'min'),
('ALGOMOVIE3','明日战记','古天乐,刘青云','国语2D','机甲大战外星生物，硬核守护家园！','2022-07-29 08:04:30',4.6,'https://p0.pipi.cn/mmdb/25bfd63302f0fa395b07accde068bfd3c361f.jpg?imageView2/1/w/218/h/300','',40,'动作,科幻,冒险',77.77,180,'min'),
('ALGOMOVIE4','猎屠','郭晓峰,王千源','国语2D','府河市公安局接收到多起涉及全国以“恋爱”为名的“杀猪盘”电信诈骗案件，其中几起案件的受害者甚至因此自杀。','2022-07-29 08:04:30',4.8,'https://p0.pipi.cn/mmdb/25bfd633ddd2ffddd250c89d929469891238a.jpg?imageView2/1/w/218/h/300','',5,'剧情,动作,犯罪',66.66,180,'min'),
('ALGOMOVIE5','迷你世界之觉醒','何春,花信','国语2D','脱胎于人气沙盒游戏《迷你世界》，为首部沙盒类游戏改编大电影。','2022-07-29 08:04:30',4.5,'https://p0.pipi.cn/mmdb/25bfd6d7338ddd300bd2366ad18f464363723.jpg?imageView2/1/w/464/h/644','',60,'喜剧,科幻',55.55,180,'min'),
('ALGOMOVIE6','流浪地球2','吴京,刘德华','国语2D','太阳即将毁灭，人类在地球表面建造出巨大的推进器，寻找新的家园，然而宇宙之路危机四伏，为了拯救地球，流浪地球时代的年轻人再次挺身而出，展开争分夺秒的生死之战...','2022-07-29 08:04:30',4.2,'https://p0.pipi.cn/mmdb/d2dad5927a302f11e5e7aa3693d8e32412fb5.jpg?imageView2/1/w/218/h/300','',71,'科幻,冒险,灾难',44.44,180,'min'),
('ALGOMOVIE7','刺猬索尼克2','杰夫·福勒,本·施瓦茨','国语2D','蓝色的音速刺猬“索尼克”回归，搭档新朋友黄色狐狸，大战新对手红色针鼹。','2022-07-30 08:04:30',7.5,'https://p0.pipi.cn/mmdb/25bfd6025bf51bddd2e7aae175db712038100.jpg?imageView2/1/w/218/h/300','',8,'喜剧,动作,冒险',33.33,180,'min'),
('ALGOMOVIE8','我是哪吒2之大闹东海','文帝,四喜','国语2D','东海龙王在得知三太子被哪吒打败后羞恼成怒，发誓要替儿子报仇。','2022-07-31 08:04:30',7.9,'https://p0.pipi.cn/mmdb/25bfd6d7923f2a67cbb535ffbc4115a91ba03.jpg?imageView2/1/w/218/h/300','',9,'动画,喜剧,奇幻',22.22,180,'min'),
('ALGOMOVIE9','暗杀风暴','张智霖,古天乐','国语2D','轰动全城的连环杀人案接连发生，凡是收到“死亡通知单”的人，都将按预告日期，被神秘杀手残忍杀害。','2022-07-30 08:04:30',7.8,'https://p0.pipi.cn/mmdb/25bfd68d11eddde7aabe2a448f95e847d36a3.jpg?imageView2/1/w/218/h/300','',8.0,'犯罪,悬疑',11.11,180,'min');


