<template>
<div class="container">
	<h1><router-link v-bind:to="'/#/clanek/' + id">{{title}}</router-link></h1>

	<p><strong>Autor:</strong> {{author}}</p>

	<P><strong>Datum vydání:</strong> {{date}}</p>

	<img v-if="img" :src="img"/>

	<p>{{text1}}</p>

	<p>{{text2}}</p>

	<p>{{text3}}</p>

	<p>{{text4}}</p>



	<p v-if="place"><strong>Sportoviště:</strong> {{place}}</p>

	<p v-if="other"><strong>Další informace:</strong> {{other}}</p>

	<p v-if="price"><strong>Cena:</strong> {{price}}</p>

	<p v-if="card"><strong>Sport karty:</strong> {{card}}</p>

	<p v-if="review"><strong>Hodnocení:</strong> {{review}}</p>

</div>

</template>

<script>
export default {
	props: [
		'article',
		'id',
		'title',
		'img',
		'author',
		'date',
		'text1',
		'text2',
		'text3',
		'text4',
		'place',
		'other',
		'price',
		'card',
		'review'
	]
}
</script>

<style scoped>

.container {
	padding: 30px;
}

img {
	width: 100%;
	max-width: 500px;
	float: left;
	padding-right: 20px;
}

a {
	text-decoration: none;
	color: black;
}

@media(min-width:1000px) {
	.container {
		width: 960px;
		margin: 0 auto;
	}
}

</style>