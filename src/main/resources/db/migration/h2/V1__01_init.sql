create table promotions
(
    id           bigserial not null,
    product_code varchar,
    discount     numeric   not null,
    created_at   timestamp,
    updated_at   timestamp,
    primary key (id),
    CONSTRAINT promotions_product_code_unique UNIQUE (product_code)
);
