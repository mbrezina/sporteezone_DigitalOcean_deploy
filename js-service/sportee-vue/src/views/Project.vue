<template>
  <div class="contejner">
    <h1>A o čem to celé bylo?</h1>
      <div class="border"></div>
    <p class="text">
      Hlavním cílem našeho projektu bylo vytvořit jednoduchou aplikaci, která má člověku zjednodušit život při
      vybírání vhodné sportovní aktivity. Tak vznikl nápad SporteeZone. Při vytváření aplikace jsme vycházeli nejen z
      vlastní zkušenosti, ale i ze zkušenosti našich známých, kteří se často potýkají s nedostatkem času kvůli
      pracovní vytíženosti a hledají aktivity v konkrétním čase.
    </p>

    <p class="text">
      Naše aplikace SporteeZone momentálně shromažďuje informace 5 vybraných sportovišť v Brně.
      Hlavní částí stránky je formulář, který filtruje aktivity na základě několika zvolených parametrů jako jsou
      čas, datum a karta. Na sesbírání informací z provozoven jsme použili metodu scrapování pomocí knihovny Cheerio.js.
    </p>

    <p class="text">
      Cílem našeho projektu je především úspora času a rychlost vyhledávání jednotlivých aktivit pro uživatele,
      kteří mají zájem cvičit a nestrávit zbytečný čas proklikáváním webů a rozvrhů. Do budoucna bychom chtěli samozřejmě
      rozšířit počet provozoven, zdokonalit filtrování a také bychom se rádi spojili s provozovnami a vyzkoušeli
      spolupráci.
    </p>

    <h2>Kdo stojí za projektem?</h2>


    <div class="medailonky">
      <div id class="medailonek">
        <div class="obal">
          <img class="foto" src="../assets/lenka.jpg" alt="Lenka Florišová">
        </div>
        <h3 class="text">Lenka Florišová</h3>
        <p class="text">Člověk s velkým smyslem pro detail a design. Akademie mi otevřela nové obzory do světa
          programování, UX a UI spojující interakci mezi zkušenostmi zákazníků a designem.
        </p>
        <div class="icony">
          <a href="mailto:l.florisova(zav)gmail.com" target="_top">
            <i class="fas fa-envelope-open-text fa-2x"></i>
          </a>
          <a href="https://www.facebook.com/lenka.florisova.5" target="_blank">
            <i class="fab fa-facebook fa-2x"></i>
          </a>

          <a href="https://www.linkedin.com/in/lenkaflorisova" target="_blank">
            <i class="fab fa-linkedin-in fa-2x"></i>
          </a>
        </div>
      </div>

      <div id class="medailonek">
        <div class="obal">
          <img class="foto" src="../assets/katka.jpg" alt="Kateřina Blatná">
        </div>
        <h3 class="text">Kateřina Blatná</h3>
        <p class="text">Velká nadšenkyně do informačních technologií, která si oblíbila kouzla s webovým kódem.
          Digitální akademie mi otevřela další zajímavou a neprobádanou oblast. Jsem vděčná za tuto
          příležitost.
        </p>
        <div class="icony">
          <a href="mailto:katerina.blatna(zav)email.cz" target="_top">
            <i class="fas fa-envelope-open-text fa-2x"></i>
          </a>
          <a href="https://www.facebook.com/katerina.blatna.9" target="_blank">
            <i class="fab fa-facebook fa-2x"></i>
          </a>

          <a href="https://www.linkedin.com/in/katerinablatna" target="_blank">
            <i class="fab fa-linkedin-in fa-2x"></i>
          </a>

        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>

.text {
  padding-left: 40px;
  padding-right: 30px;
  text-align: center;
}

h1,
h2 {
  text-align: center;
}

h2 {
  margin-top: 60px;
}
.contejner {
  margin: 30px;
  margin: 50px auto 0 auto;
  position: relative;
}

.border{
  width: 160px;
  height: 5px;
  background: rgb(100, 195, 158);
  margin: 26px auto;
}

.obal{
margin:0 auto;
width: 250px;
height: 250px;
border-radius: 50%;
overflow: hidden;
}
.foto{
width: 100%;

}
.logo{
width: 50%;
min-width: 50px;
max-width: 150px;
}


.icony{
    text-align:center ;
}
.icony i{
padding: 40px;
width: 30%;


min-width: 50px;

max-width: 70px;

}
.icony a{
    text-decoration: none;
   color: black;
}

@media (min-width: 600px) and (max-width: 999px) {
  .medailonky
      .text {
        padding-left: 150px;
        padding-right: 150px;
  }
}

@media (min-width: 1000px) {
  .contejner {
    width: 960px;
  }
  .medailonky{
    display:flex;
  }
}

</style>