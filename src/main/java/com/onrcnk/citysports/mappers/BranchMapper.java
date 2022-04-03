package com.onrcnk.citysports.mappers;

import com.onrcnk.citysports.commands.BranchCommand;
import com.onrcnk.citysports.domain.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    @Mappings({
            @Mapping(target = "branchId", source = "branch.branchId")
    })
    BranchCommand branchToBranchComment(Branch branch);

}
