package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Conexion;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.dtos.ConexionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ConexionMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(ConexionMapper.class);

    public static Conexion mapDtoToEntity(ConexionDto dto) throws ParseException {
        Conexion entity = EntityFactory.createConexion();

        entity.set_id(dto.getId());
        entity.set_fecha(dto.get_fecha());
        entity.set_estadoConexion(dto.get_estadoConexion());
        entity.set_latitud(dto.get_latitud());
        entity.set_longitud(dto.get_longitud());

        if ( Objects.nonNull( dto.get_usuario() ) ) {
            entity.set_usuario( UsuarioMapper.mapDtoToEntity( dto.get_usuario() ) );
        }

        return entity;
    }

    public static ConexionDto mapEntityToDto(Conexion entity) {
        final ConexionDto dto = new ConexionDto();


        dto.setId(entity.get_id());
        dto.set_fecha(entity.get_fecha());
        dto.set_estadoConexion(entity.get_estadoConexion());
        dto.set_latitud(entity.get_latitud());
        dto.set_longitud(entity.get_longitud());

        if(Objects.nonNull(entity.get_usuario()))
            dto.set_usuario( UsuarioMapper.mapEntityToDto( entity.get_usuario()));

        return dto;
    }

    public static Conexion mapDtoToEntity(long id) {
        Conexion entity = EntityFactory.createConexion(id);
        entity.set_id(id);
        return entity;
    }

    public static List<ConexionDto> mapEntityListToDtoList(List<Conexion> entityList){
        List<ConexionDto> dtoList = new ArrayList<ConexionDto>();
        ConexionDto ConexionDto;

        for (Conexion conexion : entityList) {

            ConexionDto = new ConexionDto();
            ConexionDto.setId(conexion.get_id());
            ConexionDto.set_fecha(conexion.get_fecha());
            ConexionDto.set_estadoConexion(conexion.get_estadoConexion());
            ConexionDto.set_latitud(conexion.get_latitud());
            ConexionDto.set_longitud(conexion.get_longitud());

            if (Objects.nonNull(conexion.get_usuario()))
                ConexionDto.set_usuario(UsuarioMapper.mapEntityToDto(conexion.get_usuario()));

            dtoList.add(ConexionDto);

        }

        return dtoList;
    }

    public static Conexion mapDtoToEntityUsuarioId(long usuarioId){
        Usuario usuario = new Usuario(usuarioId);
        Conexion conexion = EntityFactory.createConexion();
        conexion.set_usuario(usuario);
        return conexion;
    }

}
