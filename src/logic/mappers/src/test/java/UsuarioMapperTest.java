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
        dto.set_Correo("alejo@example.com");
        dto.setDocIdentidad("12345");
        dto.setIMEI("00:00:00:00:00:00");
        dto.setEstatus(false);
        dto.set_Password("password");

        // Act
        Usuario result = UsuarioMapper.mapDtoToEntity(dto);

        // Assert
        assertNotNull(result);
        assertEquals(dto.getId(), result.get_idUsuario());
        assertEquals(dto.get_Nombre(), result.get_Nombre());
        assertEquals(dto.get_Username(), result.get_Username());
        assertEquals(dto.getDocIdentidad(), result.getDocIdentidad());
        assertEquals(dto.get_Correo(), result.get_Correo());
        assertEquals(dto.getIMEI(), result.getIMEI());
        assertEquals(dto.get_Password(), result.get_Password());
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
    public void testMapDtoToEntityInsert() throws ParseException {
        // Arrange
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.set_Username("ejemplo_username");
        usuarioDto.set_Nombre("Nombre Ejemplo");
        usuarioDto.setDocIdentidad("V-12345678");
        usuarioDto.setIMEI("123456789012345");
        usuarioDto.setEstatus(true);
        usuarioDto.set_Correo("ejemplo@correo.com");
        usuarioDto.set_Password("ejemplo_password");

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntityInsert(usuarioDto);

        // Assert
        assertEquals(usuarioDto.get_Username(), entity.get_Username());
        assertEquals(usuarioDto.get_Nombre(), entity.get_Nombre());
        assertEquals(usuarioDto.getDocIdentidad(), entity.getDocIdentidad());
        assertEquals(usuarioDto.getIMEI(), entity.getIMEI());
        assertEquals(usuarioDto.isEstatus(), entity.isEstatus());
        assertEquals(usuarioDto.get_Correo(), entity.get_Correo());
        assertEquals(usuarioDto.get_Password(), entity.get_Password());
    }

    @Test
    public void testMapListEntityToDto() {
        // Arrange
        List<Usuario> entities = new ArrayList<>();
        Usuario usuario1 = new Usuario();
        usuario1.set_idUsuario(1);
        Usuario usuario2 = new Usuario();
        usuario2.set_idUsuario(2);
        entities.add(usuario1);
        entities.add(usuario2);

        // Act
        List<UsuarioDto> dtos = UsuarioMapper.mapListEntityToDto(entities);

        // Assert
        assertEquals(entities.size(), dtos.size());
        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).get_idUsuario(), dtos.get(i).getId());
        }
    }

    @Test
    public void testMapDtoToEntity2() {
        // Arrange
        long id = 1;

        // Act
        Usuario entity = UsuarioMapper.mapDtoToEntity(id);

        // Assert
        assertEquals(id, entity.get_idUsuario());
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
