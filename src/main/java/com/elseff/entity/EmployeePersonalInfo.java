package com.elseff.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@Builder
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EmployeePersonalInfo {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Override
    public String toString() {
        return "EmployeePersonalInfo{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + new SimpleDateFormat("yyyy-MM-dd")
                .format(dateOfBirth) + '\'' + '}';
    }
}
