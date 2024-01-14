package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.UserType;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.common.entities.ZonaSegura;
import com.ucab.cmcapp.logic.dtos.ZonaSeguraDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ZonaSeguraMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( ZonaSeguraMapper.class );

    public static ZonaSegura mapDtoToEntity(ZonaSeguraDto dto ) throws ParseException
    {
        ZonaSegura entity = EntityFactory.createZonaSegura(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_nombreZona( dto.get_nombre());

        if ( Objects.nonNull( dto.getUsuario() ) )
        {
            entity.setUsuario( UsuarioMapper.mapDtoToEntity( dto.getUsuario() ) );
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguraMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }


    public static ZonaSegura mapDtoToEntityInsert(ZonaSeguraDto dto ) throws ParseException
    {
        ZonaSegura entity = EntityFactory.createZonaSegura();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_nombreZona( dto.get_nombre());
        if ( Objects.nonNull( dto.getUsuario() ) )
        {
            entity.setUsuario( UsuarioMapper.mapDtoToEntity( dto.getUsuario() ) );
        }
        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguraMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static ZonaSeguraDto mapEntityToDto( ZonaSegura entity )
    {
        final ZonaSeguraDto dto = new ZonaSeguraDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_idZona());

        dto.set_nombre(  entity.get_nombreZona() );

        if(Objects.nonNull(entity.getUsuario()))
            dto.setUsuario( UsuarioMapper.mapEntityToDto( entity.getUsuario() ));

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguraMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static ZonaSegura mapDtoToEntity( long id )
    {
        ZonaSegura entity = EntityFactory.createZonaSegura( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in ZonaSeguraMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_idZona( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving ZonaSeguraMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }
    public static List<ZonaSeguraDto> mapListEntityToDto(List<ZonaSegura> entities) {
        List<ZonaSeguraDto> dtos = new ArrayList<>();
        for (ZonaSegura entity : entities) {
            dtos.add(mapEntityToDto(entity));
        }
        return dtos;
    }
    public static List<ZonaSeguraDto> mapEntityListToDtoList(List<ZonaSegura> entityList){
        List<ZonaSeguraDto> dtoList = new ArrayList<ZonaSeguraDto>();
        ZonaSeguraDto Zona_SeguraDto;

        for (ZonaSegura zonasSegura : entityList) {

            Zona_SeguraDto = new ZonaSeguraDto();
            Zona_SeguraDto.setId(zonasSegura.get_idZona());
            Zona_SeguraDto.set_nombre(zonasSegura.get_nombreZona());

            if (Objects.nonNull(zonasSegura.getUsuario()))
                Zona_SeguraDto.setUsuario(UsuarioMapper.mapEntityToDto(zonasSegura.getUsuario()));

            dtoList.add(Zona_SeguraDto);

        }

        return dtoList;
    }
    public static ZonaSegura mapDtoToEntityUsuarioId(long usuarioId){
        Usuario victima = new Usuario(usuarioId);
        ZonaSegura zonaSegura = EntityFactory.createZonaSegura();
        zonaSegura.setUsuario(victima);
        return zonaSegura;
    }
}

