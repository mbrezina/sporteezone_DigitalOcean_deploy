<template>
<div class="main-article">
	<img src="../assets/yoga.jpg" alt="women in yoga position">
	<div class="article-holder">
		<div class="text">
			<h2>Hotjóga přohřeje tělo i duši</h2>
			<p>Jóga ať už klasické nebo jakákoliv jiná mě nikdy nějak extra nelákala. To se změnilo po několika návštěvách
				hotjógy, kdy jsem zjistila, kolik benefitů mi cvičení ásán v teple přináší. Co mi jóga dává a kam chodím cvičit?
			</p>
		</div>
		<router-link to="/clanek/1"><button>Číst více</button></router-link>
	</div>
</div>

</template>

<script>
export default {

}
</script>

<style scoped>

.main-article img {
	width: 300px;
}

.main-article {
	margin: 30px;
}

#readMore {
	display: none;
	margin-left: 20px;
}

.article-holder button {
	margin-left: 20px
}

@media (min-width: 650px) {

	.main-article {
		display: flex;
	}

	.text {
		margin-left: 20px;
	}
}

</style>