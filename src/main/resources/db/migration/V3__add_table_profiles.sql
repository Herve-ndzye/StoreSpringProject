create table profiles
(
    user_id            bigint not null
        primary key,
    bio           varchar(255) not null,
    phone_number  varchar(15) not null,
    loyalty_point int UNSIGNED default 0 not null,
    date_of_birth date         not null,
    constraint profiles_users_id_fk
        foreign key (user_id) references users (id)
);

