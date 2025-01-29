CREATE TABLE nave_espacial (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    series VARCHAR(255) NOT NULL
);

INSERT INTO nave_espacial (name, series) VALUES ('Enterprise', 'Star Trek');
COMMIT;