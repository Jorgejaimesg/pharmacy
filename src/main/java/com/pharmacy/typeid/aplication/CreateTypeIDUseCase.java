package com.pharmacy.typeid.aplication;

import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;

public class CreateTypeIDUseCase {
    private final TypeIDService typeIDService;

    public CreateTypeIDUseCase(TypeIDService typeIDService){
        this.typeIDService = typeIDService;
    }

    public void execute(TypeID typeID){
        typeIDService.createTypeID(typeID);
    }
}
