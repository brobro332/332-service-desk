CREATE TABLE tbl_reply (
    id SERIAL,
    inquiry_id INT,
    inquiry_writer_email VARCHAR(100),
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    writer_email VARCHAR(100),
    delete_flag BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (inquiry_id, writer_email) REFERENCES tbl_inquiry(id, writer_email)
);