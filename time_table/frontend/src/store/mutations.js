export const mutations = {
    setUser (state, payload) {
        localStorage.setItem("user", payload.firstName);
        localStorage.setItem("token", payload.token);
        state.user = payload.firstName;
    },
    setAuth (state, payload) {
        localStorage.setItem("auth", payload);
    },
    clearAuth(state) {
        localStorage.removeItem("auth");
        localStorage.removeItem("user");
        localStorage.removeItem("token");
    },
    setError (state, payload) {
        state.error = payload
    },
    setLoading (state, payload) {
        state.loading = payload
    }
}
