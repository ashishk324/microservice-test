package com.microservices.demo.dbservice.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.demo.dbservice.domain.Quote;

public interface QuotesRepository extends JpaRepository<Quote, Integer>{

	List<Quote> findByUserName(String username);
}
