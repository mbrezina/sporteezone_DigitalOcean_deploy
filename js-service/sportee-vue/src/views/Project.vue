<template>
  <div class="projekt">
    <h1>O projektu</h1>
    <hr />
    <div class="content">
      <p class="text">
        Projekt Sporteezone byl pokračováním webové digitální akademie
        (Digitální akademie = DA) týmu Katky Blatné. Na webové stránce
        Sporteezone bylo možné vyhledávat hodiny cvičení podle času v různých
        fitkách. Původní web byl celý v JavaScriptu, data byla scrapována z webů
        pěti fitek, ukládala se v JSON souborech. Cílem nového týmu Sporteezone
        bylo udělat robustní aplikaci, která bude brát data z databáze
        doplňované automatickým scrapováním dat z webů, které by časem bylo
        ideálně doplněno i o poskytovaná data přímo od fitness center. Zájemci o
        cvičení by tedy nemuseli hledat fitness centra v okolí a prohledávat
        jejich weby aby našli cvičení, které by jim vyhovovalo typem, časem a
        dostupností. Prostě by si v naší aplikaci naklikali datum a čas, popř.
        typ sportu, a dostali by seznam vyhovujících lekcí a odkazy na
        rezervaci. Do aplikace by bylo možné se i přihlásit, kde by byly uložené
        uživatelovy preferované sporty, časy, fitka a adresy, odkud hledat
        nejbližší cvičení. Inspirací byl holandský web Onefit, přes který se dá
        i registrovat na rozličné lekce a platit.
      </p>
      <p class="text">
        Když jsme dávaly dohromady tým, byly jsme dvě známé z datové Digitální
        akademie v Brně — Katka Blatná chtěla dělat frontend ve Vue, Martina
        Burjanová chtěla programovat backend v Javě. Náš projekt byl vybrán, i
        když jsme byly jen dvě, ale chtěly jsme ještě najít Czechitu, která by
        programovala scrapovací skripty v Pythonu. Tak jsme se daly dohromady po
        registraci s Pavlou Morávkovou z Prahy, která zrovna dokončila datovou
        Digitální akademii v Praze a chtěla si procvičit Python. V průběhu práce na projektu Katka ze zdravotních důvodů od projektu odešla a nahradila ji Veronika Jiříčková, také absolventka digitální akademie.
      </p>
      <div class="button">
        <a href="https://medium.com/@sporteezone/8441523344b8" target="_blank" ><button>Více o projektu</button></a>
      </div>
      
    </div>

    <!--
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
    -->
  </div>
</template>


<style scoped>
.projekt h1 {
  text-align: center;
  color: #fcfbff;
  text-transform: uppercase;
  font-weight: 100;
  margin-bottom: 5px;
  font-size: 42px;
  margin-top: 40px;
}

.har {
  color: white;
  width: 50%;
  margin-bottom: 30px;
}

.text {
  padding-left: 40px;
  padding-right: 30px;
  text-align: left;
}

.content {
  background-color: #f1f1f1;
  padding: 5px 5px;
  margin: 30px;
  border-radius: 15px;
}

h1,
h2 {
  text-align: center;
}

h2 {
  margin-top: 60px;
}

.projekt {
  margin: 30px;
  margin: 50px auto 0 auto;
  position: relative;
}

.obal {
  margin: 0 auto;
  width: 250px;
  height: 250px;
  border-radius: 50%;
  overflow: hidden;
}

.foto {
  width: 100%;
}
.logo {
  width: 50%;
  min-width: 50px;
  max-width: 150px;
}

.icony {
  text-align: center;
}
.icony i {
  padding: 40px;
  width: 30%;

  min-width: 50px;

  max-width: 70px;
}
.icony a {
  text-decoration: none;
  color: black;
}

.button {
  text-align: center;
  margin: 30px;
}

@media (min-width: 600px) and (max-width: 999px) {
  .medailonky .text {
    padding-left: 150px;
    padding-right: 150px;
  }
  .content {
    margin-top: 30px;
  }
}

@media (min-width: 1000px) {
  .projekt {
    width: 960px;
  }
  .medailonky {
    display: flex;
  }
  .content {
    padding: 40px 60px;
    margin-top: 40px;
  }
  .projekt h1 {
    font-size: 70px;
    margin-top: 80px;
  }
}
</style>