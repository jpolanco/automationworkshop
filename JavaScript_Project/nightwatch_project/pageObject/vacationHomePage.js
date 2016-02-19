module.exports = function(client){

	var pageTitle = "Vacations Management Site - Growth Acceleration Partners";
	var successfully_message = "p[class = flash_notice]"
	return {
		isMainPageLoaded: function(){
			client
				.waitForElementVisible("body", 3000)
				.assert.title(pageTitle)
		},

		is_successfully_message: function(){
			client
				.assert.elementPresent(successfully_message);
		}
	}
};