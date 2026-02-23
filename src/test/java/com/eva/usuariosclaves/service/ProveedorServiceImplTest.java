package com.eva.usuariosclaves.service;

import com.eva.usuariosclaves.dto.ProveedorDTO;
import com.eva.usuariosclaves.model.Proveedor;
import com.eva.usuariosclaves.repository.ProveedorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProveedorServiceImplTest {

    @Mock
    private ProveedorRepository proveedorRepository;

    @InjectMocks
    private ProveedorServiceImpl proveedorService;

    @Test
    void guardar_deberiaGuardarProveedor() {

        ProveedorDTO dto = new ProveedorDTO(null, "Empresa", "mail@test.com", "123456");

        Proveedor proveedor = new Proveedor();
        proveedor.setNombreEmpresa("Empresa");

        when(proveedorRepository.save(any(Proveedor.class))).thenReturn(proveedor);

        ProveedorDTO resultado = proveedorService.guardar(dto);

        assertEquals("Empresa", resultado.getNombreEmpresa());
        verify(proveedorRepository, times(1)).save(any(Proveedor.class));
    }
}