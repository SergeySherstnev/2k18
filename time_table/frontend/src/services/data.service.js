import { authHeader } from "./auth-header";
import config from 'config';

export const dataService = {
  getAllRoutes,
  getBusesOnRoute
};

function getAllRoutes() {
  const requestOptions = {
    method: 'GET',
    headers: authHeader()
  };

  return fetch(`${config.apiUrl}/cityRoutes`, requestOptions)
    .then(handleResponse)
}

function getBusesOnRoute(routeId) {
  const requestOptions = {
    method: 'GET',
    headers: authHeader()
  };

  return fetch(`${config.apiUrl}/buses/`+routeId, requestOptions)
    .then(handleResponse)
}

function logout() {
  // remove user from local storage to log user out
  localStorage.removeItem('user');
}

function handleResponse(response) {
  return response.text().then(text => {
    const data = text && JSON.parse(text);
    if (!response.ok) {
      if (response.status === 401) {
        // auto logout if 401 response returned from api
        console.log("Refused connection");
        logout();
        // location.reload(true);
      }

      const error = (data && data.message) || response.statusText;
      return Promise.reject(error);
    }

    return data;
  });
}
