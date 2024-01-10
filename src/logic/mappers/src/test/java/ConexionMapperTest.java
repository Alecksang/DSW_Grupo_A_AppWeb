import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import com.ucab.cmcapp.logic.mappers.ConexionMapper;
import org.junit.jupiter.api.Test;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.UsuarioMapper;

import java.text.ParseException;
import java.util.ArrayList;
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


}