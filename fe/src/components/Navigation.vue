

<template>
  <nav class ="mx-auto flex max-w-7xl items-center justify-between p-6 lg:px-8">
  <div class="flex lg:flex-1">
        <a href="#" class="-m-1.5 p-1.5">
          <span class="sr-only">Your Company</span>
          <img class="h-8 w-auto" src="https://tailwindui.com/img/logos/mark.svg?color=indigo&amp;shade=600" alt="">
        </a>
      </div>
      <div class ="hidden lg:flex lg:gap-x-12">
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about" v-if="isLogged">Todos</RouterLink>
        </div>
      <div class = "hidden lg:flex lg:flex-1 lg:justify-end">
        <RouterLink to="/login" v-if="!isLogged">Login</RouterLink>
        <RouterLink to="/login" v-if="isLogged" @click="logout">Signout {{u.name}}</RouterLink>
      </div>

      </nav>
</template>

<script setup>
import {computed} from "vue";
import { userStore } from '@/stores/user'
const user = userStore();
const isLogged = computed(() => user.isLogged);
const u = user.user;
function logout() {
  user.logout();
}
</script>


