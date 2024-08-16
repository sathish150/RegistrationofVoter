package com.VoterApplication.VoterRegistration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class UserEntity {
@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private String email;
    private long phoneNumber;


//    public UserEntity(){
//
//    }
//
//    public UserEntity(String userName,String password,String email,long phoneNumber){
//        this.userName=userName;
//        this.password=password;
//        this.email=email;
//        this.phoneNumber=phoneNumber;
//    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
