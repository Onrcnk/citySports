package com.onrcnk.citysports.converters;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Facility;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FacilityCommandToFacility implements Converter<FacilityCommand, Facility> {

    @Synchronized
    @Nullable
    @Override
    public Facility convert(FacilityCommand source) {
        if (source == null) {
            return null;
        }

        final Facility facility = new Facility();
        facility.setFacilityId(source.getId());
        facility.setFacilityName(source.getFacilityName());
        return facility;
    }
}
