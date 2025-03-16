CREATE TABLE tbl_inquiry (
    id SERIAL,
    writer_email VARCHAR(100),
    title VARCHAR(100) NOT NULL,
    content TEXT NOT NULL,
    writer_phone_number VARCHAR(15) NOT NULL,
    delete_flag BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id, writer_email)
);
