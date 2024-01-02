import { createApp } from "vue"
import router from "./router/index.ts"
import en from '@/locales/en.json'
import fr from '@/locales/fr.json'
import { createI18n } from "vue-i18n"
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
import "./style.css"
import App from "./App.vue"

function getStartingLocale() {
  if (localStorage.getItem("last-locale")) {
    return localStorage.getItem("last-locale")
  }
  return import.meta.env.VITE_I18N_LOCALE || "en"
}

const i18n = createI18n({
  legacy: false,
  locale: getStartingLocale(),
  fallbackLocale: import.meta.env.VITE_I18N_FALLBACK_LOCALE,
  messages: {
    
  },
})

const vuetify = createVuetify({
  components,
  directives,
});

createApp(App).use(router).use(i18n).use(vuetify).mount("#app");
