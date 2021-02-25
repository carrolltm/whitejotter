<template>
  <div>
    <nav-menu></nav-menu>
    <router-view/>
  </div>
</template>

<script>
// 主页面
import NavMenu from './common/NavMenu'
export default {
  name: 'Home',
  components: {NavMenu}
}
</script>

<style scoped>

</style>
