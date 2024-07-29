INSERT INTO products (name, country, manufacturer, online_order, installment) VALUES
('Телевизор', 'Корея', 'Samsung', true, true),
('Пылесос', 'Германия', 'Bosch', true, false),
('ПК', 'США', 'Apple', true, true),
('Смартфон', 'Китай', 'Xiaomi', true, true),
('Холодильник', 'Япония', 'Panasonic', false, true);

INSERT INTO model (name, serial_number, color, size, price, in_stock, product_id) VALUES
('Samsung QLED', 'SN12345', 'Черный', '55', 1000.0, true, 1),
('Samsung LED', 'SN12346', 'Белый', '50', 800.0, true, 1),
('Bosch Pro', 'VC12345', 'Красный', 'Compact', 200.0, true, 2),
('Bosch Home', 'VC12346', 'Синий', 'Medium', 150.0, true, 2),
('MacBook Pro', 'CP12345', 'Серый', '13', 2000.0, true, 3),
('iMac', 'CP12346', 'Белый', '27', 2500.0, true, 3),
('Xiaomi Mi 11', 'SM12345', 'Черный', '6.5', 600.0, true, 4),
('Xiaomi Redmi Note 10', 'SM12346', 'Синий', '6.3', 400.0, true, 4),
('Panasonic NR', 'RF12345', 'Серебристый', 'Large', 1200.0, true, 5),
('Panasonic NR-B', 'RF12346', 'Белый', 'Medium', 1000.0, true, 5);

INSERT INTO tvs (id, category, technology) VALUES
((SELECT id FROM model WHERE serial_number = 'SN12345'), 'Premium', 'QLED'),
((SELECT id FROM model WHERE serial_number = 'SN12346'), 'Standard', 'LED');

INSERT INTO vacuum_cleaners (id, dust_collector_volume, modes) VALUES
((SELECT id FROM model WHERE serial_number = 'VC12345'), 2.5, 5),
((SELECT id FROM model WHERE serial_number = 'VC12346'), 3.0, 3);

INSERT INTO computers (id, category, processor_type) VALUES
((SELECT id FROM model WHERE serial_number = 'CP12345'), 'Laptop', 'M1'),
((SELECT id FROM model WHERE serial_number = 'CP12346'), 'Desktop', 'Intel i9');

INSERT INTO smartphones (id, memory, cameras) VALUES
((SELECT id FROM model WHERE serial_number = 'SM12345'), 128, 4),
((SELECT id FROM model WHERE serial_number = 'SM12346'), 64, 3);

INSERT INTO refrigerators (id, door_count, compressor_type) VALUES
((SELECT id FROM model WHERE serial_number = 'RF12345'), 3, 'Inverter'),
((SELECT id FROM model WHERE serial_number = 'RF12346'), 2, 'Standard');