CREATE TABLE IF not EXISTS t_user (
    id varchar(30) NOT NULL COMMENT 'ID',
    username varchar(32) NOT NULL COMMENT '用户名',
    nickname varchar(32) NOT NULL COMMENT '用户昵称',
    password varchar(60) NOT NULL COMMENT '密码',
    role_id varchar(100) DEFAULT '3' COMMENT '角色',
    avatar varchar(255) NOT NULL COMMENT '头像地址',
    phone varchar(100) DEFAULT '' COMMENT '邮箱地址',
    sign varchar(100) DEFAULT '' COMMENT '签名',
    status varchar(10) DEFAULT '1' COMMENT '状态：0表示删除，1表示正常',
    create_time datetime NULL COMMENT '创建时间',
    update_time datetime NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF not EXISTS t_role (
    id varchar(30) NOT NULL COMMENT 'ID',
    role_name varchar(32) NOT NULL COMMENT '角色名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE IF not EXISTS t_order (
    id varchar(30) NOT NULL COMMENT 'ID',
    price double NOT NULL COMMENT '价钱',
    status varchar(10) DEFAULT '0' COMMENT '支付状态：0表示未支付，1表示已支付',
    session_id varchar(100) DEFAULT '-1' COMMENT '场次ID',
    movie_id varchar(100) DEFAULT '-1' COMMENT '电影ID',
    cinema_id varchar(100) DEFAULT '-1' COMMENT '电影院ID',
    room_id varchar(100) DEFAULT '-1' COMMENT '电影院ID',
    user_id varchar(100) DEFAULT '-1' COMMENT '角色ID',
    seat_info varchar(100) DEFAULT '-1' COMMENT '座位信息',
    create_time datetime NULL COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



create table if not exists t_session(
    id              varchar(255) primary key comment '场次ID',
    room_id         varchar(255) not null comment '电影房间ID',
    movie_id        varchar(255) not null comment '电影ID',
    seats_info      varchar(1000) not null comment '场次座位分布',
    start_time      datetime not null  comment '场次开始时间',
    end_time        datetime not null  comment '场次结束时间',
    screening_date  date not null  comment '场次日期',
    price           double not null  comment '场次价格'
);

create table if not exists t_room(
   id               varchar(255) primary key comment '观影厅ID',
   room_name        varchar(255) not null comment '观影厅名',
   seats_layout     varchar(255) not null comment '观影厅座位',
   cinema_id        varchar(255) not null comment '电影院ID'
);

create table if not exists t_cinema(
    id              varchar(255) primary key comment '电影院ID',
    cinema_name     varchar(255) not null comment '电影院名字',
    address         varchar(255) default '' comment '电影院地址'
);

create table if not exists t_movie(
    id             varchar(255) primary key comment '电影ID',
    movie_name     varchar(60) not null comment '电影名',
    actors         varchar(255) default '' comment '演员介绍',
    movie_desc     varchar(500) default '' comment '电影介绍',
    release_date   datetime null comment '持续时间',
    score          float  default 0.0 comment '电影评分',
    cover          varchar(255) default '' comment '电影封面',
    video          varchar(255) default '' comment '电影视频',
    hot_spot       int default 0 comment '热点',
    movie_type     varchar(255) null comment '电影类型',
    language_version     varchar(255) null comment '电影语言',
    box_office     double default 0.0 comment '票房',
    duration       double null comment '持续时间',
    duration_unit  varchar(255) default 'minute' comment '持续时间单位'
);