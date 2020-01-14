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

  SelectByNo(No)
  {
    return this.helper.get("http://localhost:9898/emps/"+No); 
  }

  Update(empObj)
  {
    return this.helper.put("http://localhost:9898/emps/"+empObj.No,empObj);
  }

  Delete(No)
  {
    return this.helper.delete("http://localhost:9898/emps/"+No);
  }

  Insert(empObj)
  {
    return this.helper.post("http://localhost:9898/emps",empObj);
  }

}
