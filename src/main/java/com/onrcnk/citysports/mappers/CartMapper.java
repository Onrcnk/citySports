package com.onrcnk.citysports.mappers;

import com.onrcnk.citysports.commands.CartCommand;
import com.onrcnk.citysports.commands.ReservationCommand;
import com.onrcnk.citysports.domain.Cart;
import com.onrcnk.citysports.domain.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    CartCommand cartToCartCommand(Cart cart);
}

