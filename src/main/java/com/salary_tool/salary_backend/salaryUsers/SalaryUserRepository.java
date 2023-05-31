package com.salary_tool.salary_backend.salaryUsers;

import com.salary_tool.salary_backend.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface SalaryUserRepository extends JpaRepository<SalaryUser, UUID> {
     //List<SalaryUser> findById(String id);
}
