const request = require("request-promise");
const cheerio = require("cheerio");
var fs = require("fs");

(async () => {

	let itemList = [];

	const cardsUrl = "https://www.activepass.cz/aktivity?activities=%5B%5D&locations=%5B%5D&gps_latitude=-1&gps_longitude=-1&orderBy=asc&page=1&resultsPerPage=18&searchString=&partnerSearch=true&activitySearch=false&view=list&sortBy=alphabet";

	const options = {
		url: cardsUrl,
		headers: {
		  'x-requested-with': 'xhr'
		}
	  };


	const response = await request(options);

	const $ = cheerio.load(response);

	console.log(JSON.parse(response));


	let gym = $("div[class='ActivityBox-name']").text().trim();
	console.log(gym)

	itemList.push({
		gym
	  });

	fs.writeFile("./gyms.json", JSON.stringify(itemList, null, 4).replace(/\\n/g,""), (err) => {

		if (err) {
			console.error(err);
			return;
		};
		console.log("File has been created");
	});

}
)();