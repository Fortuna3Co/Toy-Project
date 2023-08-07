<template>
  <v-layout class="rounded rounded-md">
    <v-app-bar title="Application bar">
      <div class="d-flex justify-end mb-6 bg-surface-variant">
      <v-sheet
        v-for="n in 3"
        :key="n"
        class="ma-2 pa-2"
      >
        justify-end
      </v-sheet>
    </div>
    </v-app-bar>

    <v-navigation-drawer>
      <v-list>
        <v-list-item title="Navigation drawer"></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main class="d-flex align-center justify-center" style="min-height: 300px;">
      Main Content
    </v-main>
  </v-layout>
  
</template>

<script>

export default {
  name: 'HelloWorld',

  data: () => ({
  }),
}
</script>
