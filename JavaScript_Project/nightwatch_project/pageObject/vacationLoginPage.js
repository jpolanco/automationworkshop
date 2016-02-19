module.exports = function (client){

	var data = client.globals;

	 var pageTitle = "Vacations Management Site - Growth Acceleration Partners";
	 var emailField = "input[id = user_email]";
	 var passwordField = "input[id = user_password]";
	 var submitButton = "input[name = commit]";
	 var bodyPage = "body";

	return{
		goTo: function(){
			client
				.url(data.vacationUrl.url)
				.windowMaximize()
		},

		isPageLoaded: function(){
			client
				.waitForElementVisible(bodyPage, 3000)
				.assert.title(pageTitle)
		},

		insertCreedentials: function(){
			client
				.setValue(emailField, data.creedentials.email)
				.setValue(passwordField, data.creedentials.password)
				.click(submitButton)
				return client.page.vacationHomePage();
		}

	}
};