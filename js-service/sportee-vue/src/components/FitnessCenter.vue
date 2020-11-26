<template>
  <div class="fitko">
    <a v-bind:href="result.url" target="_blank"> <img src="https://st2.depositphotos.com/2100659/5952/v/600/depositphotos_59525863-stock-illustration-health-woman-vector-logo-concept.jpg" alt="logo" class="logo"> </a>
    <h3>{{ result.nazev }}</h3>
    <p>Adresa: {{ result.ulice }}, {{result.psc}} {{ result.mesto }}</p>
    <a v-bind:href="result.url" target="_blank"> <button>WEB</button></a>
  </div>
</template>

<script>
export default {
  props: ["result"]
};
</script>

<style scoped>
.fitko {
  border-radius: 20px;
  background-color: #fff;
  width: 400px;
  text-align: center;
  margin: 30px 20px;
  padding: 25px;
  font-size: 16px;
}

.fitko h3 {
  color: #f83600;
  margin-top: 0;
}

.logo {
  width: 40%;
  padding: 0;
}
</style>