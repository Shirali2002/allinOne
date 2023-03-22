package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.City;
import com.all.in.one.allinOne.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

    Currency findByCurrencyCode(Integer code);

}
