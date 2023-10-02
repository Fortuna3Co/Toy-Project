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
                    :rules="[required]"
                    class="mb-2"
                    clearable
                    label="Email"
                ></v-text-field>
        
                <v-text-field
                    v-model="password"
                    :readonly="loading"
                    :rules="[required]"
                    clearable
                    label="Password"
                    type="password"
                    placeholder="Enter your password"
                ></v-text-field>
        
                <br>
        
                <v-btn
                    :disabled="!form"
                    :loading="loading"
                    block
                    color="success"
                    size="large"
                    type="submit"
                    variant="elevated"
                >
                    Sign In
                </v-btn>

                <br>
                
                <v-btn
                    :loading="loading"
                    block
                    color="primary"
                    size="large"
                    type="submit"
                    variant="elevated"
                    @click="$router.push('/signUp')"
                >
                    Sign Up
                </v-btn>
            </v-form>
        </v-card>
    </v-sheet>
</template>

<script>

</script>