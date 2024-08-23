CREATE TABLE Customer (
    idCustomer INT AUTO_INCREMENT PRIMARY KEY,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    numberPhone VARCHAR(15),
    email VARCHAR(100) UNIQUE NOT NULL,
    address TEXT,
    birthDate DATE NOT NULL,
    gender VARCHAR(10),
    personalId VARCHAR(20) UNIQUE,
    nationality VARCHAR(50),
    registrationDate DATE DEFAULT CURDATE(),
    userName VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL, -- Almacenar contraseñas hasheadas
    loyaltyPoints INT DEFAULT 0,
    accountStatus ENUM('ACTIVE', 'SUSPENDED', 'CLOSED') NOT NULL,
    lastLoginDate DATETIME,
    preferredPaymentMethod VARCHAR(50),
    subscriptionType ENUM('BASIC', 'PREMIUM', 'VIP'),
    shippingAddress TEXT,
    billingAddress TEXT
);


CREATE TABLE Product (
    idProduct INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único del producto
    code VARCHAR(50) UNIQUE NOT NULL,        -- Código único del producto
    name VARCHAR(100) NOT NULL,              -- Nombre del producto
    description TEXT,                        -- Descripción del producto
    stock INT DEFAULT 0,                     -- Cantidad en stock
    status BOOLEAN NOT NULL,                 -- Estado del producto (disponible o no disponible)
    price DECIMAL(10, 2) NOT NULL            -- Precio del producto, con dos decimales
);

CREATE TABLE Sale (
    idSale INT AUTO_INCREMENT PRIMARY KEY,   -- Identificador único de la venta
    saleDate DATE NOT NULL,                  -- Fecha de la venta
    totalAmount DECIMAL(10, 2) NOT NULL,     -- Monto total de la venta
    customerId INT,                          -- Clave foránea que referencia al cliente
    FOREIGN KEY (customerId) REFERENCES Customer(idCustomer)  -- Relación con la tabla Customer
);
CREATE TABLE Purchase (
    idPurchase INT AUTO_INCREMENT PRIMARY KEY,   -- Identificador único de la compra
    saleId INT,                                -- Clave foránea que referencia a la venta
    productId INT,                             -- Clave foránea que referencia al producto
    quantity INT NOT NULL,                     -- Cantidad de productos comprados
    unitPrice DECIMAL(10, 2) NOT NULL,         -- Precio por unidad del producto
    productName VARCHAR(100) NOT NULL,         -- Nombre del producto en el momento de la compra
    productDescription TEXT,                   -- Descripción del producto en el momento de la compra
    totalPrice DECIMAL(10, 2) NOT NULL,        -- Precio total (quantity * unitPrice)
    FOREIGN KEY (saleId) REFERENCES Sale(idSale),    -- Relación con la tabla Sale
    FOREIGN KEY (productId) REFERENCES Product(idProduct)  -- Relación con la tabla Product
);


