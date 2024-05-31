package com.csdj.springbootvue.service;

import com.csdj.springbootvue.pojo.Consumption;

import java.util.List;

public interface ConsumptionService {

    List<Consumption> consumptions();

    int add(Consumption consumption);

    int delete(String id);
}
