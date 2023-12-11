package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(UsuarioMapper.class);

    public static Usuario mapDtoToEntity(UsuarioDto dto) throws ParseException {
        Usuario entity = EntityFactory.createUsuario();

        entity.set_id(dto.getId());
        entity.set_username(dto.get_username());
        entity.set_estatus(dto.get_estatus());
        entity.set_nombre(dto.get_nombre());
        entity.set_apellido(dto.get_apellido());
        entity.set_correo(dto.get_correo());
        entity.set_IMEI(dto.get_IMEI());

        return entity;
    }

    public static UsuarioDto mapEntityToDto(Usuario entity) {
        final UsuarioDto dto = new UsuarioDto();


        dto.setId(entity.get_id());
        dto.set_username(entity.get_username());
        dto.set_nombre(entity.get_nombre());
        dto.set_estatus(entity.get_estatus());
        dto.set_apellido(entity.get_apellido());
        dto.set_correo(entity.get_correo());
        dto.set_IMEI(entity.get_IMEI());

        return dto;
    }

    public static Usuario mapDtoToEntity(long id) {
        Usuario entity = EntityFactory.createUsuario(id);
        entity.set_id(id);
        return entity;
    }

    public static List<UsuarioDto> mapEntityListToDtoList(List<Usuario> entityList){
        List<UsuarioDto> dtoList = new ArrayList<UsuarioDto>();
        UsuarioDto usuarioDto;

        for (Usuario usuario : entityList) {
            usuarioDto = new UsuarioDto();
            usuarioDto.setId(usuario.get_id());
            usuarioDto.set_username(usuario.get_username());
            usuarioDto.set_estatus(usuario.get_estatus());
            usuarioDto.set_nombre(usuario.get_nombre());
            usuarioDto.set_apellido(usuario.get_apellido());
            usuarioDto.set_correo(usuario.get_correo());
            usuarioDto.set_IMEI(usuario.get_IMEI());


            dtoList.add(usuarioDto);
        }

        return dtoList;
    }

    public static Usuario mapDtoToEntityCorreo(String email) {
        Usuario entity = EntityFactory.createUsuario();
        entity.set_correo(email);
        return entity;
    }

    public static Usuario mapDtoToEntityUsername(String username){
        Usuario entity = EntityFactory.createUsuario();
        entity.set_username(username);
        return entity;
    }

    public static Usuario mapDtoToEntityIMEI(String imei) {
        Usuario entity = EntityFactory.createUsuario();
        entity.set_IMEI(imei);
        return entity;
    }

}
