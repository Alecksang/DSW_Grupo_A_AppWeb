package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Agresor;
import com.ucab.cmcapp.logic.dtos.AgresorDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AgresorMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(AgresorMapper.class);

    public static Agresor mapDtoToEntity(AgresorDto dto) throws ParseException {
        Agresor entity = EntityFactory.createAgresor();

        entity.set_id(dto.getId());

        if ( Objects.nonNull( dto.get_usuario() ) ) {
            entity.set_usuario( UsuarioMapper.mapDtoToEntity( dto.get_usuario() ) );
        }

        return entity;
    }

    public static AgresorDto mapEntityToDto(Agresor entity) {
        final AgresorDto dto = new AgresorDto();


        dto.setId(entity.get_id());

        if(Objects.nonNull(entity.get_usuario()))
            dto.set_usuario( UsuarioMapper.mapEntityToDto( entity.get_usuario()));

        return dto;
    }

    public static Agresor mapDtoToEntity(long id) {
        Agresor entity = EntityFactory.createAgresor(id);
        entity.set_id(id);
        return entity;
    }

    public static List<AgresorDto> mapEntityListToDtoList(List<Agresor> entityList){
        List<AgresorDto> dtoList = new ArrayList<AgresorDto>();
        AgresorDto Usuario_AtacanteDto;

        for (Agresor atacanteUsuario : entityList) {

            Usuario_AtacanteDto = new AgresorDto();
            Usuario_AtacanteDto.setId(atacanteUsuario.get_id());

            if (Objects.nonNull(atacanteUsuario.get_usuario()))
                Usuario_AtacanteDto.set_usuario(UsuarioMapper.mapEntityToDto(atacanteUsuario.get_usuario()));

            dtoList.add(Usuario_AtacanteDto);

        }

        return dtoList;
    }

}
