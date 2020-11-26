<template>
  <div class="container">
    <h1 class="heading">{{ result.title }}</h1>
    <hr class="har" />

    <p class="heading"><strong>Autor:</strong> {{ result.author }}</p>

    <p class="heading"><strong>Datum vydání:</strong> {{ result.date }}</p>

    <div class="content">
      <img v-if="result.img" :src="result.img" />

      <p>{{ result.text1 }}</p>

      <p>{{ result.text2 }}</p>

      <p>{{ result.text3 }}</p>

      <p>{{ result.text4 }}</p>

      <p v-if="result.place"><strong>Sportoviště:</strong> {{ result.place }}</p>

      <p v-if="result.other"><strong>Další informace:</strong> {{ result.other }}</p>

      <p v-if="result.price"><strong>Cena:</strong> {{ result.price }}</p>

      <p v-if="result.card"><strong>Sport karty:</strong> {{ result.card }}</p>

      <p v-if="result.review"><strong>Hodnocení:</strong> {{ result.review }}</p>
    </div>
  </div>
</template>

<script>
import { id } from 'date-fns/locale';
export default {
  data() {
    return {
      result: {}
    };
  },
  mounted() {
    const url = "/articles.json";
    const idx = this.$route.params.id-1;

    return axios.get(url).then((response) => {
      this.result = response.data[idx];
    });
  }
};
</script>

<style scoped>
.container {
  padding: 30px;
}

.container h1 {
  text-transform: uppercase;
	font-weight: 100;
	margin-bottom: 5px;
}

.heading {
  text-align: center;
  color: white;
}

.har {
	color: white;
	width: 65%;
	margin-bottom: 30px;
}

.content {
  background-color: #f1f1f1;
	padding: 5px 5px;
  margin: 30px;
  border-radius: 15px;
}

.content p {
  text-align: left;
}

img {
  width: 100%;
  max-width: 500px;
  float: left;
	padding: 0 30px 30px 0;
	margin-top: 18px;
}

a {
  text-decoration: none;
  color: black;
}

@media (min-width: 600px) and (max-width: 999px) {
  .content {
  margin-top: 30px;
  }
}

@media (min-width: 1000px) {
  .container {
    width: 960px;
    margin: 0 auto;
  }
  .content {
	padding: 40px 60px;
  margin-top: 40px;
  }
}
</style>