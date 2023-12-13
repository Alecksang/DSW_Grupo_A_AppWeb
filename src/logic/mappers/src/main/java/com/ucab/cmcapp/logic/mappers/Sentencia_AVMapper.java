package com.ucab.cmcapp.logic.mappers;


import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Sentencia_AV;
import com.ucab.cmcapp.logic.dtos.Sentencia_AVDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sentencia_AVMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(Sentencia_AVMapper.class);

    public static Sentencia_AV mapDtoToEntity(Sentencia_AVDto dto) throws ParseException {
        Sentencia_AV entity = EntityFactory.createSentencia_AV();

        entity.set_id(dto.getId());
        entity.set_distancia(dto.get_distancia());

        if ( Objects.nonNull( dto.get_victima() ) ) {
            entity.set_victima( VictimaMapper.mapDtoToEntity( dto.get_victima() ) );
        }

        if ( Objects.nonNull( dto.get_agresor() ) ) {
            entity.set_agresor(AgresorMapper.mapDtoToEntity( dto.get_agresor() ) );
        }



        return entity;
    }

    public static Sentencia_AVDto mapEntityToDto(Sentencia_AV entity) {
        final Sentencia_AVDto dto = new Sentencia_AVDto();


        dto.setId(entity.get_id());
        dto.set_distancia(entity.get_distancia());

        if(Objects.nonNull(entity.get_victima()))
            dto.set_victima( VictimaMapper.mapEntityToDto( entity.get_victima()));

        if(Objects.nonNull(entity.get_agresor()))
            dto.set_agresor( AgresorMapper.mapEntityToDto( entity.get_agresor()));

        return dto;
    }

    public static Sentencia_AV mapDtoToEntity(long id) {
        Sentencia_AV entity = EntityFactory.createSentencia_AV(id);
        entity.set_id(id);
        return entity;
    }

    public static List<Sentencia_AVDto> mapEntityListToDtoList(List<Sentencia_AV> entityList){
        List<Sentencia_AVDto> dtoList = new ArrayList<Sentencia_AVDto>();
        Sentencia_AVDto Sentencia_AVDto;

        for (Sentencia_AV relacionSentencia : entityList) {

            Sentencia_AVDto = new Sentencia_AVDto();
            Sentencia_AVDto.setId(relacionSentencia.get_id());
            Sentencia_AVDto.set_distancia(relacionSentencia.get_distancia());

            if (Objects.nonNull(relacionSentencia.get_victima()))
                Sentencia_AVDto.set_victima(VictimaMapper.mapEntityToDto(relacionSentencia.get_victima()));

            if (Objects.nonNull(relacionSentencia.get_agresor()))
                Sentencia_AVDto.set_agresor(AgresorMapper.mapEntityToDto(relacionSentencia.get_agresor()));


            dtoList.add(Sentencia_AVDto);

        }

        return dtoList;
    }

}