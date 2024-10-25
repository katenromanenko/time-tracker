ALTER TABLE records
    ADD CONSTRAINT fk_records_users
        FOREIGN KEY (user_id) REFERENCES users(id)
            ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE records
    ADD CONSTRAINT fk_records_projects
        FOREIGN KEY (project_id) REFERENCES projects(id)
            ON DELETE CASCADE ON UPDATE CASCADE;
