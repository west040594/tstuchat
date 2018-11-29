<template>
    <div>
        <input type="text" placeholder="Message" v-model="text" class="form-control"/>
        <button class="btn btn-success btn-small" @click="save">Send</button>
    </div>
</template>

<script>
    import {sendMessage} from "../util/ws";

    export default {
        name: "MessageForm",
        props: ['messages', 'user', 'chat'],
        data() {
            return {
                text:'',
            }
        },
        methods: {
            save() {
                const message = {
                    text: this.text,
                    user: this.user,
                    chat: this.chat
                };
                sendMessage(message)
                this.text = ''
            }
        }
    }
</script>

<style scoped>

</style>