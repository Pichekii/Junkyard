/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pichekiink.javaeexample.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

/**
 *
 * @author Scott
 */
@Singleton
public class TimerClass {
    
    @Schedule(second = "0", minute = "*", hour = "*", dayOfWeek = "*", dayOfMonth = "*", month = "*", year = "*", persistent = true)
    public void scheduledJob() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();        
        System.out.println(dateFormat.format(date));
    }
}
