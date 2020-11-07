<template>

  <div class="container blog">

    <!--<div v-for="article in this.articles">
      <articledetail v-bind:title="article.title" v-bind:author="article.author" v-bind:id="article.id" />
    </div>-->

		<div class="blog-container">
			<h1>Blog</h1>
      <div class="border"></div>
			<p>V našem blogu se dočtete novinky ze světa sportu, recenze na sportoviště a také informace o jednotlivých
				sportech.</p>
		</div>

  <mainarticle />

  <hr>

  <otherarticle />

  <div class="other-article">
		<img src="../assets/workout.jpg" alt="workout">
		<div class="article-holder">
			<div class="text">
				<h3>Befit nabízí množství lekcí i o víkendu</h3>
				<p>Do Befitu si většinou najdu cestu několikrát do týdne. Líbí se mi, že se tu cvičí od brzkých ranních hodin
          přes oběd až do večera. Oproti ostatním cvičištím je to určitě výhoda. Často se
          mi stává, že ráno ani odpoledne čas nemám a jediný čas na cvičení mi zbývá právě v obědové přestávce.</p>
			</div>
			<router-link to="/clanek/3"><button>Číst více</button></router-link>
		</div>
	</div>

</div>

</template>

<script>

import MainArticle from "./../components/MainArticle.vue"
import OtherArticle from "./../components/OtherArticle.vue"
import ArticleDetail from './../components/ArticleDetail.vue'

export default {
  components: {
    "mainarticle": MainArticle,
    "otherarticle": OtherArticle,
    "articledetail": ArticleDetail
  },
  data() {
		return {
			articles: [{
				id: null,
        title: null,
        img: null,
				author: null,
				date: null,
        text1: null,
        text2: null,
        text3: null,
        text4: null,
				place: null,
				other: null,
				price: null,
				card: null,
				review: null,
      }
      ]
		}
	},
	mounted() {
		this.fetchArticles()
	},
	methods: {
    fetchArticles() {
      let id = this.$route.params.id;
        let url = '/articles.json';
        axios.get(url)
            .then(response => {
        this.articles = response.data
        })
			},
	}
}
</script>

<style scoped>

.blog-container {
	margin: 30px;
  text-align: center;
}

.blog-container p {
	margin-bottom: 50px;
}

.border{
  width: 160px;
  height: 5px;
  background: rgb(100, 195, 158);
  margin: 26px auto;
}

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



	@media (min-width: 650px) {

		.other-article {
			display: flex;
		}

		.other-article .text {
			font-size: 16px;
		}
	}

@media (min-width: 860px) {
	.blog {
		padding: 10px;
		margin: 0px auto 0 auto;
  }

  .container {
    width: 960px;
    background-color: white;
    box-shadow: 0 0 8px 1px rgba(140, 138, 140, 1);
    position: relative;
    z-index: 1;
  }

  .article-holder {
		margin-left: 20px;
	}
}


</style>
