package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.Sentencia;
import com.ucab.cmcapp.common.entities.User;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.SentenciaDto;
import com.ucab.cmcapp.logic.dtos.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SentenciaMapper extends BaseMapper
{
    private static Logger _logger = LoggerFactory.getLogger( SentenciaMapper.class );

    public static Sentencia mapDtoToEntity(SentenciaDto dto ) throws ParseException
    {
        Sentencia entity = EntityFactory.createSentencia(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_distanciaMinima( dto.get_distanciaMinima() );
        entity.set_tiempo_control( dto.get_tiempo_control() );


        //AQUI VA LA EL OBJETO DE LA TABLA RELACIONADA
        if ( Objects.nonNull( dto.get_agresor() ) )
        {
            entity.set_agresor( UsuarioMapper.mapDtoToEntity( dto.get_agresor() ) );
        }

        if ( Objects.nonNull( dto.get_victima() ) )
        {
            entity.set_victima( UsuarioMapper.mapDtoToEntity( dto.get_victima() ) );
        }




        //region Instrumentation DEBUG
        _logger.debug( "Leaving SentenciaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Sentencia mapDtoToEntityInsert(SentenciaDto dto ) throws ParseException
    {
        Sentencia entity = EntityFactory.createSentencia();

        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.set_distanciaMinima( dto.get_distanciaMinima() );
        entity.set_tiempo_control( dto.get_tiempo_control() );

        if ( Objects.nonNull( dto.get_agresor() ) )
        {
            entity.set_agresor( UsuarioMapper.mapDtoToEntity( dto.get_agresor() ) );
        }

        if ( Objects.nonNull( dto.get_victima() ) )
        {
            entity.set_victima( UsuarioMapper.mapDtoToEntity( dto.get_victima() ) );
        }


        //region Instrumentation DEBUG
        _logger.debug( "Leaving SentenciaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static SentenciaDto mapEntityToDto( Sentencia entity )
    {
        final SentenciaDto dto = new SentenciaDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.get_IdAlej());
        dto.set_distanciaMinima(  entity.get_distanciaMinima() );
        dto.set_tiempo_control(  entity.get_tiempo_control() );

        //AQUI VA LA EL OBJETO DE LA TABLA RELACIONADA

        if(Objects.nonNull(entity.get_victima()))
            dto.set_victima( UsuarioMapper.mapEntityToDto( entity.get_victima() ));

        if(Objects.nonNull(entity.get_agresor()))
            dto.set_agresor( UsuarioMapper.mapEntityToDto( entity.get_agresor() ));


        //region Instrumentation DEBUG
        _logger.debug( "Leaving SentenciaMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Sentencia mapDtoToEntity( long id )
    {
        Sentencia entity = EntityFactory.createSentencia( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.set_IdAlej( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving SentenciaMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Sentencia mapDtoToEntityUsuarios( Usuario Victima, Usuario Agresor )
    {
        Sentencia entity = EntityFactory.createSentencia();

        //region Instrumentation DEBUG
        _logger.debug( "Get in SentenciaMapper.mapDtoToEntityEmail: email" );
        //endregion
//si te da algun error el crud comenta las dos lineas de abajo

        entity.set_agresor( Agresor );
        entity.set_victima( Victima );



        //region Instrumentation DEBUG
        _logger.debug( "Leaving SentenciaMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }

    public static List<SentenciaDto> mapEntityListToDtoList(List<Sentencia> entityList){
        List<SentenciaDto> dtoList = new ArrayList<SentenciaDto>();
        SentenciaDto SentenciaDto;

        for (Sentencia relacionUsuario : entityList) {

            SentenciaDto = new SentenciaDto();
            SentenciaDto.setId(relacionUsuario.get_IdAlej());
            SentenciaDto.set_distanciaMinima(relacionUsuario.get_distanciaMinima());

            if (Objects.nonNull(relacionUsuario.get_victima()))
                SentenciaDto.set_victima(UsuarioMapper.mapEntityToDto(relacionUsuario.get_victima()));


            if (Objects.nonNull(relacionUsuario.get_agresor()))
                SentenciaDto.set_agresor(UsuarioMapper.mapEntityToDto(relacionUsuario.get_agresor()));


            dtoList.add(SentenciaDto);

        }

        return dtoList;
    }

}
