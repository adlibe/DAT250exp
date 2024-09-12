<script>
    export let addUser;

    // Function to create a new user
    function createUser() {
        const username = prompt("Enter username: ");
        const email = prompt("Enter email: ");
        if (username && email) {
            addUser({ username, email });
            alert("User created!");
        } else {
            alert("Please provide both username and email.");
        }
    }
</script>

<button on:click={createUser}>Create User</button>
