<script>
    export let addPoll;

    let question = '';
    let validUntil = '';
    let voteOptions = [];
    let voteOption = '';

    // Add a vote option
    function addOption() {
        if (voteOption.trim()) {
            voteOptions = [...voteOptions, { caption: voteOption }];
            voteOption = ''
        }
    }

    // Create a new poll by posting it to the backend
    async function createPoll() {
        const poll = {
            question: question,
            validUntil: new Date(validUntil).toISOString(),
            voteOptions: voteOptions,
        };

        addPoll(poll);
    }
</script>

<div>
    <h2>Create a Poll</h2>

    <input bind:value={question} placeholder="Enter poll question" />
    <input type="date" bind:value={validUntil} />
    <input bind:value={voteOption} placeholder="Add a vote option" />
    <button on:click={addOption}>Add Option</button>

    <ul>
        {#each voteOptions as option}
            <li>{option.caption}</li>
        {/each}
    </ul>

    <button on:click={createPoll}>Create Poll</button>
</div>

<style>
    div {
        margin: 20px;
    }

    input {
        margin: 5px;
        padding: 8px;
        font-size: 16px;
    }

    button {
        margin: 5px;
        padding: 10px;
        font-size: 16px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        margin: 5px 0;
    }
</style>
