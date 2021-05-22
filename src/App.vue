<template>
  <v-app>
    <v-main>
      <WitchSaga />
    </v-main>
  </v-app>
</template>

<script>
import WitchSaga from "./components/WitchSaga";

export default {
  name: "App",

  components: {
    WitchSaga,
  },

  data: () => ({
    //
  }),
};
</script>
