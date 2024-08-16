package com.VoterApplication.VoterRegistration.Service;
import com.VoterApplication.VoterRegistration.DAO.RegistrationRepository;
import com.VoterApplication.VoterRegistration.Entity.RegistrationEntity;
import com.VoterApplication.VoterRegistration.Enum.ResultCode;
import com.VoterApplication.VoterRegistration.Exceptions.AadharException;
import com.VoterApplication.VoterRegistration.models.VoterRegistrationResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationService {

    private static final String regex="^[2-9][0-9]{11}$";
    private static final String regex1="^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
    private static String validAdhar="";
    @Autowired
    public RegistrationRepository registrationRepository;
    public VoterRegistrationResponseBody save(RegistrationEntity registration){
        VoterRegistrationResponseBody response;
        validAdhar= isItValideAdharNumber(registration.getAadharNumber());
        response=toCheckDataPresentInDataBaseOrNot(validAdhar);
        if(response.getStatusCode().equals(ResultCode.Not_Exists)){
            registration.setAadharNumber(validAdhar);
//            registration.setZonedDateTime(ZonedDateTime.now(ZoneId.of("Asia/Kolkata")));
            RegistrationEntity result=registrationRepository.save(registration);
            response.setData(result);
            response.setStatusCode(ResultCode.Success);
            response.setMessage("Save the data in database with adharNumber:"+validAdhar);
            response.setZonedDateTime(result.getZonedDateTime());
            return response;
        }
        return response;
    }
    public static String  isItValideAdharNumber( String aadharNumber){
        if(aadharNumber !=null && aadharNumber.matches(regex)){
            validAdhar=aadharNumber.substring(0,4)+" "+aadharNumber.substring(4,8)+" "+aadharNumber.substring(8,12);
            System.out.println(validAdhar);
        }
        else if (aadharNumber !=null && aadharNumber.matches(regex1)) {
            validAdhar=aadharNumber;

        } else{
            throw new AadharException("Check the format of adhar number with length of  12 digits which is start with any one of the number strats from 2 to 9:"+aadharNumber, ResultCode.INVALID_AADHAR_NUMBER);
        }
        return validAdhar;
    }
    public VoterRegistrationResponseBody toCheckDataPresentInDataBaseOrNot(String aadharNumber){
         VoterRegistrationResponseBody response=new VoterRegistrationResponseBody();
         validAdhar=isItValideAdharNumber(aadharNumber);
        Optional<RegistrationEntity> result=registrationRepository.findByAadharNumber(validAdhar);
        if(result.isPresent()){
            response.setData(result);
            response.setStatusCode(ResultCode.Already_Exists);
            response.setZonedDateTime(result.get().getZonedDateTime());
            response.setMessage("The adhar which is entered is alredy present in database with adhar:"+validAdhar);
        }else {
           response.setMessage("Please  save data in database:");
           response.setStatusCode(ResultCode.Not_Exists);

        }
           return response;
    }
    public List<VoterRegistrationResponseBody> saveAll(List<RegistrationEntity> list){
        return list.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }


}
