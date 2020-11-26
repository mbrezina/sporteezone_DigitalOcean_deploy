<template>
<div class="container">
	<form id="app"
	@submit.prevent="sendForm"
	action="https://vuejs.org/"
	method="post"
	novalidate="true">

	<p v-if="errors.length">
		<b>Prosím, opravte chyby, které nastaly při odesílání:</b>
			<ul>
			<li v-for="error in errors">{{ error }}</li>
			</ul>
  	</p>

    <div v-if="formSend" class="after-send">
      <h3>Děkujeme!</h3>
      <P>Vaše zpráva byla úspěšně odeslána.</p>
    </div>

      <label for="name">Jméno</label>
      <input v-model="name" type="text" id="name" name="firstname" placeholder="Jméno">

      <label for="surname">Příjmení</label>
      <input v-model="surname" type="text" id="surname" name="surname" placeholder="Příjmení">

      <label for="email">E-mail</label>
      <input v-model="email" type="text" id="email" name="email" placeholder="E-mail">

      <label for="subject">Zpráva</label>
      <textarea v-model="message" id="subject" name="subject" placeholder="Prosím zadejte svou zprávu" style="height:200px"></textarea>

      <buttonDefault>Odeslat</buttonDefault>

	</form>


</div>
</template>

<script>
  import ButtonDefault from './../components/ButtonDefault.vue'

  export default {
    components: {
      buttonDefault: ButtonDefault
	},
	data() {
    return {
	  errors: [],
      name: "",
      surname: "",
      email: "",
      message: "",
      formSend: false
	}
	},
	methods: {
    checkForm: function (e) {
      this.errors = [];

        if (!this.email) {
        this.errors.push('Nevíme, kam vám máme odpovědět. Uveďte prosím e-mail.');
      } else if (!this.validEmail(this.email)) {
        this.errors.push('Uveďte prosím platný e-mail.');
	  }

	  if (!this.message) {
        this.errors.push("Bez vyplněného textu to nepůjde. Prosím zadejte text zprávy.");
      }

      if (!this.errors.length) {
        return true;
      }

      e.preventDefault();
    },
    sendForm() {
      this.checkForm();
      if (this.errors.length == 0) {
        this.name = "",
        this.surname = "",
        this.email = "",
        this.message = "",
        this.formSend = true
      }
    },
    validEmail: function (email) {
      var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      return re.test(email);
    }
  }
}
</script>

<style scoped>

.container {
  border-radius: 5px;
  padding: 20px;
  margin-top: 50px;
  text-align: left;
  background-color: #f1f1f1;
}

.contacts-container {
  display: grid;
}

input[type=text],
select,
textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 11px;
  margin-bottom: 16px;
  resize: vertical;
  font-family: 'Cabin', sans-serif;

}

input[type=submit]:hover {
  background-color: solid grey;
}

.after-send {
    box-shadow: 0 0 8px 1px rgba(140, 138, 140, 1);
    text-align: center;
    width: 300px;
    padding: 30px;
    margin: auto;
}

@media (min-width: 860px) {
  .container {
    width: 960px;
    background-color: white;
	  margin: 0 auto;
	  margin-top: 50px;
    box-shadow: 0 0 8px 1px rgba(140, 138, 140, 1);
    position: relative;
    z-index: 1;
    margin-bottom: 80px;
  }

  .col {
    display: flex;
    align-items: center;
  }
}

</style>