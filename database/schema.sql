CREATE TABLE tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    task_title VARCHAR(255) NOT NULL,
    task_description TEXT,
    task_due_date DATE,
    task_status VARCHAR(50),
    task_remarks VARCHAR(255),
    created_on DATETIME,
    last_updated_on DATETIME,
    created_by VARCHAR(100),
    last_updated_by VARCHAR(100)
);