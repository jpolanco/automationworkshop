module.exports = {
	
	"Login Test" : function(client) {
		current_page = client.page.vacationLoginPage();
		current_page.goTo();
		current_page.isPageLoaded();
		current_page = current_page.insertCreedentials();
		current_page.isMainPageLoaded();
		current_page.is_successfully_message();
		client.end();
	}
};