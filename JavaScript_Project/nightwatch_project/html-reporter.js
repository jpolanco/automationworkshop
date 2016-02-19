var HtmlReporter = require('nightwatch-html-reporter');
/* Same options as when using the built in nightwatch reporter option */
now = Date.now()+"_report.html";
var reporter = new HtmlReporter({
  openBrowser: false,
  reportsDirectory: __dirname + "/reports/",
  themeName: 'default',
  reportFilename: now
});

module.exports = {
  write : function(results, options, done) {
    reporter.fn(results, done);
  }
};