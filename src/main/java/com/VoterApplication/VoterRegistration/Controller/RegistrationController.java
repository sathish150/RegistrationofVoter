package com.VoterApplication.VoterRegistration.Controller;
import com.VoterApplication.VoterRegistration.Entity.RegistrationEntity;
import com.VoterApplication.VoterRegistration.Service.RegistrationService;
import com.VoterApplication.VoterRegistration.models.VoterRegistrationResponseBody;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
   public RegistrationService registrationService;

    @PostMapping("/save")
    public VoterRegistrationResponseBody saveRegistration(@RequestBody RegistrationEntity registrationEntity) {
        return  registrationService.save(registrationEntity);
    }
    @GetMapping(value = "/fetch/{aadharNumber}")
    public VoterRegistrationResponseBody fetchDataWithAdhar(@PathVariable String aadharNumber){
        return registrationService.toCheckDataPresentInDataBaseOrNot(aadharNumber);
    }
    @PostMapping("/saveAll")
    public List<VoterRegistrationResponseBody> saveAll(@RequestBody List<RegistrationEntity> list){
        return registrationService.saveAll(list);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }


}
