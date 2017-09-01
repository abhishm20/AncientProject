var mailer = require('./mailer');
var fs = require('fs')
mailer.send("abhishm20@gmail.com", "Subject", "<h1>Bidy</h1>");
// fs.readFile("/home/abhishek/git/daybox-node/server/util/demo.js", function (err, data) {
//
//
// });
//
//
// var nodemailer = require('nodemailer');
// var mailConfig = require('./mailConfig');
//
// var generator = require('xoauth2').createXOAuth2Generator({
//     user: mailConfig.email,
//     clientid: mailConfig.client_id,
//     clientSecret: mailConfig.client_secret,
//     refreshToken: mailConfig.refresh_token,
//     accessToken: mailConfig.access_token,
//     timeout: 3600
// });
// // listen for token updates
// // you probably want to store these to a db
// generator.on('token', function(token){
//     console.log('New token for %s: %s', token.user, token.accessToken);
// });
//
// // login
// var transporter = nodemailer.createTransport("SMTP",{
//     service: 'gmail',
//     debug: true,
//     auth: {
//         XOAuth2: {
//             user: mailConfig.email,
//             clientid: mailConfig.client_id,
//             clientSecret: mailConfig.client_secret,
//             refreshToken: mailConfig.refresh_token,
//             accessToken: mailConfig.access_token,
//             timeout: 3600
//         }
//     }
// });
// console.log(transporter.options.auth);
//
// // send mail
// transporter.sendMail({
//     from: 'DayBox <contact@daybox.in>',
//     to: 'abhishm20@gmail.com',
//     subject: 'hello world!',
//     text: 'Authenticated with OAuth2'
// }, function(error, response) {
//    if (error) {
//         console.log(error);
//    } else {
//         console.log('Message sent');
//    }
// });
