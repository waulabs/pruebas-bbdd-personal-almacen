INSERT INTO Customer (firstName, lastName, numberPhone, email, address, birthDate, gender, personalId, nationality, userName, password, accountStatus, lastLoginDate, preferredPaymentMethod, subscriptionType, shippingAddress, billingAddress)
VALUES
('Juan', 'Pérez', '555-1234', 'juan.perez@example.com', 'Calle Falsa 123, Ciudad', '1985-06-15', 'M', '12345678A', 'Española', 'juanperez', 'hashedpassword1', 'ACTIVE', NOW(), 'Tarjeta de Crédito', 'PREMIUM', 'Calle Falsa 123, Ciudad', 'Calle Falsa 123, Ciudad'),
('María', 'Gómez', '555-5678', 'maria.gomez@example.com', 'Avenida Siempreviva 456, Ciudad', '1990-09-22', 'F', '87654321B', 'Española', 'mariagomez', 'hashedpassword2', 'ACTIVE', NOW(), 'PayPal', 'BASIC', 'Avenida Siempreviva 456, Ciudad', 'Avenida Siempreviva 456, Ciudad'),
('Pedro', 'Martínez', '555-2345', 'pedro.martinez@example.com', 'Plaza Mayor 789, Ciudad', '1982-03-11', 'M', '23456789C', 'Española', 'pedromartinez', 'hashedpassword3', 'SUSPENDED', NOW(), 'Tarjeta de Débito', 'VIP', 'Plaza Mayor 789, Ciudad', 'Plaza Mayor 789, Ciudad'),
('Laura', 'Sánchez', '555-6789', 'laura.sanchez@example.com', 'Calle del Sol 321, Ciudad', '1995-12-01', 'F', '34567890D', 'Española', 'laurasanchez', 'hashedpassword4', 'ACTIVE', NOW(), 'Tarjeta de Crédito', 'PREMIUM', 'Calle del Sol 321, Ciudad', 'Calle del Sol 321, Ciudad'),
('Luis', 'Fernández', '555-3456', 'luis.fernandez@example.com', 'Avenida Libertad 654, Ciudad', '1988-07-20', 'M', '45678901E', 'Española', 'luisfernandez', 'hashedpassword5', 'CLOSED', NOW(), 'PayPal', 'BASIC', 'Avenida Libertad 654, Ciudad', 'Avenida Libertad 654, Ciudad'),
('Ana', 'Moreno', '555-7890', 'ana.moreno@example.com', 'Calle de la Luna 987, Ciudad', '1992-04-18', 'F', '56789012F', 'Española', 'anamorenos', 'hashedpassword6', 'ACTIVE', NOW(), 'Tarjeta de Débito', 'PREMIUM', 'Calle de la Luna 987, Ciudad', 'Calle de la Luna 987, Ciudad'),
('Carlos', 'Ruiz', '555-4567', 'carlos.ruiz@example.com', 'Calle de los Olivos 654, Ciudad', '1981-11-09', 'M', '67890123G', 'Española', 'carlosruiz', 'hashedpassword7', 'ACTIVE', NOW(), 'Tarjeta de Crédito', 'VIP', 'Calle de los Olivos 654, Ciudad', 'Calle de los Olivos 654, Ciudad'),
('Marta', 'Jiménez', '555-0123', 'marta.jimenez@example.com', 'Calle del Viento 432, Ciudad', '1996-10-30', 'F', '78901234H', 'Española', 'martajimenez', 'hashedpassword8', 'SUSPENDED', NOW(), 'PayPal', 'BASIC', 'Calle del Viento 432, Ciudad', 'Calle del Viento 432, Ciudad'),
('David', 'Hernández', '555-8901', 'david.hernandez@example.com', 'Plaza del Comercio 543, Ciudad', '1989-05-12', 'M', '89012345I', 'Española', 'davidhdez', 'hashedpassword9', 'ACTIVE', NOW(), 'Tarjeta de Crédito', 'PREMIUM', 'Plaza del Comercio 543, Ciudad', 'Plaza del Comercio 543, Ciudad'),
('Paula', 'Vázquez', '555-6780', 'paula.vazquez@example.com', 'Calle de las Flores 321, Ciudad', '1993-08-25', 'F', '90123456J', 'Española', 'paulavazquez', 'hashedpassword10', 'ACTIVE', NOW(), 'Tarjeta de Débito', 'VIP', 'Calle de las Flores 321, Ciudad', 'Calle de las Flores 321, Ciudad');

