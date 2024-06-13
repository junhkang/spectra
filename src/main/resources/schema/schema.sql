CREATE TABLE IF NOT EXISTS monitoring_result (
                                                 id BIGINT PRIMARY KEY,
                                                 result_data VARCHAR(255),
                                                 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
