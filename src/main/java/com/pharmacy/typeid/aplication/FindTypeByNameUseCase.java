package com.pharmacy.typeid.aplication;

import java.util.Optional;

import com.pharmacy.typeid.domain.entity.TypeID;
import com.pharmacy.typeid.domain.service.TypeIDService;

public class FindTypeByNameUseCase {
            private final TypeIDService typeIDService;

    public FindTypeByNameUseCase(TypeIDService typeIDService) {
        this.typeIDService = typeIDService;
    }

    public Optional<TypeID> findTypeByName(String typeName) {
        return typeIDService.findTypeByName(typeName);
    }
}
