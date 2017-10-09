"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var purchase_service_1 = require("./purchase.service");
var PurchasesComponent = (function () {
    function PurchasesComponent(purchaseService) {
        this.purchaseService = purchaseService;
    }
    PurchasesComponent.prototype.getPurchases = function () {
        var _this = this;
        this.purchaseService.getPurchases().then(function (purchases) { return _this.purchases = purchases; });
    };
    PurchasesComponent.prototype.deletePurchase = function (id) {
        console.log("component");
        this.purchaseService.deletePurchase(id);
    };
    PurchasesComponent.prototype.ngOnInit = function () {
        this.getPurchases();
    };
    PurchasesComponent.prototype.onSelect = function (purchase) {
        this.selectedPurchase = purchase;
    };
    return PurchasesComponent;
}());
PurchasesComponent = __decorate([
    core_1.Component({
        selector: 'purchases',
        templateUrl: './purchases.component.html',
        styleUrls: ['./reset.css', './index.css']
    }),
    __metadata("design:paramtypes", [purchase_service_1.PurchaseService])
], PurchasesComponent);
exports.PurchasesComponent = PurchasesComponent;
//# sourceMappingURL=purchases.component.js.map