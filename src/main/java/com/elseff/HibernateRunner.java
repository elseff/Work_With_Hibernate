package com.elseff;

import com.elseff.entity.dao.CompanyDao;
import com.elseff.entity.dao.CompanyDaoImpl;
import com.elseff.entity.dao.EmployeeDao;
import com.elseff.entity.dao.EmployeeDaoImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HibernateRunner {
    static CompanyDao companyDao = new CompanyDaoImpl();
    static EmployeeDao employeeDao = new EmployeeDaoImpl();

    public static void main(String[] args) {

    }
}
