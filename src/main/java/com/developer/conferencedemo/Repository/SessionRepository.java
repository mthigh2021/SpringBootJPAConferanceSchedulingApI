package com.developer.conferencedemo.Repository;

import com.developer.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long>
{



}
