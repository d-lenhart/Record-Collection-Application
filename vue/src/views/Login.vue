<template>
<div> 
  <div class="header-container">
    <header>
      <div id="header-text-container">
        <div id="headerText">
          A Hub for Enthusiasts of the Chicago Vinyl Scene
        </div>
      </div>
    </header>
</div> 
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link class="router-link" :to="{ name: 'register' }">Need an account?</router-link>
      <button  type="submit">
        <span id="content1">Sign</span>
        <span id="content2"></span>
        <div class="inner-circle"></div>
        <span id="content3"></span>
        <span id="content4">In</span>

      </button>
    </form>
  </div>
</div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>

header {
  background: url("/images/ChicagoSkylineWideSmallerer.jpg");
  height: 24vh;
  background-position-x: 0px;
  background-position-y: -100px;
  background-repeat: repeat-x;
  position: static;
}

.header-container {
  height: 24vh;
}

#headerText {
  font-size: min(max(40px), 4vw);
  font-family: 'PT Serif';
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  padding-top: 11vh;
  text-align: center;
  margin: auto;
  position: static;
}

#header-text-container {
  display: flex;
  width: 100vw;
  height: 2px;
  position: static;
}

h1 {
  background: #003;
  border-radius: 5px;
}

.form-signin {
  font-size: 40px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}

#login {
  display: flex;
  text-align: center;
  justify-content: center;
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
               
  
  background-image: url(/images/LOUIS_ARMSTRONG_LOUIS+ARMSTRONG+AND+HIS+HOT+FIVE+NO.2-548158.jpg);
  background-position: bottom;
background-repeat: no-repeat;
background-size: contain;
background-color: rgb(247, 241, 230);
height: 100vh;
padding-top: 10%;
}

input {
  background: #003;
  color: #eee;
}

input[type=text] {
    font-size: 30px;
    text-align: center;
    width: 500px;
    height: 30px;
    border-radius: 10px;
}

input[type=password] {
    font-size: 30px;
    text-align: center;
    width: 500px;
    height: 30px;
    border-radius: 10px;
}

button {
  font-size: 20px;

  color: gold;

  background-color: #003;
  width: 150px;
  height: 150px;
  border-radius:100px;

  font-family: 'PT Serif', 'Rubik', Calibri;

  border-color: grey;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.inner-circle {
  background-color: white;
  width: 25px;
  height: 25px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border-radius: 75px;
  border-color: #f7df5b;
}

#content1::after{
    content: "\a";
    white-space: pre;
}

#content2::after{
    content: "\a";
    white-space: pre;
}

#content3::after{
    content: "\a";
    white-space: pre;
}

.router-link {
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  background: #003;
  border-radius: 5px;
}

.sr-only {
  background: #003;
  border-radius: 5px;
}
</style>
