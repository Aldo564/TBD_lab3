<template>
  <div class="container">
    <title> TBD laboratorio 1 - Emergencias</title>
    <h1 class="text-center">Emergencias</h1>

    <div class="center-table">
      <form>
        <table class="table table-bordered table-hover" style="center">
          <thead class="thead-dark">
            <tr>
              <th>Id</th>
              <th>Asunto</th>
              <th>Fecha</th>
              <th>Estado</th>
              <th colspan="3">Acciones</th>
            </tr>
          </thead>
          <tbody>
            <tr
              v-for="emergency in emergencies"
              v-bind:key="emergency.id_emergencia"
            >
              <th>{{ emergency.id_emergencia }}</th>
              <th>{{ emergency.asunto }}</th>
              <th>{{ emergency.fecha }}</th>
              <th v-if="emergency.activa"> Activa </th>
              <th v-else> No activa </th>
              <td>
                <router-link
                  v-on:click="guardarId"
                  :to="'/getById-id/' + emergency.id_emergencia"
                  ><button>Ver</button></router-link
                >
              </td>
              <td>
                <router-link
                  v-on:click="guardarId"
                  :to="'/updateById-id/' + emergency.id_emergencia"
                  ><button>Modificar</button></router-link
                >
              </td>
              <td v-if="emergency.activa" >
                <button v-bind:id="emergency.id_emergencia" v-on:click="cambiarEstado(emergency.id_emergencia)">Desactivar</button>
                
              </td>
              <td v-else>
                <button v-bind:id="emergency.id_emergencia" v-on:click="cambiarEstado(emergency.id_emergencia)">Activar</button>
                
              </td>
            </tr>
          </tbody>
        </table>
      </form>
    </div>
    <form action="/">
      <button type="submit" value="Volver">
        Volver
      </button>
    </form>
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
      emergencies: [], //Todas las emergencias
      tasks: [], //Tareas de la emergencia en especifico
    };
  },

  methods: {
    getData: async function () {
      try {
        let response = await this.$axios.get("/emergencia");
        this.emergencies = response.data;
      } catch (error) {
        console.log("Error", error);
      }
    },

    guardarId: async function () {
      try {
        localStorage.setItem("id_emergencia", id_emergencia);
      } catch (error) {
        console.log("Error ", error);
      }
    },

    cambiarEstado: async function(id_emergencia)
    {
      try
      {
        console.log("id: "+id_emergencia);
        let response = await this.$axios.put(
          '/cambiarEstado/' + id_emergencia, null,
          {
            params:
            {
              id_emergencia: id_emergencia
            }
          });
      }
      catch(error)
      {
        console.log('Error ', error.response.data);
        
      }
    }
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
  margin-bottom: 40px;
}
</style>