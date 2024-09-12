<script>
    let showButtons = false;

    function openButtons() {
        showButtons = true;
    }
</script>

<button on:click={openButtons}>Start creating polls!</button>

<!-- Conditionally render new buttons if showButtons is true -->
{#if showButtons}
    <div>
        <button on:click={() => alert('Button 1 clicked')}>Create User</button>
        <button on:click={() => alert('Button 2 clicked')}>Create Poll</button>
        <button on:click={() => alert('Button 3 clicked')}>Vote on Poll</button>
    </div>
{/if}

<style>
    /* Optional: Add some margin or styling for the buttons */
    button {
        margin: 5px;
    }
</style>