
<template>
  <div ref="wrapper" class="scroll-wrapper">
    <slot></slot>
  </div>
</template>

<script>
import BScroll from 'better-scroll'
export default {
  props: {
    /**
      * 1 When scrolling, the scroll event will be dispatched and the stream will be intercepted.
      * 2 When scrolling, the scroll event is dispatched in real time without interception.
      * 3 In addition to dispatching scroll events in real time, scroll events can still be dispatched in real time in the case of swipe
      */
    probeType: {
      type: Number,
      default: 1
    },
    // Whether the click list dispatches the click event
    click: {
      type: Boolean,
      default: true
    },
    // Whether to enable horizontal scrolling
    scrollX: {
      type: Boolean,
      default: false
    },
    //Whether to dispatch scroll events
    listenScroll: {
      type: Boolean,
      default: false
    },
    // list of data
    scrollData: {
      type: Array,
      default: null
    },
    // Whether to dispatch the event of scrolling to the bottom for pull-up loading
    pullup: {
      type: Boolean,
      default: false
    },
    // Whether to dispatch the top drop-down event for pull-down refresh
    pulldown: {
      type: Boolean,
      default: false
    },
    // Whether to dispatch the list scrolling start event
    beforeScroll: {
      type: Boolean,
      default: false
    },
    // When the data is updated, refresh the scroll delay
    refreshDelay: {
      type: Number,
      default: 20
    }
  },
  mounted() {
    // Initialize better-scroll after DOM rendering
    setTimeout(() => {
      this.initScroll()
    }, 20)
  },
  methods: {
    initScroll() {
      if (!this.$refs.wrapper) {
        return
      }
      // better-scroll Initialize
      this.scroll = new BScroll(this.$refs.wrapper, {
        probeType: this.probeType,
        click: this.click,
        scrollX: this.scrollX
      })
      // Whether to dispatch scroll events
      if (this.listenScroll) {
        const self = this
        this.scroll.on('scroll', (position) => {
          self.$emit('scroll', position)
        })
      }
      if (this.pullup) {
        this.scroll.on('scrollEnd', () => {
          // scroll to bottom
          if (this.scroll.y <= (this.scroll.maxScrollY + 50)) {
            // Dispatches scroll to bottom event
            this.$emit('scrollToEnd')
          }
        })
      }
      if (this.pulldown) {
        this.scroll.on('touchend', (pos) => {
          if (pos.y > 50) {
            // Pull down to refresh
            this.$emit('pulldown')
          }
        })
      }
      if (this.beforeScroll) {
        this.scroll.on('beforeScrollStart', () => {
          // Fired before the list scrolls
          this.$emit('beforeScroll')
        })
      }
    },
    disable() {
      // Proxy better-scroll's method
      this.scroll && this.scroll.disable()
    },
    enable() {
        this.scroll && this.scroll.enable()
    },
    refresh() {
        this.scroll && this.scroll.refresh()
    },
    scrollTo() {
        this.scroll && this.scroll.scrollTo.apply(this.scroll, arguments)
    },
    scrollToElement() {
        this.scroll && this.scroll.scrollToElement.apply(this.scroll, arguments)
    }
  },
  watch: {
    // Monitor data changes and recalculate the height
    data() {
      setTimeout(() => {
          this.refresh()
      }, this.refreshDelay)
    }
  }
}
</script>

<style lang="less" scoped>
  .scroll-wrapper {
    width: 100%;
    height: 100%;
    overflow: hidden;
  }
</style>
