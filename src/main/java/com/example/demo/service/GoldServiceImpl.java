package com.example.demo.service;

import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GoldServiceImpl implements GoldService{

    @Override
    public List<String> calculate(Double weight, Double karat) {
        double weightOfPureGold = weight*karat/1000;
        double weightOf24KGold = DoubleRounder.round(weightOfPureGold*1000/999,3);
        double weightOf18KGold = DoubleRounder.round(weightOfPureGold*1000/750,3);
        double weightOf14KGold = DoubleRounder.round(weightOfPureGold*1000/585,3);
        double weightOf8KGold = DoubleRounder.round(weightOfPureGold*1000/333,3);
        List<String> result = new ArrayList<>(Arrays.asList( "24K "+ weightOf24KGold + "g",
                "18K "+ weightOf18KGold + "g",
                "14K "+ weightOf14KGold + "g",
                "8K "+ weightOf8KGold +"g"));
        return result;
    }
}
