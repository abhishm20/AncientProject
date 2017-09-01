'use strict'
// built in package, used for generating accessToken
var uuid = require('node-uuid');
var constants = require('./constants');
var moment = require('moment');
// var pushNotify = require('./pushNotify');
// var bcrypt = require('bcrypt');
var Hashids = require("hashids");
var orderHashId = new Hashids("daybox_secret",6, '0123456789ABCDEF');
// qrCodeHashId = new Hashids("ainaa007QrCode",30);


module.exports = {

    parserOutletsExcelData : function(data){
        var outlets = [];
        data.forEach(function(outlet){
            outlets.push({
                'id' : outlet['Id'],
                'name' : outlet['Name'],
                'daysPlan': outlet['Days Plan'],
                'mobiles': outlet['Mobiles'],
                'purchasers': outlet['Purchasers'],
                'creditLimit': outlet['Credit Limit'],
                'freezeTime' : outlet['Freeze Time'],
                'pendingBoxes': outlet['Pending Boxes'],
                'returnWindow': outlet['Returning Window'],
                'representative': outlet['DB Representative'],
                'bussinessNature': outlet['Nature of Bussiness'],
                'billingName': outlet['Billing Name'],
                'email': outlet['Email'],
                'rateSlab': outlet['Rate Slab'],
                'paymentCycle': outlet['Payment Cycle'],
                'paymentMode': outlet['Preferred Payment Mode'],
                'street': outlet['Street'],
                'area': outlet['Area'],
                'landmark': outlet['Landmark'],
                'city': outlet['City'],
                'state': outlet['State'],
                'pincode': outlet['Pincode'],
                'telephone': outlet['Landline Number'],
                'route': outlet['Route'],
                'createdAt': outlet['Created']
            });
        });
        return outlets;
    },

    parserOutletSkusExcelData : function(data){
        var skus = [];
        data.forEach(function(sku){
            skus.push({
                'outletName' : sku['Outlet Name'],
                'dayboxSku': sku['DayBox SKU'],
                'name': sku['Outlet SKU'],
                'unit': sku['Outlet SKU Unit'],
                'rate': sku['Outlet SKU Rate'],
                'step': sku['Outlet SKU Step'],
                'rateType': sku['Outlet SKU Rate Type'],
                'startDate': sku['Outlet SKU Rate Start Date'],
                'endDate': sku['Outlet SKU Rate End Date'],
                'rateSlope': sku['Outlet SKU Rate Slope'],
                'rateConstant': sku['Outlet SKU Rate Constant'],
                'rateMin': sku['Outlet SKU Rate Min'],
                'rateMax': sku['Outlet SKU Rate Max']
            });
        });
        return skus;
    },

    parserDBSkusExcelData : function(data){
        var skus = [];
        data.forEach(function(sku){
            skus.push({
                'id' : sku['Id'],
                'name' : sku['Name'],
                'hindi': sku['Hindi'],
                'unit': sku['Unit'],
                'step': sku['Step'],
                'aliases': sku['Aliases'],
                'g1': sku['G1'],
                'g2': sku['G2'],
                'g3': sku['G3'],
                'g4': sku['G4'],
                'g5': sku['G5']
            });
        });
        return skus;
    },

    parserDBSkusRatesExcelData: function(data, date){
        var rates = [];
        data.forEach(function(rate){
            rates.push({
                'id' : rate['Id'],
                'sku': rate['Name'],
                'daily': rate['Daily'],
                'weekly': rate['Weekly'],
                'monthly': rate['Monthly'],
                'annually': rate['Annually'],
            });
        });
        return rates;
    },

    parserOrdersExcelData : function(data){
        var orders = [];
        data.forEach(function(order){
            orders.push({
                'deliveryDate': order['Delivery Date'],
                'name': order['Outlet SKU'],
                'orderedQuantity': order['Quantity'],
                'dispatchedQuantity': order['Quantity'],
                'isRated': order['Is Rated'],
                'rating': order['Rating'],
                'outletId': order['Outlet Id'],
                'purchaserId': order['Purchaser Id'],
                'rate': order['Rate'],
                'unit': order['Unit'],
                'extraChargeAmount': order['Extra Charge Amount'],
                'extraChargeName': order['Extra Charge Name']
            });
        });
        return orders;
    }
}
