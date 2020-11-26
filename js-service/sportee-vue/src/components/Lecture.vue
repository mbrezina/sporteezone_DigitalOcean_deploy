<template>
  <div class="lekce">
    <a v-bind:href="result.fitko.url" target="_blank"> <img src="https://st2.depositphotos.com/2100659/5952/v/600/depositphotos_59525863-stock-illustration-health-woman-vector-logo-concept.jpg" alt="logo" class="logo"> </a>
    
    <h3>{{ result.nazev }}</h3>
    <p>Den: {{ den }}</p>
    <p>Čas: {{ cas }}</p>
    <!-- <p>Místo: {{ result.fitko.nazev }}</p> -->
    <p>Trenér: {{ result.trener }}</p>
    <p>Cena: {{ result.cena }} Kč</p>
    <p>Obsazenost: {{ result.obsazenost }} / {{ result.kapacita }}</p>
    <a v-bind:href="result.url" target="_blank"> <button>Jdu do toho!</button></a>
  </div>
</template>

<script>
export default {
  props: ["result"],

  computed: {
    den() {
      const date = new Date(this.result.zacatek);
      return `${date.getDate()}. ${date.getMonth() + 1}. ${date.getFullYear()}`;
    },
    cas() {
      const start = new Date(this.result.zacatek);
      const end = new Date(this.result.konec);
      return `${start.getHours()}:${start.getMinutes()} - ${end.getHours()}:${end.getMinutes()}`;
    },
  },
};
</script>

<style scoped>
.lekce {
  border-radius: 20px;
  background-color: #fff;
  width: 400px;
  text-align: center;
  margin: 30px 20px;
  padding: 25px;
  font-size: 16px;
}

.lekce h3 {
  color: #f83600;
  margin-top: 0;
}

.logo {
  width: 40%;
  padding: 0;
}
</style>