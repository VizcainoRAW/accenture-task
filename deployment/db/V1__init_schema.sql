CREATE TABLE IF NOT EXISTS franchises (
                                          id   VARCHAR(36)  PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS branches (
                                        id           VARCHAR(36)  PRIMARY KEY,
    name         VARCHAR(255) NOT NULL,
    franchise_id VARCHAR(36)  NOT NULL REFERENCES franchises(id)
    );

CREATE TABLE IF NOT EXISTS products (
                                        id        VARCHAR(36)  PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    stock     INTEGER      NOT NULL DEFAULT 0,
    branch_id VARCHAR(36)  NOT NULL REFERENCES branches(id)
    );