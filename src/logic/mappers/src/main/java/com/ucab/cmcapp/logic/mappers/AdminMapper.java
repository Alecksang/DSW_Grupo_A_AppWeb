package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Admin;
import com.ucab.cmcapp.logic.dtos.AdminDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class AdminMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(AdminMapper.class);

    public static Admin mapDtoToEntity(AdminDto dto) throws ParseException {
        Admin entity = EntityFactory.createAdmin();

        _logger.debug( "Tomar en AdminMapper.mapDtoToEntity: dto {}", dto );

        entity.set_id(dto.getId());
        entity.set_username(dto.get_username());
        entity.set_correo(dto.get_correo());
        entity.set_password(dto.get_password());

        return entity;
    }

    public static AdminDto mapEntityToDto(Admin entity) {
        final AdminDto dto = new AdminDto();

        _logger.debug( "Tomar en AdminMapper.mapEntityToDto: entity {}", entity );

        dto.setId(entity.get_id());
        dto.set_username(entity.get_username());
        dto.set_correo(entity.get_correo());
        dto.set_password(entity.get_password());

        return dto;
    }

    public static Admin mapDtoToEntity(long id) {
        Admin entity = EntityFactory.createAdmin(id);

        _logger.debug( "Tomar en AdminMapper.mapDtoToEntity: id {}", id );

        entity.set_id(id);
        return entity;
    }

    public static List<AdminDto> mapEntityListToDtoList(List<Admin> entityList){
        List<AdminDto> dtoList = new ArrayList<AdminDto>();
        AdminDto AdminDto;

        _logger.debug( "Tomar en AdminMapper.mapEntityListToDtoList: entityList {}", entityList );

        for (Admin Admin : entityList) {
            AdminDto = new AdminDto();
            AdminDto.setId(Admin.get_id());
            AdminDto.set_username(Admin.get_username());
            AdminDto.set_correo(Admin.get_correo());
            AdminDto.set_password(Admin.get_password());
            dtoList.add(AdminDto);
        }

        return dtoList;
    }

    public static Admin mapDtoToEntityCorreo(String email) {
        Admin entity = EntityFactory.createAdmin();

        _logger.debug( "Tomar en AdminMapper.mapDtoToEntityCorreo: email {}", email );

        entity.set_correo(email);
        return entity;
    }

    public static Admin mapDtoToEntityUsername(String username){
        Admin entity = EntityFactory.createAdmin();

        _logger.debug( "Tomar en AdminMapper.mapDtoToEntityUsername: username {}", username );

        entity.set_username(username);
        return entity;
    }

}
