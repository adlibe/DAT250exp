import { defineConfig } from 'vite'
import { svelte } from '@sveltejs/vite-plugin-svelte'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [svelte()],
  server: {
    watch: {
      usePolling: true, // Helpful in some environments to watch for file changes
    },
    hmr: true,  // Enable Hot Module Replacement
  },
});
