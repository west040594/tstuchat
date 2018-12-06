<template>
    <table class="table">
        <thead>

        </thead>
        <tbody>
        <message-row v-for="message in messages"
                     :key="message.id"
                     :message="message"
                     :messages="messages"
                     :user="user"
                     :deleteMessage="deleteMessage"
        />
        </tbody>
    </table>
</template>

<script>
    import {deleteMessage} from "../util/ws";
    import MessageRow from "./MessageRow.vue";

    export default {
        name: "MessageList",
        components: {MessageRow},
        props: ['messages', 'user'],
        methods: {
            deleteMessage(message) {
                deleteMessage(message.id)
            }
        }
    }
</script>

<style scoped>

</style>