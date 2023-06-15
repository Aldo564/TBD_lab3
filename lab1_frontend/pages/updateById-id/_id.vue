<template>
  <div class="container">
    <title> TBD laboratorio 1 - Actualizar emergencia</title>
    <h1>Información emergencia</h1>
    <form>
      <div class="form-group">
        <label for="asunto">Asunto emergencia:</label>
        <!--<p>{{emergencia.asunto}}</p>-->
        <input
          v-model="asunto"
          type="text"
          class="form-control"
          name="asunto"
          placeholder="Ingrese nuevo asunto"
          
        />
      </div>

      <div class="form-group">
        <label for="descripcion">Descripción:</label>
        <!--<p>{{emergencia.descripcion}}</p>-->
        <input
          v-model="descripcion"
          type="text"
          class="form-control"
          name="descripcion"
          placeholder="Ingrese nueva descripcion"
          
        />
      </div>

      <div class="form-group">
        <label for="direccion">Dirección:</label>
        <!--<p>{{emergencia.direccion}}</p>-->
        <input
          v-model="direccion"
          type="text"
          class="form-control"
          name="direccion"
          placeholder="Ingrese nueva direccion"
          
        />
      </div>

      <div class="form-group">
        <label for="fecha">Fecha:</label>
        <!--<p>{{emergencia.fecha}}</p>-->
        <input
          v-model="fecha"
          type="date"
          class="form-control"
          
        />
      </div>

      <div class="form-group">
        <label for="activa"> Estado:</label>
        <!--<p v-if="emergencia.activa">Activa</p>-->
        <!--<p v-else>No Activa</p>-->
        <input
          id="checkbox"
          type="checkbox"
          v-model="activa"
          name="activa"
          aria-label="Default select example"
        >

        <label for="checkbox">Activa?</label>
      </div>


      <button v-on:click="updateEmergency" type="submit" class="btn btn-success">
        Actualizar emergencia
      </button>
    </form>
    <router-link to="/emergencies"
        ><button id="back_btn">Volver</button></router-link
      >
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
      crossorigin="anonymous"
    /></div>
</template>

<script>
export default {
  data() {
    return {
      param: {},
      emergencia: {},
      tareas: {},
      asunto: {},
      descripcion: {},
      direccion: {},
      fecha: {},
      activa: {}
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
        this.asunto = this.emergencia.asunto;
        this.descripcion = this.emergencia.descripcion;
        this.direccion = this.emergencia.direccion;
        this.fecha = this.emergencia.fecha;
        this.activa = this.emergencia.activa;
      } catch (error) {
        console.log("error", error);
      }
    },

    updateEmergency: async function() //asunto, descripcion, direccion, fecha, activa
    {
      try {
        let id_emergencia = this.$route.params.id;
        let response = await this.$axios.put(
        "/updateById/" + id_emergencia,
        {
          params: 
          {
            id_emergencia: id_emergencia,
            asunto: this.asunto,
            descripcion: this.descripcion,
            direccion: this.direccion,
            fecha: this.fecha,
            activa: this.activa
          }
        }
        );

        this.emergencia = response.data;
        console.log("id: " + this.$route.params.id);


        
      } catch (error) {
        console.log("error", error);
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

#back_btn {
  margin-top: 30px;
  margin-bottom: 60px;
}


</style>
