import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private helper:HttpClient) { }

  Select()
  {
   return this.helper.get("http://localhost:9898/emps");    //it returns all records to get perticular record add / at the end and append No which we get from url
  }

  SelectAdmin()
  {
   return this.helper.get("http://localhost:8080/Railway_Reservation/users/adminlist");    //it returns all records to get perticular record add / at the end and append No which we get from url
  }
  SelectUsers()
  {
    return this.helper.get("http://localhost:8080/Railway_Reservation/users");
  }

  SelectPassengerById(passengerId)
   {
    return this.helper.get("http://localhost:8080/Railway_Reservation/bookings/passengers/"+passengerId);
  }

  SelectByNo(No)
  {
    console.log("in service");
    console.log(No);
    return this.helper.get("http://localhost:8080/Railway_Reservation/users/"+No); 
  }

  SelectSeats()
  {
    return this.helper.get("http://localhost:8080/Railway_Reservation/bookings/AvailableSeats");  
  }
  ChangePassword(uObj)
  {
    console.log("in data service of change password"+uObj.email);
    return this.helper.put("http://localhost:8080/Railway_Reservation/users/changepassword/"+uObj.email,uObj);
  }
  SelectPassengers(No)
  {
    return this.helper.get("http://localhost:8080/Railway_Reservation/bookings/passengerslist/"+No); 
  }
  Update(uObj)
  {
    return this.helper.put("http://localhost:8080/Railway_Reservation/users/"+uObj.userId,uObj);
  }

  UpdatePassenger(pObj) 
  {
    return this.helper.put("http://localhost:8080/Railway_Reservation/bookings/passengers/"+pObj.passengerId,pObj);
  }

  
  Delete(No)
  {
    return this.helper.delete("http://localhost:9898/emps/"+No);
  }

  DeleteAdmin(No)
  {
    return this.helper.delete("http://localhost:8080/Railway_Reservation/users/"+No);
  }

  deleteAllConfirmSeats(id)
  {
    return this.helper.delete("http://localhost:8080/Railway_Reservation/bookings/deleteAllConfirmSeats/"+id);
  }

  Insert(uObj)
  {
    return this.helper.post("http://localhost:8080/Railway_Reservation/users",uObj);
  }


  DeletePassenger(No)
  {
    return this.helper.delete("http://localhost:8080/Railway_Reservation/bookings/passengers/"+No);
  }

  InsertTrain(tObj)
  {
    return this.helper.post("http://localhost:8080/Railway_Reservation/trains",tObj);
  }


  InsertBkId(No)
  {
    console.log("in new service "+No);
    //console.log("http://localhost:8080/Railway_Reservation/bookings/setBookingkId/"+bObj);
    return this.helper.delete("http://localhost:8080/Railway_Reservation/bookings/setBookingId/"+No);
  }

  InsertPassenger(pObj,id)
  {
    console.log("in insert service : "+pObj+"user id is "+id);
    return this.helper.post("http://localhost:8080/Railway_Reservation/bookings/passengers/"+id,pObj);
  }
  
  SearchTrains(source,destination)
  {
    return this.helper.get("http://localhost:8080/Railway_Reservation/trains/"+source+"/"+destination); 
  }  

  SelectAllTrains()
  {
    return this.helper.get("http://localhost:8080/Railway_Reservation/trains");
  }

  DeleteTrain(No)
  {
    return this.helper.delete("http://localhost:8080/Railway_Reservation/trains/"+No);
  }

  makePayment(fair,id)
  {
    console.log("fair is :"+fair+" for user id : "+id);
  }

  GetCount(No)
  {
    return this.helper.get("http://localhost:8080/Railway_Reservation/bookings/countPassengers/"+No);
  }

}
