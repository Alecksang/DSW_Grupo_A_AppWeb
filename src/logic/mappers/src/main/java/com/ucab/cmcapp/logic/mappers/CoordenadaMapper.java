package com.ucab.cmcapp.logic.mappers;

import com.ucab.cmcapp.common.EntityFactory;
import com.ucab.cmcapp.common.entities.Coordenada;
import com.ucab.cmcapp.common.entities.Usuario;
import com.ucab.cmcapp.logic.dtos.CoordenadaDto;
import com.ucab.cmcapp.logic.dtos.UsuarioDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CoordenadaMapper extends BaseMapper {
    private static Logger _logger = LoggerFactory.getLogger(CoordenadaMapper.class);

    public static Coordenada mapDtoToEntity(CoordenadaDto dto) throws ParseException {
        Coordenada entity = EntityFactory.createCoordenada();

        entity.set_id(dto.getId());
        entity.set_latitudY(dto.get_latitudY());
        entity.set_longitudX(dto.get_longitudX());


        if ( Objects.nonNull( dto.get_zona_segura() ) ) {
            entity.set_zona_segura( ZonaSeguraMapper.mapDtoToEntity( dto.get_zona_segura() ) );
        }

        return entity;
    }

    public static CoordenadaDto mapEntityToDto(Coordenada entity) {
        final CoordenadaDto dto = new CoordenadaDto();


        dto.setId(entity.get_id());
        dto.set_latitudY(entity.get_latitudY());
        dto.set_longitudX(entity.get_longitudX());

        if ( Objects.nonNull( entity.get_zona_segura() ) )
            dto.set_zona_segura( ZonaSeguraMapper.mapEntityToDto( entity.get_zona_segura() ) );

        return dto;
    }

    public static Coordenada mapDtoToEntity(long id) {
        Coordenada entity = EntityFactory.createCoordenada(id);
        entity.set_id(id);
        return entity;
    }

    public static List<CoordenadaDto> mapEntityListToDtoList(List<Coordenada> entityList){
        List<CoordenadaDto> dtoList = new ArrayList<CoordenadaDto>();
        CoordenadaDto coordenadaDto;

        for (Coordenada coordenada : entityList) {
            coordenadaDto = new CoordenadaDto();
            coordenadaDto.setId(coordenada.get_id());
            coordenadaDto.set_latitudY(coordenada.get_latitudY());
            coordenadaDto.set_longitudX(coordenada.get_longitudX());

            if ( Objects.nonNull( coordenada.get_zona_segura() ) )
                coordenadaDto.set_zona_segura( ZonaSeguraMapper.mapEntityToDto( coordenada.get_zona_segura() ) );

            dtoList.add(coordenadaDto);
        }

        return dtoList;
    }

}
