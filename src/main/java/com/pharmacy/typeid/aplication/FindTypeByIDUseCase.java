package com.pharmacy.typeid.aplication;

import java.util.Optional;

import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;

public class FindTypeByIDUseCase {
                private final TypeIDService typeIDService;

    public FindTypeByIDUseCase(TypeIDService typeIDService) {
        this.typeIDService = typeIDService;
    }

    public Optional<TypeID> findTypeById(int ID) {
        return typeIDService.findTypeById(ID);
    }
}
