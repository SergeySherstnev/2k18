export const state = {
    isAuthenticated: localStorage.getItem("auth"),
    user: localStorage.getItem("user"),
    error: null,
    loading: false
}
