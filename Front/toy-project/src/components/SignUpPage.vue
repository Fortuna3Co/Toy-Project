<template>
    <v-sheet class="pa-12" rounded>
        <v-card class="mx-auto px-6 py-8" max-width="60%" :elevation="12">
            <v-form
            v-model="form"
            @submit.prevent="onSubmit"
            >
                <v-text-field
                    v-model="email"
                    :readonly="loading"
                    :rules="[rules.required, rules.email.expertTest, emailDuplicateCheck, rules.email.lengthCheck]"
                    class="mb-2"
                    clearable
                    label="Email"
                ></v-text-field>
        
                <v-text-field
                    v-model="password"
                    :readonly="loading"
                    :rules="[rules.required, rules.passowrd.expertTest, rules.passowrd.lengthCheck]"
                    type="password"
                    clearable
                    label="Password"
                    placeholder="Enter your password"
                ></v-text-field>

                <v-text-field
                    v-model="passwordVerify"
                    :readonly="loading"
                    :rules="[rules.required, passwordMatchCheck]"
                    type="password"
                    clearable
                    label="Password"
                    placeholder="Enter your password"
                ></v-text-field>

                <br>
                
                <v-btn
                    :disabled="!form"
                    :loading="loading"
                    block
                    color="primary"
                    size="large"
                    type="submit"
                    variant="elevated"
                >
                    Sign Up
                </v-btn>
            </v-form>
        </v-card>
    </v-sheet>
</template>

<script>
import UserService from '../service/UserService'

export default {
    created() {
        this.userService = new UserService();
    },
    data: () => ({
        form: false,
        email: null,
        password: null,
        passwordVerify: null,
        loading: false,
        userService: null,
        rules: {
            email: {
                expertTest: v => {
                    const emailExpert = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/
                    return !!emailExpert.test(v) || 'It must be in email format.'
                },
                lengthCheck: v => {
                    return v.length < 50 || 'The email you entered is too long.'
                }
            },
            passowrd: {
                expertTest: v => {
                    const passwordExpert = /^(?=(?:[^a-zA-Z]*[a-zA-Z]))(?=(?:\D*\d))(?=(?:[^\W_]*[\W_])).{8,}$/
                    return !!passwordExpert.test(v) || 'It must be at least 8 characters and a combination of 3 or more letters, numbers, and special characters.'
                },
                lengthCheck: v => {
                    return v.length < 50 || 'The password you entered is too long.'
                }
            },
            required: v => !!v || 'Field is required'
        },
    }),

    methods: {
        onSubmit () {
            if (!this.form) { 
                alert('Please follow the input form')
                return
            }
            
            this.loading = true

            let userData = {
                userEmail : this.email,
                userPassword : this.password
            }

            this.userService.postSignUp(userData).then(data => {
                if(data) alert('Creation has been completed.')
                else alert('A problem has occurred.')
            })
            
            this.loading = false
        },
        emailDuplicateCheck (email) {
            console.log(email)
            // duplicateCheck: v => this.emailDuplicateCheck(v) || 'This is a duplicate email. Please use a different email.',
            return true;
            // true가 아닐 경우 'This is a duplicate email. Please use a different email.',
        },
        passwordMatchCheck (passwordVerify) {
            return (this.password === passwordVerify) || 'It does not match your password.'
        },
        
    },
}
</script>