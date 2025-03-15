CREATE TABLE tbl_notice (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_email VARCHAR(100),
    CONSTRAINT fk01_user_email FOREIGN KEY (user_email) REFERENCES "tbl_user" (email)
);