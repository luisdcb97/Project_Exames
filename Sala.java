package project;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 * @author Kwinten Jacobs
 * @author Luis David
 *
 * @version 0.2
 */
public class Sala implements Serializable{
    private static final long serialVersionUID = 513L;
    private String id;
    private ArrayList<Date> timeslots;
    private ArrayList<Integer> duration;
    
    // <editor-fold defaultstate="collapsed" desc="Color variables">
    // final makes the value unchangeable
    // static means all instances share the same variable instead of creating a copy for themselves
    // \n funciona como ANSI_RESET
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    
    private static final String ANSI_BLACK_BKG = "\u001B[40m";
    private static final String ANSI_RED_BKG = "\u001B[41m";
    private static final String ANSI_GREEN_BKG = "\u001B[42m";
    private static final String ANSI_YELLOW_BKG = "\u001B[43m";
    private static final String ANSI_BLUE_BKG = "\u001B[44m";
    private static final String ANSI_PURPLE_BKG = "\u001B[45m";
    private static final String ANSI_CYAN_BKG = "\u001B[46m";
    private static final String ANSI_WHITE_BKG = "\u001B[47m";
    //</editor-fold>
    
    public Sala(String name){
        this.timeslots = new ArrayList<>();
        this.duration = new ArrayList<>();
        this.id = name;
    }
    
