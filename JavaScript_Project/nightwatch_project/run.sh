rm -f reports/*
node_modules/nightwatch/bin/nightwatch -c nightwatch.json --reporter html-reporter.js
