<template>
    <tr>
        <td style="width: 18%">{{message.createdDate}}</td>
        <td style="width: 10%">{{message.user.username}}</td>
        <td style="width: 64%">{{message.text}}</td>
        <td style="width:  8%"><button v-if="user.id === message.user.id"  class="btn btn-mini btn-danger" @click="del" ref="deleteButton">X</button></td>
    </tr>

</template>

<script>
    export default {
        name: "MessageRow",
        props: ['message', 'messages', 'deleteMessage', 'user'],
        methods: {
            del() {
                this.$el.lastChild.textContent = '';
                this.deleteMessage(this.message)
            }
        }
    }
</script>

<style>

</style>