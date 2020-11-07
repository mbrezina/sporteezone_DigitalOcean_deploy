<template>
  <div id="app">



<div id="kontejner">
	<div class="header">
		<div class="horni_lista">

			<div class="hamburger" v-on:click="displayMenu">
				<div class="bar1"></div>
				<div class="bar2"></div>
				<div class="bar3"></div>
			</div>

			<logo></logo>

		</div>
	</div>

	<div id="uvod" v-on:mouseover="cancelMenu">
		<div class="perex">
			<p class="info"></p>
		</div>

	</div>
	<ul id="menu">
		<li><router-link to="/">Home</router-link></li>
		<li><router-link to="/blog">Blog</router-link></li>
        <li><router-link to="/recenze">Recenze</router-link></li>
		<li><router-link to="/projekt">O projektu</router-link></li>
		<li><router-link to="/kontakt">Kontakt</router-link></li>
	</ul>

</div>
    <router-view/>
  </div>
</template>

<script>
import Logo from '@/components/Logo.vue'

export default {
  name: 'app',
  components: {
    "logo": Logo
  },
  methods: {
      displayMenu() {
        let button = document.querySelector("#menu");

        if (button.style.display === "block") {
            button.style.display = "none";
        } else {
            button.style.display = "block";
        }
    },
    cancelMenu() {
        if (window.matchMedia("(max-width: 499px)").matches) {

            let button = document.querySelector("#menu");
            button.style.display = "none";
        }
    }
  }
}

</script>

<style>
html {
    box-sizing: border-box;
}

*,
::after,
::before {
    box-sizing: inherit;
}



body {
    font-family: 'Cabin', sans-serif;
    font-size: 18px;
    margin: 0;
    min-width: 390px;
    background-color: #f1f1f1;
}

#kontejner {
    position: relative;
}

.info {
    display: none;
}

.hamburger {
    padding-left: 10px;
}

.bar1,
.bar2,
.bar3 {
    width: 35px;
    height: 5px;
    background-color: white;
    margin: 6px 0;
}

#menu {
    display: none;
    min-width: 300px;
    max-width: 300px;
    box-shadow: 0 2.5px 5px rgba(0, 0, 0, 0.3);
    list-style-type: none;
    margin: 0;
    padding: 20px;
    font-size: 16px;
    background-color: white;
    position: absolute;
    top: 60px;
    text-transform: uppercase;
    font-weight: 600;
}

#menu li {
    padding: 10px;
    padding-left: 30px;
    padding-right: 30px;
}


#menu a {
    text-decoration: none;
    color: white;
}

#menu a:hover,
#menu a:focus {
    color: #e9d699;
}

.header,
#menu {
    background: rgba(19, 22, 21);

}

.horni_lista {
    padding-left: 20px;
    display: flex;
    min-width: 400px;
    align-items: center;
    box-shadow: inset 20px 20px 34px -43px rgba(0, 0, 0, 0.56);

}

@media (min-width: 1000px) {
    #menu {
        display: flex;
        min-width: 300px;
        max-width: 800px;
        padding: 0px;
        list-style-type: none;
        margin: 0;
        box-shadow: none;
        text-align: center;
        font-size: 16px;
        right: 0;
        line-height: 18px;
        position: absolute;
        top: 20px;
    }

    .bar1,
    .bar2,
    .bar3,
    .hamburger {
        display: none;
    }
}
</style>
