import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.logic.dtos.UserTypeDto;
import com.ucab.cmcapp.logic.mappers.UserTypeMapper;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTypeMapperTest {
    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Arrange
        UserTypeDto userTypeDto = new UserTypeDto();
        userTypeDto.setId(1);
        userTypeDto.setName("Admin");

        // Act
        UserType entity = UserTypeMapper.mapDtoToEntity(userTypeDto);

        // Assert
        assertEquals(userTypeDto.getId(), entity.getId());
        assertEquals(userTypeDto.getName(), entity.getName());
    }

    @Test
    public void testMapDtoToEntityInsert() throws ParseException {
        // Arrange
        UserTypeDto userTypeDto = new UserTypeDto();
        userTypeDto.setName("Admin");

        // Act
        UserType entity = UserTypeMapper.mapDtoToEntityInsert(userTypeDto);

        // Assert
        assertEquals(userTypeDto.getName(), entity.getName());
    }

    @Test
    public void testMapEntityToDto() {
        // Arrange
        UserType userType = new UserType();
        userType.setId(1);
        userType.setName("Admin");

        // Act
        UserTypeDto dto = UserTypeMapper.mapEntityToDto(userType);

        // Assert
        assertEquals(userType.getId(), dto.getId());
        assertEquals(userType.getName(), dto.getName());
    }

    @Test
    public void testMapDtoToEntity2() {
        // Arrange
        long id = 1;

        // Act
        UserType entity = UserTypeMapper.mapDtoToEntity(id);

        // Assert
        assertEquals(id, entity.getId());
    }
}
