var vacationUrl = {
 	url: "http://vacations.evercoding.com"
};

var creedentials = {
	email: 'gap-automation-test@mailinator.com',
	password: '12345678'

};

var HtmlReporter = require('nightwatch-html-reporter');
var reporter = new HtmlReporter({
    openBrowser: true,
    reportsDirectory: __dirname + '/reports'
});

module.exports = {
	vacationUrl: vacationUrl,
 	creedentials: creedentials,
 	reporter: reporter.fn
};