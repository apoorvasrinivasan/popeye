import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';


export const userStore = defineStore('user', () => {
 const router = useRouter();
  const user = ref({})
  const isLogged = ref(false)

  function login(data) {
      this.user = {
          name : "Test",
          token: "4234324",
          email: data.email
      }
      this.isLogged = true;
      localStorage.setItem("user", JSON.stringify(this.user));
      console.log("logged in");
      router.push('/');
    }

    function checkUser() {
        const u = localStorage.user;
        if (u) {
            this.user = JSON.parse(u);
            this.isLogged = true
        }
    }
    function logout() {
      localStorage.removeItem("user");
      this.isLogged = false;
      this.user = {};
      console.log("logged out");
    }
 
  return { user, isLogged , login, logout, checkUser}
})

