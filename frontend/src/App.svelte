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

  function togglePollForm() { showPollForm = !showPollForm; }
  function toggleUsers() { showUsers = !showUsers; }
  function togglePolls() {
    showPolls = !showPolls;
    if (!showPolls) {
      showVoteOnPoll = false;
    }
  }

  function addPoll(poll) {
    polls = [...polls, poll];
    showPollForm = false;
  }

  function addUser(user) {
    users = [...users, user];
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
