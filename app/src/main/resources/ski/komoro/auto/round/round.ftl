<#-- @ftlvariable name="" type="ski.komoro.auto.round.RoundView" -->
<section class="RoundView container-fluid">
    <button
            hx-get="/app/rounds/create"
            hx-swap="outerHTML"
            hx-target="closest .RoundView"
            type="button"
            class="btn btn-primary">
        Create New Round
    </button>
    <button
            hx-get="/app/rounds/delete"
            hx-swap="outerHTML"
            hx-target="closest .RoundView"
            type="button"
            class="btn btn-danger">
        Delete Last Round
    </button>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Round</th>
            <th scope="col">Groups</th>
        </tr>
        </thead>
        <tbody>
        <#list rounds>
            <#items as round>
                <tr>
                    <th scope="row">${round.id()}</th>
                    <td>group</td>
                </tr>
            </#items>
        </#list>
        </tbody>
    </table>
</section>
