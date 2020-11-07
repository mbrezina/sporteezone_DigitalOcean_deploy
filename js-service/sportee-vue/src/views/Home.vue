<template>
<div>
	<div id="cover-photo">
		<div class="text-cover-photo">
			<h1>Sportuj s námi</h1>
			<p>Sportuješ často a nebaví tě pořád sledovat rozvrhy jednotlivých sportovišť? Vyzkoušej naši aplikaci a
				hned zjistíš, kde se co cvičí.</p>
		</div>
	</div>

   <activityform />

  <div class="container">

  <mainarticle />

   <div class="testimonials">
    <div class="inner">
      <div class="row">


          <div class="col">
             <router-link to="/recenze">
            <div class="testimonial">
              <img src="../assets/afit.png" alt="afit logo">
              <div class="name">Ludmila</div>
              <p>"Skvělé místo dát si pořádně do těla. Vybavení posilovny na jedničku, sprchy by zasloužily
                častější pořádek. Oceňuji možnost využití multisportky."
              </p>
              <div class="stars">
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star checked"></span>
                <span class="fa fa-star"></span>
              </div>
            </div>
            </router-link>
          </div>


        <div class="col">
          <router-link to="/recenze">
          <div class="testimonial">
            <img src="../assets/bluegym.png" alt="Bluegym logo">
            <div class="name">Veronika</div>
            <p>"V Blue Gym cvičím několikrát do týdne. Oceňuji především různorodost sálových lekcí a v mém případě
              výbornou dostupnost do centra."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
          </router-link>
        </div>


        <div class="col">
           <router-link to="/recenze">
          <div class="testimonial">
            <img src="../assets/bfit.jpg" alt="bfit logo">
            <div class="name">Zuzka</div>
            <p>"Je to místo, kde mám rozhodně pocit, že něco dělám! Rozhodně oceňuji prostředí a vřele doporučuji všem,
              kteří se rozhodli cvičit."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
           </router-link>
        </div>
      </div>
    </div>
  </div>

  <pagefooter />

  </div>
</div>

</template>

<script>

import ActivityForm from './../components/ActivityForm.vue'
import SignPost from './../components/SignPost.vue'
import PageFooter from './../components/PageFooter.vue'
import MainArticle from './../components/MainArticle.vue'

export default {
  components: {
    "activityform": ActivityForm,
    "signpost": SignPost,
    "pagefooter": PageFooter,
    "mainarticle": MainArticle
  }
}

</script>

<style scoped>
#cover-photo {
  height: 550px;
  background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.4), rgba(0, 0, 0, 0.4)), url(../assets/cover.jpg);
  background-position: 30% 50%;
  background-repeat: no-repeat;
  background-size: cover;
}

#app {
  background-color: #fcfbff;
}

.text-cover-photo {
  padding: 30px;
  padding-top: 150px;
  color: white;
  font-size: 25px;
}

h1 {
  text-align: left;
}

a {
  text-decoration: none;
  color: black;
}

.row {
  display: block;
}

.main-article {
  margin-top: 0;
  padding-top: 30px;
  text-align: center;
}

.testimonials {
  padding-top: 100px;
  padding-bottom: 60px;
}

@media (min-width: 650px) {

  .text-cover-photo {
    padding-left: 20%;
    padding-right: 20%;
  }
  .row {
    display: flex;
  }
}

@media (min-width: 860px) {
  .container {
    background-color: #f1f1f1;
   }
   .main-article {
     max-width: 1000px;
     margin: auto;
     margin-top: 60px;
   }
}

@media (min-width: 1000px) {
  #cover-photo {
    display: flex;
   }

    .text-cover-photo p {
      width: 500px;
    }

    .main-article img {
      width: 100%;
      max-width: 500px;
    }



    .article-holder {
      max-width: 500px;
    }
}
</style>
