import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.dtos.AdminDto;
import com.ucab.cmcapp.logic.mappers.AdminMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdminMapperTest {

    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        AdminDto dto = new AdminDto();
        dto.setId(1);
        dto.set_username("admin");
        dto.set_correo("admin@example.com");
        dto.set_password("password");

        // Act
        Admin entity = AdminMapper.mapDtoToEntity(dto);

        // Assert
        assertEquals(dto.getId(), entity.get_id());
        assertEquals(dto.get_username(), entity.get_username());
        assertEquals(dto.get_correo(), entity.get_correo());
        assertEquals(dto.get_password(), entity.get_password());
    }
    /*@Test
    public void testMapDtoToEntityotro() {
        // Arrange
        long id = 1;

        // Act
        Admin entity = AdminMapper.mapDtoToEntity(id);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(id, entity.get_id());

        // Verificar que se haya llamado a EntityFactory.createAdministrador con el id correcto
        EntityFactory entityFactoryMock = Mockito.mock(EntityFactory.class);
        Admin expectedEntity = EntityFactory.createAdmin(id);
        Mockito.verify(entityFactoryMock, Mockito.times(1)).createAdmin(id);
    }*/

    @Test
    public void testMapEntityToDto() {
        // Arrange
        Admin entity = new Admin();
        entity.set_id(1);
        entity.set_username("admin");
        entity.set_correo("admin@example.com");
        entity.set_password("password");

        // Act
        AdminDto dto = AdminMapper.mapEntityToDto(entity);

        // Assert
        assertEquals(entity.get_id(), dto.getId());
        assertEquals(entity.get_username(), dto.get_username());
        assertEquals(entity.get_correo(), dto.get_correo());
        assertEquals(entity.get_password(), dto.get_password());
    }

    @Test
    public void testMapEntityListToDtoList() {
        // Arrange
        List<Admin> entityList = new ArrayList<>();
        Admin entity1 = new Admin();
        entity1.set_id(1);
        entity1.set_username("admin1");
        entity1.set_correo("admin1@example.com");
        entity1.set_password("password1");
        entityList.add(entity1);
        Admin entity2 = new Admin();
        entity2.set_id(2);
        entity2.set_username("admin2");
        entity2.set_correo("admin2@example.com");
        entity2.set_password("password2");
        entityList.add(entity2);

        // Act
        List<AdminDto> dtoList = AdminMapper.mapEntityListToDtoList(entityList);

        // Assert
        assertEquals(entityList.size(), dtoList.size());
        assertEquals(entityList.get(0).get_id(), dtoList.get(0).getId());
        assertEquals(entityList.get(0).get_username(), dtoList.get(0).get_username());
        assertEquals(entityList.get(0).get_correo(), dtoList.get(0).get_correo());
        assertEquals(entityList.get(0).get_password(), dtoList.get(0).get_password());
        assertEquals(entityList.get(1).get_id(), dtoList.get(1).getId());
        assertEquals(entityList.get(1).get_username(), dtoList.get(1).get_username());
        assertEquals(entityList.get(1).get_correo(), dtoList.get(1).get_correo());
        assertEquals(entityList.get(1).get_password(), dtoList.get(1).get_password());
    }
    @Test
    public void testMapDtoToEntity2() {
        // Arrange
        long id = 1;

        // Act
        Admin entity = AdminMapper.mapDtoToEntity(id);

        // Assert
        assertEquals(id, entity.get_id());
    }
    @Test
    public void testMapDtoToEntityCorreo() {
        // Arrange
        String email = "admin@example.com";

        // Act
        Admin entity = AdminMapper.mapDtoToEntityCorreo(email);

        // Assert
        assertEquals(email, entity.get_correo());
    }

    @Test
    public void testMapDtoToEntityAlias() {
        // Arrange
        String alias = "admin";

        // Act
        Admin entity = AdminMapper.mapDtoToEntityUsername(alias);

        // Assert
        assertEquals(alias, entity.get_username());
    }
}