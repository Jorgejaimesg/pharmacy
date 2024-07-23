package com.pharmacy.typeid.aplication;

import java.util.List;

import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;

public class FindAllTypeIDUseCase {
    private final TypeIDService typeIDService;

    public FindAllTypeIDUseCase(TypeIDService typeIDService){
        this.typeIDService = typeIDService;
    }

        public List<TypeID> findAllTypeID() {
        return typeIDService.findAllTypeID();
    }
}
