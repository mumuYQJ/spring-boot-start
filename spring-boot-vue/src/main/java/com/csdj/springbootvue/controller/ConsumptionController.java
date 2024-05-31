package com.csdj.springbootvue.controller;

import com.csdj.springbootvue.pojo.Consumption;
import com.csdj.springbootvue.service.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/consumption")
@Controller
@CrossOrigin
public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;

    @GetMapping
    @ResponseBody
    public List<Consumption> list() {
        return consumptionService.consumptions();
    }

    @PostMapping("/add")
    public String add(@RequestBody Consumption consumption) {
        consumptionService.add(consumption);
        return "redirect:/consumption";
    }

    @GetMapping("/delete")
    public String delete(String id) {
        consumptionService.delete(id);
        return "forward:/consumption";
    }
}
