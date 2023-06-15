<template>
  <div class="container">
    <title> TBD laboratorio 1 - Vista detallada emergencia</title>
    <h1>Información emergencia</h1>
    <div class="center">
      <h5>Asunto:</h5>
      <p>{{ emergencia.asunto }}</p>
      <h5>Fecha de registro:</h5>
      <p>{{ emergencia.fecha }}</p>
      <h5>Descripción:</h5>
      <p>{{ emergencia.descripcion }}</p>
      <h5>Dirección:</h5>
      <p>{{ emergencia.direccion }}</p>
      <h5>Estado:</h5>
      <p v-if="emergencia.activa"> Activa </p>
      <p v-else> No activa </p>
      <h5>Tareas relacionadas a la emergencia:</h5>
      <div class="center-table" v-if="tareas.length != 0">
        <table class="table table-bordered table-hover">
          <thead class="thead-dark">
            <tr>
              <th>ID</th>
              <th>Tarea</th>
              <!--<th>Completada</th>-->
            </tr>
          </thead>
          <tbody>
            <tr v-for="tarea in tareas" v-bind:key="tarea.id_tarea">
              <td>{{ tarea.id_tarea }}</td>
              <td>{{ tarea.asunto_tarea }}</td>
              <!--<td>{{ estado }}</td>--> <!-- Esto seria para cada estado en estados -->
            </tr>
          </tbody>
        </table>
      </div>
      <div class="center-table" v-else>
        <p>No existen tareas relacionadas con esta emergencia</p>
      </div>
      <router-link to="/emergencies"
        ><button id="back_btn">Volver</button></router-link
      >
    </div>

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    />
  </div>
</template>

<script>

export default {
  data() {
    return {
      param: {},
      emergencia: {},
      tareas: {},
      estados: {}
    };
  },
  mounted() {
    this.param = this.$route.params.id_emergencia;
  },
  methods: {
    getData: async function () {
      try {
        let id_emergencia = this.$route.params.id;
        let response = await this.$axios.get("/getById-id/" + id_emergencia, {
          params: {
            id_emergencia: id_emergencia,
          },
        });

        this.emergencia = response.data;
        //console.log("datos: " + this.emergencia);
        
        let tareas_response = await this.$axios.get(
          "/getTareasByIdEmergencia/" + id_emergencia, {
          params: 
          {
            id_emergencia: id_emergencia
          }});
        this.tareas = tareas_response.data;
        console.log("tarea: " + this.tareas);

          
        let estados_response = await this.$axios.get(
          "/getEstadoBytarea", {
          params:
          {
            tareas: this.tareas
          }});

        this.estados = estados_response.data;
        console.log("estados: " + this.estados);
        
        
      } catch (error) {
        console.log("error", error.response.data);
      }
    },
  },

  created: function () {
    this.getData();
  },
};
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

div.center-table {
  margin-left: auto;
  margin-right: auto;
  overflow-y: auto;
}

#back_btn {
  margin-top: 30px;
  margin-bottom: 60px;
}
</style>
