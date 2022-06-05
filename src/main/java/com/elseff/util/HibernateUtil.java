package com.elseff.util;

import com.elseff.entity.Company;
import com.elseff.entity.CompanyCar;
import com.elseff.entity.Employee;
import com.elseff.entity.EmployeePersonalInfo;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Create session with hibernate.cfg.xml
 */
@UtilityClass
public class HibernateUtil {
    public static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        //adding mapping for classes
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(EmployeePersonalInfo.class);
        configuration.addAnnotatedClass(CompanyCar.class);
        configuration.configure();
        return configuration.buildSessionFactory();
    }
}
