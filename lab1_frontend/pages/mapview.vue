<template>
  <div>
    <div class="heading">
      <h1> TBD laboratorio 3 - Mapa </h1>
    </div>
    <div id="mapContainer">
     <!-- <a v-for="emergency in this.emergencies" v-bind:key="emergency.id_emergencia">
        <l-marker :lat-lng="[emergency.latitud, emergency.longitud]" ></l-marker>
      </a> -->
    </div>
    <form action="/">
      <button type="submit" value="Volver">
        Volver
      </button>
    </form>
  </div>
</template>


<script>
  import "leaflet/dist/leaflet.css";
  import * as L from "leaflet";
  import axios from 'axios';
  import 'leaflet-defaulticon-compatibility/dist/leaflet-defaulticon-compatibility.webpack.css'; // Re-uses images from ~leaflet package
  import 'leaflet-defaulticon-compatibility';
  

  export default {
  components: { },
    name: "LeafletMap",
    data() {
      return {
        map: null,
        emrgencies: [],
        volunteers: []
      };
    },

    
    methods: {
      getData: async function () {
        let response = await axios.get("/emergencia").catch(error => console.log("Error: " + error));
        let response2 = await axios.get("/voluntario").catch(error => console.log("Error: " + error)); //Cambiar por /voluntarioFiltrados

        this.emergencies = response.data;
        this.volunteers = response2.data;
      },
    },


    mounted: async function() {
      await this.getData();

      this.map = L.map("mapContainer").setView([-33.45694, -70.64827], 5);
      L.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", {
        attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
        maxZoom: 10
      }).addTo(this.map);

      var blueMarker = L.icon({
          iconUrl: 'emergenciaActiva.png',
          iconSize:     [38, 80], // size of the icon
          iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
          popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
      });

      var redMarker = L.icon({
          iconUrl: 'emergenciaNoActiva.png',
          iconSize:     [38, 80], // size of the icon
          iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
          popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
      });

      var greenMarker = L.icon({
          iconUrl: 'voluntario.png',
          iconSize:     [38, 80], // size of the icon
          iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
          popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
      });

      var legend = L.control({position: "bottomright"});

      legend.onAdd = function(map) {

        var div = L.DomUtil.create("div", "legend");
        div.innerHTML += '<h4>Marcadores</h4>';
        div.innerHTML += '<i style="background: #FF0000"></i><span>Emergencia no activa</span><br>';
        div.innerHTML += '<i style="background: #00FF00"></i><span>Voluntario</span><br>';
        div.innerHTML += '<i style="background: #0000FF"></i><span>Emergencia activa</span><br>';
        div.innerHTML += '<h4>Areas</h4>';
        div.innerHTML += '<i class="circle" style="background: #FF0000"></i><span>Impacto emergencia</span><br>';

        return div;
        };

      legend.addTo(this.map);
      
      var dist = require('geo-distance-js');
      this.emergencies.forEach(emergencia => {
        var popupContent = "<hr>Asunto: </hr>" + emergencia.asunto + "<hr>Descripción: </hr>" + emergencia.descripcion 
          + "<hr>Dirección: </hr>" + emergencia.direccion + "<hr>Fecha: </hr>" + emergencia.fecha + "<hr>Activa: </hr>" + emergencia.activa
          + "<hr>Latitud: </hr>" + emergencia.latitud + "<hr>Longitud: </hr>" + emergencia.longitud + "<hr></hr>";
        if(emergencia.activa)
        {
          L.marker([emergencia.latitud, emergencia.longitud], {icon: blueMarker}).bindPopup(popupContent).openPopup().addTo(this.map);
          L.circle([emergencia.latitud, emergencia.longitud], {radius: 100000, color: "#FF0000"}).addTo(this.map);
        }
        else
        {
          L.marker([emergencia.latitud, emergencia.longitud], {icon: redMarker}).bindPopup(popupContent).openPopup().addTo(this.map);
          L.circle([emergencia.latitud, emergencia.longitud], {radius: 100000, color: "#FF0000"}).addTo(this.map);
        }
      });

      this.volunteers.forEach(voluntario => {
        var popupContent = "<hr>Nombre: </hr>" + voluntario.nombre + "<hr></hr>";
        L.marker([voluntario.latitud, voluntario.longitud], {icon: greenMarker}).bindPopup(popupContent).openPopup().addTo(this.map);
      });

      
      
    },

    onBeforeUnmount() {
      if (this.map) {
        this.map.remove();
      }
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
  }

  #mapContainer {
    margin: 50px;
    width: 90vw;
    height: 90vh;
  }

  .heading {
    margin: 0;
    padding: 0px;
    color: 
  rgb(69, 69, 121);
  }

  .heading > h1 {
    padding: 20px;
    margin: 0;
  }
  .legend {
  padding: 6px 8px;
  font: 14px Arial, Helvetica, sans-serif;
  background: white;
  background: rgba(255, 255, 255, 0.8);
  /*box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);*/
  /*border-radius: 5px;*/
  line-height: 24px;
  color: #555;
  }
  .legend h4 {
  text-align: center;
  font-size: 16px;
  margin: 2px 12px 8px;
  color: #777;
  }

  .legend span {
  position: relative;
  bottom: 3px;
  }

  .legend i {
  width: 18px;
  height: 18px;
  float: left;
  margin: 0 8px 0 0;
  opacity: 0.7;
  }

  .legend i.circle {
  border-radius: 50%;
  width: 18px;
  height: 18px;
  }
</style>
