export const getters = {
    isAuthenticated (state) {
        return state.isAuthenticated === 'true'
    },
    getUser (state) {
        return state.user
    },
    getError (state) {
        return state.error
    },
    getLoading (state) {
        return state.loading
    }
}
