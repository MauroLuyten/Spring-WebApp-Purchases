import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpModule} from "@angular/http";
import { AppComponent }  from './app.component';
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";

import{PurchasesComponent} from "./purchases.component";
import {PurchaseService} from "./purchase.service";

@NgModule({
  imports:      [ BrowserModule,
                  FormsModule,
                  AppRoutingModule,
                  HttpModule],
  declarations: [ AppComponent, PurchasesComponent ],
  providers: [PurchaseService],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
