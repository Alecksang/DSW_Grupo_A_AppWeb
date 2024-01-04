package com.ucab.cmcapp.implementation;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import src.services.implementation.src.main.java.com.ucab.cmcapp.implementation.UsuarioService;
import com.ucab.cmcapp.logic.commands.CommandFactory;
import com.ucab.cmcapp.logic.commands.usuario.composite.GetUsuarioCommand;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import com.ucab.cmcapp.common.entities.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.ws.rs.core.Response;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private CommandFactory commandFactory;

    @Mock
    private GetUsuarioCommand getUsuarioCommand;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        when(commandFactory.createGetUsuarioCommand(any(Usuario.class))).thenReturn(getUsuarioCommand);
    }

    @Test
    void getUsuario_Success() {
        // Arrange
        long userId = 1L;
        UsuarioService mockUser = new Usuario(); // Set properties as needed
        UsuarioDto mockUserDto = new UsuarioDto(); // Set properties as needed
        when(getUsuarioCommand.getReturnParam()).thenReturn(mockUser);
        when(UsuarioMapper.mapDtoToEntity(userId)).thenReturn(mockUser);
        when(UsuarioMapper.mapEntityToDto(mockUser)).thenReturn(mockUserDto);

        // Act
        Response response = usuarioService.getUsuario(userId);

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        // Additional assertions as needed
    }

    // Other test methods...
}
