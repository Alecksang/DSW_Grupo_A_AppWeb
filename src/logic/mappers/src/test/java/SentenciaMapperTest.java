import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.logic.dtos.SentenciaDto;
import com.ucab.cmcapp.logic.mappers.SentenciaMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;


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
        Assertions.assertEquals(dto.getId(), result.get_IdAlej());
        Assertions.assertEquals(dto.get_distanciaMinima(), result.get_distanciaMinima());
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
        Assertions.assertEquals(entity.get_IdAlej(), result.getId());
        Assertions.assertEquals(entity.get_distanciaMinima(), result.get_distanciaMinima());
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
        Assertions.assertEquals(id, result.get_IdAlej());
    }
}
