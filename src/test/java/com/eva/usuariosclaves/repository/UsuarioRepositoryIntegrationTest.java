package com.eva.usuariosclaves.repository;

import com.eva.usuariosclaves.model.Proveedor;
import com.eva.usuariosclaves.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@DataJpaTest
class UsuarioRepositoryIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:15")
                    .withDatabaseName("testdb")
                    .withUsername("test")
                    .withPassword("test");

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Test
    void guardarYBuscarUsuario() {

        Proveedor proveedor = new Proveedor();
        proveedor.setNombreEmpresa("Empresa Test");
        proveedor.setEmailContacto("test@test.com");
        proveedor.setTelefonoContacto("600000000");

        proveedor = proveedorRepository.save(proveedor);

        Usuario usuario = new Usuario();
        usuario.setNombre("Test User");
        usuario.setEmail("test@test.com");
        usuario.setPassword("1234");
        usuario.setProveedor(proveedor);

        usuarioRepository.save(usuario);

        Optional<Usuario> encontrado =
                usuarioRepository.findByEmail("test@test.com");

        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNombre()).isEqualTo("Test User");
    }
}