package uz.itic.itic_company.example.model.exaptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorCodeMsg {
    private String errorCode;
    private String message;
}
