package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuarios;
import com.ucab.cmcapp.logic.dtos.UserDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Objects;
public class UsuarioMapper extends BaseMapper {

    private static Logger _logger = LoggerFactory.getLogger( UsuarioMapper.class );

    public static Usuarios mapDtoToEntity(UsuarioDto dto ) throws ParseException
    {
        Usuarios entity = EntityFactory.createUsuario(dto.getId());

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuariorMapper.mapDtoToEntity: dto {}", dto );
        //endregion

        entity.setUsuarios_username( dto.getUsuarios_username() );
        entity.setUsuarios_Nombre(dto.getUsuarios_Nombre());
        entity.setUsuarios_Apellido( dto.getUsuarios_Apellido() );


        //if ( Objects.nonNull( dto.getUsuarioTypeDto() ) )
       // {
           // entity.set_userType( UserTypeMapper.mapDtoToEntity( dto.getUsuarioTypeDto() ) );
       // }

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static UsuarioDto mapEntityToDto( Usuarios entity )
    {
        final UsuarioDto dto = new UsuarioDto();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapEntityToDto: entity {}", entity );
        //endregion

        dto.setId( entity.getUsarios_ID());
        dto.setUsuarios_username(  entity.getUsuarios_username() );
        dto.setUsuarios_Nombre( entity.getUsuarios_Nombre() );
        //if(Objects.nonNull(entity.getUserType()))
            //dto.setUserTypeDto( UserTypeMapper.mapEntityToDto( entity.getUserType() ));

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UserMapper.mapEntityToDto: dto {}", dto );
        //endregion
        return dto;
    }

    public static Usuarios mapDtoToEntity( long id )
    {
        Usuarios entity = EntityFactory.createUsuario( id );

        //region Instrumentation DEBUG
        _logger.debug( "Get in UserMapper.mapDtoToEntity: id {}", id );
        //endregion

        entity.setUsarios_ID( id );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntity: entity {}", entity );
        //endregion

        return entity;
    }

    public static Usuarios mapDtoToEntityEmail( String usuarios_username )
    {
        Usuarios entity = EntityFactory.createUsuario();

        //region Instrumentation DEBUG
        _logger.debug( "Get in UsuarioMapper.mapDtoToEntityEmail: usuarios_username {}", usuarios_username );
        //endregion

        entity.setUsuarios_username( usuarios_username );

        //region Instrumentation DEBUG
        _logger.debug( "Leaving UsuarioMapper.mapDtoToEntityEmail: entity {}", entity );
        //endregion

        return entity;
    }

}




