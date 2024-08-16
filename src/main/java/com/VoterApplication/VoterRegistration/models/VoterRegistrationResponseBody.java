package com.VoterApplication.VoterRegistration.models;

import com.VoterApplication.VoterRegistration.Enum.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class VoterRegistrationResponseBody<T> {

    private ResultCode statusCode;
    private  String message;
    private  T data;
    private  ZonedDateTime zonedDateTime;
}
