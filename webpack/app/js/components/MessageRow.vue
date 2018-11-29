<template>
    <tr>
        <th scope="row">{{message.id}}</th>
        <td>{{message.createdDate}}</td>
        <td>{{message.user.username}}</td>
        <td>{{message.text}}</td>
        <td><button v-if="user.id === message.user.id"  class="btn btn-mini btn-danger" @click="del">X</button></td>
    </tr>

</template>

<script>
    export default {
        name: "MessageRow",
        props: ['message', 'messages', 'deleteMessage', 'user'],
        methods: {
            del() {
                this.deleteMessage(this.message)
            }
        }
    }
</script>

<style scoped>

</style>