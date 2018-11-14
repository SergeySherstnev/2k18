import router from '../router'
import axios from 'axios'
import {EventBus} from '../event-bus.js'


export const actions = {
    userSignIn ({commit}, payload) {
        let data = {
            username: payload.username,
            password: payload.password,
        }

        let urls = {
            backend: payload.backendURL,
            baseUrl: payload.baseURL
        }

      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
      };

        commit('setLoading', true)
          fetch(urls.backend + '/auth/login', requestOptions)
            .then(handleResponse)
              .then(res => {
                  commit ('setAuth', true)
                  commit ('setLoading', false)
                  commit ('setError', null)
                  commit ('setUser', res)
                  EventBus.$emit('authenticated', 'User authenticated')
                  router.push(urls.baseUrl + '/view')
              })
            .catch(error => {
                commit('setError', error.message)
                commit('setLoading', false)
            })
    },
    userSignOut ({commit}, payload) {
        let url = {
            baseUrl: payload.baseURL
        }
        commit ('clearAuth');
        EventBus.$emit('authenticated', 'User not authenticated');
        // router.push(url.baseUrl + '/signIn')
    },

    // getAllRoutes() {
    //     const requestOptions = {
    //       method: 'GET',
    //       headers: authHeader()
    //     };
    //
    //     return fetch(`${config.apiUrl}/cityRoutes`, requestOptions)
    //       .then(handleResponse)
    // },
    //
    // getBusesOnRoute(routeId) {
    //     const requestOptions = {
    //       method: 'GET',
    //       headers: authHeader()
    //     };
    //
    //     return fetch(`${config.apiUrl}/buses/`+routeId, requestOptions)
    //       .then(handleResponse)
    // }
 }

function handleResponse(response) {
  return response.text().then(text => {
    const data = text && JSON.parse(text);
    if (!response.ok) {
      if (response.status === 401) {
        console.log("Refused connection");
      }

      const error = (data && data.message) || response.statusText;
      return Promise.reject(error);
    }

    return data;
  });
}

