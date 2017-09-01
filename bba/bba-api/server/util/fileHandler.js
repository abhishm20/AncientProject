var json2xls = require('json2xls');
var fs = require("fs");
var xlsToJson = require('xlsx');
var moment = require('moment');

module.exports = {

    jsonToXls: function(jsonData, fileName){
        var xlsData = json2xls(jsonData);
        var t = new Date().getTime();
        if(fileName){
            fs.writeFileSync(__dirname+'/../../static/package-list/'+fileName+"-"+moment().format('DD-MM-YY, h:mm')+'.xlsx', xlsData, 'binary')
            return '/static/package-list/'+fileName+"-"+moment().format('DD-MM-YY, h:mm')+'.xlsx';
        }else{
            fs.writeFileSync(__dirname+'/../../static/package-list/'+t+'.xlsx', xlsData, 'binary')
            return '/static/package-list/'+t+'.xlsx';
        }
    },
    XlsToJson: function(filePath){
        var workbook = xlsToJson.readFile(filePath);
        var result = {};
        workbook.SheetNames.forEach(function(sheetName) {
            var roa = xlsToJson.utils.sheet_to_row_object_array(workbook.Sheets[sheetName]);
            if(roa.length > 0){
                result[sheetName] = roa;
            }
        });
        return result;
    }
}
