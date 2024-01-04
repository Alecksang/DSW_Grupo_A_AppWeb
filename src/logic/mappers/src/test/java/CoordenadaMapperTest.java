
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.logic.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.mappers.CoordenadaMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CoordenadaMapperTest {


    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        CoordenadaDto dto = new CoordenadaDto();
        dto.setId(1);
        dto.set_latitudY(40);
        dto.set_longitudX(-122);

        // Act
        Coordenada entity = CoordenadaMapper.mapDtoToEntity(dto);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.get_id());
        Assertions.assertEquals(dto.get_latitudY(), entity.get_latitudY());
        Assertions.assertEquals(dto.get_longitudX(), entity.get_longitudX());
    }
    @Test
    public void testMapEntityToDto() {
        // Arrange
        Coordenada entity = new Coordenada();
        entity.set_id(1);
        entity.set_latitudY(37);
        entity.set_longitudX(-122);

        // Act
        CoordenadaDto dto = CoordenadaMapper.mapEntityToDto(entity);

        // Assert
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.get_id(), dto.getId());
        Assertions.assertEquals(entity.get_latitudY(), dto.get_latitudY());
        Assertions.assertEquals(entity.get_longitudX(), dto.get_longitudX());
    }

    @Test
    public void testMapDtoToEntityWithId() {
        // Arrange
        long id = 1;

        // Act
        Coordenada entity = CoordenadaMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(id, entity.get_id());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Coordenada> entityList = new ArrayList<>();
        Coordenada entity1 = new Coordenada();
        entity1.set_id(1);
        entity1.set_latitudY(40);
        entity1.set_longitudX(-122);
        Coordenada entity2 = new Coordenada();
        entity2.set_id(2);
        entity2.set_latitudY(32);
        entity2.set_longitudX(-225);
        entityList.add(entity1);
        entityList.add(entity2);

        // Act
        List<CoordenadaDto> dtoList = CoordenadaMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {
            Coordenada entity = entityList.get(i);
            CoordenadaDto dto = dtoList.get(i);
            Assertions.assertEquals(entity.get_id(), dto.getId());
            Assertions.assertEquals(entity.get_latitudY(), dto.get_latitudY());
            Assertions.assertEquals(entity.get_longitudX(), dto.get_longitudX());
        }
    }
}
