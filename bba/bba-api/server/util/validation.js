var validator = require('./validation');
var constants = require("./constants");

module.exports = {


	isEmptyObject : function(obj){
		return !Object.keys(obj).length;
	},


	isMobile : function(mobile){
		var re = /^[789]\d{9}$/;
		return re.test(mobile);
	},


	isRealm : function(realm){
		return (realm == constants.REALM_ANDROID || realm == constants.REALM_WEB || realm == constants.REALM_IOS);
	},


	isName:function(name){
		var re = /^[a-zA-Z ',.-_]*$/;
		return re.test(name);
	},


	isEmail : function(email){
		var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		return re.test(email);
	},

	isRateSlab : function(rateSlab){
		if(['daily', 'weekly', 'monthly', 'annually'].indexOf(rateSlab) >= 0){
			return true;
		}
		return false;
	},


	isValidOutletsExcelData : function(outlets, cb){
		if(outlets){
			var uniqueNames = [];
			var uniqueMobiles = [];
			var i =0;
			var digitRe = /^\d+$/;
			for(i=0; i< outlets.length; i++){
				// name check
				if(outlets[i].name){
					if(outlets[i].name.length < 2 || outlets[i].name.length > 100){
						cb("Invalid Outlet Name at "+(i+1)+", length: [2-100]");
						return;
					}
				}else{
					cb("Outlet Name is required at "+(i+1)+", length: [2-100]");
					return;
				}
				//unique name check
				if(uniqueNames.indexOf(outlets[i].name) >= 0){
					cb("Duplicate Outlet Name at "+(i+1));
					return;
				}else{
					uniqueNames.push(outlets[i].name)
				}
				//credit limit check
				if(!digitRe.test(outlets[i].creditLimit)){
					cb("Invalid credit limit at "+(i+1));
					return;
				}
				//pending boxes check
				if(!digitRe.test(outlets[i].pendingBoxes)){
					cb("Invalid Pending Boxes field at "+(i+1));
					return;
				}
				//freezeTime check
				var ft = outlets[i].freezeTime.split(':');
				if(!(digitRe.test(ft[0]) && digitRe.test(ft[0]) && digitRe.test(ft[0]) && outlets[i].freezeTime.length == 8)){
					cb("Invalid Freeze Time at "+(i+1)+", format: HH:MM:SS in 24hrs");
					return;
				}
				//purchaser and mobile count check
				if(outlets[i].mobiles && outlets[i].purchasers){
					outlets[i].mobiles = outlets[i].mobiles.split(',');
					outlets[i].purchasers = outlets[i].purchasers.split(',');
					if(outlets[i].mobiles.length <1){
						cb("Atleast One mobile is required at "+(i+1));
						return;
					}
					if(outlets[i].purchasers.length != outlets[i].mobiles.length){
						cb("Purchaser and Mobile does not match at "+(i+1));
						return;
					}
					// mobile check
					for(var j=0; j<outlets[i].mobiles.length; j++){
						var re = /^[789]\d{9}$/;
						if(re.test(outlets[i].mobiles[j])){
							if(uniqueMobiles.indexOf(outlets[i].mobiles[j]) >= 0){
								cb("Duplicate Purchaser Mobile at "+(i+1));
								return;
							}else{
								uniqueMobiles.push(outlets[i].mobiles[j])
							}
						}else{
							cb("Invalid Mobile at "+(i+1));
							return;
						}
					}
				}else{
					cb("Atleast One mobile is required at "+(i+1));
					return;
				}
				//days plan check
				outlets[i].daysPlan = outlets[i].daysPlan.split(',');
				if(outlets[i].daysPlan.length != 7){
					cb("Invalid Count of Days Plan at "+(i+1));
					return;
				}
				for(var j=0; j<outlets[i].daysPlan.length; j++){
					if(!(digitRe.test(outlets[i].daysPlan[j]) || outlets[i].daysPlan[j] == 'y' || outlets[i].daysPlan[j] == 'n')){
						cb("Invalid Days Plan at "+(i+1)+", Supported are 'y', 'n', 123");
						return;
					}
				}
				if(outlets[i].createdAt){
					var tempDate = new Date(outlets[i].createdAt);
					if(tempDate == 'Invalid Date'){
						cb("Invalid Created At date at "+(i+1));
						return;
					}else{
						outlets[i].createdAt = new Date(outlets[i].createdAt);
					}
				}
			}
			cb(null, outlets);
			return;
		}else{
			cb("No Data recieved");
			return;
		}
	},

	isValidDBSkusExcelData : function(skus, cb){
		if(skus){
			var uniqueNames = [];
			var i =0;
			var rateRe = /^\d+\.\d{0,3}$/;
			var digitRe = /^\d+$/;
			var charRe = /^[A-Za-z]{1,10}$/;
			for(i=0; i< skus.length; i++){
				// name check
				if(skus[i].name){
					if(skus[i].name.length < 2 || skus[i].name.length > 100){
						cb("Invalid SKU Name at "+(i+1)+", length: [2-100]");
						return;
					}
				}else{
					cb("SKU Name is required at "+(i+1)+", length: [2-100]");
					return;
				}
				//unique name check
				if(uniqueNames.indexOf(skus[i].name) >= 0){
					cb("Duplicate SKU Name at "+(i+1));
					return;
				}else{
					uniqueNames.push(skus[i].name)
				}
				//step check
				if(!(digitRe.test(skus[i].step) || rateRe.test(skus[i].step))){
					cb("Invalid Step field at "+(i+1));
					return;
				}
				//Unit check
				if(!charRe.test(skus[i].unit)){
					cb("Invalid unit at "+(i+1));
					return;
				}
				if(!skus[i].g1){
					skus[i].g1 = '';
				}
				if(!skus[i].g2){
					skus[i].g2 = '';
				}
				if(!skus[i].g3){
					skus[i].g3 = '';
				}
				if(!skus[i].g4){
					skus[i].g4 = '';
				}
				if(!skus[i].g5){
					skus[i].g5 = '';
				}
				// Aliases test
				if(skus[i].aliases && skus[i].aliases.length > 0){
					skus[i].aliases = skus[i].aliases.split(",");
				}else{
					skus[i].aliases = [];
				}
			}
			cb(null, skus);
			return;
		}else{
			cb("No Data recieved");
			return;
		}
	},

	isValidDBSkusRatesExcelData: function(rates, cb){
		if(rates){
			var uniqueNames = [];
			var i =0;
			var rateRe = /^\d+\.\d{0,3}$/;
			var digitRe = /^\d+$/;
			for(i=0; i< rates.length; i++){
				// name check
				if(rates[i].sku){
					if(rates[i].sku.length < 2 || rates[i].sku.length > 100){
						cb("Invalid SKU Name at "+(i+1)+", length: [2-100]");
						return;
					}
				}else{
					cb("SKU Name is required at "+(i+1)+", length: [2-100]");
					return;
				}
				//unique name check
				if(uniqueNames.indexOf(rates[i].sku) >= 0){
					cb("Duplicate SKU Name at "+(i+1));
					return;
				}else{
					uniqueNames.push(rates[i].sku)
				}
				//rate check
				if(rates[i].daily){
					if(!(rateRe.test(rates[i].daily) || digitRe.test(rates[i].daily))){
						cb("Invalid Daily Rate at "+(i+1));
						return;
					}
				}
				if(rates[i].weekly){
					if(!(rateRe.test(rates[i].weekly) || digitRe.test(rates[i].weekly))){
						cb("Invalid weekly Rate at "+(i+1));
						return;
					}
				}
				if(rates[i].monthly){
					if(!(rateRe.test(rates[i].monthly) || digitRe.test(rates[i].monthly))){
						cb("Invalid monthly Rate at "+(i+1));
						return;
					}
				}
				if(rates[i].annually){
					if(!(rateRe.test(rates[i].annually) || digitRe.test(rates[i].annually))){
						cb("Invalid annual Rate at "+(i+1));
						return;
					}
				}
				if(!(rates[i].daily || rates[i].weekly || rates[i].monthly || rates[i].annually)){
					cb("No rates provided at "+(i+1));
					return;
				}
			}
			cb(null, rates);
			return;
		}else{
			cb("No Data recieved");
			return;
		}
	},

	isValidOutletSkusExcelData: function(skus, cb){
		if(skus){
			var uniqueNames = [];
			var i =0;
			var rateRe = /^\d+\.\d{0,3}$/;
			var digitRe = /^\d+$/;
			var charRe = /^[A-Za-z]{1,10}$/;
			for(i=0; i< skus.length; i++){
				// name check
				if(skus[i].name && skus[i].outletName){
					if(skus[i].name.length < 2 || skus[i].name.length > 100){
						cb("Invalid SKU Name at "+(i+1)+", length: [2-100]");
						return;
					}
					if(skus[i].outletName.length < 2 || skus[i].outletName.length > 100){
						cb("Invalid Outlet Name at "+(i+1)+", length: [2-100]");
						return;
					}
				}else{
					cb("SKU and Outlet Name is required at "+(i+1)+", length: [2-100]");
					return;
				}
				//unique name check
				if(uniqueNames.indexOf(skus[i].name+skus[i].name) >= 0){
					cb("Duplicate SKU and Outlet Name at "+(i+1));
					return;
				}else{
					uniqueNames.push(skus[i].name+skus[i].outletName)
				}
				//rate check
				if(!(rateRe.test(skus[i].rate) || digitRe.test(skus[i].rate))){
					cb("Invalid Rate at "+(i+1));
					return;
				}
				//step check
				if(!(digitRe.test(skus[i].step) || rateRe.test(skus[i].step))){
					cb("Invalid Step field at "+(i+1));
					return;
				}
				//Unit check
				if(!charRe.test(skus[i].unit)){
					cb("Invalid unit at "+(i+1));
					return;
				}
				//Rate Type check
				if(!(skus[i].rateType == 'Daily' || skus[i].rateType == 'Fixed')){
					cb("Invalid Rate Type at "+(i+1)+", Allowed: 'Daily' or 'Fixed'");
					return;
				}
				//rate slope check
				if(!(rateRe.test(skus[i].rateSlope) || digitRe.test(skus[i].rateSlope))){
					cb("Invalid Rate Slope at "+(i+1));
					return;
				}
				//rate constant check
				if(!(rateRe.test(skus[i].rateConstant) || digitRe.test(skus[i].rateConstant))){
					cb("Invalid Rate Constant at "+(i+1));
					return;
				}
				//rate min check
				if(!(rateRe.test(skus[i].rateMin) || digitRe.test(skus[i].rateMin))){
					cb("Invalid Rate Min at "+(i+1));
					return;
				}
				//rate slope check
				if(!(rateRe.test(skus[i].rateMax) || digitRe.test(skus[i].rateMax))){
					cb("Invalid Rate Max at "+(i+1));
					return;
				}
				// start and end date check
				var splitedStartDate = skus[i].startDate.split('-');
				var splitedEndDate = skus[i].startDate.split('-');
		        if(splitedStartDate.length != 3){
					cb("Invalid Start Date at "+(i+1)+", Format: 'DD-MM-YYYY'");
					return;
		        }
				skus[i].startDate = new Date(splitedStartDate[2], splitedStartDate[1]-1, splitedStartDate[0]);
				if(splitedEndDate.length != 3){
					cb("Invalid End Date at "+(i+1)+", Format: 'DD-MM-YYYY'");
					return;
		        }
				skus[i].endDate = new Date(splitedEndDate[2], splitedEndDate[1]-1, splitedEndDate[0]);
			}
			cb(null, skus);
			return;
		}else{
			cb("No Data recieved");
			return;
		}
	},

	isDayboxSkuListExistsById: function(DayboxSku, skuList, cb){
		if(skuList && skuList.length > 0){
			var count = 0;
			var errorsIndex = [];
			for(var i=0; i<skuList.length; i++){
				DayboxSku.findById(skuList[i].id, function(err, foundInstance){
					if(!err){
						if(!(foundInstance && foundInstance.id)){
							errorsIndex.push(i+1);
						}
					}
					count ++;
					if(count == skuList.length){
						if(errorsIndex.length > 0){
							cb('DayBox SKUs not exists at '+errorsIndex.join(','));
							return;
						}
						cb(null, skuList);
						return;
					}
				});
			}
		}else{
			cb("SKUs List is empty");
			return;
		}
	},

	isOutletsExistsByName: function(Outlet, outletList, cb){
		if(outletList && outletList.length > 0){
			var count = 0;
			var errorsIndex = [];
			for(var i=0; i<outletList.length; i++){
				Outlet.findOne({where:{name: outletList[i].outletName}}, function(err, foundInstance){
					if(!err){
						if(!(foundInstance && foundInstance.id)){
							errorsIndex.push(i+1);
						}
					}
					count ++;
					if(count == outletList.length){
						if(errorsIndex.length > 0){
							cb('Outlets not exists at '+errorsIndex.join(','));
							return;
						}
						cb(null, outletList);
						true
					}
				});
			}
		}else{
			cb("SKUs List is empty");
			return;
		}
	},

	isValidOrdersExcelData : function(orders, cb){
		var finalOrders = [];
		var finalOrdersCount = -1;
		if(orders){
			var uniqueOrder = [];
			var uniqueOutlet = []
			var i =0;
			var digitRe = /^\d+$/;
			var rateRe = /^\d+\.\d{0,3}$/;
			for(i=0; i< orders.length; i++){
				//unique name check
				if(uniqueOrder.indexOf(orders[i].deliveryDate+orders[i].outletId+orders[i].name) >= 0){
					cb("Duplicate SKU for Order at "+(i+1));
					return;
				}else{
					uniqueOrder.push(orders[i].deliveryDate+orders[i].outletId+orders[i].name)
				}

				//delivery date check
				var ft = orders[i].deliveryDate.split('-');
				if(!(digitRe.test(ft[0]) && digitRe.test(ft[0]) && digitRe.test(ft[0]) && orders[i].deliveryDate.length == 10)){
					cb("Invalid Delivery Date at "+(i+1)+", format: DD-MM-YYYY");
					return;
				}

				if(uniqueOutlet.indexOf(orders[i].deliveryDate+orders[i].outletId) >= 0){
					var skuData = {
						"unit": orders[i].unit,
						"rate": orders[i].rate,
						"orderedQuantity": orders[i].orderedQuantity,
						"dispatchedQuantity": orders[i].dispatchedQuantity,
						"name": orders[i].name
					}
					finalOrders[finalOrdersCount].skus.push(skuData);
				}else{
					finalOrders.push({
						"deliveryDate": orders[i].deliveryDate,
						"rating": orders[i].rating,
						"isRated": (orders[i].isRated == 1),
						"orderDate": new Date(orders[i].deliveryDate.split("-")[2],orders[i].deliveryDate.split("-")[0],orders[i].deliveryDate.split("-")[1]),
						"extraChargeAmount": orders[i].extraChargeAmount,
						"extraChargeName": orders[i].extraChargeName,
						"outletId": orders[i].outletId,
						"purchaserId": orders[i].purchaserId,
						"skus":[{
							"unit": orders[i].unit,
							"rate": orders[i].rate,
							"orderedQuantity": orders[i].orderedQuantity,
							"dispatchedQuantity": orders[i].dispatchedQuantity,
							"name": orders[i].name
						}]
					});
					finalOrdersCount ++;
					uniqueOutlet.push(orders[i].deliveryDate+orders[i].outletId)
				}
			}
			cb(null, finalOrders);
			return;
		}else{
			cb("No Data recieved");
			return;
		}
	},


	isOutletAndSkuExistsByName: function(Outlet, outletList, cb){
		if(outletList && outletList.length > 0){
			var outletCount = 0;
			var errorsIndex = [];
			outletList.forEach(function(outlet){
				Outlet.findOne({where:{name: outlet.outlet}, include:"skus"}, function(err, foundInstance){
						if(!(foundInstance && foundInstance.id)){
							errorsIndex.push(outletCount+1);
						}else{
							foundInstance.skus({name:outlet.sku}, function(err, fSku){
								if(!(fSku && fSku.id)){
									if(errorsIndex.indexOf(outletCount+1)){
										errorsIndex.push(outletCount+1);
									}
								}else{
									console.log(outlet.sku);
								}
							});
						}
						outletCount ++;
						if(outletCount == outletList.length){
							if(errorsIndex.length > 0){
								cb('Outlet or SKU not exists at '+errorsIndex.join(','));
								return;
							}
							cb(null, outletList);
							return;
						}
				});
			});
		}else{
			cb("Outlet List is empty");
			return;
		}
	}
}
