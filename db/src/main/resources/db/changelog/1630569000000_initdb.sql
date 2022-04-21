--changeset mathter:c_messages
create table c_messages
(
    id        uuid primary key,
    user_name varchar(20)   not null,
    text      varchar(4000) not null,
    date      datetime      not null
);
--rollback drop table c_messages