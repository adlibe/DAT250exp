<script>
    import { v4 as uuidv4 } from 'uuid';

    export let addPoll;

    // Poll fields
    let question = '';
    let validUntil = '';
    let voteOptions = [];
    let voteOptionInput = '';

    // Function to create new polls
    function createPoll() {
        const newPoll = {
            pollId: uuidv4(),
            question,
            publishedAt: new Date().toISOString(),
            validUntil: new Date(validUntil).toISOString(),
            voteOptions: [...voteOptions]
        };
        addPoll(newPoll);

        // Reset fields
        question = '';
        validUntil = '';
        voteOptions = [];
    }

    // Function to add vote options
    function addVoteOption() {
        if (voteOptionInput) {
            voteOptions = [...voteOptions, voteOptionInput];
            voteOptionInput = '';
        }
    }
</script>

<!-- Poll creation page -->
<h2>Create a Poll</h2>
<div>
    <label>Question: </label>
    <input type="text" bind:value={question} placeholder="Enter poll question"/>
</div>

<div>
    <label>Valid Until: </label>
    <input type="datetime-local" bind:value={validUntil}/>
</div>

<!-- Vote options -->
<div>
    <label>Vote Option: </label>
    <input type="text" bind:value={voteOptionInput} placeholder="Add a vote option"/>
    <button type="button" on:click={addVoteOption}>Add Option</button>
</div>

<!-- Display all of the vote options -->
{#if voteOptions.length > 0}
    <h3>Vote Options:</h3>
    <ul>
        {#each voteOptions as option}
            <li>{option}</li>
        {/each}
    </ul>
{/if}

<!-- Button to create poll -->
<button on:click={createPoll}>Create Poll</button>

<style>
    input {
        margin: 5px 0;
        padding: 8px;
        font-size: 1rem;
    }

    button {
        margin: 10px 0;
        padding: 10px;
        font-size: 1rem;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 5px 0;
    }
</style>
