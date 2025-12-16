CREATE TABLE wishlist
(
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL
);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_user FOREIGN KEY (user_id) REFERENCES users(id),
    ADD CONSTRAINT fk_wishlist_on_product FOREIGN KEY (prod_id) REFERENCES products(id) ON DELETE CASCADE;
