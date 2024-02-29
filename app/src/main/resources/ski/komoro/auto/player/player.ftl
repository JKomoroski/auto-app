<#-- @ftlvariable name="" type="ski.komoro.auto.player.PlayerView" -->
<section class="PlayerView container-fluid">
    <h2>Active Players</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Player Name</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <#list players>
            <#items as player>
                <tr>
                    <th scope="row">${player.playerName()}</th>
                    <td>
                        <button
                                hx-delete="/app/players?id=${player.id()}"
                                hx-swap="outerHTML"
                                hx-target="closest .PlayerView"
                                type="button"
                                class="btn btn-danger">
                            Deactivate Player
                        </button>
                    </td>
                </tr>
            </#items>
        </#list>
        </tbody>
    </table>
    <form
            hx-post="/app/players"
            hx-swap="outerHTML"
            hx-target="closest .PlayerView">
        <div class="mb-3">
            <label for="name" class="form-label">Player Name</label>
            <input type="text" class="form-control" name="playerName" id="name" placeholder="Enter New Player Name Here" required>
            <div id="name-help" class="form-text">Names Must Be Unique</div>
        </div>
        <button
                type="submit"
                class="btn btn-primary">
            Create New Player
        </button>
    </form>
</section>
