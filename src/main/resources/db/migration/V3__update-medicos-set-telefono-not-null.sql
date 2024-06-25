-- V3__update-medicos-set-telefono-not-null.sql
UPDATE medicos SET telefono = 'default_value' WHERE telefono IS NULL;

ALTER TABLE medicos ALTER COLUMN telefono SET NOT NULL;
