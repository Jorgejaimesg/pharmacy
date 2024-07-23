package com.pharmacy.typeid.domain.entity;

public class TypeID {
    private int ID;
    private String type;
    public TypeID() {
    }
    public TypeID(int iD, String type) {
        ID = iD;
        this.type = type;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void startType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startType'");
    }

    


}
