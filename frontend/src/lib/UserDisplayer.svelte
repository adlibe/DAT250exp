<script>
    let showUsers = false;
    let users = [];

    // Toggle the displaying of the user list
    function toggleUsers() {
        showUsers = !showUsers;
    }
</script>

<button on:click={toggleUsers}>Show Users</button>

<!-- Displays list of created users -->
{#if showUsers && users.length > 0}
    <h2>Created Users:</h2>
    <ul>
        {#each users as user}
            <li>{user.username} - {user.email}</li>
        {/each}
    </ul>
{/if}
