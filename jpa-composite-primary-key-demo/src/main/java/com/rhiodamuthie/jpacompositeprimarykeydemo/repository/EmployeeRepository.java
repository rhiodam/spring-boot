package com.rhiodamuthie.jpacompositeprimarykeydemo.repository;

import com.rhiodamuthie.jpacompositeprimarykeydemo.model.Employee;
import com.rhiodamuthie.jpacompositeprimarykeydemo.model.EmployeeIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {
    /*
           Spring Data JPA will automatically parse this method name
           and create a query from it
        */
    List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}