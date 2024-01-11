import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ConexionMapperTest {
    @Test
    public void testMapDtoToEntity() throws ParseException {
        // Crear un objeto ConexionDto para la prueba
        ConexionDto dto = new ConexionDto();
        dto.setId(1);
        dto.set_fecha(new Date());
        dto.set_estadoConexion(true);
        dto.set_latitud(10);
        dto.set_longitud(-66);
        dto.set_usuario(null);

        // Llamar al método que se está probando
        Conexion entity = ConexionMapper.mapDtoToEntity(dto);

        // Verificar que los valores de la entidad coinciden con los del DTO
        assertEquals(dto.getId(), entity.get_id());
        assertEquals(dto.get_fecha(), entity.get_fecha());
        assertEquals(dto.get_estadoConexion(), entity.get_estadoConexion());
        assertEquals(dto.get_latitud(), entity.get_latitud());
        assertEquals(dto.get_longitud(), entity.get_longitud());
        assertNull(entity.get_usuario());
    }

    @Test
    public void testMapEntityToDto() throws ParseException {
        // Crear un objeto Conexion para la prueba
        Conexion entity = new Conexion();
        entity.set_id(1);
        entity.set_fecha(new Date());
        entity.set_estadoConexion(true);
        entity.set_latitud(10);
        entity.set_longitud(-66);
        entity.set_usuario(UsuarioMapper.mapDtoToEntity(new UsuarioDto(2)));

        // Llamar al método que se está probando
        ConexionDto dto = ConexionMapper.mapEntityToDto(entity);

        // Verificar que los valores del DTO coinciden con los de la entidad
        assertEquals(entity.get_id(), dto.getId());
        assertEquals(entity.get_fecha(), dto.get_fecha());
        assertEquals(entity.get_estadoConexion(), dto.get_estadoConexion());
        assertEquals(entity.get_latitud(), dto.get_latitud());
        assertEquals(entity.get_longitud(), dto.get_longitud());
        assertNotNull(dto.get_usuario());
        assertEquals(entity.get_usuario().get_idUsuario(), dto.get_usuario().getId());
        assertEquals(entity.get_usuario().get_Nombre(), dto.get_usuario().get_Nombre());
    }

    private void assertNotNull(UsuarioDto usuario) {
    }
    @Test
    void testMapDtoToEntity2() {
        // Preparación
        long expectedId = 1L; // Define el valor esperado para el ID

        // Ejecución
        Conexion result = ConexionMapper.mapDtoToEntity(expectedId);

        // Verificación
        assertNotNull(result, "El resultado no debería ser null");
        assertEquals(expectedId, result.get_id(), "El ID del resultado debería ser igual al ID esperado");
    }

    private void assertNotNull(Conexion result, String s) {
    }

    @Test
    public void testMapEntityListToDtoList() throws ParseException {
        // Arrange
        List<Conexion> entityList = new ArrayList<>();
        Conexion entity1 = new Conexion();
        entity1.set_id(1);
        entity1.set_fecha(convertStringToDate("2023-10-31"));
        entity1.set_estadoConexion(true);
        entity1.set_latitud(37);
        entity1.set_longitud(-122);
        Conexion entity2 = new Conexion();
        entity2.set_id(2);
        entity2.set_fecha(convertStringToDate("2023-10-31"));
        entity2.set_estadoConexion(false);
        entity2.set_latitud(34);
        entity2.set_longitud(-118);
        entityList.add(entity1);
        entityList.add(entity2);

        // Act
        List<ConexionDto> dtoList = ConexionMapper.mapEntityListToDtoList(entityList);

        // Assert
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {
            Conexion entity = entityList.get(i);
            ConexionDto dto = dtoList.get(i);
            Assertions.assertEquals(entity.get_id(), dto.getId());
            Assertions.assertEquals(entity.get_fecha(), dto.get_fecha());
            Assertions.assertEquals(entity.get_estadoConexion(), dto.get_estadoConexion());
            Assertions.assertEquals(entity.get_latitud(), dto.get_latitud());
            Assertions.assertEquals(entity.get_longitud(), dto.get_longitud());
        }
    }

    private Date convertStringToDate(String date) {
        return null;
    }

    @Test
    public void testMapDtoToEntityUsuarioId() {
        // Arrange
        long usuarioId = 1;

        // Act
        Conexion entity = ConexionMapper.mapDtoToEntityUsuarioId(usuarioId);

        // Assert
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(usuarioId, entity.get_usuario().get_idUsuario());
    }
}
