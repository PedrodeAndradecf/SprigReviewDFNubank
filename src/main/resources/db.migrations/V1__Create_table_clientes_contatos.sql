CREATE TABLE contatos (
                          id BIGSERIAL PRIMARY KEY,
                          email VARCHAR(150) NOT NULL,
                          telefone VARCHAR(20) NOT NULL,
                          cliente_id BIGINT NOT NULL,

                          CONSTRAINT check_contato_valido CHECK (email IS NOT NULL OR telefone IS NOT NULL),


                          CONSTRAINT uk_contatos_email UNIQUE (email),


                          CONSTRAINT uk_contatos_telefone UNIQUE (telefone),

                          CONSTRAINT fk_contatos_cliente
                              FOREIGN KEY (cliente_id) REFERENCES clientes(id)
                                  ON DELETE CASCADE
);