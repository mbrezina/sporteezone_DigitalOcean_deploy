<template>
  <div id="app">
    <div class="main-content">
      <div id="kontejner" class="header">
        <div class="logo-sportee">
          <!--  <logo /> -->
          <img src="./assets/logo-bile.png" alt="sportee-logo" />
        </div>

        <!-- 
          <div id="uvod" v-on:mouseover="cancelMenu">
            <div class="perex">
              <p class="info"></p>
            </div>
          </div> 
        -->

        <div>
          <div class="hamburger" v-on:click="displayMenu">
            <div class="bar1"></div>
            <div class="bar2"></div>
            <div class="bar3"></div>
          </div>

          <div>
            <ul id="menu">
              <li><router-link to="/">Home</router-link></li>
              <li><router-link to="/sportoviste">Sportoviště</router-link></li>
              <li><router-link to="/blog">Blog</router-link></li>
              <li><router-link to="/projekt">O projektu</router-link></li>
              <li><router-link to="/kontakt">Přihlásit se</router-link></li>
            </ul>
          </div>
        </div>
      </div>

      <router-view />
    </div>

    <pagefooter />
  </div>
</template>

<script>
import Logo from "@/components/Logo.vue";
import PageFooter from "@/components/PageFooter.vue";

export default {
  name: "app",
  components: {
    logo: Logo,
    pagefooter: PageFooter,
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
    },
  },
};
</script>

<style>
html {
  box-sizing: border-box;
}

.main-content {
  min-height: calc(100vh - 80px);
}

*,
::after,
::before {
  box-sizing: inherit;
}

body {
  font-family: "Spartan", sans-serif;
  font-size: 18px;
  margin: 0;
  min-width: 300px;
  /*background: #ff3e78 linear-gradient(to top, #ff3e78, #ffbd2e); */
  background-image: linear-gradient(to top, #f83600 0%, #f9d423 100%);
}

/*.info {
  display: none;
}*/

.header {
  /*background: #ff3e78 linear-gradient(to right, #ff3e78, #ffbd2e);*/
  background-image: linear-gradient(to right, #f83600 0%, #f9d423 100%);
  border-bottom: 2px solid white;
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 60px;
}

.logo-sportee {
  display: flex;
  align-items: center;
  /*box-shadow: inset 20px 20px 34px -43px rgba(0, 0, 0, 0.56);*/
}

.logo-sportee img {
  width: 200px;
  padding: 10px;
}

.hamburger {
  padding-right: 30px;
}

.bar1,
.bar2,
.bar3 {
  width: 35px;
  height: 5px;
  background-color: rgb(26, 2, 2);
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
  text-transform: uppercase;
}

#menu a {
  text-decoration: none;
  color: white;
}

#menu a:hover,
#menu a:focus {
  color: #f83600;
}

@media (min-width: 807px) {
  #menu {
    display: flex;
    max-width: 900px;
    padding: 0px;
    list-style-type: none;
    margin: 0;
    box-shadow: none;
    text-align: center;
    font-size: 14px;
    right: 0;
  }

  .bar1,
  .bar2,
  .bar3,
  .hamburger {
    display: none;
  }


  #menu li {
    padding: 10px 10px;
  }
}

@media (min-width: 1000px) {
  #menu li {
    padding: 10px 20px;
  }

  #menu {
    font-size: 16px;
  }
}
</style>
