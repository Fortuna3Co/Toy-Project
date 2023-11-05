import http from "@/util/http-commons"

export default class UserService {
    async postSignUp(params) {
        // params
        // userEmail : [email Type (string)]
        // passowrd : [password Type (string)]
        // return : boolean (creation result)
        console.log("url : ", process.env.VUE_APP_LOCAL_DEVELOP_SERVER_URL)
        console.log(params)
        return await http.post("user/signUp", params).then((data) => data.data)
    }
}