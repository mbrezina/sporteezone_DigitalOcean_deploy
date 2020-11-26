<template>
  <div>
    <form @submit.prevent="sendForm">
      <div class="activity-form">
        <h3>Vyber si aktivitu</h3>
        <div class="input">
          <label>Datum</label>
          <input
            v-model="date"
            placeholder="Vyber datum"
            type="date"
            name="date"
          />
        </div>

        <div class="input">
          <label>Čas</label>
          <input v-model="time" type="time" name="time" />
        </div>

        <div class="flex">
          <div class="kategorie">
            <div class="checkbox all">
              <input
                v-model="all"
                type="checkbox"
                name="all"
                v-on:click="checkAll()"
              />
              <label>Vše</label>
            </div>

            <div class="checkbox">
              <input v-model="posilovani" type="checkbox" name="posilovani" />
              <label>Posilování</label>
            </div>

            <div class="checkbox">
              <input v-model="dance" type="checkbox" name="dance" />
              <label>Tanec</label>
            </div>

            <div class="checkbox">
              <input v-model="joga" type="checkbox" name="joga" />
              <label>Jóga</label>
            </div>

            <div class="checkbox">
              <input v-model="deti" type="checkbox" name="deti" />
              <label>Děti</label>
            </div>

            <div class="checkbox">
              <input v-model="zumba" type="checkbox" name="zumba" />
              <label>Zumba</label>
            </div>
          </div>

          <div class="kategorie">
            <div class="checkbox">
              <input v-model="pilates" type="checkbox" name="pilates" />
              <label>Pilates</label>
            </div>

            <div class="checkbox">
              <input v-model="bosu" type="checkbox" name="bosu" />
              <label>BOSU</label>
            </div>

            <div class="checkbox">
              <input v-model="tabata" type="checkbox" name="tabata" />
              <label>Tabata</label>
            </div>

            <div class="checkbox">
              <input v-model="aerobic" type="checkbox" name="aerobic" />
              <label>Aerobic</label>
            </div>

            <div class="checkbox">
              <input v-model="box" type="checkbox" name="box" />
              <label>Box</label>
            </div>

            <div class="checkbox">
              <input v-model="ostatni" type="checkbox" name="ostatni" />
              <label>Ostatní</label>
            </div>
          </div>
        </div>

        <!-- 
        <div class="card">
            <label>Vyber kartu:</label><br>
            <input v-model="multisport" type="checkbox" class="largerCheckbox" id="multisport" name="multisport" value="multisport"><label>Multisport</label>
            <input v-model="activepass" type="checkbox" class="largerCheckbox" id="activepass" name="activepass" value="activepass"><label>Activepass</label>
        </div>
        -->

        <button class="button-activity">Vyhledat</button>
      </div>
    </form>
  </div>
</template>

<script>
import ButtonDefault from "./../components/ButtonDefault.vue";
import { utcToZonedTime, format } from "date-fns-tz";
import { endOfDay } from "date-fns";

export default {
  components: {
    buttonDefault: ButtonDefault,
  },
  data() {
    return {
      date: "",
      time: "",
      selected: "",
      multisport: false,
      activepass: false,
      results: "",
      posilovani: true,
      dance: true,
      joga: true,
      deti: true,
      zumba: true,
      pilates: true,
      bosu: true,
      tabata: true,
      aerobic: true,
      box: true,
      ostatni: true,
      all: true,
    };
  },

  methods: {
    sendForm(event) {
      let startDate = Date.parse(`${this.date}T${this.time}`);
      let endDate = endOfDay(startDate);

      startDate = format(startDate, "yyyy-M-d'T'HH:mm:ss", {
        timeZone: "Europe/Prague",
      });
      endDate = format(endDate, "yyyy-M-d'T'HH:mm:ss", {
        timeZone: "Europe/Prague",
      });

      let kategorie = "";
      if (this.posilovani) {
        kategorie = `${kategorie},posilovani`;
      }
      if (this.dance) {
        kategorie = `${kategorie},dance`;
      }
      if (this.joga) {
        kategorie = `${kategorie},joga`;
      }
      if (this.deti) {
        kategorie = `${kategorie},deti`;
      }
      if (this.zumba) {
        kategorie = `${kategorie},zumba`;
      }
      if (this.pilates) {
        kategorie = `${kategorie},pilates`;
      }
      if (this.bosu) {
        kategorie = `${kategorie},bosu`;
      }
      if (this.tabata) {
        kategorie = `${kategorie},tabata`;
      }
      if (this.aerobic) {
        kategorie = `${kategorie},aerobic`;
      }
      if (this.box) {
        kategorie = `${kategorie},box`;
      }
      if (this.ostatni) {
        kategorie = `${kategorie},ostatni`;
      }

      const url = `${process.env.VUE_APP_API_URL}/lekce/byDatum?zacatek=${startDate}&konec=${endDate}&hledaneKategorie=${kategorie}`;

      console.log(url);

      return axios.get(url).then((response) => {
        this.results = response.data;
        this.$emit("eventResults", this.results);
        console.log(this.results);
      });
    },

    checkAll() {
      if (this.all) {
        this.posilovani = false;
        this.dance = false;
        this.joga = false;
        this.deti = false;
        this.zumba = false;
        this.pilates = false;
        this.bosu = false;
        this.tabata = false;
        this.aerobic = false;
        this.box = false;
        this.ostatni = false;
      } else {
        this.posilovani = true;
        this.dance = true;
        this.joga = true;
        this.deti = true;
        this.zumba = true;
        this.pilates = true;
        this.bosu = true;
        this.tabata = true;
        this.aerobic = true;
        this.box = true;
        this.ostatni = true;
      }
    },
  },
};
</script>

<style scoped>
.activity-form {
  text-align: center;
  padding: 10px;
  text-transform: uppercase;
  width: 420px;
  border-radius: 20px;
  /*background: #ff3e78 linear-gradient(to right, #ff3e78, #ffbd2e);*/
  background-image: linear-gradient(to right, #f83600 0%, #f9d423 100%);
  color: white;
}

.input {
  padding: 5px;
  font-size: 16px;
}

input,
select {
  padding: 5px;
  color: #f83600;
}

.button-activity {
  color: #f83600;
  background-color: white;
  margin-top: 10px;
  border-radius: 15px;
  border: 1px solid #f83600;
  padding: 10px 25px;
  border: none;
  text-transform: uppercase;
  font-weight: 100;
  font-size: 20px;
}

input[type="checkbox"] {
  width: 30px;
}

input,
select {
  box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.2);
  border-radius: 10px;
  border: none;
  margin-left: 10px;
  height: 40px;
  font-size: 18px;
}

.checkbox {
  margin-right: 20px;
  display: flex;
  align-items: flex-end;
}

.flex {
  display: flex;
  justify-content: space-between;
  padding: 20px;
}

input[type="checkbox"] {
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  outline: 0;
  background: white;
  width: 20px;
  height: 20px;
}

input[type="checkbox"]:checked {
  background: white;
  -webkit-appearance: none;
  -moz-appearance: none;
  width: 20px;
  height: 20px;
  position: relative;
}

input[type="checkbox"]:checked::after {
  font: normal normal normal 14px/1 FontAwesome;
  content: "\f00c";
  color: #333;
  font-size: 12px;
  position: absolute;
  top: 5px;
  left: 5px;
}

/*
input.largerCheckbox {
  vertical-align: middle;
  width: 20px;
  height: 40px;
  margin: 5px;
}
*/

@media (min-width: 1000px) {
}
</style>