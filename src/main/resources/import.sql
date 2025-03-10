CREATE TABLE IF NOT EXISTS profession (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    code VARCHAR(50) UNIQUE NOT NULL
);


-- Insertar datos de ejemplo en la tabla PROFESSION
INSERT INTO PROFESSION (ID, NAME, DESCRIPTION, CODE) VALUES (1, 'Software Developer', 'Develops software applications', 'SD001');
INSERT INTO PROFESSION (ID, NAME, DESCRIPTION, CODE) VALUES (2, 'Data Scientist', 'Analyzes and interprets complex data', 'DS001');
INSERT INTO PROFESSION (ID, NAME, DESCRIPTION, CODE) VALUES (3, 'Network Engineer', 'Designs and implements computer networks', 'NE001');
INSERT INTO PROFESSION (ID, NAME, DESCRIPTION, CODE) VALUES (4, 'Cybersecurity Specialist', 'Protects systems from cyber threats', 'CS001');
INSERT INTO PROFESSION (ID, NAME, DESCRIPTION, CODE) VALUES (5, 'Cloud Architect', 'Designs cloud computing strategies', 'CA001');