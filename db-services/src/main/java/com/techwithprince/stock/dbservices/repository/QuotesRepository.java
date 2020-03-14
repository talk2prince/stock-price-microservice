package com.techwithprince.stock.dbservices.repository;

import com.techwithprince.stock.dbservices.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuotesRepository extends JpaRepository<Quote,Integer> {
    List<Quote> findByUsername(String username);

}
