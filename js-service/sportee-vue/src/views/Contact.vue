<template>
  <div class="container">
    <div id="app">
      <h1>Jak ti můžeme pomoci?</h1>
      <div class="border"></div>
      <p class="intro">
        Nenašel jsi ve výběru aktivitu, kterou preferuješ?
        Chceš si něco vyfiltrovat a nemůžeš?
        <br>Tak nám pomoz to zlepšit.</p>


    <contactform />
    </div>

  </div>
</template>

<script>
  import ContactForm from './../components/ContactForm.vue'

  export default {
    components: {
      "contactform": ContactForm
    }
  }
</script>

<style scoped>
  #app {
    text-align: center;
    background-color: #f1f1f1;
  }

  h1 {
    margin-top: 0;
    padding-top: 40px;
  }
  .border{
  width: 160px;
  height: 5px;
  background: rgb(100, 195, 158);
  margin: 26px auto;
}
</style>