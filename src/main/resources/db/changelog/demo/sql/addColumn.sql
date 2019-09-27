ALTER TABLE user_info
    ADD COLUMN address text NOT NULL DEFAULT 'NA',
    ADD COLUMN mobile text NOT NULL DEFAULT 'NA';
