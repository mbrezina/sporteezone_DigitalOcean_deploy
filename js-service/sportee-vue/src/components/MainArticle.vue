<template>
  <div class="article">
    <div class="content">
      <img v-bind:src="result.img" v-bind:alt="result.title" class="image" />
      <h3>{{ result.title }}</h3>
      <p>{{ result.text1 }}</p>
    </div>
    <router-link :to="{ name: 'detail', params: { id: result.id } }">
      <button>Číst více</button>
    </router-link>
  </div>
</template>

<script>
export default {
  props: ["result"],
};
</script>

<style scoped>
.article {
  border-radius: 20px;
  background-color: #fff;
  width: 400px;
  text-align: center;
  margin: 30px 20px;
  padding: 25px;
  font-size: 16px;
  position: relative;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.article h3 {
  color: #f83600;
}

.image {
  width: 100%;
}
</style>