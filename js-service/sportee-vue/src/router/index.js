import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Blog from '../views/Blog.vue'
import Project from '../views/Project.vue'
import Contact from '../views/Contact.vue'
import Review from '../views/Review.vue'
import SearchResults from '../views/SearchResults.vue'
import BlogDetail from '../views/BlogDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/blog',
    name: 'blog',
    component: Blog
  },
  {
    path: '/projekt',
    name: 'project',
    component: Project
  },
  {
    path: '/kontakt',
    name: 'contact',
    component: Contact
  },
  {
    path: '/recenze',
    name: 'review',
    component: Review
  },
  {
    path: '/vysledky',
    name: 'search',
    component: SearchResults
  },
  {
    path: '/clanek/:id',
    name: 'article',
    component: BlogDetail
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
