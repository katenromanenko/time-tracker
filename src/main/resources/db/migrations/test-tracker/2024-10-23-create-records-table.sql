CREATE TABLE IF NOT EXISTS records
(
    id         BIGSERIAL PRIMARY KEY,
    time_spent DECIMAL(10, 2) NOT NULL,
    date       DATE NOT NULL,
    user_id    BIGINT NOT NULL,
    project_id BIGINT NOT NULL
);
