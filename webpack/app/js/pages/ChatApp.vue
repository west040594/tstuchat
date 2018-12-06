<template>

    <div>
        <VuePerfectScrollbar ref="ps" class="scroll-area" v-once :settings="settings" tagname="div">
            <message-list :messages="messages" :user="profile"/>
        </VuePerfectScrollbar>
        <message-form :messages="messages" :user="profile" :chat="chat" />
    </div>

</template>

<script>
    import {getIndex} from "../util/collection";
    import {addHandler} from "../util/ws";
    import MessageList from "../components/MessageList.vue";
    import MessageForm from "../components/MessageForm.vue";
    import VuePerfectScrollbar from 'vue-perfect-scrollbar'


    export default {
        name: "ChatApp",
        components: {MessageForm, MessageList, VuePerfectScrollbar},
        data() {
            return {
                profile: frontendData.user,
                chat: frontendData.chat,
                messages: frontendData.messages,
                settings: {
                    wheelSpeed: 2,
                    maxScrollbarLength: 50
                }
            }
        },
        created() {
            this.scrollToEnd()
            addHandler(data => {
                this.$refs.ps.update()
                if(data.chat.id === this.chat.id) {
                    let index = getIndex(this.messages, data.id)
                    if(index === -1) {
                        this.messages.push(data)
                        this.scrollToEnd()
                    } else {
                        this.messages[index].text = 'This message deleted'
                        //this.messages.splice(index, 1)
                    }
                }
            })
        },
        methods: {
            scrollToEnd() {
                setTimeout(() => {
                    const container = this.$el.querySelector('.ps-container');
                    container.scrollTop = container.scrollHeight;
                }, 0);
            },
        }
    }
</script>


<style lang="scss">
    .scroll-area {
        position: relative;
        height: 504px;
    }
</style>