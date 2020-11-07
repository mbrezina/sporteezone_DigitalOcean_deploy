const request = require("request-promise");
const cheerio = require("cheerio");
var fs = require("fs");

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
		 courses
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

	const friendUrl = "https://rezervace.friendsfit.cz:18443/timeline/week?ac%5B0%5D.s=true&_ac%5B0%5D.s=on&ac%5B1%5D.s=true&_ac%5B1%5D.s=on&ac%5B2%5D.s=true&_ac%5B2%5D.s=on&ac%5B3%5D.s=true&_ac%5B3%5D.s=on&ac%5B4%5D.s=true&_ac%5B4%5D.s=on&ac%5B5%5D.s=true&_ac%5B5%5D.s=on&ac%5B6%5D.s=true&_ac%5B6%5D.s=on&ac%5B7%5D.s=true&_ac%5B7%5D.s=on&ac%5B8%5D.s=true&_ac%5B8%5D.s=on&ac%5B9%5D.s=true&_ac%5B9%5D.s=on&ac%5B10%5D.s=true&_ac%5B10%5D.s=on&ac%5B11%5D.s=true&_ac%5B11%5D.s=on&ac%5B12%5D.s=true&_ac%5B12%5D.s=on&ac%5B13%5D.s=true&_ac%5B13%5D.s=on&ac%5B14%5D.s=true&_ac%5B14%5D.s=on&ac%5B15%5D.s=true&_ac%5B15%5D.s=on&ac%5B16%5D.s=true&_ac%5B16%5D.s=on&ac%5B17%5D.s=true&_ac%5B17%5D.s=on&ac%5B18%5D.s=true&_ac%5B18%5D.s=on&ac%5B19%5D.s=true&_ac%5B19%5D.s=on&ac%5B20%5D.s=true&_ac%5B20%5D.s=on&ac%5B21%5D.s=true&_ac%5B21%5D.s=on&ac%5B22%5D.s=true&_ac%5B22%5D.s=on&ac%5B23%5D.s=true&_ac%5B23%5D.s=on&ac%5B24%5D.s=true&_ac%5B24%5D.s=on&tc%5B0%5D.s=true&_tc%5B0%5D.s=on&tc%5B1%5D.s=true&_tc%5B1%5D.s=on&tc%5B2%5D.s=true&_tc%5B2%5D.s=on&ic%5B0%5D.s=true&_ic%5B0%5D.s=on&ic%5B1%5D.s=true&_ic%5B1%5D.s=on&ic%5B2%5D.s=true&_ic%5B2%5D.s=on&ic%5B3%5D.s=true&_ic%5B3%5D.s=on&ic%5B4%5D.s=true&_ic%5B4%5D.s=on&ic%5B5%5D.s=true&_ic%5B5%5D.s=on&ic%5B6%5D.s=true&_ic%5B6%5D.s=on&ic%5B7%5D.s=true&_ic%5B7%5D.s=on&ic%5B8%5D.s=true&_ic%5B8%5D.s=on&ic%5B9%5D.s=true&_ic%5B9%5D.s=on&ic%5B10%5D.s=true&_ic%5B10%5D.s=on&ic%5B11%5D.s=true&_ic%5B11%5D.s=on&ic%5B12%5D.s=true&_ic%5B12%5D.s=on&ic%5B13%5D.s=true&_ic%5B13%5D.s=on&ic%5B14%5D.s=true&_ic%5B14%5D.s=on&ic%5B15%5D.s=true&_ic%5B15%5D.s=on&ic%5B16%5D.s=true&_ic%5B16%5D.s=on&check_all=on&criteriaTimestamp=1576762959000";

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
		friendfitness:  {
		 courses
		}
	  });

	fs.writeFile("./friendfitness.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();