<template>

  <div class="container">
    <title> TBD laboratorio 3 - Home</title>
    <v-row justify="center" alling="center">
      <h1 class="text-center">Laboratorio 3 TBD, grupo 2</h1>
      <hr />
      <!-- 
      <form action="/emergencies">
        <button type="submit" value="Emergencias">
          Ir a emergencias
        </button>
      </form>
      -->
      <form action="/mapview">
        <button type="submit" value="Mapa">
          Ver mapa
        </button>
      </form>
    </v-row>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  </div>
</template>

<script>
export default {
  name: 'IndexPage',
}
</script>

<style>
* {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 40px;
}
</style>
