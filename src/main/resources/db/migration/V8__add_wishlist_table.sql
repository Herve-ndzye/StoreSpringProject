CREATE TABLE wishlist
(
    prod_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL
);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_product FOREIGN KEY (user_id) REFERENCES products (id);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_user FOREIGN KEY (prod_id) REFERENCES users (id);