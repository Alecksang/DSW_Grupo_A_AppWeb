import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguraDto;
import com.ucab.cmcapp.logic.dtos.ZonaSeguraDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import com.ucab.cmcapp.logic.mappers.ZonaSeguraMapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


public class ZonaSeguraMapperTest {

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(1);
        usuarioDto.set_Username("ejemplo_username");
        usuarioDto.set_Correo("ejemplo@correo.com");
        usuarioDto.set_Nombre("Nombre Ejemplo");
        usuarioDto.setDocIdentidad("V-12345678");
        usuarioDto.setIMEI("123456789012345");
        usuarioDto.setEstatus(true);
        usuarioDto.set_Password("ejemplo_password");


        ZonaSeguraDto dto = new ZonaSeguraDto();
        dto.setId(1);
        dto.set_nombre("Alejandro Sangia");
        dto.setUsuario(usuarioDto);

        // Act
        ZonaSegura entity = ZonaSeguraMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.get_idZona());
        Assertions.assertEquals(dto.get_nombre(), entity.get_nombreZona());
        Assertions.assertEquals(dto.getUsuario().getId(), entity.getUsuario().get_idUsuario());
    }

    @Test
    public void testMapDtoToEntityInsert() throws ParseException {
        // Arrange
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(1);
        usuarioDto.set_Username("ejemplo_username");
        usuarioDto.set_Correo("ejemplo@correo.com");
        usuarioDto.set_Nombre("Nombre Ejemplo");
        usuarioDto.setDocIdentidad("V-12345678");
        usuarioDto.setIMEI("123456789012345");
        usuarioDto.setEstatus(true);
        usuarioDto.set_Password("ejemplo_password");

        ZonaSeguraDto dto = new ZonaSeguraDto();
        dto.set_nombre("Alejandro Sangia");
        dto.setUsuario(usuarioDto);

        // Act
        ZonaSegura entity = ZonaSeguraMapper.mapDtoToEntityInsert(dto);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.get_nombre(), entity.get_nombreZona());
        Assertions.assertEquals(dto.getUsuario().getId(), entity.getUsuario().get_idUsuario());
    }

    @Test
    public void testMapEntityToDto() throws ParseException {
        // Arrange
        Usuario entityUsuario = new Usuario();
        entityUsuario.set_idUsuario(1);
        entityUsuario.set_Username("ejemplo_username");
        entityUsuario.set_Correo("ejemplo@correo.com");
        entityUsuario.set_Nombre("Nombre Ejemplo");
        entityUsuario.setDocIdentidad("V-12345678");
        entityUsuario.setIMEI("123456789012345");
        entityUsuario.setEstatus(true);
        entityUsuario.set_Password("ejemplo_password");

        ZonaSegura entity = new ZonaSegura();
        entity.set_idZona(1);
        entity.set_nombreZona("Alejandro Sangia");
        entity.setUsuario(entityUsuario);

        // Act
        ZonaSeguraDto dto = ZonaSeguraMapper.mapEntityToDto(entity);
        // Assert
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.get_idZona(), dto.getId());
        Assertions.assertEquals(entity.get_nombreZona(), dto.get_nombre());
        Assertions.assertEquals(entity.getUsuario().get_idUsuario(), dto.getUsuario().getId());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1;

        // Act
        ZonaSegura entity = ZonaSeguraMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(id, entity.get_idZona());
    }
}



