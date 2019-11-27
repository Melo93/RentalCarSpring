package com.si2001.rentalcarspring.entities.mapper;

import com.si2001.rentalcarspring.entities.Utente;
import com.si2001.rentalcarspring.entities.Veicoli;
import com.si2001.rentalcarspring.entities.dto.EditProfileDTO;
import com.si2001.rentalcarspring.entities.dto.NewCarDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;

@Mapper
public interface MyMapper {

    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);

    @Mapping(target = "ruolo", ignore = true)
    EditProfileDTO UtenteToEditProfileDTO(Utente user) throws ParseException;

    @Mapping(target = "ruolo", ignore = true)
    Utente EditProfileDTOToUtente(EditProfileDTO edit) throws ParseException;

    @Mapping(target = "tipologia", ignore = true)
    Veicoli NewCarDTOToVeicoli(NewCarDTO car);

}
