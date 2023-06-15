export default {
  // Disable server-side rendering: https://go.nuxtjs.dev/ssr-mode
  ssr: false,

  // Se cambia el puerto del front a 8080
  server: {
    port:8080,
  },

  // Target: https://go.nuxtjs.dev/config-target
  target: 'static',

  // Global page headers: https://go.nuxtjs.dev/config-head
  head: {
    title: 'lab1_frontend',
    htmlAttrs: {
      lang: 'en'
    },
    meta: [
      { charset: 'utf-8' },
      { name: 'viewport', content: 'width=device-width, initial-scale=1' },
      { hid: 'description', name: 'description', content: '' },
      { name: 'format-detection', content: 'telephone=no' }
    ],
    link: [
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }
    ]
  },

  // Global CSS: https://go.nuxtjs.dev/config-css
  css: [
  ],

  // Plugins to run before rendering page: https://go.nuxtjs.dev/config-plugins
  plugins: [
  ],

  // Auto import components: https://go.nuxtjs.dev/config-components
  components: true,

  // Modules for dev and build (recommended): https://go.nuxtjs.dev/config-modules
  buildModules: [
  ],

  // Modules: https://go.nuxtjs.dev/config-modules
  modules: [
    // https://go.nuxtjs.dev/axios
    '@nuxtjs/axios',
  ],

  // Axios module configuration: https://go.nuxtjs.dev/config-axios
  axios: {
    // Workaround to avoid enforcing hard-coded localhost:3000: https://github.com/nuxt-community/axios-module/issues/308
    baseURL: 'http://localhost:3000/',
    proxy: true,
  },

  proxy: {
    "/emergencia": 'http://localhost:3000/',
    "/voluntario": 'http://localhost:3000/',
    "/create": 'http://localhost:3000/emergencia',
    "/getById-id": 'http://localhost:3000/emergencia',
    "/updateById-id": 'http://localhost:3000/emergencia',
    "/deleteById": 'http://localhost:3000/emergencia',
    "/cambiarEstado": 'http://localhost:3000/emergencia',
    "/getTareasByIdEmergencia": 'http://localhost:3000/tarea',
    "/getEstadoBytarea": 'http://localhost:3000/estado_tarea',
  },

  // Build Configuration: https://go.nuxtjs.dev/config-build
  build: {
  }
}
