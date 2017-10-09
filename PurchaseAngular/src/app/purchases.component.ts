import {Component, OnInit} from "@angular/core";
import {Purchase} from "./purchase";
import {PurchaseService} from "./purchase.service";
@Component({
  selector: 'purchases',
  templateUrl: './purchases.component.html',
  styleUrls: ['./reset.css', './index.css']
})
export class PurchasesComponent implements OnInit {
  purchases: Purchase[];
  selectedPurchase: Purchase;

  constructor(private purchaseService: PurchaseService) {

  }

  getPurchases(): void {
    this.purchaseService.getPurchases().then(purchases => this.purchases = purchases);
  }
  public deletePurchase(id:String):void{
    console.log("component");
    this.purchaseService.deletePurchase(id);

  }


  ngOnInit(): void {
    this.getPurchases();
  }

  onSelect(purchase: Purchase): void {
    this.selectedPurchase = purchase;
  }



}
