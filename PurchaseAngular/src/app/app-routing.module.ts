import {PurchasesComponent} from "./purchases.component";
import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
const routes:Routes=[
  {path: "purchases", component:PurchasesComponent},
  {path: "purchases/delete", component:PurchasesComponent}
];

@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})
export class AppRoutingModule{}
