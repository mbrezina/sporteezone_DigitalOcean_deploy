<template>
  <div class="projekt">
    <h1>O projektu</h1>
    <hr class="har" />
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
  border-top: 1px solid #ffff;
  border-bottom: none;
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

.button {
  text-align: center;
  margin: 30px;
}

@media (min-width: 600px) and (max-width: 999px) {
  .content {
    margin-top: 30px;
  }
}

@media (min-width: 1000px) {
  .projekt {
    width: 960px;
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