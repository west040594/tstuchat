<template>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Created</th>
            <th scope="col">User</th>
            <th scope="col">Text</th>
        </tr>
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