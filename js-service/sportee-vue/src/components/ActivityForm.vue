<template>
<div>

<form @submit.prevent="sendForm" action="/#/vysledky" method="GET">

  <div id="app">
      <h1>Vyber si aktivitu</h1>
      <div class="date">
          <label>Datum:</label>
          <input v-model="date" placeholder="Vyber datum" type="date" name="date">
      </div>

      <div class="time">
          <label>Zvolte čas:</label>
          <input v-model="time" type="time" name="time">
      </div>

      <div class="card">
          <label>Vyber kartu:</label><br>
          <input v-model="multisport" type="checkbox" class="largerCheckbox" id="multisport" name="multisport" value="multisport"><label>Multisport</label>
          <input v-model="activepass" type="checkbox" class="largerCheckbox" id="activepass" name="activepass" value="activepass"><label>Activepass</label>
      </div>

    <button>Vyhledat</button>
  </div>

</form>
</div>

</template>

<script>
import Button from './../components/Button.vue'

export default {
  components: {
    "button": Button
  },
  data() {
    return {
      date: "",
      time: "",
      selected: "",
      multisport: false,
      activepass: false
    }
  },
  methods: {
    sendForm(event) {
      event.currentTarget.submit();
    }
  }
}
</script>

<style scoped>
#app {
  width: 100%;
  padding-top: 20px;
  padding-bottom: 20px;
  text-align: center;
  color: black;
}

#app h1 {
  text-align: center;
}

.date,
.time,
.activity,
.card {
  padding: 10px;
}

input,
select {
  padding: 5px;
}

input[type="checkbox"] {
  width: 30px;
}

input,
select
 {
  box-shadow: 0 0 6px 0 rgba(0,0,0,0.2);
  border-radius: 5px;
  border: none;
  margin-left: 10px;
  height: 50px;
  font-size: 20px;
}

input[type="checkbox"] {
  cursor: pointer;
  -webkit-appearance: none;
  -moz-appearance: none;
  appearance: none;
  outline: 0;
  background: white;

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

input.largerCheckbox {
  vertical-align: middle;
  width: 20px;
  height: 20px;
  margin: 5px;
}

@media (min-width: 1000px) {
    #app {
      width: 550px;
      background-color: white;
      border-radius: 10px;
    }
    form {
      position: absolute;
      top: 145px;
      right: 60px;
    }

}


</style>