INSERT INTO Product (code, name, description, stock, status, price)
VALUES
('P001', 'Laptop HP', 'Laptop con procesador i7, 16GB RAM', 10, TRUE, 1200.00),
('P002', 'Smartphone Samsung', 'Smartphone con pantalla AMOLED y 128GB de almacenamiento', 25, TRUE, 800.00),
('P003', 'Auriculares Sony', 'Auriculares inalámbricos con cancelación de ruido', 30, TRUE, 150.00),
('P004', 'Monitor Dell', 'Monitor de 27 pulgadas, resolución 4K', 15, TRUE, 300.00),
('P005', 'Teclado Mecánico', 'Teclado mecánico con retroiluminación RGB', 20, TRUE, 100.00),
('P006', 'Ratón Logitech', 'Ratón ergonómico con precisión alta', 50, TRUE, 60.00),
('P007', 'Cámara Canon', 'Cámara DSLR con lente de 18-55mm', 8, TRUE, 700.00),
('P008', 'Altavoces Bose', 'Altavoces Bluetooth con sonido envolvente', 12, TRUE, 250.00),
('P009', 'Disco Duro Externo', 'Disco duro externo de 1TB', 18, TRUE, 120.00),
('P010', 'Impresora HP', 'Impresora multifuncional con función de escaneo', 7, TRUE, 180.00);


INSERT INTO Sale (saleDate, totalAmount, customerId)
VALUES
('2024-08-01', 1500.00, 1), -- Venta para Juan Pérez
('2024-08-02', 800.00, 2),  -- Venta para María Gómez
('2024-08-03', 300.00, 3),  -- Venta para Pedro Martínez
('2024-08-04', 1000.00, 4), -- Venta para Laura Sánchez
('2024-08-05', 120.00, 5),  -- Venta para Luis Fernández
('2024-08-06', 150.00, 6),  -- Venta para Ana Moreno
('2024-08-07', 400.00, 7),  -- Venta para Carlos Ruiz
('2024-08-08', 200.00, 8),  -- Venta para Marta Jiménez
('2024-08-09', 700.00, 9),  -- Venta para David Hernández
('2024-08-10', 250.00, 10); -- Venta para Paula Vázquez


-- Compras asociadas a la venta 1 (Juan Pérez)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(1, 1, 1, 1200.00, 'Laptop HP', 'Laptop con procesador i7, 16GB RAM', 1200.00),
(1, 3, 2, 150.00, 'Auriculares Sony', 'Auriculares inalámbricos con cancelación de ruido', 300.00);

-- Compras asociadas a la venta 2 (María Gómez)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(2, 2, 1, 800.00, 'Smartphone Samsung', 'Smartphone con pantalla AMOLED y 128GB de almacenamiento', 800.00);

-- Compras asociadas a la venta 3 (Pedro Martínez)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(3, 4, 1, 300.00, 'Monitor Dell', 'Monitor de 27 pulgadas, resolución 4K', 300.00);

-- Compras asociadas a la venta 4 (Laura Sánchez)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(4, 5, 1, 100.00, 'Teclado Mecánico', 'Teclado mecánico con retroiluminación RGB', 100.00),
(4, 6, 1, 60.00, 'Ratón Logitech', 'Ratón ergonómico con precisión alta', 60.00),
(4, 7, 1, 700.00, 'Cámara Canon', 'Cámara DSLR con lente de 18-55mm', 700.00),
(4, 8, 1, 250.00, 'Altavoces Bose', 'Altavoces Bluetooth con sonido envolvente', 250.00),
(4, 9, 1, 120.00, 'Disco Duro Externo', 'Disco duro externo de 1TB', 120.00);

-- Compras asociadas a la venta 5 (Luis Fernández)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(5, 10, 1, 180.00, 'Impresora HP', 'Impresora multifuncional con función de escaneo', 180.00);

-- Compras asociadas a la venta 6 (Ana Moreno)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(6, 3, 1, 150.00, 'Auriculares Sony', 'Auriculares inalámbricos con cancelación de ruido', 150.00);

-- Compras asociadas a la venta 7 (Carlos Ruiz)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(7, 1, 1, 1200.00, 'Laptop HP', 'Laptop con procesador i7, 16GB RAM', 1200.00);

-- Compras asociadas a la venta 8 (Marta Jiménez)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(8, 2, 1, 800.00, 'Smartphone Samsung', 'Smartphone con pantalla AMOLED y 128GB de almacenamiento', 800.00);

-- Compras asociadas a la venta 9 (David Hernández)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(9, 7, 1, 700.00, 'Cámara Canon', 'Cámara DSLR con lente de 18-55mm', 700.00);

-- Compras asociadas a la venta 10 (Paula Vázquez)
INSERT INTO Purchase (saleId, productId, quantity, unitPrice, productName, productDescription, totalPrice)
VALUES
(10, 9, 1, 120.00, 'Disco Duro Externo', 'Disco duro externo de 1TB', 120.00),
(10, 6, 1, 60.00, 'Ratón Logitech', 'Ratón ergonómico con precisión alta', 60.00);
