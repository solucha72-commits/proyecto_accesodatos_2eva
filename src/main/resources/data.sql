-- ====================================
-- PROVEEDORES (10)
-- ====================================

INSERT INTO proveedores (id, nombre_empresa, email_contacto, telefono_contacto) VALUES
                                                                                    (1, 'Tech Solutions', 'contacto@tech.com', '600000001'),
                                                                                    (2, 'Global Services', 'info@global.com', '600000002'),
                                                                                    (3, 'DataCorp', 'ventas@datacorp.com', '600000003'),
                                                                                    (4, 'NetSystems', 'support@netsystems.com', '600000004'),
                                                                                    (5, 'CloudBase', 'hello@cloudbase.com', '600000005'),
                                                                                    (6, 'SecureIT', 'admin@secureit.com', '600000006'),
                                                                                    (7, 'DevFactory', 'contact@devfactory.com', '600000007'),
                                                                                    (8, 'DigitalPro', 'info@digitalpro.com', '600000008'),
                                                                                    (9, 'SmartTech', 'ventas@smarttech.com', '600000009'),
                                                                                    (10, 'Innovatech', 'info@innovatech.com', '600000010');


-- ====================================
-- USUARIOS (10)
-- ====================================

INSERT INTO usuarios (id, nombre, email, password, fecha_creacion, proveedor_id) VALUES
                                                                                     (1, 'Juan Perez', 'juan1@test.com', '1234', CURRENT_TIMESTAMP, 1),
                                                                                     (2, 'Ana Lopez', 'ana2@test.com', '1234', CURRENT_TIMESTAMP, 1),
                                                                                     (3, 'Carlos Ruiz', 'carlos3@test.com', '1234', CURRENT_TIMESTAMP, 2),
                                                                                     (4, 'Marta Gomez', 'marta4@test.com', '1234', CURRENT_TIMESTAMP, 2),
                                                                                     (5, 'Luis Torres', 'luis5@test.com', '1234', CURRENT_TIMESTAMP, 3),
                                                                                     (6, 'Elena Diaz', 'elena6@test.com', '1234', CURRENT_TIMESTAMP, 4),
                                                                                     (7, 'Pedro Sanchez', 'pedro7@test.com', '1234', CURRENT_TIMESTAMP, 5),
                                                                                     (8, 'Laura Martin', 'laura8@test.com', '1234', CURRENT_TIMESTAMP, 6),
                                                                                     (9, 'Sergio Ramos', 'sergio9@test.com', '1234', CURRENT_TIMESTAMP, 7),
                                                                                     (10, 'Paula Ortega', 'paula10@test.com', '1234', CURRENT_TIMESTAMP, 8);


-- ====================================
-- PERFILES (10)
-- ====================================

INSERT INTO perfiles (id, apodo, usuario_id) VALUES
                                                 (1, 'Juani', 1),
                                                 (2, 'Anita', 2),
                                                 (3, 'Carlitos', 3),
                                                 (4, 'Marti', 4),
                                                 (5, 'Luismi', 5),
                                                 (6, 'Ele', 6),
                                                 (7, 'Pedri', 7),
                                                 (8, 'Laurita', 8),
                                                 (9, 'Ser', 9),
                                                 (10, 'Pau', 10);