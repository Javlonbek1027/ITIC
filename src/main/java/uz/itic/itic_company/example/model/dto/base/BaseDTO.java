package uz.itic.itic_company.example.model.dto.base;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public abstract class BaseDTO<R> {
    protected R id;
    protected Timestamp createdAt;


}
