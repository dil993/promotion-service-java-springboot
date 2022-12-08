create sequence promotion_id_seq start with 1 increment by 1;

create table promotions
(
    id         bigint DEFAULT nextval('promotion_id_seq') not null,
    isbn       varchar,
    discount   numeric                                    not null,
    created_at timestamp,
    updated_at timestamp,
    primary key (id),
    CONSTRAINT promotion_isbn_unique UNIQUE (isbn)
);
