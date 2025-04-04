CREATE TABLE tbl_notice (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    writer_email VARCHAR(100),
    CONSTRAINT tbl_notice_fkey FOREIGN KEY (writer_email) REFERENCES "tbl_agent" (email)
);