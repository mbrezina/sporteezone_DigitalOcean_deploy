<template>
	<div>
	<button> {{ text }} </button>
	</div>
</template>

<script>
export default {
  props: ['text']
}
</script>

<style>

button {
  margin-top: 10px;
  border-radius: 15px;
  border: 1px solid white;
  background-color: #f83600;
  padding: 10px 25px;
  border: none;
  text-transform: uppercase;
  color: white;
  font-weight: 100;
  font-size: 20px;
  cursor: pointer;
}

</style>