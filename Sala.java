package project;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Luis David
 */
public class Sala {
    private String id;
    private ArrayList<Date> timeslots;
    private ArrayList<Integer> duration;
    
    public Sala(String name){
        timeslots = new ArrayList<>();
        duration = new ArrayList<>();
        id = name;
    }
    
    public Sala(String name, int y, int m, int d, int h, int min, int dur){
        timeslots = new ArrayList<>();
        duration = new ArrayList<>();
        id = name;
        //turn into method↓
        Date dat = new Date(y, m, d, h, min);
        reserveSala(dat,dur);
    }
    
    public Sala(String name, ArrayList<Date> dt, ArrayList<Integer> dur){
        timeslots = new ArrayList<>();
        duration = new ArrayList<>();
        id = name;
        
        for (int i = 0; i < dt.size(); i++) {
            timeslots.add(dt.get(i));
            duration.add(dur.get(i));
        }
    }
    
    public boolean reserveSala(Date dt, int dur){
        if(this.isOccupied(dt,dur)){
            return false;
        }
        else{
            timeslots.add(dt);
            duration.add(dur);
        }
        return true;
    }
    
    /* CRITICAL if an exam terminates at the same time that another 
        starts it will not allow to reserve the Sala
        Example: exam1 terminates at 18:30 in Sala C51, exam2 starts at 18:30 same day
                exam2 cannot be made in C51
    */
    public boolean isOccupied(Date dt, int time){
        Date temp, comp, term;
        int dur;
        for (int i = 0; i < timeslots.size(); i++) {
            temp = timeslots.get(i);
            dur = duration.get(i);
            comp = new Date(temp.getYear(), temp.getMonth(), temp.getDate(), temp.getHours(), 
                    temp.getMinutes() + dur);
            term = new Date(dt.getYear(), dt.getMonth(), dt.getDate(), dt.getHours(), 
                    dt.getMinutes() + time);
            if(temp.equals(dt) || (temp.before(dt) && comp.after(dt))){
                return true;
            }
            else if(term.after(temp)){
                return true;
            }
        }
        
        return false;
    }
    
    public String getId(){
        return this.id;
    }
    
}
