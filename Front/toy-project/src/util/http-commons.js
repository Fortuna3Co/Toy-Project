import axios from "axios";

export default axios.create({
    baseURL: process.env.VUE_APP_LOCAL_DEVELOP_SERVER_URL,
    headers: {
    "Content-Type": "application/json",
    },
});
