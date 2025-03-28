-- Suppress NOTICE messages for cleaner output
SET client_min_messages TO WARNING;

-- Drop tables if they exist (for clean slate)
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS ticket_status;
DROP TABLE IF EXISTS ticket_priority;
DROP TABLE IF EXISTS users;

-- Create tables with proper data types and constraints
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    department VARCHAR(100),
    phone_number VARCHAR(10),
    password VARCHAR(6) NOT NULL
);

CREATE TABLE user_role (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role VARCHAR(50) NOT NULL,
    UNIQUE(user_id, role)
);

CREATE TABLE ticket_priority (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE ticket_status (
    id SERIAL PRIMARY KEY,
    description VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE ticket (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    priority_id INTEGER NOT NULL REFERENCES ticket_priority(id),
    status_id INTEGER NOT NULL REFERENCES ticket_status(id),
    created_by INTEGER NOT NULL REFERENCES users(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modified_date TIMESTAMP,
    assigned_to INTEGER REFERENCES users(id),
    ticket_comment TEXT,
    is_deleted BOOLEAN DEFAULT FALSE,
    delete_date TIMESTAMP
);

-- Insert initial data with conflict handling
-- First insert priorities (if they don't exist)
INSERT INTO ticket_priority (description) VALUES 
('Critical'), ('High'), ('Medium'), ('Low')
ON CONFLICT (description) DO NOTHING;

-- Then insert statuses (if they don't exist)
INSERT INTO ticket_status (description) VALUES 
('Open'), ('In Progress'), ('Closed'), ('Resolved')
ON CONFLICT (description) DO NOTHING;

-- Insert admin user (with properly hashed password)
-- Using bcrypt hash for "password" with cost factor 10
INSERT INTO users (name, email, department, phone_number, password) VALUES 
('Admin', 'admin@questk2.com', 'TT', '9988774455', 'Ad@12$')
ON CONFLICT (email) DO UPDATE SET
    name = EXCLUDED.name,
    department = EXCLUDED.department,
    phone_number = EXCLUDED.phone_number,
    password = EXCLUDED.password;

-- Assign admin role (only if not already assigned)
INSERT INTO user_role (user_id, role) VALUES 
((SELECT id FROM users WHERE email = 'admin@questk2.com'), 'ADMIN'),
((SELECT id FROM users WHERE email = 'admin@questk2.com'), 'USER')
ON CONFLICT (user_id, role) DO NOTHING;