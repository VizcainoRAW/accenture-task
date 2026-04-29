CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE IF NOT EXISTS franchises (
                                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL
    );

CREATE TABLE IF NOT EXISTS branches (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    franchise_id UUID NOT NULL REFERENCES franchises(id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS products (
                                        id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(255) NOT NULL,
    stock INTEGER NOT NULL DEFAULT 0,
    branch_id UUID NOT NULL REFERENCES branches(id) ON DELETE CASCADE
    );