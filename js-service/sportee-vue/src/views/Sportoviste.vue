<template>
  <div class="sportoviste">
    <h1>Sportoviště</h1>
    <hr class="har" />

    <div class="content">
      <fitnessCenter
        v-for="(result, index) in results"
        v-bind:key="index"
        v-bind:result="result"
      />
    </div>
  </div>
</template>

<script>
import FitnessCenter from "@/components/FitnessCenter.vue";
import { utcToZonedTime, format } from "date-fns-tz";
import { endOfDay } from "date-fns";

export default {
  components: {
    fitnessCenter: FitnessCenter,
  },

  data() {
    return {
      results: [],
    };
  },

  mounted() {
    const url = `${process.env.VUE_APP_API_URL}/fitness`;

    return axios.get(url).then((response) => {
      this.results = response.data;
      console.log(this.results);
    });
  }
};
</script>

<style scoped>
.sportoviste h1 {
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
  .sportoviste h1 {
    font-size: 70px;
    margin-top: 80px;
  }
}
</style>