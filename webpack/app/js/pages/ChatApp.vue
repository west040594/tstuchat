<template>
    <div>
        <message-list :messages="messages" :user="profile"/>
        <message-form :messages="messages" :user="profile" :chat="chat" />
    </div>
</template>

<script>
    import {getIndex} from "../util/collection";
    import {addHandler} from "../util/ws";
    import MessageList from "../components/MessageList.vue";
    import MessageForm from "../components/MessageForm.vue";

    export default {
        name: "ChatApp",
        components: {MessageForm, MessageList},
        data() {
            return {
                profile: frontendData.user,
                chat: frontendData.chat,
                messages: frontendData.messages,
            }
        },
        created() {
            addHandler(data => {
                if(data.chat.id === this.chat.id) {
                    let index = getIndex(this.messages, data.id)
                    if(index === -1) {
                        this.messages.push(data)
                    } else {
                        this.messages.splice(index, 1)
                    }
                }
            })
        }
    }
</script>

<style scoped>

</style>