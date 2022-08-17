import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import AddRecordView from '../views/AddRecordView.vue'
import ShowLibrary from '../components/ShowLibrary.vue'
import UpdateNote from '../components/UpdateNote.vue'
import AddCollection from '../components/AddCollection'
import MyCollectionView from '../views/MyCollectionView.vue'
import DeleteRecord from '../components/DeleteRecord.vue'
import ShowCollectionDetails from '../components/ShowCollectionDetails.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      },
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/albums/:userId',
      name: 'Albums',
      component: AddRecordView,
    },
    {
      path: '/library/:userId',
      name: 'Library',
      component: ShowLibrary
    },
    {
      path: '/albums/:userId/:albumId',
      name: 'update-note',
      component: UpdateNote
    },
    {
      path: '/collections/:userId',
      name: 'add-collection',
      component: AddCollection
    },
    {
      path: '/my-collections/:userId',
      name: 'my-collections',
      component: MyCollectionView
    },
    {
      path: '/albums/:userId/delete/:albumId',
      name: 'delete-record',
      component: DeleteRecord
    },  
    {
      path: '/collections/:userId/:collectionId',
      name: 'show-collection-details',
      component: ShowCollectionDetails
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
