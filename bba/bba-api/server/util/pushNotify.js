'use strict';

var gcm = require('node-gcm');
var constants = require('./constants');
// Create a message
// ... with default values
//var message = new gcm.Message();

// ... or some given values
var message = new gcm.Message({

});


// add notification data


// Set up the sender with you API key
var sender = new gcm.Sender("AIzaSyAdTNwESCbTXd7EZekLtrSb0_V3tB41W6g");

// Add the registration tokens of the devices you want to send to
var gcms = [];





module.exports = {

  // add notification data
  addNotificationData: function(data){
    message.addNotification(data);
  },

  // add gcm
  addGcm : function(gcm){
    gcms.push(gcm);
  },

  // add data
  addData: function(data){
    message.addData(data);
  },

  // ... or retrying
  send: function(){
    sender.send(message, { registrationTokens: gcms }, function (err, response) {
      if(err) console.error('err '+err);
      else    console.log('res '+JSON.stringify(response));
    });
  },

}
