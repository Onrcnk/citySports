package com.onrcnk.citysports.converters;

import com.onrcnk.citysports.commands.FacilityCommand;
import com.onrcnk.citysports.domain.Branch;
import com.onrcnk.citysports.domain.Facility;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class FacilityToFacilityCommand implements Converter<Facility, FacilityCommand> {

    @Synchronized
    @Nullable
    @Override
    public FacilityCommand convert(Facility source) {
        if (source == null) {
            return null;
        }

        final FacilityCommand facilityCommand = new FacilityCommand();

        facilityCommand.setId(source.getFacilityId());
        facilityCommand.setFacilityName(source.getFacilityName());

        for(Branch branch : source.getBranchSet()){
            facilityCommand.setBranchNames((facilityCommand.getBranchNames().isEmpty() ? "" : facilityCommand.getBranchNames() + " : " )+ branch.getBranchName());
        }

        return facilityCommand;
    }
}
