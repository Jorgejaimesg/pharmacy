package com.pharmacy.typeid.domain.service;

import java.util.List;
import java.util.Optional;

import com.pharmacy.typeid.domain.entity.TypeID;

public interface TypeIDService {
        void createTypeID(TypeID typeID);
        TypeID deleteTypeID(String name);
        Optional<TypeID> findTypeByName (String Name);
        Optional<TypeID> findTypeById(int ID);
        List<TypeID> findAllTypeID();
}
