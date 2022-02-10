CREATE TABLE `fac_clientes` (
                                `cli_id` varchar(20) NOT NULL,
                                `cli_celular` varchar(20) DEFAULT NULL,
                                `cli_direccion` varchar(100) DEFAULT NULL,
                                `cli_email` varchar(50) DEFAULT NULL,
                                `cli_nombre` varchar(100) DEFAULT NULL,
                                `cli_nombre_empresa` varchar(50) DEFAULT NULL,
                                `cli_numero_documento` varchar(20) DEFAULT NULL,
                                `cli_tipo_documento` varchar(20) DEFAULT NULL,
                                PRIMARY KEY (`cli_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `fac_facturas` (
                                `fact_id` varchar(50) NOT NULL,
                                `fact_estado` char(1) DEFAULT NULL,
                                `fact_fecha_emision` date DEFAULT NULL,
                                `fact_fecha_pago` date DEFAULT NULL,
                                `fact_subtotal` decimal(7,2) DEFAULT NULL,
                                `fact_importe_total` decimal(7,2) DEFAULT NULL,
                                `fact_impuesto` decimal(7,2) DEFAULT NULL,
                                `fact_cli_id` varchar(20) NOT NULL,
                                PRIMARY KEY (`fact_id`),
                                KEY `FKqb4b0ydi1p882w7ft5tb4e7nq` (`fact_cli_id`),
                                CONSTRAINT `FKqb4b0ydi1p882w7ft5tb4e7nq` FOREIGN KEY (`fact_cli_id`) REFERENCES `fac_clientes` (`cli_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `fac_facturas_detalles` (
                                         `factura_fact_id` varchar(50) NOT NULL,
                                         `detalles_pfact_id` varchar(50) NOT NULL,
                                         UNIQUE KEY `UK_5fdymp79acygbn6f9me7bcvjd` (`detalles_pfact_id`),
                                         KEY `FK8w9l71c5s8ybajn81pioutp95` (`factura_fact_id`),
                                         CONSTRAINT `FK8w9l71c5s8ybajn81pioutp95` FOREIGN KEY (`factura_fact_id`) REFERENCES `fac_facturas` (`fact_id`),
                                         CONSTRAINT `FKa5cp6oyujkamoftngynk347yq` FOREIGN KEY (`detalles_pfact_id`) REFERENCES `fac_productos_facturas` (`pfact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `fac_productos` (
                                 `pro_id` varchar(50) NOT NULL,
                                 `pro_nombre` varchar(100) DEFAULT NULL,
                                 `pro_precio_unitario` decimal(7,2) DEFAULT NULL,
                                 PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `fac_productos_facturas` (
                                          `pfact_id` varchar(50) NOT NULL,
                                          `pfact_cantidad` int DEFAULT NULL,
                                          `pfact_importe` decimal(7,2) DEFAULT NULL,
                                          `pfact_fac_id` varchar(50) NOT NULL,
                                          `pfact_pro_id` varchar(50) NOT NULL,
                                          PRIMARY KEY (`pfact_id`),
                                          KEY `FK8f7jadutof50d19rhmyk23s6h` (`pfact_fac_id`),
                                          KEY `FK89n88oel61qjx7fkivp6nvk4x` (`pfact_pro_id`),
                                          CONSTRAINT `FK89n88oel61qjx7fkivp6nvk4x` FOREIGN KEY (`pfact_pro_id`) REFERENCES `fac_productos` (`pro_id`),
                                          CONSTRAINT `FK8f7jadutof50d19rhmyk23s6h` FOREIGN KEY (`pfact_fac_id`) REFERENCES `fac_facturas` (`fact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

