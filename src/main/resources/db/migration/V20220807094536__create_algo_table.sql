
create table if not exists t_session(
    id              varchar(255) primary key,
    room_id         varchar(255) not null ,
    movie_id        varchar(255) not null,
    seats_info      varchar(1000) not null,
    start_time      timestamp not null ,
    end_time        timestamp not null ,
    screening_date  timestamp not null  ,
    price           DECIMAL(10,3) not null
);

create table if not exists t_room(
   id               varchar(255) primary key ,
   room_name        varchar(255) not null,
   seats_layout     varchar(255) not null ,
   cinema_id        varchar(255) not null
);

create table if not exists t_cinema(
    id              varchar(255) primary key,
    cinema_name     varchar(255) not null ,
    address         varchar(255) default ''
);

create table if not exists t_movie(
    id             varchar(255) primary key,
    movie_name     varchar(60) not null,
    actors         varchar(255) default '',
    movie_desc     varchar(500) default '',
    release_date   timestamp null,
    score          float  default 0.0,
    cover          varchar(255) default '' ,
    video          varchar(255) default '',
    hot_spot       int default 0,
    movie_type     varchar(255) null,
    box_office      varchar(255) null,
    duration       float null ,
    duration_unit  varchar(255) null
);

CREATE TABLE IF not EXISTS t_user (
                      id varchar(30) primary key,
                      username varchar(32) not null,
                      nickname varchar(32) not null,
                      password varchar(60) not null,
                      role_id varchar(100) DEFAULT '3',
                      avatar varchar(255) NOT NULL,
                      phone varchar(100) DEFAULT '',
                      sign varchar(100) DEFAULT '',
                      status varchar(10) DEFAULT '1',
                      create_time timestamp NULL,
                      update_time timestamp NULL
);

CREATE TABLE IF not EXISTS t_role (
                      id varchar(30) primary key,
                      role_name varchar(32) NOT NULL
);


CREATE TABLE IF not EXISTS t_order (
                         id varchar(30) primary key,
                         price DECIMAL(10,3) NOT NULL,
                         status varchar(10) DEFAULT '0',
                         session_id varchar(100) DEFAULT '-1',
                         movie_id varchar(100) DEFAULT '-1',
                         cinema_id varchar(100) DEFAULT '-1',
                         room_id varchar(100) DEFAULT '-1',
                         user_id varchar(100) DEFAULT '-1',
                         seat_info varchar(100) DEFAULT '-1'
);