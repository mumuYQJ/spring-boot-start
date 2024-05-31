package com.csdj.springbootvue.service.Impl;

import com.csdj.springbootvue.mapper.ConsumptionMapper;
import com.csdj.springbootvue.pojo.Consumption;
import com.csdj.springbootvue.service.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionServiceImpl implements ConsumptionService {

    @Autowired
    private ConsumptionMapper consumptionMapper;

    @Override
    public List<Consumption> consumptions() {
        return consumptionMapper.list();
    }

    @Override
    public int add(Consumption consumption) {
        return consumptionMapper.insertSelective(consumption);
    }

    @Override
    public int delete(String id) {
        return consumptionMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
