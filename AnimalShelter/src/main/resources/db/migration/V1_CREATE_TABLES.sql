create table hibernate_sequence (
    next_val bigint
) engine=MyISAM;

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password varchar(64) not null,
    phone varchar(64) not null unique,
    first_name varchar(64) not null,
    last_name varchar(64) not null,
    credit_card BIGINT not null,
    PRIMARY KEY (id)
) engine=MyISAM;

CREATE TABLE animal (
    id BIGINT NOT NULL AUTO_INCREMENT,
    animal_name varchar(64) not null,
    breed varchar(64) not null,
    age varchar(64) not null,
    gender varchar(64) not null,
    color varchar(64) not null,
    size varchar(64) not null,
    vaccinations varchar(64) not null,
    diseases varchar(64) not null,
    has_home BOOLEAN NOT NULL,
    PRIMARY KEY (id)
) engine=MyISAM;

