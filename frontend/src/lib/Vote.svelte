<script>
    export let poll;
    let selectedOption = null;

    // Function to make votes
    function submitVote() {
        if (selectedOption) {
            alert(`You voted: ${selectedOption}`);
        } else {
            alert('Select an option before submitting.');
        }
    }
</script>

<h2>Voting on Poll: {poll.question}</h2>

<!-- Display poll options -->
<ul>
    {#each poll.voteOptions as option}
        <li>
            <input
                    type="radio"
                    name="vote"
                    value={option}
                    bind:group={selectedOption} />
            <label>{option}</label>
        </li>
    {/each}
</ul>

<!-- Button to submit the selected vote -->
<button on:click={submitVote}>Submit Vote</button>

<style>
    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 10px 0;
    }

    button {
        margin-top: 10px;
        padding: 10px;
        font-size: 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    button:hover {
        background-color: #45a049;
    }
</style>
