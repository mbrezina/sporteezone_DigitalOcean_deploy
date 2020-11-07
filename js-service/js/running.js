const request = require("request-promise");
const cheerio = require("cheerio");
var fs = require("fs");

(async () => {

	let itemList = [];

	const runningUrl = "https://runningzone.cz/lekce/";

	const response = await request(runningUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("span[title]").each(function(){
		let course = {}
		course.name = $(this).text().trim()
		courses.push(course)
	});

	let day = $("time[datetime]").text().trim();
	$("time[datetime]").each(function(i){
		let course = courses[i];
		course.day = $(this).text().trim()
	});
/*
	let start = $("span[class='time']").text().trim();
	$("span[class='time']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	let availability = $("span[class='capacity']").text().trim();
	$("span[class='capacity']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim()
	});



	/*let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim()
	});*/

	itemList.push({
		running: {
		 courses
		}
	  });



	fs.writeFile("./running.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();
