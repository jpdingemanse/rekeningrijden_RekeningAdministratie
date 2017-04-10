/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RateDAO;
import domain.Rate;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ruthgervandeneikhof
 */
@Stateless
public class RateService {
    @Inject
    RateDAO rateDao;
    
    public Rate createNewRate(Rate rate){
        return rateDao.createNewRate(rate);
    }
    
    public List<Rate> getAllRates(){
        return rateDao.getAllRates();
    }
}
