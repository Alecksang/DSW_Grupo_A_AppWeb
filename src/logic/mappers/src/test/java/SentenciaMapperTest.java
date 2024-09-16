import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.SentenciaDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.SentenciaMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SentenciaMapperTest {

    private SentenciaDto dto;
    private Sentencia entity;

    @BeforeEach
    public void setup() {
        dto = new SentenciaDto();
        entity = new Sentencia();
    }


    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        dto.setId(1L);
        dto.set_distanciaMinima(10);

        // Act
        Sentencia result = SentenciaMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(result);
        assertEquals(dto.getId(), result.get_IdAlej());
        assertEquals(dto.get_distanciaMinima(), result.get_distanciaMinima());
        // Verificar que se llame a los mappers correspondientes
        Assertions.assertNull(result.get_victima());
        Assertions.assertNull(result.get_agresor());
    }


    @Test
    public void testMapEntityToDto() {
        // Arrange
        entity.set_IdAlej(1L);
        entity.set_distanciaMinima(20);

        // Act
        SentenciaDto result = SentenciaMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(result);
        assertEquals(entity.get_IdAlej(), result.getId());
        assertEquals(entity.get_distanciaMinima(), result.get_distanciaMinima());
        // Verificar que se llame a los mappers correspondientes
        Assertions.assertNull(result.get_victima());
        Assertions.assertNull(result.get_agresor());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1L;

        // Act
        Sentencia result = SentenciaMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(result);
        assertEquals(id, result.get_IdAlej());
    }

    @Test
    public void testMapDtoToEntityInsert() throws ParseException {
        // Arrange
        UsuarioDto agresorDto = new UsuarioDto();
        agresorDto.setId(1);
        agresorDto.set_Username("agresor_username");

        UsuarioDto victimaDto = new UsuarioDto();
        victimaDto.setId(2);
        victimaDto.set_Username("victima_username");

        SentenciaDto sentenciaDto = new SentenciaDto();
        sentenciaDto.set_distanciaMinima(100.0f);
        sentenciaDto.set_agresor(agresorDto);
        sentenciaDto.set_victima(victimaDto);

        // Act
        Sentencia entity = SentenciaMapper.mapDtoToEntityInsert(sentenciaDto);

    }

    @Test
    public void testMapDtoToEntityUsuarios() {
        // Arrange
        Usuario victima = new Usuario();
        victima.set_idUsuario(1);
        victima.set_Username("victima_username");

        Usuario agresor = new Usuario();
        agresor.set_idUsuario(2);
        agresor.set_Username("agresor_username");

        // Act
        Sentencia entity = SentenciaMapper.mapDtoToEntityUsuarios(victima, agresor);

        // Assert
        // Aquí necesitarás descomentar las líneas correspondientes en tu método original
        // para poder hacer las aserciones correspondientes.
        assertEquals(victima.get_idUsuario(), entity.get_victima().get_idUsuario());
        assertEquals(agresor.get_idUsuario(), entity.get_agresor().get_idUsuario());

    }
}
