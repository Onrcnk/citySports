package com.onrcnk.citysports.converters;

import com.onrcnk.citysports.commands.SportCenterCommand;
import com.onrcnk.citysports.domain.Facility;
import com.onrcnk.citysports.domain.SportCenter;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class SportCenterToSportCenterCommand implements Converter<SportCenter, SportCenterCommand> {

    @Synchronized
    @Nullable
    @Override
    public SportCenterCommand convert(SportCenter source) {
        if (source == null) {
            return null;
        }

        final SportCenterCommand sportCenterCommand = new SportCenterCommand();

        sportCenterCommand.setId(source.getSportsCenterId());
        sportCenterCommand.setSportCenterName(source.getSportCenterName());

        return sportCenterCommand;
    }
}
