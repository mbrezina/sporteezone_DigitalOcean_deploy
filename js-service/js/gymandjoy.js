const request = require("request-promise");
const cheerio = require("cheerio");
var fs = require("fs");

(async () => {

	let itemList = [];

	const gymAndJoyUrl = "https://gymandjoy.reservio.com/booking/business/event?businessId=0c305322-c23e-11e6-8b1c-525400ef745e";

	const response = await request(gymAndJoyUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("div[class='calendarEvent']").each(function(){
		let course = {}
		course.name = $(this).text().trim()
		courses.push(course)
	});

	let day = $("span[class='date']").text().trim();
	$("span[class='date']").each(function(i){
		let course = courses[i];
		course.day = $(this).text().trim()
	});

	let start = $("span[class='time']").text().trim();
	$("span[class='time']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	/*let end = $("div[class='time end']").text().trim();
	$("div[class='time end']").each(function(i){
		let course = courses[i];
		course.end = $(this).text().trim()
	});

	let availability = $("div[class='availability']").text().trim();
	$("div[class='availability']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim()
	});*/

	/*let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim()
	});*/

	itemList.push({
		gymandjoy: {
		 courses
		}
	  });

	fs.writeFile("./gymandjoy.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();