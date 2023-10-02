<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer">
      <v-sheet
        color="grey-lighten-4"
        class="pa-4"
      >
        <v-avatar
          class="mb-4"
          color="grey-darken-1"
          size="64"
        ></v-avatar>
        <div>john@google.com</div>
      </v-sheet>

      <v-divider></v-divider>

      <v-list>
        <v-list-item
          v-for="[icon, text] in links"
          :key="icon"
          link
        >
          <template v-slot:prepend>
            <v-icon>{{ icon }}</v-icon>
          </template>

          <v-list-item-title>{{ text }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    
    <v-app-bar
      :order="order"
      flat
      title="Application bar"
    >

      <template v-slot:append>
        <v-switch
          v-model="order"
          hide-details
          inset
          label="Toggle order"
          true-value="-1"
          false-value="0"
        ></v-switch>
      </template>

      <!-- Activator Slot Start -->
      <v-menu>
        <template v-slot:activator="{ props }">
          <v-btn
            color="primary"
            v-bind="props"
          >
            Activator slot
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="(item, index) in items"
            :key="index"
            :value="index"
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
      <!-- Activator Slot End -->

      <!-- Activator2 Slot Start -->
      <v-menu>
        <template v-slot:activator="{ props }">
          <v-btn
            color="primary"
            v-bind="props"
          >
            Activator2 slot
          </v-btn>
        </template>
        <v-list>
          <v-list-item
            v-for="(item, index) in items2"
            :key="index"
            :value="index"
          >
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item>
        </v-list>
      </v-menu>
      <!-- Activator2 Slot End -->

      
      <v-btn icon @click="$router.push('/login')">
        <v-icon>mdi-login</v-icon>
      </v-btn>

    </v-app-bar>

    <v-main class="bg-grey-lighten-2">
      <v-container>
        <v-row>
          <template v-for="n in 4" :key="n">
            <v-col
              class="mt-2"
              cols="12"
            >
              <strong>Category {{ n }}</strong>
            </v-col>

            <v-col
              v-for="j in 6"
              :key="`${n}${j}`"
              cols="6"
              md="2"
            >
              <v-sheet height="150"></v-sheet>
            </v-col>
          </template>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
  
</template>

<script>

export default {
  name: 'HelloWorld',

  data: () => ({
    order: 0,
    drawer: null,
    items: [
        { title: 'Item1 Click Me 1' },
        { title: 'Item1 Click Me 2' },
        { title: 'Item1 Click Me 3' },
        { title: 'Item1 Click Me 4' },
      ],
    items2: [
        { title: 'Item2 Click Me 1' },
        { title: 'Item2 Click Me 2' },
        { title: 'Item2 Click Me 3' },
        { title: 'Item2 Click Me 4' },
      ],
      links: [
        ['mdi-inbox-arrow-down', 'Inbox'],
        ['mdi-send', 'Send'],
        ['mdi-delete', 'Trash'],
        ['mdi-alert-octagon', 'Spam'],
      ],
  }),
}
</script>