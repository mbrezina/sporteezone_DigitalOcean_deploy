<template>
  <div class="testimonials">
    <div class="inner">
      <h1>Recenze</h1>
      <div class="border"></div>
      <div class="row">

        <div class="col">
          <div class="testimonial">
            <img src="../assets/afit.png" alt="afit logo">
            <div class="name">Ludmila</div>
            <p>"Skvělé místo dát si pořádně do těla. Vybavení posilovny na jedničku, sprchy by zasloužily
              častější pořádek. Oceňuji možnost využití multisportky."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
        </div>

        <div class="col">
          <div class="testimonial">
            <img src="../assets/bluegym.png" alt="Bluegym logo">
            <div class="name">Veronika</div>
            <p>"V Blue Gym cvičím několikrát do týdne. Oceňuji především různorodost sálových lekcí a v mém případě
              výbornou dostupnost do centra."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="testimonial">
            <img src="../assets/bfit.jpg" alt="bfit logo">
            <div class="name">Zuzka</div>
            <p>"Je to místo, kde mám rozhodně pocit, že něco dělám! Rozhodně oceňuji prostředí a vřele doporučuji všem,
              kteří se rozhodli cvičit."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="testimonial">
            <img src="../assets/myfit.jpg" alt="myfit logo">
            <div class="name">Anička</div>
            <p>"Krásné a moderní prostory, ve kterých pracuje personál ochotný vždy poradit. V odpoledních hodinách bývá
              více lidí. Fandím jim a doporučuji i svým přátelům."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
        </div>
        <div class="col">
          <div class="testimonial">
            <img src="../assets/weissersport.jpg" alt="weissersport logo">
            <div class="name">Míša</div>
            <p>"Se sportovištěm Weisser sport jsme byla spokojená.
              Bylo pro mě praktické naleznout informace na jednom míste a pro každenní cvičení naprosto dostačující."
            </p>
            <div class="stars">
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star checked"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
              <span class="fa fa-star"></span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {

  }
</script>

<style>
  .testimonials{
  padding:20px 0;
  background: #f1f1f1;
  columns: #434343;
  text-align: center;
}
.inner{
  max-width: 1200px;
  margin: auto;
  overflow: hidden;
  padding: 0 20px;
}
.border{
  width: 160px;
  height: 5px;
  background: rgb(100, 195, 158);
  margin: 26px auto;
}
.row{
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.col{
  flex: 33.3%;

  box-sizing: border-box;
  padding: 15px;
}
.testimonial{
  background: #fff;
  padding: 30px;
}
.testimonial img{
  width: 100px;
  height: 100px;
  border-radius: 50%;
  object-fit: cover;
}
.name{
 font-size: 20px;
 text-transform: uppercase;
 margin:20px 0;
}
.stars{
  color: black;
  margin-bottom: 20px;
  margin-top:20px;
}
.checked {
  color: orange;
}
@media screen and (max-width: 960px) {
.col{
  flex: 100%;
  max-width: 80%;
}
}
@media screen and (max-width: 600px) {
  .col{
  flex: 100%;
  max-width: 100%;
  }
}
</style>