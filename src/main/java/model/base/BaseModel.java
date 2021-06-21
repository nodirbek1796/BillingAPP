package model.base;

import java.util.UUID;

public class BaseModel {
    protected UUID id;
    protected String name;

    public BaseModel(String name) {
        this.name = name;
    }

    public BaseModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
