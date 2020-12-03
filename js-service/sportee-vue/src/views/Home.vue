<template>
  <div>
    <div id="cover-photo">
      <div class="text-cover-photo">
        <h1 class="display">Sportuj s námi</h1>
        <p class="display">
          Sportuješ často a nebaví tě pořád sledovat rozvrhy jednotlivých
          sportovišť? Vyzkoušej naši aplikaci a hned zjistíš, kde se co cvičí.
        </p>
      </div>
      <activityform v-on:eventResults="getResults" class="form" />
    </div>

    <div class="content">
      <lecture
        v-for="(result, index) in results"
        v-bind:key="index"
        v-bind:result="result"
      />

      <h1 v-if="this.results.length == 0" class="no-lectures">
        Pro tento den bohužel nejsou žádné lekce vypsány 😢
      </h1>
    </div>
  </div>
</template>

<script>
import ActivityForm from "./../components/ActivityForm.vue";
import Lecture from "@/components/Lecture.vue";
import { utcToZonedTime, format } from "date-fns-tz";
import { endOfDay } from "date-fns";

export default {
  components: {
    activityform: ActivityForm,
    lecture: Lecture,
  },

  data() {
    return {
      results: [],
    };
  },

  mounted() {
    let startDate = new Date();
    let endDate = endOfDay(startDate);

    startDate = format(startDate, "yyyy-MM-dd'T'HH:mm:ss", {
      timeZone: "Europe/Prague",
    });
    endDate = format(endDate, "yyyy-MM-dd'T'HH:mm:ss", {
      timeZone: "Europe/Prague",
    });

    const url = `${process.env.VUE_APP_API_URL}/lekce/byDatum?zacatek=${startDate}&konec=${endDate}&hledaneKategorie=`;

    return axios.get(url).then((response) => {
      this.results = response.data;
    });
  },

  methods: {
    getResults(results) {
      this.results = results;
    },
  },
};
</script>

<style scoped>
.content h1 {
  padding-right: 20px;
  padding-left: 40px;
}

#cover-photo {
  height: 550px;
  background-image: linear-gradient(
      to bottom,
      rgba(0, 0, 0, 0.4),
      rgba(0, 0, 0, 0.4)
    ),
    url(../assets/cover.jpg);
  background-position: 30% 50%;
  background-repeat: no-repeat;
  background-size: cover;
  border-bottom: 2px solid white;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.text-cover-photo {
  color: white;
  text-align: left;

  margin: 10px 60px;
}

.text-cover-photo h1 {
  text-transform: uppercase;
  font-weight: 100;
  text-align: left;
}

.text-cover-photo p {
  text-align: left;
  font-style: italic;
}

.form {
  margin: 20px;
}

.no-lectures {
  text-align: center;
  color: #fcfbff;
}

.display {
  display: none;
}

@media (min-width: 650px) {
  .content {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
  }
}

@media (min-width: 860px) {
  .display {
    display: flex;
  }
  #cover-photo {
    flex-direction: row;
    justify-content: space-evenly;
  }
  .text-cover-photo {
    width: 382px;
    text-align: center;
  }
}
</style>
