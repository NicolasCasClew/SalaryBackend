package com.salary_tool.salary_backend.InfoUsers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface InfoUserRepository extends JpaRepository<InfoUser, UUID> {
}
