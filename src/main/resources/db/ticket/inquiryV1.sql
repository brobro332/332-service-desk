CREATE TABLE tbl_inquiry (
    id SERIAL,
    parent_id INT,
    writer_email VARCHAR(100),
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    writer_phone_number VARCHAR(15) NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, writer_email),
    FOREIGN KEY (parent_id, writer_email) REFERENCES tbl_inquiry(id, writer_email)
);