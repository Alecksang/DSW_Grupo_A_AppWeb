package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Alerta;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.logic.dtos.AlertaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlertaMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( AlertaMapper.class );

    public static Alerta mapDtoToEntity(AlertaDto dto ) throws ParseException
    {
        Alerta entity = EntityFactory.createAlerta(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_alertaTipo( dto.get_alertaTipo());
        entity.set_alertaFechaHora(dto.get_alertaFechaHora());

        if ( Objects.nonNull( dto.get_usuario() ) )
        {
            entity.set_victima( UsuarioMapper.mapDtoToEntity( dto.get_usuario() ) );
        }


        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Alerta mapDtoToEntityInsert(AlertaDto dto ) throws ParseException
    {
        Alerta entity = EntityFactory.createAlerta();

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_alertaTipo( dto.get_alertaTipo());
        entity.set_alertaFechaHora(dto.get_alertaFechaHora());
        if ( Objects.nonNull( dto.get_usuario() ) )
        {
            entity.set_victima( UsuarioMapper.mapDtoToEntity( dto.get_usuario() ) );
        }



        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static AlertaDto mapEntityToDto( Alerta entity )
    {
        final AlertaDto dto = new AlertaDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_alertaId());

        dto.set_alertaTipo(  entity.get_alertaTipo() );
        dto.set_alertaFechaHora( entity.get_alertaFechaHora() );

        if(Objects.nonNull(entity.get_victima()))
            dto.set_usuario( UsuarioMapper.mapEntityToDto( entity.get_victima() ));


        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Alerta mapDtoToEntity( long id )
    {
        Alerta entity = EntityFactory.createAlerta( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_alertaId( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Alerta mapDtoToEntityTipoAlerta( String TipoAlerta )
    {
        Alerta entity = EntityFactory.createAlerta();

        //region Instrumentation DEBUG
        _logger.debug( "Get in AlertaMapper.mapDtoToEntityEmail: email {}", TipoAlerta );
        //endregion

        entity.set_alertaTipo( TipoAlerta );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving AlertaMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }

    public static List<Alerta> mapDtosToEntities(List<AlertaDto> dtos) throws ParseException {
        List<Alerta> entities = new ArrayList<>();

        for (AlertaDto dto : dtos) {
            entities.add(mapDtoToEntity(dto));
        }

        return entities;
    }

    public static List<AlertaDto> mapEntitiesToDtos(List<Alerta> entities) {
        List<AlertaDto> dtos = new ArrayList<>();

        for (Alerta entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }

        return dtos;
    }


}
