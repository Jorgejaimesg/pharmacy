package com.pharmacy.typeid.aplication;

import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;

public class DeleteTypeIDUseCase {
    private final TypeIDService typeIDService;

    public DeleteTypeIDUseCase(TypeIDService typeIDService){
        this.typeIDService = typeIDService;
    }

    public TypeID execute(String Name) {
        return typeIDService.deleteTypeID(Name);
    }
}
