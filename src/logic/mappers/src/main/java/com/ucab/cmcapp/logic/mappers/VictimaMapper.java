package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Victima;
import com.ucab.cmcapp.logic.dtos.VictimaDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class VictimaMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(VictimaMapper.class);
    public static Victima mapDtoToEntity(VictimaDto dto) throws ParseException {
        Victima entity = EntityFactory.createVictima();

        entity.set_id(dto.getId());

        if ( Objects.nonNull( dto.get_usuario() ) ) {
            entity.set_usuario( UsuarioMapper.mapDtoToEntity( dto.get_usuario() ) );
        }

        return entity;
    }
    public static VictimaDto mapEntityToDto(Victima entity) {
        final VictimaDto dto = new VictimaDto();


        dto.setId(entity.get_id());

        if(Objects.nonNull(entity.get_usuario()))
            dto.set_usuario( UsuarioMapper.mapEntityToDto( entity.get_usuario()));

        return dto;
    }
    public static Victima mapDtoToEntity(long id) {
        Victima entity = EntityFactory.createVictima(id);
        entity.set_id(id);
        return entity;
    }
    public static List<VictimaDto> mapEntityListToDtoList(List<Victima> entityList){
        List<VictimaDto> dtoList = new ArrayList<VictimaDto>();
        VictimaDto Usuario_VictimaDto;

        for (Victima victimaUsuario : entityList) {

            Usuario_VictimaDto = new VictimaDto();
            Usuario_VictimaDto.setId(victimaUsuario.get_id());

            if (Objects.nonNull(victimaUsuario.get_usuario()))
                Usuario_VictimaDto.set_usuario(UsuarioMapper.mapEntityToDto(victimaUsuario.get_usuario()));

            dtoList.add(Usuario_VictimaDto);

        }
        return dtoList;
    }
}
