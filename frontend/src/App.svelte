<script>
  import UserCreator from './lib/UserCreator.svelte';
  import PollCreator from './lib/PollCreator.svelte';
  import Vote from './lib/Vote.svelte';

  let showPollForm = false;
  let showUsers = false;
  let showPolls = false;
  let showVoteOnPoll = false;
  let selectedPoll = null;
  let users = [];
  let polls = [];

  // Fetch users from backend
  async function fetchUsers() {
    const response = await fetch('http://localhost:8080/users');
    if (response.ok) {
      const data = await response.json();
      users = data;
    } else {
      console.error('Failed to fetch users');
    }
  }

  // Fetch polls from backend
  async function fetchPolls() {
    const response = await fetch('http://localhost:8080/polls');
    if (response.ok) {
      const data = await response.json();
      polls = data;
    } else {
      console.error('Failed to fetch polls');
    }
  }


  function togglePollForm() { showPollForm = !showPollForm; }
  function toggleUsers() {
    showUsers = !showUsers;
    if (showUsers) {
      fetchUsers();
    }
  }
  async function togglePolls() {
    showPolls = !showPolls;
    if (showPolls) {
      try {
        const response = await fetch('http://localhost:8080/polls');
        const data = await response.json();
        polls = data;
      } catch (error) {
        console.error('Error fetching polls:', error);
      }
    } else {
      showVoteOnPoll = false;
    }
  }


  async function addPoll(poll) {
    const response = await fetch('http://localhost:8080/polls', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(poll)
    });

    if (response.ok) {
      fetchPolls();
      showPollForm = false;
    } else {
      console.error('Failed to add poll');
    }
  }




  async function addUser(user) {
    const response = await fetch('http://localhost:8080/users', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(user)
    });

    if (response.ok) {
      fetchUsers();
    } else {
      console.error('Failed to add user');
    }
  }


  function selectPoll(poll) {
    selectedPoll = poll;
    showVoteOnPoll = true;
  }
</script>

<main>
  <h1>Poll App</h1>

  <!-- Creates buttons -->
  <div class="button-container">
    <UserCreator {addUser}/>
    <button on:click={togglePollForm}>Create Poll</button>
    <button on:click={toggleUsers}>Show Users</button>
    <button on:click={togglePolls}>Show Polls</button>
  </div>

  <!-- Creates the page for creating polls -->
  {#if showPollForm}
    <PollCreator {addPoll} />
  {/if}

  <!-- Display users -->
  {#if showUsers && users.length > 0}
    <h2>Users</h2>
    <ul>
      {#each users as user}
        <li>{user.username} - {user.email}</li>
      {/each}
    </ul>
  {/if}

  <!-- Display polls -->
  {#if showPolls && polls.length > 0}
    <h2>Polls</h2>
    <ul>
      {#each polls as poll}
        <li>
          {poll.question}
          <button on:click={() => selectPoll(poll)}>Vote on this Poll</button>
        </li>
      {/each}
    </ul>
  {/if}

  <!-- Display selected poll -->
  {#if showVoteOnPoll && selectedPoll}
    <Vote poll={selectedPoll}/>
  {/if}
</main>

<style>
  main {
    text-align: center;
    padding: 20px;
  }

  .button-container {
    display: flex;
    justify-content: center;
    gap: 10px;
  }

  button {
    padding: 10px;
    font-size: 1rem;
  }

  ul {
    list-style: none;
    padding: 0;
  }

  li {
    margin: 10px 0;
  }
</style>
