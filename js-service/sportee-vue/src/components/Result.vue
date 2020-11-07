<template>

	<div class="container">

		 <h1>Najdi si čas a aktivitu vhodnou právě pro tebe</h1>
		 <p>Zde si můžete vybrat z dostupných možností</p>
      <div class="border"></div>


		<div v-for="(gym, index) in filteredGyms"  :key="index" class="session-body">

			<a v-bind:href="gym.url"><h3>{{gym.name}}</h3></a>

			<table>
				<tr>
					<th class="date">Datum</th>
					<th class="time">Čas</th>
					<th class="activity">Aktivita</th>
				</tr>
				<tr v-for="(course, index) in gym.courses" :key="index">
					<td class="date">{{(new Date(course.day).getDate()) + ". " + (new Date(course.day).getMonth() + 1) + ". " + (new Date(course.day).getFullYear())}}</td>
					<td class="time">{{course.start}}</td>
					<td class="activity">{{course.name}}</td>
				</tr>

			</table>
		</div>
	</div>

</template>

<script>
export default {
	data() {
		return {
			gyms: [],
			filteredGyms: [],
			url: ""
		}

	},
	mounted() {
		Promise.all([
			this.fetchGym("/afit.json"),
			this.fetchGym("/befit.json"),
			this.fetchGym("/weisser.json"),
			this.fetchGym("/kantor.json"),
			this.fetchGym("/friend.json")

		]).then(() => {
			this.filterGyms();
		});
	},
	methods: {
		filterGyms() {
			let date = this.$route.query.date;
			let time = this.$route.query.time;
			let multisport = this.$route.query.multisport;
			let activepass = this.$route.query.activepass;

			console.log(time);
			this.gyms.forEach(gym => {

				if ((multisport && !gym.multisport) || (activepass && !gym.activepass)) {
					return;
				}

				let name = gym.name;
				let courses = gym.courses.filter(course => {
					if (date && date != course.day) {
						return false;
					}

					if (time && time.padStart(5, '0') != course.start.padStart(5, '0')) {
						return false;
					}
					return true;
				})


				if (courses.length) {
					this.filteredGyms.push({
						"name": name,
						"courses": courses
					})
				}
			})

		},

		fetchGym(url) {

			return axios.get(url)
				.then(response => {
					response.data.forEach(gym => {

						for (let key in gym) {
							let newGym = gym[key];
							newGym.name = this.getGymName(key);
							this.gyms.push(newGym);
						}

					});
				});
		},

		getGymName(slug) {

			switch(slug) {
			case "afit":
				return "Afit.cz";
			case "befit":
				return "Befitbrno.cz";
			case "weisser":
				return "Weissersportcentrum.cz";
			case "kantor":
				return "Kantorfitness.cz";
			case "friend":
				return "Friendsfit.cz";
			default:
				return "-";
			}

		}
	}
}
</script>

<style scoped>

.container {
	max-width: 1000px;
	margin: 0 auto;
	text-align: center;
}

.session-body{
    padding: 10px 30px;
    padding-bottom: 30px;
    border-radius: 8px 2px;
    position: top;
    background-color: white;
    margin:40px;
    box-shadow: 0 3px 25px rgba(0,0,0,.1);
}

h1 {
    margin-top: 0;
	padding-top: 40px;

  }
  .border{
  width: 160px;
  height: 5px;
  background: rgb(100, 195, 158);
  margin: 26px auto;
  }

table {
  border-collapse: collapse;
  width: 100%;
}

a {
	text-decoration: none;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 15px;
}

tr:nth-child(1) {
  background-color: rgb(215, 190, 95);
}

tr:nth-child(even) {

  background-color: #F8F8F8;
}

th.date {
	background-color: rgb(215, 190, 95);
}

th.time {
	background-color: rgb(100, 195, 158);
}

th.activity {
background-color: rgb(244, 124, 121);
}

</style>