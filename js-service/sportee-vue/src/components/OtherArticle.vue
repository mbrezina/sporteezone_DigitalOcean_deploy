<template>
	<div class="other-article">
		<img src="../assets/yoga2.jpg" alt="women training yoga">
		<div class="article-holder">
			<div class="text">
				<h3>Ano pohybu i ve starším věku</h3>
				<p>Už jako malé děti sme se učili o výhodách udržování aktivního pohybu a cvičení. Je velmi snadné si
					myslet, že sport a cvičení jsou možné pouze tehdy, když jsme mladší. Je milnou představou, že
					zahájení nového sportu není tak výhodné, když je člověku několik let. To ale není úplne pravda!</p>
			</div>
			<router-link to="/clanek/2"><button>Číst více</button></router-link>
		</div>
	</div>
</template>

<script>
	export default {

	}
</script>

<style scoped>
	.other-article img {
		width: 200px;
	}

	.other-article {
		margin: 30px;
	}

	#readMore {
		display: none;
		margin-left: 20px;
	}

	.article-holder {
		margin-left: 20px;
	}

	@media (min-width: 650px) {

		.other-article {
			display: flex;
		}

		.other-article .text {
			font-size: 16px;
		}
	}
</style>