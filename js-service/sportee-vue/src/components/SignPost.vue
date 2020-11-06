<template>
<div>

	<div class="object-container">
		<h2>Rozcestník kam dále</h2>
		<p class="object-text">Chceš se o projektu dozvědět víc? Hledáš recenze na provozovny nebo informace o jednotlivých sportovních aktivitách?
			Mrkni se na rozcestník.
		</p>

		<div class="first-col">
			<router-link to="/blog">
				<div class="object pink">
					<div class="icon">
						<vue-fontawesome icon="book" size="2" color="white"></vue-fontawesome>
					</div>
					<div class="popis">
						<h2 class="hlavni-nazev">Blog</h2>
						<p class="description">Zajímavé čtení o&nbsp;sportu a&nbsp;cvičení</p>
					</div>
				</div>
			</router-link>

			<router-link to="/recenze">
				<div class="object green">
					<div class="icon">
						<i class="fas fa-star-half-alt fa-lg"></i>
						<vue-fontawesome icon="star" size="2" color="white"></vue-fontawesome>
					</div>
					<div class="popis">
						<h2 class="hlavni-nazev">Recenze</h2>
						<p class="description">Kde se nám dobře cvičilo</p>
					</div>
				</div>
			</router-link>
		</div>

		<div class="second-col">
			<router-link to="/projekt">
				<div class="object yellow">
					<div class="icon">
						<vue-fontawesome icon="file" size="2" color="white"></vue-fontawesome>
					</div>
					<div class="popis">
						<h2 class="hlavni-nazev">Projekt</h2>
						<p class="description">Přečtěte si, jak celý projekt vznikl</p>
					</div>
				</div>
			</router-link>

			<router-link to="/kontakt">
				<div class="object pea">
					<div class="icon">
						<vue-fontawesome icon="comment" size="2" color="white"></vue-fontawesome>
					</div>
					<div class="popis">
						<h2 class="hlavni-nazev">Kontakt</h2>
						<p class="description">Máte pro nás nějaký vzkaz?</p>
					</div>
				</div>
			</router-link>
		</div>
	</div>
</div>
</template>

<script>
export default {

}
</script>

<style>

.object-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 50px;
  color: black;
  text-align: center;
}

.object-container a {
  text-decoration: none;
}

.object-container p {
  padding-left: 30px;
  padding-right: 30px;
  margin-bottom: 40px;
}

.object {
  height: 150px;
  width: 100%;
  min-width: 300px;
  max-width: 300px;
  color: white;
  display: flex;
  justify-content: center;
  align-items: center;
}

.description {
  font-size: 16px;
}

.pink {
  background: rgb(244, 124, 121) none repeat scroll 0% 0%;
}

.green {
  background: rgb(100, 195, 158) none repeat scroll 0% 0%;
}

.yellow {
  background: rgb(215, 190, 95) none repeat scroll 0% 0%;
}

.pea {
  background: rgb(161, 190, 95) none repeat scroll 0% 0%;
}

.hlavnimenu img {
  border-radius: 50%;
}

hr {
  width: 50%;
}

.icon {
  border-radius: 50%;
  border: 3px solid white;
  padding: 30px;
  margin-right: 20px;
  margin-left: 20px;
}

@media (min-width: 650px) {
  .first-col {
    display: flex;
    margin-bottom: 20px;
  }

  .second-col {
    display: flex;
  }

  .pink,
  .yellow {
    margin-right: 20px;
  }

}

@media (min-width: 860px) {

  .object-container {
    padding-bottom: 50px;
  }

  p.object-text {
    width: 50%;
  }
}


</style>