    public Sala(String name, int d, int m, int y, int h, int min, int dur){
        this.timeslots = new ArrayList<>();
        this.duration = new ArrayList<>();
        this.id = name;
        
        int data[];
        
        data = checkArguments(d, m, y, h, min);
        
        String str = "";
        str += data[0] + "-";
        str += data[1] + "-";
        str += data[2];
        str += " at ";
        str += data[3] + ":";
        str += data[4];
        
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
        Date temp = null;
        try {
            temp = format1.parse(str);
        } catch (ParseException ex) {
            ex.printStackTrace();
            System.out.println("Error parsing string into date");
        }

        reserveSala(temp, dur);
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
    
    /**Attempts to reserve the sala on date dt for timespan dur and if this is the case, reserves the sala on this date for that timespan
     * @param dt The date of the reservation
     * @param dur The duration of the reservation
     * @return True if the sala is reserved succesfully, false if otherwise
     */
    public boolean reserveSala(Date dt, int dur){
        dur = checkDuration(dt, dur);
        if(this.isOccupied(dt,dur)){
            return false;
        }
        else{
            timeslots.add(dt);
            duration.add(dur);
        }
        return true;
    }
    
    /**Frees index "slot" from the sala's timeslot and duration ArrayLists. This method is to be used in conjunction with Disciplina.removeExame();
     * @param slot This integer should be retrieved from the disciplina.removeExame() function
     */
    public void freeSala(int slot) {
    	timeslots.remove(slot);
    	duration.remove(slot);
    }
    
    
    /**Checks whether the sala is available on Date new_date at time.
     * @param new_date
     * @param time
     * @return true if the sala is occupied, false if the sala is available
     */
    public boolean isOccupied(Date new_date, int time){
        Date cur_date, cur_end, new_end;
        int dur;
        for (int i = 0; i < this.timeslots.size(); i++) {
            cur_date = this.timeslots.get(i);
            dur = this.duration.get(i);
            cur_end = new Date( cur_date.getTime() + (long) dur );
            new_end = new Date( new_date.getTime() + (long) time);
            
            if(cur_date.equals(new_date) // Dates cant start at the same time
                    || (cur_date.before(new_date) // new date cant start between the beginning and end of an already existing exam
                            && cur_end.after(new_date))
                    || (new_date.before(cur_date)   // new date cant start before an already existing date AND end after that date
                            && new_end.after(cur_date))){
                return true;
            }
        }
        
        return false;
    }
    
    /**Returns the ID of the sala
     * @return String ID
     */
    public String getId(){
        return this.id;
    }

    /**Returns the timeslots ArrayList of the Sala
     * @return ArrayList<Date> timeslots
     */
    public ArrayList<Date> getTimeslots() {
        return this.timeslots;
    }

    /**Returns the duration ArrayList of the Sala
     * @return ArrayList<Integer> duration
     */
    public ArrayList<Integer> getDuration() {
        return this.duration;
    }
    

    @Override
    public String toString() {
        String str = "Sala " + this.id + "\n";
        
        if(this.timeslots.isEmpty()){
            //str += "Sala sem ocupacao!!!\n";
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
            for (int i = 0; i < this.timeslots.size(); i++) {
                str += "---> " + sdf.format(this.timeslots.get(i)) + "\n";
                str += "---> " + this.duration.get(i) + " minutes\n";
                str += "----------------------\n";
            }
           
        }
        
        //str += "----------------END OF SALA " + this.id.toUpperCase() + "-----------------\n";
            
        return str;
    }
    
    /**
     * @param index
     * @return
     */
    public String printHour(int index) {
        String str = "";
        
        if(this.timeslots.isEmpty()){
            str += "Sala sem ocupacao!!!\n";
        }
        else if(index > this.timeslots.size()){
            str += "Sala com menor ocupacao!!!\n";
        }
        else{
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
           
            str += sdf.format(this.timeslots.get(index)) + "\n";
            str += this.duration.get(index) + " minutes\n";
                
           
        }
          
        return str;
    }
    
    // <editor-fold defaultstate="collapsed" desc="checkArguments(int *5)">
    private int[] checkArguments(int day, int mon, int year, int hour, int min){
        int vec[] = {day,mon,year,hour,min};
        Scanner scan = new Scanner(System.in);
        
        if(day < 1 || day > 31){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para dia do exame ";
            str += ANSI_CYAN + "[" + day + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 31");
                    scan.nextLine();
                }
                vec[0] = scan.nextInt();
            } while(vec[0] < 1 || vec[0] > 31);
            
            System.out.println("Antigo valor: " + ANSI_RED + day + ANSI_RESET);
            System.out.println("\nNovo valor: " + ANSI_GREEN + vec[0] + ANSI_RESET);
        }
        if(mon < 1 || mon > 12){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para mes do exame ";
            str += ANSI_CYAN + "[" + mon + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 1 e 12");
                    scan.nextLine();
                }
                vec[1] = scan.nextInt();
            } while(vec[1] < 1 || vec[1] > 12);

            System.out.println("Antigo valor: " + ANSI_RED + mon + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[1] + ANSI_RESET);
        }
        if(year < 1 ){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para ano do exame ";
            str += ANSI_CYAN + "[" + year + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro maior que 1");
                    scan.nextLine();
                }
                vec[2] = scan.nextInt();
            } while(vec[2] < 1 );

            System.out.println("Antigo valor: " + ANSI_RED + year + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[2] + ANSI_RESET);
        }
        if(hour < 0 || hour > 23 ){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para hora do exame ";
            str += ANSI_CYAN + "[" + hour + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 0 e 23");
                    scan.nextLine();
                }
                vec[3] = scan.nextInt();
            } while(vec[3] < 0 || vec[3] > 23 );

            System.out.println("Antigo valor: " + ANSI_RED + hour + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[3] + ANSI_RESET);
        }
        if(min < 0 || min > 59 ){
            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para minuto do exame ";
            str += ANSI_CYAN + "[" + min + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n"+ ANSI_RESET;
            
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro entre 0 e 59");
                    scan.nextLine();
                }
                vec[4] = scan.nextInt();
            } while(vec[4] < 0 || vec[4] > 59);

            System.out.println("Antigo valor: " + ANSI_RED + min + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + vec[4] + ANSI_RESET);
        }
        return vec;
    }// </editor-fold>
   
    // <editor-fold defaultstate="collapsed" desc="checkDuration(Date, dur)">
    private int checkDuration(Date new_date, int dur){
        int new_dur = dur;
        
        if(dur <= 0){
            Scanner scan = new Scanner(System.in);

            String str = "";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "O valor inserido para duracao do exame ";
            str += ANSI_CYAN + "[" + dur + "]";
            str += ANSI_WHITE + " e invalido\n";
            str += ANSI_WHITE + ANSI_BLUE_BKG  + "Insira um novo valor:\n" + ANSI_RESET;
            System.out.print(str);

            do{
                while(!scan.hasNextInt()){
                    System.out.println("Insercao invalida! Insira um inteiro > 0");
                    scan.nextLine();
                }
                new_dur = scan.nextInt();
            }while(new_dur <= 0);
            
            System.out.println("Antigo valor: " + ANSI_RED + dur + ANSI_RESET);
            System.out.println("Novo valor: " + ANSI_GREEN + new_dur + ANSI_RESET);
            
        } //</editor-fold>
        
        return new_dur;
    }
    
    
}
