<template>

<articledetail v-bind:title="this.article.title" v-bind:author="this.article.author" v-bind:img="this.article.img" v-bind:date="this.article.date"
v-bind:text1="this.article.text1" v-bind:text2="this.article.text2" v-bind:text3="this.article.text3" v-bind:text4="this.article.text4" v-bind:place="this.article.place" v-bind:other="this.article.other" v-bind:price="this.article.price"
v-bind:card="this.article.card" v-bind:review="this.article.review"


/>

</template>

<script>

import ArticleDetail from './../components/ArticleDetail.vue'

export default {
	data() {
		return {
			article: {
				article: null,
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
		}
	},
	components: {
		"articledetail": ArticleDetail
	},
	mounted() {
		this.fetchArticle()
	},
	methods: {
            fetchArticle() {
				let id = this.$route.params.id;
                let url = '/articles.json';
                axios.get(url)
                    .then(response => {
						response.data.forEach(article => {
							if(article.id == id) {
								this.article = article;
							}
						});
                    })
			},
	},
	watch: {
            '$route.params.id': 'fetchArticle'
        }

}
</script>

<style>

</style>