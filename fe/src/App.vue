<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Navigation from './components/Navigation.vue'
import { userStore } from '@/stores/user'

userStore().checkUser();

</script>

<template>
  <header>
      <Navigation/>
  </header>

  <RouterView />
</template>
