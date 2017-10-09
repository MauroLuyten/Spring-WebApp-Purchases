import {Http} from "@angular/http";
import {Purchase} from "./purchase";
import "rxjs/add/operator/toPromise"
import {Injectable} from "@angular/core";

@Injectable()
export class PurchaseService{

  private purchasesUrl = "http://193.191.187.14:10118/PurchaseRest";


  constructor(private http: Http){

  }


  getPurchases(): Promise<Purchase[]>{
    return this.http.get(this.purchasesUrl+"/purchases")
      .toPromise()
      .then(response => response.json() as Purchase[])
      .catch(this.handleError);
}
  deletePurchase(id: String):void{
    var url = this.purchasesUrl+"/purchases/"+id;

    this.http.delete(url).toPromise().catch(this.handleError);
  }
  private handleError(error:any): Promise<any>{
    console.error("An error occurred", error);
    return Promise.reject(error.message||error);
  }
}
