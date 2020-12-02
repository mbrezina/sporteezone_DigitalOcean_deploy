<template>
  <div class="blog">
		<h1>Blog</h1>
		<hr class="har" />
    
		<div class="content">
      <mainarticle
        v-for="(result, index) in results"
        v-bind:key="index"
        v-bind:result="result"
      />
    </div>
  </div>
</template>

<script>
import MainArticle from "./../components/MainArticle.vue";

export default {
  components: {
    mainarticle: MainArticle,
	},
	
  data() {
    return {
      results: [],
    };
  },
  mounted() {
		const url = "/articles.json";

    return axios.get(url).then((response) => {
      this.results = response.data;
      console.log(this.results);
    });
  }
};
</script>

<style scoped>
.blog h1 {
  text-align: center;
  color: #fcfbff;
  text-transform: uppercase;
  font-weight: 100;
  margin-bottom: 5px;
  font-size: 42px;
  margin-top: 40px;
}

.har {
  border-top: 1px solid #ffff;
  border-bottom: none;
  width: 50%;
  margin-bottom: 30px;
}

.content {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-evenly;
}

@media (min-width: 1000px) {
  .blog h1 {
    font-size: 70px;
    margin-top: 80px;
  }
}
</style>
