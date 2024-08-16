package com.VoterApplication.VoterRegistration.Exceptions;

import com.VoterApplication.VoterRegistration.Enum.ResultCode;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AadharException extends RuntimeException{
     private final ResultCode resultCode;
    public AadharException(String message, ResultCode resultCode){
        super(message);

        this.resultCode = resultCode;
    }
}
