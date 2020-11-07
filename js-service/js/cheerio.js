const request = require("request-promise");
const cheerio = require("cheerio");
var fs = require("fs");

(async () => {

	let itemList = [];

	const afitUrl = "http://rezervace.afit.cz:18080/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar";

	const response = await request(afitUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("div[class='lesson_name']").each(function(){
		let course = {}
		course.name = $(this).text().trim()
		courses.push(course)
	});


	$(".book").each(function(i){
		let course = courses[i];
		let day = $(this).attr("href").trim().split("/");
		course.day = day[day.length - 1].substr(0,10);
	});


	let start = $("div[class='time start']").text().trim();
	$("div[class='time start']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	let end = $("div[class='time end']").text().trim();
	$("div[class='time end']").each(function(i){
		let course = courses[i];
		course.end = $(this).text().trim()
	});

	let availability = $("div[class='availability']").text().trim();
	$("div[class='availability']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim().replace(/  +/g, " ");
	});

	let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim().replace(/  +/g, " ");
	});

	courses = courses.filter(course => course.day != "#");

	itemList.push({
		afit:  {
		 courses,
		 "url": afitUrl,
		 "multisport": false,
		 "activepass": true
		}
	  });

	fs.writeFile("./afit.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();


(async () => {

	let itemList = [];

	const befitUrl = "https://rezervace.befitbrno.cz/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar";

	const response = await request(befitUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("div[class='lesson_name']").each(function(){
		let course = {}
		course.name = $(this).text().trim()
		courses.push(course)
	});


	$(".book").each(function(i){
		let course = courses[i];
		let day = $(this).attr("href").trim().split("/");
		course.day = day[day.length - 1].substr(0,10);
	});


	let start = $("div[class='time start']").text().trim();
	$("div[class='time start']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	let end = $("div[class='time end']").text().trim();
	$("div[class='time end']").each(function(i){
		let course = courses[i];
		course.end = $(this).text().trim()
	});

	let availability = $("div[class='availability']").text().trim();
	$("div[class='availability']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim().replace(/  +/g, " ");
	});

	let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim().replace(/  +/g, " ");
	});

	courses = courses.filter(course => course.day != "#");

	itemList.push({
		befit:  {
		 courses,
		 "url": befitUrl,
		 "multisport": true,
		 "activepass": true
		}
	  });

	fs.writeFile("./befit.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();

(async () => {

	let itemList = [];

	const weisserUrl = "https://rezervace.weissersportcentrum.cz/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar";

	const response = await request(weisserUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("div[class='lesson_name']").each(function(){
		let course = {}
		course.name = $(this).text().trim();
		courses.push(course)
	});

	$(".book").each(function(i){
		let course = courses[i];
		let day = $(this).attr("href").trim().split("/");
		course.day = day[day.length - 1].substr(0,10);
	});


	let start = $("div[class='time start']").text().trim();
	$("div[class='time start']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	let end = $("div[class='time end']").text().trim();
	$("div[class='time end']").each(function(i){
		let course = courses[i];
		course.end = $(this).text().trim()
	});

	let availability = $("div[class='availability']").text().trim();
	$("div[class='availability']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim().replace(/  +/g, " ");
	});

	/*let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim().replace(/  +/g, " ");
	});*/

	courses = courses.filter(course => course.day != "#");

	itemList.push({
		weisser:  {
		 courses,
		 "url": weisserUrl,
		 "multisport": true,
		 "activepass": false
		}
	  });

	fs.writeFile("./weisser.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();

(async () => {

	let itemList = [];

	const kantorUrl = "https://rezervace.kantorfitness.cz/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar";

	const response = await request(kantorUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("div[class='lesson_name']").each(function(){
		let course = {}
		course.name = $(this).text().trim();
		courses.push(course)
	});

	$(".book").each(function(i){
		let course = courses[i];
		let day = $(this).attr("href").trim().split("/");
		course.day = day[day.length - 1].substr(0,10);
	});


	let start = $("div[class='time start']").text().trim();
	$("div[class='time start']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	let end = $("div[class='time end']").text().trim();
	$("div[class='time end']").each(function(i){
		let course = courses[i];
		course.end = $(this).text().trim()
	});

	let availability = $("div[class='availability']").text().trim();
	$("div[class='availability']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim().replace(/  +/g, " ");
	});

	let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim().replace(/  +/g, " ");
	});

	courses = courses.filter(course => course.day != "#");

	itemList.push({
		kantor:  {
		 courses,
		 "url": kantorUrl,
		 "multisport": false,
		 "activepass": false
		}
	  });

	fs.writeFile("./kantor.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();

(async () => {

	let itemList = [];

	const friendUrl = "https://rezervace.friendsfit.cz:18443/timeline/week?criteriaTimestamp&resetFilter=true#timelineCalendar";

	const response = await request(friendUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("div[class='lesson_name']").each(function(){
		let course = {}
		course.name = $(this).text().trim();
		courses.push(course)
	});

	$(".book").each(function(i){
		let course = courses[i];
		let day = $(this).attr("href").trim().split("/");
		course.day = day[day.length - 1].substr(0,10);
	});


	let start = $("div[class='time start']").text().trim();
	$("div[class='time start']").each(function(i){
		let course = courses[i];
		course.start = $(this).text().trim()
	});

	let end = $("div[class='time end']").text().trim();
	$("div[class='time end']").each(function(i){
		let course = courses[i];
		course.end = $(this).text().trim()
	});

	let availability = $("div[class='availability']").text().trim();
	$("div[class='availability']").each(function(i){
		let course = courses[i];
		course.availability = $(this).text().trim().replace(/  +/g, " ");
	});

	let price = $("div[class='price']").text().trim();
	$("div[class='price']").each(function(i){
		let course = courses[i];
		course.price = $(this).text().trim().replace(/  +/g, " ");
	});

	courses = courses.filter(course => course.day != "#");

	itemList.push({
		friend:  {
		 courses,
		 "url": friendUrl,
		 "multisport": true,
		 "activepass": true
		}
	  });

	fs.writeFile("./friend.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();