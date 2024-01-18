import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import com.ucab.cmcapp.logic.mappers.AlertaMapper;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertaMapperTest {

    @Test
    void mapDtoToEntity() throws ParseException {
        // Crear un objeto AlertaDto con datos de prueba
        AlertaDto dto = new AlertaDto();
        dto.setId(1L);
        dto.set_tipoAlerta("Test Alerta");
        dto.set_fechaHora(new Date());

        UsuarioDto usuarioDto = new UsuarioDto();
        // Añade los campos necesarios para el UsuarioDto
        dto.setUsuario(usuarioDto);

        // Llamar al método que se está probando
        Alerta entity = AlertaMapper.mapDtoToEntity(dto);

        // Verificar que los datos en la entidad coinciden con los datos del DTO
        assertEquals(dto.getId(), entity.get_IdAlerta());
        assertEquals(dto.get_tipoAlerta(), entity.get_tipoAlerta());
        assertEquals(dto.get_fechaHora(), entity.get_fechaHora());
        // Asegúrate de añadir más aserciones para todos los campos del Usuario
    }

    @Test
    void mapDtoToEntityInsert() throws ParseException {
        // Crear un objeto AlertaDto con datos de prueba
        AlertaDto dto = new AlertaDto();
        dto.set_tipoAlerta("Test Alerta");
        dto.set_fechaHora(new Date());

        // Crear un objeto UsuarioDto con datos de prueba
        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.set_Username("Test Username");
        usuarioDto.set_Correo("test@test.com");
        usuarioDto.set_Nombre("Test Nombre");
        // Añade los campos necesarios para el UsuarioDto
        dto.setUsuario(usuarioDto);

        // Llamar al método que se está probando
        Alerta entity = AlertaMapper.mapDtoToEntityInsert(dto);

        // Verificar que los datos en la entidad coinciden con los datos del DTO
        assertEquals(dto.get_tipoAlerta(), entity.get_tipoAlerta());
        assertEquals(dto.get_fechaHora(), entity.get_fechaHora());
        assertEquals(dto.getUsuario().get_Username(), entity.getUsuario().get_Username());
        assertEquals(dto.getUsuario().get_Correo(), entity.getUsuario().get_Correo());
        assertEquals(dto.getUsuario().get_Nombre(), entity.getUsuario().get_Nombre());
        // Asegúrate de añadir más aserciones para todos los campos del Usuario
    }


    @Test
    void mapEntityToDto() {
        // Crear un objeto Alerta con datos de prueba
        Alerta entity = new Alerta();
        entity.set_IdAlerta(1L);
        entity.set_tipoAlerta("Test Alerta");
        entity.set_fechaHora(new Date());

        // Crear un objeto Usuario con datos de prueba
        Usuario usuario = new Usuario();
        usuario.set_Username("Test Username");
        usuario.set_Correo("test@test.com");
        usuario.set_Nombre("Test Nombre");
        // Añade los campos necesarios para el Usuario
        entity.setUsuario(usuario);

        // Llamar al método que se está probando
        AlertaDto dto = AlertaMapper.mapEntityToDto(entity);

        // Verificar que los datos en el DTO coinciden con los datos de la entidad
        assertEquals(entity.get_IdAlerta(), dto.getId());
        assertEquals(entity.get_tipoAlerta(), dto.get_tipoAlerta());
        assertEquals(entity.get_fechaHora(), dto.get_fechaHora());
        assertEquals(entity.getUsuario().get_Username(), dto.getUsuario().get_Username());
        assertEquals(entity.getUsuario().get_Correo(), dto.getUsuario().get_Correo());
        assertEquals(entity.getUsuario().get_Nombre(), dto.getUsuario().get_Nombre());
        // Asegúrate de añadir más aserciones para todos los campos del Usuario
    }

    @Test
    void mapDtoToEntity2() {
        // Crear un id de prueba
        long id = 1L;

        // Llamar al método que se está probando
        Alerta entity = AlertaMapper.mapDtoToEntity(id);

        // Verificar que el id en la entidad coincide con el id de prueba
        assertEquals(id, entity.get_IdAlerta());
    }

    @Test
    void mapDtoToEntityTipoAlerta() {
        // Crear un tipo de alerta de prueba
        String tipoAlerta = "Test Alerta";

        // Llamar al método que se está probando
        Alerta entity = AlertaMapper.mapDtoToEntityTipoAlerta(tipoAlerta);

        // Verificar que el tipo de alerta en la entidad coincide con el tipo de alerta de prueba
        assertEquals(tipoAlerta, entity.get_tipoAlerta());
    }

    @Test
    public void testMapDtoToEntityTipoAlerta() {
        // Crear mock de la lista de tipoAlertas
        List<String> mockTipoAlertas = new ArrayList<>();
        mockTipoAlertas.add("tipoAlerta1");
        mockTipoAlertas.add("tipoAlerta2");

        // Llamar al método que se está probando
        List<Alerta> entities = AlertaMapper.mapDtoToEntityTipoAlerta(mockTipoAlertas);

        // Verificar el resultado
        assertEquals(2, entities.size());
        assertEquals("tipoAlerta1", entities.get(0).get_tipoAlerta());
        assertEquals("tipoAlerta2", entities.get(1).get_tipoAlerta());
    }

    @Test
    void mapDtosToEntities() throws ParseException {
        // Crear una lista de AlertaDto con datos de prueba
        List<AlertaDto> dtos = new ArrayList<>();
        AlertaDto dto = new AlertaDto();
        dto.set_tipoAlerta("Test Alerta");
        dto.set_fechaHora(new Date());
        dtos.add(dto);

        // Llamar al método que se está probando
        List<Alerta> entities = AlertaMapper.mapDtosToEntities(dtos);

        // Verificar que los datos en las entidades coinciden con los datos de los DTOs
        for (int i = 0; i < dtos.size(); i++) {
            assertEquals(dtos.get(i).get_tipoAlerta(), entities.get(i).get_tipoAlerta());
            assertEquals(dtos.get(i).get_fechaHora(), entities.get(i).get_fechaHora());
        }
    }

    @Test
    void mapEntitiesToDtos() {
        // Crear una lista de Alerta con datos de prueba
        List<Alerta> entities = new ArrayList<>();
        Alerta entity = new Alerta();
        entity.set_tipoAlerta("Test Alerta");
        entity.set_fechaHora(new Date());

        // Crear un objeto Usuario con datos de prueba
        Usuario usuario = new Usuario();
        usuario.set_Username("Test Username");
        usuario.set_Correo("test@test.com");
        usuario.set_Nombre("Test Nombre");
        // Añade los campos necesarios para el Usuario
        entity.setUsuario(usuario);

        entities.add(entity);

        // Llamar al método que se está probando
        List<AlertaDto> dtos = AlertaMapper.mapEntitiesToDtos(entities);
    }
    @Test
    public void testMapListEntityToDto() {
        // Crear una lista de entidades Alerta para la prueba
        List<Alerta> entities = new ArrayList<>();
        Alerta alerta1 = EntityFactory.createAlerta();
        alerta1.set_tipoAlerta("tipo1");
        alerta1.set_fechaHora(new Date());
        alerta1.set_latitudY(10.0f);
        alerta1.set_longitudX(20.0f);
        entities.add(alerta1);

        Alerta alerta2 = EntityFactory.createAlerta();
        alerta2.set_tipoAlerta("tipo2");
        alerta2.set_fechaHora(new Date());
        alerta2.set_latitudY(30.0f);
        alerta2.set_longitudX(40.0f);
        entities.add(alerta2);

        // Llamar al método que se está probando
        List<AlertaDto> dtos = AlertaMapper.mapListEntityToDto(entities);

        // Verificar que la lista de dtos tiene el mismo tamaño que la lista de entidades
        assertEquals(entities.size(), dtos.size());

        // Verificar que las propiedades de los dtos coinciden con las de las entidades correspondientes
        for (int i = 0; i < entities.size(); i++) {
            assertEquals(entities.get(i).get_tipoAlerta(), dtos.get(i).get_tipoAlerta());
            assertEquals(entities.get(i).get_fechaHora(), dtos.get(i).get_fechaHora());
            assertEquals(entities.get(i).get_latitudY(), dtos.get(i).get_latitud(), 0.001);
            assertEquals(entities.get(i).get_longitudX(), dtos.get(i).get_longitud(), 0.001);
        }
    }


}


