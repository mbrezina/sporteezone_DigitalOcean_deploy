const request = require("request-promise");
const cheerio = require("cheerio");
var fs = require("fs");

(async () => {

	let itemList = [];

	const yogaUrl = "https://yogahouse.isportsystem.cz/ajax/ajax.schema.php?day=12&month=12&year=2019&id_sport=5&default_view=day&reset_date=0&event=create&id_infotab=0&time=&filterId=false&filterChecked=false&tab_type=activity&numberOfDays=35";

	const response = await request(yogaUrl);

	const $ = cheerio.load(response);

	let courses = [];

	$("span[class='name']").each(function(){
		let course = {}
		course.name = $(this).text().trim()
		courses.push(course)
	});

	let day = $("td[class='endDay ']").text().trim();
	$("td[class='endDay ']").each(function(i){
		let course = courses[i];
		course.day = $(this).text().trim()
	});

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
		yogaHouse: {
		 courses
		}
	  });



	fs.writeFile("./yogaHouse.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();
