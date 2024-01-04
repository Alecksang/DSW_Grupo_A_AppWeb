import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class UsuarioMapperTest {
    private UsuarioDto dto;
    private Usuario entity;

    @BeforeEach
    public void setup() {
        dto = new UsuarioDto();
        entity = new Usuario();
    }

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);
        dto.set_Nombre("alejo");
        dto.set_Username("sangia_");
        //dto.set_correo("johndoe@example.com");
        dto.setDocIdentidad("12345");
        dto.setIMEI("00:00:00:00:00:00");
        dto.setEstatus(false);
        //dto.set_clave("password");

        // Act
        Usuario result = UsuarioMapper.mapDtoToEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(dto.getId(), result.get_idUsuario());
        assertEquals(dto.get_Nombre(), result.get_Nombre());
        assertEquals(dto.get_Username(), result.get_Username());
        assertEquals(dto.getDocIdentidad(), result.getDocIdentidad());
        //añadir correo
        //Assertions.assertEquals(dto.get_correo(), result.get_correo());
        assertEquals(dto.getIMEI(), result.getIMEI());
        //Añadir password
        //Assertions.assertEquals(dto.get_clave(), result.get_clave());
        assertEquals(dto.isEstatus(), result.isEstatus());
    }

    @Test
    public void testMapEntityToDto() throws ParseException {
        // Arrange
        dto.setId(1L);
        dto.set_Nombre("alejo");
        dto.set_Username("sangia_");
        //dto.set_correo("johndoe@example.com");
        dto.setDocIdentidad("12345");
        dto.setIMEI("00:00:00:00:00:00");
        dto.setEstatus(false);
        //dto.set_clave("password");

        // Act
        UsuarioDto result = UsuarioMapper.mapEntityToDto(entity);

        // Assert
        assertNotNull(result);
        assertEquals(entity.get_idUsuario(), result.getId());
        assertEquals(entity.get_Nombre(), result.get_Nombre());
        assertEquals(entity.get_Username(), result.get_Username());
        assertEquals(entity.getDocIdentidad(), result.getDocIdentidad());
        //añadir correo
        //Assertions.assertEquals(dto.get_correo(), result.get_correo());
        assertEquals(entity.getIMEI(), result.getIMEI());
        //Añadir password
        //Assertions.assertEquals(dto.get_clave(), result.get_clave());
        assertEquals(entity.isEstatus(), result.isEstatus());
    }

    @Test
    public void testMapDtoToEntityUsername() {
        // Arrange
        String username = "username_prueba";

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntityUsername(username);

        // Assert
        assertNotNull(entity);
        assertEquals(username, entity.get_Username());
    }
}
