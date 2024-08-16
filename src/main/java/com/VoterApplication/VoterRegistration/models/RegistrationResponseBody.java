package com.VoterApplication.VoterRegistration.models;

import com.VoterApplication.VoterRegistration.Enum.ResultCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.ZonedDateTime;
@Setter
@Getter
@ToString
public class RegistrationResponseBody<T> {
    private T data;
    private String message;
    private ZonedDateTime zonedDateTime;
    private ResultCode resultCode;

}
