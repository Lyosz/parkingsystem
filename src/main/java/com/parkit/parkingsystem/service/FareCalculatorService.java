package com.parkit.parkingsystem.service;
import com.parkit.parkingsystem.constants.Fare;
import com.parkit.parkingsystem.model.Ticket;
import com.parkit.parkingsystem.util.RegistrationInArrayList;


public class FareCalculatorService {
	

    
    public void calculateFare(Ticket ticket){
        if( (ticket.getOutTime() == null) || (ticket.getOutTime().before(ticket.getInTime())) ){
            throw new IllegalArgumentException("Out time provided is incorrect:"+ticket.getOutTime().toString());
        }
        
        RegistrationInArrayList dataRegistrationsnumbers = new RegistrationInArrayList(ticket.getVehicleRegNumber());
        boolean regular = dataRegistrationsnumbers.VerifyRegistration();
        
        long inHour = ticket.getInTime().getTime();
        long outHour = ticket.getOutTime().getTime();
        
        double duration = (double)((outHour - inHour)/1000)/60/60;
        
        if (duration<=0.5)
        	duration = 0;
        if (regular == true)
        	duration = duration*0.95;
        
        switch (ticket.getParkingSpot().getParkingType()){
            case CAR: {
                ticket.setPrice(duration * Fare.CAR_RATE_PER_HOUR);
                break;
            }
            case BIKE: {
                ticket.setPrice(duration * Fare.BIKE_RATE_PER_HOUR);
                break;
            }
            default: throw new IllegalArgumentException("Unkown Parking Type");
        }
    }
}