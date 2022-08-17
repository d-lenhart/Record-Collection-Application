<template>
<div> 
  <div class="header-container">
    <header>
      <div id="header-text-container">
      <div id="headerText">
        A vinyl hub and forum for enthusiasts and historians of the Chicago music scene
      </div>
      </div>
       <div id="headerImg">
      </div>
    </header>
</div>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
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
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
       <!--
        <div class="input-line" id="checkbox-text">
              <label id="checkbox-label" for="">Check box for Premium Account, unchecked for Standard Account</label> &nbsp;
              <input type="checkbox" id="userIsPremium" v-model="user.isPremium" />
        </div>
         -->
      <router-link class="router-link" :to="{ name: 'login' }">Have an account?</router-link>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        <span id="content1">Create</span>
        <span id="content2"></span>
        <div class="inner-circle"></div>
        <span id="content3"></span>
        <span id="content4">Account</span>
      </button>
    </form>
  </div>
</div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style scoped>
header {
  background-image: url("/images/ChicagoSkylineWideSmallerer.jpg");
  
  height: 18vh;
}

img {
  border-radius: 40px;
  height: 20%;
  margin-left: 750px;
  position: fixed;
}

.header-container {
  text-align: center;
}

#headerText {
  font-size: 45px;
  font-family: 'PT Serif', 'Rubik', Calibri;
  color: #eee;
  text-shadow: -1px 1px 0 maroon,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  display: flex;
  align-items: center;
  justify-content: space-between;
  text-align: center;
  border-radius: 20px;
  margin-top: 45px;
  position: static;
}

#header-text-container {
  height: 100px;
  width: 1800px;
  position: fixed;
}

h1 {
  background: #003;
  border-radius: 5px;
}

.form-register {
  font-size: 40px;
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 20px;
}

#register {
  display: flex;
  text-align: center;
  justify-content: center;
  color: silver;
  text-shadow: -1px 1px 0 #cd7f32,
                1px 1px 0 #000,
                1px -1px 0 #000,
               -1px -1px 0 #000;
  background: #003;
               
  
  background-image: url(/images/LOUIS_ARMSTRONG_LOUIS+ARMSTRONG+AND+HIS+HOT+FIVE+NO.2-548158.jpg);
  background-position: bottom;
background-repeat: no-repeat;
background-size: contain;
background-color: rgb(247, 241, 230);
height: 100vh;
padding-top: 2%;
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

.inner-circle {
  background-color: white;
  width: 25px;
  height: 25px;
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

/*#checkbox-text {
  font-size: 30px;
}

#checkbox-label {
  color: white;
  text-shadow: none;
}*/
</style>
